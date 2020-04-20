## 如何使用Jetpack组件构建数据驱动视图的架构

### 概述

安卓的开发架构经历了MVC,MVP，MVVM。在很早以前我就尝试开始使用MVVM开发，在短暂的尝试了一段时间后，就果断的放弃了。

原因1：ViewModel存储的数据在通过DataBinding在xml布局需要通过伪代码的方式进行设值

原因2：在数据有异常的时候定位问题显得异常麻烦

因此我很长的一段时间内我一直使用MVP开发模式进行开发。MVP模式在一定的程度上分离了UI和数据，将处理数据的逻辑丢在Presenter中，而View层面只要负责简单的设值，loading,刷新等基本关于UI的处理问题。一切看起来都是那么合理和完美，但是在开发的过程中我却遇到了下面的几个问题；

1：**迎合MVP** 一个很简单的Activity页面，可能只涉及一些很简单的业务逻辑，但是为了迎合过程开发模式的统一，我却要创建一个Presenter,一个View来迎合MVP开发模式

2：**复用艰难的Presenter** 由于Presenter内需要传入一个View对象，页面的UI展示由Presenter来触发，这使得所谓的UI和数据分离显得那么的不纯粹。而相同的数据，不同的UI页面，那么Presenter的复用就显得异常的艰难，尽管我可以通过封装数据等其他方式来达成目的，但这个明显不是我想要的



### Jetpack下的MVVM

Jetpack是一组库，使用这组库可以设计出稳健，可测试且易维护的应用。这是官网对Jetpack的解释，在我看来jetpack推出的目的是为了统一开发者百花齐放的开发模式。

![img](https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/a7da8f5ea91bac52.png)



**1：Activity负责UI的显示**

**2：ViewModel负责UI显示需要的全部数据**

**3：Room负责数据的持久化操作**

### ViewModel

ViewModel作为数据和UI的交互中心，起着类似Presenter的作用。但是ViewModel不持有View对象，也不持有任何具有生命周期对象，他只负责数据的存储。

1：使用LiveData存储数据

2：持有Repository对象获取数据

### Room

持久化数据对象

### Repository

repository并不是Jetpack提供的组件，他是一个为ViewModel链接数据的一个类。ViewModel持有它的实例，通过观察repository来获取远程/本地数据。因为往往app的数据来源不仅仅是网络，而repository的作用就是为ViewModel提供纯粹的数据而不关注这些数据的来源。

![img](https://codelabs.developers.google.com/codelabs/android-room-with-a-view/img/57f20bf7a898c03d.png)





介绍完上面几个关键组件的作用，整个架构已经很明显了。



![img](https://miro.medium.com/max/803/1*I9WPcnpGNuI4CjxxrkP0-g.png)



View观察-->ViewModel中的LiveData数据

ViewModel观察--->Repository中的LiveData数据

当Repository的数据发生变化--->ViewModel的LiveData数据发生变化

View观察到数据发生变化--->UI响应



以上的使用虽然简单，但是体现了开发的一种思想：用**数据来驱动视图**

而使用ViewModel来存储的数据，因为是纯粹的存储数据。因此无论是哪个页面要使用，只需要观察ViewModel相应的LiveData对象即可。



### 小结

无论是MVP开发模式还是MVVM的开发模式，都没有绝对的优劣。只有合适或者不合适。官方也建议在复杂的页面也可引入presenter来处理数据。无论是后面使用哪种开发方式，这个思想都是可以借鉴的：**数据驱动视图**。

附：

![image-20200420105513407](C:\Users\ubt\AppData\Roaming\Typora\typora-user-images\image-20200420105513407.png)



Repository

![image-20200420105708714](C:\Users\ubt\AppData\Roaming\Typora\typora-user-images\image-20200420105708714.png)



BaseViewModel

![image-20200420105756405](C:\Users\ubt\AppData\Roaming\Typora\typora-user-images\image-20200420105756405.png)

![image-20200420105834045](C:\Users\ubt\AppData\Roaming\Typora\typora-user-images\image-20200420105834045.png)