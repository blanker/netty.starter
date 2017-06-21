package com.dongbawen.protobuf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * Created by blank on 2017/6/21.
 */
public class TestProtobuf {

    public static void main(String[] args) throws IOException {
        MyProtoBuf.User user = MyProtoBuf.User.newBuilder().setAge(20)
                .setEmail("wangzhiyun@sina.com").setName("王志云").build();

        File file = Paths.get("user-data.bin").toFile();
        try (OutputStream out = new FileOutputStream(file)) {
            user.writeTo(out);
        }

    }
}
