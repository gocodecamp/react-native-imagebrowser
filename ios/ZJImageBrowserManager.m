//
//  ZJImageBrowserManager.m
//  BjzjnsDemo
//
//  Created by DLonion on 2017/1/17.
//  Copyright © 2017年 Facebook. All rights reserved.
//

#import "ZJImageBrowserManager.h"
#import "React/RCTLog.h"
#import "ViewController.h"
#import "STPhotoBrowserController.h"
#import "STConfig.h"

@interface ZJImageBrowserManager() <STPhotoBrowserDelegate>

@property(nonatomic,strong)NSArray *imagesUrls;

@end

@implementation ZJImageBrowserManager

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(showBrowserWithThumbImagesUrls:(NSArray *)thumbImagesUrls BigImagesUrls:(NSArray *)bigImagesUrls)
{
  
  dispatch_async(dispatch_get_main_queue(), ^{
    ViewController *vc = [[ViewController alloc] initWithThumbImagesUrls:thumbImagesUrls BigImagesUrls:bigImagesUrls];
    UINavigationController *rootVC = (UINavigationController *)[[[UIApplication sharedApplication] keyWindow] rootViewController];
    [rootVC pushViewController:vc animated:YES];
  });
  
}


RCT_EXPORT_METHOD(showBrowserWithImagesUrls:(NSArray *)imagesUrls initialIndex:(NSInteger)initialIndex)
{
  
  dispatch_async(dispatch_get_main_queue(), ^{
    self.imagesUrls = imagesUrls;
    //启动图片浏览器
    STPhotoBrowserController *browserVc = [[STPhotoBrowserController alloc] init];
    browserVc.countImage = self.imagesUrls.count; // 图片总数
    browserVc.currentPage = initialIndex;
    browserVc.delegate = self;
    [browserVc show];
    
  });
  
}



#pragma mark - photobrowser代理方法
- (UIImage *)photoBrowser:(STPhotoBrowserController *)browser placeholderImageForIndex:(NSInteger)index
{
  return [self createImageWithColor:[UIColor blackColor] frame:CGRectMake(0, 0, 10, 10)];
}

- (NSURL *)photoBrowser:(STPhotoBrowserController *)browser highQualityImageURLForIndex:(NSInteger)index
{
  NSString *urlStr = self.imagesUrls[index];
  return [NSURL URLWithString:urlStr];
}


- (UIImage *)createImageWithColor:(UIColor *)color frame:(CGRect)rect
{
  UIGraphicsBeginImageContext(rect.size);
  CGContextRef context = UIGraphicsGetCurrentContext();
  CGContextSetFillColorWithColor(context, [color CGColor]);
  CGContextFillRect(context, rect);
  UIImage *theImage = UIGraphicsGetImageFromCurrentImageContext();
  UIGraphicsEndImageContext();
  return theImage;
}

@end
