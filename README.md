# react-native-imagebrowser

var DisplayImage = require('react-native').NativeModules.ZJImageBrowserManager;

var imagesUrls = new Array('http://ww2.sinaimg.cn/bmiddle/53932067gw1esjqfk3z6zj20hh09uabk.jpg',
                    'http://ww3.sinaimg.cn/bmiddle/53932067gw1esphcqgpurj20gy09bq46.jpg',
                    'http://ww3.sinaimg.cn/bmiddle/0061yvm6jw1estimj38bdj31cv4o87wh.jpg',
                    'http://ww4.sinaimg.cn/bmiddle/53932067gw1eshmw8t1s9j20jt0bw77l.jpg',
                    'http://ww4.sinaimg.cn/bmiddle/7f5cf1ffgw1esrte8exluj20zk0k0di1.jpg',
                    'http://ww4.sinaimg.cn/bmiddle/7f5cf1ffgw1esrt4kpyjuj20zk0k0ac9.jpg');
# method name showBrowserWithImagesUrls
first parameter : images to display type is array

second parameter: current display image index

DisplayImage.showBrowserWithImagesUrls(imagesUrls,0);       
