VerticalViewPager
===
[ ![Download](https://api.bintray.com/packages/isanwenyu/maven/VerticalViewPager/images/download.svg) ](https://bintray.com/isanwenyu/maven/VerticalViewPager/_latestVersion)

This is forked from kaelaela/VerticalViewPager
 
Optimization of VerticalViewPager
  <ul>
     <li>Catching ViewPager internal bug: java.lang.IllegalArgumentException: pointerIndex out of range {@link CatchExceptionViewPager} </li>
     <li>The vertical sliding optimization nesting {@link android.support.v4.view.ViewPager}</li>
  </ul>
 Edited by isanwenyu on 2016/9/14.<p>
 Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 
 
[![Build Status](https://travis-ci.org/kaelaela/VerticalViewPager.svg)](https://travis-ci.org/kaelaela/VerticalViewPager)
[![Platform](http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat)](http://developer.android.com/index.html)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-VerticalViewPager-green.svg?style=flat)](https://android-arsenal.com/details/1/2651)

Vertically ViewPager and vertically transformer for Android.
This library is not copy ViewPager code. Extended class.

![default](art/default.gif) ![zoom_out](art/zoom_out.gif) ![stack](art/stack.gif)

##Getting Started

 - Add the dependency to your build.gradle.
 
```
dependencies {
    compile 'com.isanwenyu.verticalviewpager:library:1.0.0'
}
```
- Maven:

```
<dependency>
  <groupId>com.isanwenyu.verticalviewpager</groupId>
  <artifactId>library</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

## Usage

```java

VerticalViewPager viewPager = new VerticalViewPager();
viewPager.setAdapter(adapter);
viewPager.setPageTransformer(false, new DefaultTransformer());

//viewPager.setPageTransformer(false, new ZoomOutTransformer());
//viewPager.setPageTransformer(true, new StackTransformer());

```


## Next

- [ ] Use with scrollable views(ListView, ScrollView, RecyclerView, WebView).
- [ ] Add more transformers.(Please contribute me!
- [ ] Sticky header.

## Contributor

Yuichi Maekawa(Kaelaela)
* Twitter [@Yuichi0531](https://twitter.com/Yuichi0531)
* kaelaela.31@gmail.com

isanwenyu
* github: [https://github.com/isanwenyu](https://github.com/isanwenyu)
* email: [isanwenyu@163.com](isanwenyu@163.com)
License
-------
    Copyright (C) 2016 isanwenyu@163.com
    Copyright (C) 2015 kaelaela
    Copyright (C) 2013 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
