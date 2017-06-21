package com.dongbawen.protobuf;

import java.io.*;
import java.nio.file.Paths;

/**
 * Created by blank on 2017/6/21.
 */
public class TestProtobufRead {
    public static void main(String[] args) throws IOException {
        File file = Paths.get("user-data.bin").toFile();
        try (InputStream input = new FileInputStream(file)) {
            MyProtoBuf.User user = MyProtoBuf.User.parseFrom(input);
            System.out.println(user.getAge());
            System.out.println(user.getName());
            System.out.println(user.getEmail());
        }
    }
}
