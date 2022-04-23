package com.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {
    public final static Map<String,Object> data = new Hashtable<String, Object>();
    private  static Random random = new Random();

    public class Task implements Runnable
    {
        @Override
        public void run() {
            Integer i = random.nextInt(1000);
            String name = Thread.currentThread().getName();
            System.out.println("线程"+name+"生成"+i);
            data.put(name,i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Object o = data.get(name);
            System.out.println("在线程");


        }
    }

}
