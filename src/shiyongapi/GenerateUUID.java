package shiyongapi;

import java.util.UUID;

/**
 * @Auther ljn
 * @Date 2019/11/22
 * 生成uuid
 */
public class GenerateUUID {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        System.out.println(uuid);
    }
}
