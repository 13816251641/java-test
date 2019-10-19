package test;

import java.util.UUID;

/*
   生成32位uuid
 */
public class GenerateUUID {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);

    }
}
