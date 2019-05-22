package com.dailylife.demo.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class MainApp001 {

    @Test
    public void test1() {
        String str = "大傻逼";

        //1. 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("-------allocate()--------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        //2. 缓冲区存放数据
        byteBuffer.put(str.getBytes());
        System.out.println("------put()------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //3. 切换读数据模式
        byteBuffer.flip();
        System.out.println("------flip()------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //4. 获取缓冲区中的数据
        System.out.println("------get()------");
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());


        //5. rewind() 可重复读
        byteBuffer.rewind();
        System.out.println("------rewind()------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //6. clear() 清空缓冲区,但是缓冲区的数据依然存在,只是处于被遗忘状态;
        byteBuffer.clear();
        System.out.println("------clear()------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] hehe = new byte[byteBuffer.limit()];
        byteBuffer.get(hehe);
        System.out.println(new String(hehe));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

    }

    @Test
    public void test2() {
        String string = "抽烟一时爽,一直抽烟一直爽!";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //放入数据
        byteBuffer.put(string.getBytes());
        //切换读模式
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes, 0, 6);
        System.out.println(new String(bytes, 0, 6));
        System.out.println(byteBuffer.position());  //6
        System.out.println(byteBuffer.limit());     //38
        System.out.println(byteBuffer.capacity());  //1024

        byteBuffer.mark();
        System.out.println("------mark()------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.get(bytes, 6, 32);
        System.out.println(new String(bytes));
        System.out.println(byteBuffer.position());  //38
        System.out.println(byteBuffer.limit());     //38
        System.out.println(byteBuffer.capacity());  //1024

        byteBuffer.reset();
        System.out.println(byteBuffer.position());  //6
        System.out.println(byteBuffer.limit());     //38
        System.out.println(byteBuffer.capacity());  //1024

        if (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.remaining()); //32
        }

        System.out.println(byteBuffer.isDirect());  //是否是直接缓冲区:false,建立在JVM内存中

        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer1.isDirect()); //true,建立在物理内存中

    }
}
