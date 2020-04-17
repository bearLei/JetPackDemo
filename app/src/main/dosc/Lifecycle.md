## Lifecycle

### Lifecycle是什么

Lifecycle（生命周期感知型组件）能感知另一个组件（Activity/Fragment）的生命周期变换，并存储组件的生命周期状态信息，允许其他对象观察此状态；

### 为什么要使用Lifecycle

以Mvp模式为例，我们在Activity的onCreate()方法中需要对presenter进行初始化，在onStop()/onDestroy()对presenter进行释放。我们的代码就会呈现下面的状态：

`class MyActivity extends AppCompatActivity {        	private MyPresenter presenter;    `

` public void onCreate(...) {       ` 

` presenter= new MyPresenter ();        presenter.create();    ` 

`}     `

`public void onDestroy() {       `

` 		super.onDestroy();      ` 

`   	presenter.destory();   `   

 ` } `  

`}`

可能经过封装代码不会太过的臃肿，但是终究缺少一点设计的美感；而谷歌推出**Lifecycle**就是为了解决这种设计上的欠缺；

### Lifecycle的使用

Lifecycle的用法很简单，只需要2步；

1：让presenter实现LifecycleObserver接口

```
public interface MyPresenter extends LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(LifecycleOwner lifecycleOwner);

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(LifecycleOwner lifecycleOwner);

}
```

2：在Activity/Fragment中添加Observer

 `getLifecycle().addObserver(mPresenter);//添加`

这样当Activity发生了对应的生命周期改变，Presenter就会执行对应事件注解的方法。因此presenter接口就从一个平平无奇的接口一跃升级为一个具有生命周期的活生生的接口。

看到上面的使用方式，我们会很自然的就想到：这是一个**观察者模式**

### Lifecycle实现原理

![image-20200417105322793](C:\Users\ubt\AppData\Roaming\Typora\typora-user-images\image-20200417105322793.png)

直接附上一张图。

1：**LifecycleOwber接口**：Lifecycle的持有者，其实没啥用，就是对外提供一个接口方便获取Lifecycle观察者

2：**LifecycleObserver**：Lifecycle的观察者，实现了该观察者的对象被注册后具有观察生命周期的能力；

3**：Lifecycle**:观察者模式中的被观察者，具有addObserver/removeObserver等基础能力

4：**LifecycleRegistry**:Lifecycle子类（具体干活的），根据生命组件的生命周期变换通知观察者，存储生命周期组件信息。处理生命周期活跃/非活跃状态等。

5：**各种Observer**:提供几种观察者方便外部使用



### 小结

Lifecycle简单且独立，可以单独使用让LocationManager,MediaPlayer，Presenter等工具类感应生命周期做业务处理。也可以结合ViewModel、liveData构建Mvvm架构模式。