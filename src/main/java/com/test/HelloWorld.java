package com.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {

    public static String sayHello(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        return "Hello " + name;
    }

    public static List<String> sayHelloToLotOfPeople(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        return names.stream()
                .map((name) -> "Hello " + name)
                .collect(Collectors.toList());
    }

    public static File createTestFile(File file) {
        File resultFile = new File(file.getAbsolutePath() + "/test");
        if (!resultFile.exists()) {
            try {
                resultFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return resultFile;
    }
}
