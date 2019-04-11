package com.github.jincs.demo;

import java.util.concurrent.CountDownLatch;

public class ConcurrentMocker {

    /**
     * 高并发开关
     */
    private CountDownLatch highConcurrentSwitch = new CountDownLatch(1);

    /**
     * 缓存并发的操作，等待高并发开关开启进行并发操作
     * @param threadNum
     * @param concurrentOperation
     * @return
     */
    public ConcurrentMocker cacheConcurrentOperations(int threadNum, IConcurrentOperation concurrentOperation) {
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                try {
                    //等待高并发开关开启
                    highConcurrentSwitch.await();
                    //执行并发的操作
                    concurrentOperation.operation();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        return this;
    }

    /**
     * 开启高并发操作
     */
    public void startHighConcurrent() {
        highConcurrentSwitch.countDown();
    }



}
