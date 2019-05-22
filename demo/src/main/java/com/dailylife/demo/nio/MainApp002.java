package com.dailylife.demo.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MainApp002 {
    public static void main(String[] args) throws IOException {
        File file = new File("1.jpg");
        System.out.println(file.getAbsolutePath());
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("2.jpg");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf) != -1) {
            buf.flip();//切换到读取数据模式;
            outChannel.write(buf);
            buf.clear();
        }
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();

    }
}
