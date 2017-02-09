//
//  ZJRichEditorViewControllerManager.m
//  BjzjnsDemo
//
//  Created by xuyang on 2017/1/17.
//  Copyright © 2017年 Facebook. All rights reserved.
//

#import "ZJRichEditorViewControllerManager.h"
#import "React/RCTLog.h"
#import "ZSSDemoViewController.h"

@interface ZJRichEditorViewControllerManager()<ZSSRichTextEditorDelegate>
@property (nonatomic, strong) ZSSDemoViewController *editorVC;
@property (nonatomic, copy) RCTResponseSenderBlock callback;
@end

@implementation ZJRichEditorViewControllerManager
RCT_EXPORT_MODULE(ZJRichEditorManager);

+ (instancetype)sharedManager {
  static dispatch_once_t once;
  static id instance;
  dispatch_once(&once, ^{
    instance = [self new];
  });
  return instance;
}

- (id)init{
  if ((self = [super init])) {
    _editorVC   = [[ZSSDemoViewController alloc] init];
    _editorVC.delegate = self;
  }
  
  return self;
}

RCT_EXPORT_METHOD(showControllerWithCallback:(RCTResponseSenderBlock)callback)
{
  [ZJRichEditorViewControllerManager sharedManager].callback = callback;
  dispatch_async(dispatch_get_main_queue(), ^{
    UINavigationController *rootVC = (UINavigationController *)[[[UIApplication sharedApplication] keyWindow] rootViewController];
    [rootVC pushViewController:[ZJRichEditorViewControllerManager sharedManager].editorVC animated:YES];
  });
  
}

#pragma mark -
#pragma mark delegate
- (void)richTextEditor:(ZSSRichTextEditor *)editor didExportHTML:(NSString *)html{
  [ZJRichEditorViewControllerManager sharedManager].callback(@[html]);
}
@end
