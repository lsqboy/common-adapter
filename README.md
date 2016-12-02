# CommonAdapter
[![Build Status](https://travis-ci.org/lsqboy/common-adapter.svg?branch=master)](https://travis-ci.org/lsqboy/common-adapter)
[ ![Download](https://api.bintray.com/packages/lsqboy/maven/common-adapter/images/download.svg) ](https://bintray.com/lsqboy/maven/common-adapter/_latestVersion)
This is a Common Adapter

### Download
This library already included in JCenter & MavenCentral
#### Gradle:
```groovy
compile 'com.lsqboy.common-adapter:common-adapter:0.0.1'
```

### Usage
Let's start it
```java
  ListView mListView = (ListView) findViewById(R.id.list_view);
        //common adapter 简单使用教程
        mListView.setAdapter(new CommonAdapter<String>(this, getData(), android.R.layout.simple_list_item_1) {
            @Override
            public void convert(ViewHolder helper, String model) {
                helper.setText(android.R.id.text1, model);
            }
        });
```

Get Data
```java
       private List<String> getData() {
           mStringList = new ArrayList<>();
           for (int i = 0; i < 50; i++) {
               mStringList.add("string Item" + i);
           }
           return mStringList;
       }
```

### License

Apache 2.0


