//
//  ZSSDemoViewController.h
//  ZSSRichTextEditor
//
//  Created by Nicholas Hubbard on 11/29/13.
//  Copyright (c) 2013 Zed Said Studio. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ZSSRichTextEditor.h"

@protocol ZSSRichTextEditorDelegate <NSObject>
@optional
- (void)richTextEditor:(ZSSRichTextEditor *)editor didExportHTML:(NSString *)html;
@end

@interface ZSSDemoViewController : ZSSRichTextEditor
@property (nonatomic, weak) id<ZSSRichTextEditorDelegate> delegate;
@end
