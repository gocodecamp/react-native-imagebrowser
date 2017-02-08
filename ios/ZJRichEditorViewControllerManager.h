//
//  ZJRichEditorViewControllerManager.h
//  BjzjnsDemo
//
//  Created by xuyang on 2017/1/17.
//  Copyright © 2017年 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "React/RCTBridgeModule.h"
@interface ZJRichEditorViewControllerManager : NSObject <RCTBridgeModule>
+ (instancetype)sharedManager;
@end
