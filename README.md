
## 模拟高并发

### demo

```java
        //创建一个高并发模拟
        ConcurrentMocker mocker = new ConcurrentMocker();
        //创建需要进行并发的操作缓存，并开启并发
        mocker.cacheConcurrentOperations(10,()->System.out.println("1"))
                .startHighConcurrent();
```

### 使用场景

对某个方法进行并发测试，验证其在高并发场景下的效率与逻辑，判断是否线程安全

### 代码的思路

- 1、使用`CountDownLatch`创建一个数量为`1`的并发开关

- 2、通过`Thread`类创建多个线程，在线程中调用`CountDownLatch的await()`方法等待并发开关开启

- 3、通过`CountDownLatch的countDown()`的方法开启并发开关，实现并发

### 原理

实现高并发这句话，换种描述就是很多的线程同时执行一个操作。
所以先创建一堆线程并让其阻塞，在某个条件发生后，撤掉阻塞，完成并发操作。
所以通过闭锁(CountDownLatch)来实现这个条件：当调用`CountDownLatch的countDown()`时，所有执行了`CountDownLatch的await()`的线程都会撤销阻塞，同时执行线程后续的代码，实现并发。


