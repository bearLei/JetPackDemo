### **LiveData**是什么:

LiveData是一种可观察的数据存储器类，是JetPack架构组件中的一员。与其他常规的可观察类不同，LiveData具有生命周期的感知能力，遵循其他应用组件的生命周期，这种感知能力确保了LiveData仅更新处于生命周期活跃状态的应用组件观察者。

### LiveData的优势？

1：有效避免内存泄漏

2：感知生命周期，不需要手动处理生命周期

3：数据可观察，确保界面符合数据状态

### 观察者模式

在使用LiveData之前，我们先说说观察者模式，这个是我们大家都非常熟练的一种设计模式；

```
public class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer){
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    public void notifyChange(){
        for (Observer observer:observers) {
            observer.onNotifyDataChange();
        }
    }
}
```

```
public interface Observer {

    void onNotifyDataChange();
}
```

### 自己定义1个简易版LiveData

#### 让LiveData充当被观察者

既然说到LiveData是一种可观察的数据存储量，那在观察者模式中充当的角色就是**被观察者**。

作为被观察者，具有的基础能力就有:**添加观察者**，**移除观察者**，**和通知观察者**

```
public class MyLiveData<T>{

    private ArrayList<MyObserver> observers = new ArrayList<>();

    /**
     * 添加观察者
     *
     * @param observer
     */
    public void addObServer(MyObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void removeObServer(MyObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    /**
     * 通知各个观察者值的变换
     */
    public void setValue(T value) {
        for (MyObserver observer : observers) {
            observer.onChange(value);
        }
    }

}
```

#### 定义观察者接口

```
public interface MyObserver<T> {
    void onChange(T t);
}
```

#### 开始观察数据

```
public class MyLiveDataTest {
    public void testMyLiveData(){
        MyLiveData<String> myLiveData = new MyLiveData<>();
        myLiveData.addObServer(new MyObserver<String>() {
            @Override
            public void onChange(String s) {
                Log.d("test",s);
            }
        });

        myLiveData.setValue("hhhh");
    }
}
```

简简单单的几部我们已经实现了一个基础版的LiveData,这么简单的吗？对的就是这么简答，通过myLiveData.setValue("hhhh")改变LiveData的值时候已经可以在MyObserver的onChange方法中实现的监听值的变换了。

### LiveData只是一个可观察的数据器类

通过上面的简单实践，已经大致得出一个结论：**LiveData只是一个普通的类，它并不是一个数据结构**。目前还没有任何的特别之处，还真是平平无奇LiveData。那接下来就看官方的LiveData是如何使用的

### LiveData的使用

```
private void useLiveData(){
    MutableLiveData<String> liveData = new MutableLiveData<>();
    liveData.observe(this, new Observer<String>() {
        @Override
        public void onChanged(String s) {
            
        }
    });

    liveData.setValue("修改值");
}
```

这个用法实在是没什么技术难度。但是指的注意是liveData在观察的时候传入了一个this对象。这个就是我们接下来要探讨的另外1个重点了。

### LiveData是如何感知生命周期的

<img src="C:\Users\ubt\AppData\Roaming\Typora\typora-user-images\image-20200416172847462.png" alt="image-20200416172847462" style="zoom:150%;" />

liveData.observe时候传入了1个this对象，该this对象为**Lifecycle**对象。LifeCycle是JetPack架构的另外1个组件了。可见LiveData之所以具有感知生命周期的能力是Lifecycle赋予的了。LifeCycle感知生命周期的原理就是另起篇章了。

而同时，LiveData对内存的有效释放也是在生命周期的感应中实现的；

### 小结

LiveData仅仅只是一个普通的观察类，耦合了Lifecycle因此具有了生命周期的感知能力。虽然LiveData的原理比较简单，但是却可以玩出很多的花招：结合Room一起使用/拓展LiveData，像Rxjava那样转换数据流等等。

