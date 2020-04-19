## Room

[Room](https://developer.android.google.cn/training/data-storage/room) 持久性库在 SQLite 的基础上提供了一个抽象层，让用户能够在充分利用 SQLite 的强大功能的同时，获享更强健的数据库访问机制。

![image](https://note.youdao.com/yws/api/personal/file/WEB9c31de6a1498813073642442a63fc8e3?method=download&shareKey=433d4d13f4ceef0b89ccadefd8abac02)



### 使用Room 

1：创建Entity

2：创建dao对象

3：创建DataBase

使用Room进行增删改查具体方式可以参考官网，不是很复杂。

### Room的优势

在性能和接入成本和维护成本方面，Room对比GreenDao实在也找不出特别亮眼的优势。2个性能相差无几。而Room在生态方面的优势却是天然的，毕竟是google亲儿子；

1：Room+RxJava：类似retrofit+Rxjava，可以直接返回一个流数据

2：Room+LiveData:返回可观察数据

3：增刪改查支持 SQLite语句