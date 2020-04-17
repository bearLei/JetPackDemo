## ViewModel

### 是什么？

要说ViewModel是什么，一个很难回答的问题。早在刚刚开始接触安卓的时候，我就使用过ViewModel,那个时候还是结合DataBind构建Mvvm开发模式，但是短暂使用过后就被我放弃了，选择了后来的Mvp模式；

目前jimu或者致远的工程中，依然是使用Mvp模式来进行开发；

先看看ViewModel在官方的定义中都能做什么

**1：为View存储和管理界面数据**

**2：在Fragment之间传递数据**

**3：允许数据在屏幕旋转等配置变化后存活**

这么一看，带入mvp模式中这是加强版的presenter。

现在姑且认为ViewModel是一个谷歌为界面(Activity/Fragment)准备的一个存储和管理界面数据的辅助类，我们可以理解成ActivityDataManger,FragmentDataManager;

基于ViewModel的以上三点能力，我们来逐个分析他是如何做到的。

### ViewModel是如何在屏幕旋转前后为页面存储数据？

