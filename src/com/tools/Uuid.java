package com.tools;
import java.util.UUID;

/**
 * 生成UUID
 */

public class Uuid {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}
