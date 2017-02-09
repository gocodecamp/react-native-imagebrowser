/**
 * example
 * https://github.com/facebook/react-native
 * @flow
 */

 import React, { Component } from 'react';
 import {NativeModules} from 'react-native';
 import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  Alert,
  DeviceEventEmitter
} from 'react-native';

var DisplayImage = NativeModules.ZJImageBrowserManager;
var imagesUrls = new Array('http://ww2.sinaimg.cn/bmiddle/53932067gw1esjqfk3z6zj20hh09uabk.jpg',
		    'http://ww3.sinaimg.cn/bmiddle/53932067gw1esphcqgpurj20gy09bq46.jpg',
		        'http://ww3.sinaimg.cn/bmiddle/0061yvm6jw1estimj38bdj31cv4o87wh.jpg',
			    'http://ww4.sinaimg.cn/bmiddle/53932067gw1eshmw8t1s9j20jt0bw77l.jpg',
			        'http://ww4.sinaimg.cn/bmiddle/7f5cf1ffgw1esrte8exluj20zk0k0di1.jpg',
				    'http://ww4.sinaimg.cn/bmiddle/7f5cf1ffgw1esrt4kpyjuj20zk0k0ac9.jpg');
export default class ReactTestProject extends Component {

  render() { 
    return (
    
      <View style={styles.container}>

      <Text style={styles.demo} onPress={onImageDisplay}>
      Show ImageDisplay
      </Text>

      <Text style={styles.welcome}>
      Welcome to React Native!
      </Text>
      <Text style={styles.instructions}>
      To get started, edit index.js
      </Text>
      <Text style={styles.instructions}>
      Double tap R on your keyboard to reload,{'\n'}
      Shake or press menu button for dev menu
      </Text>
      </View>
      );
  }
}

const  onImageDisplay =  () => {
  try {
      DisplayImage.showBrowserWithImagesUrls(imagesUrls,0);
  }catch(e) {
      console.e(e);
  }
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
   demo: {
    color: '#FF0000',
    fontSize: 30,
    textAlign: 'center',
    margin: 15,
  }
});

AppRegistry.registerComponent('ReactTestProject', () => ReactTestProject);
