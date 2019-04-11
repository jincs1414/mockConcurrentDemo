
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