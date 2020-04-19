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

![说明 ViewModel 随着 Activity 状态的改变而经历的生命周期。](https://developer.android.google.cn/images/topic/libraries/architecture/viewmodel-lifecycle.png)

以上是官方定义的ViewModel的生命周期

思路1：数据存储的地方具有生命周期，且生命周期处于onCreate和最后finish之间

思路2：建立一个数据管理类跟Activity实例对象绑定能否达成目的？

源码思路

1：在Activity内建立一个无界面的Fragment（HoldFragment），并设置为setRetainInstance(true),保证Activity重建时Fragment不会被销毁

2:让holdFragment内持有1个Map,存储所有的ViewModel。

3:当Activity finish时，清除holdFragment内全部的ViweModel

### ViewModel是如何在Fragment之间传递数据的

ViewModel也是有生命周期的,即OnCreate到最后的finish,而在创建ViewModel的时候就需要传入一个上下文对象，ViewModel在改上下文对象的域内可以做到局部单例