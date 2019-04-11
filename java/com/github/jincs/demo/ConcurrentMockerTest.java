package com.github.jincs.demo;

public class ConcurrentMockerTest {

    public static void main(String[] args) {
        ConcurrentMocker mocker = new ConcurrentMocker();
        mocker.cacheConcurrentOperations(10,()->System.out.println("1"))
                .startHighConcurrent();
    }
}
