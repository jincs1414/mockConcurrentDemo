package com.github.jincs.demo;

/**
 * 需要高并发的操作接口
 */
public interface IConcurrentOperation {

    /**
     * 具体的操作
     */
    void operation();
}
