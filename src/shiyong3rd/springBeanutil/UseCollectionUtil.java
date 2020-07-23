package shiyong3rd.springBeanutil;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class UseCollectionUtil {

    public static void main(String[] args) {
        //List<String> list = null;
        //List<String> list = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("s");
        System.out.println(CollectionUtils.isEmpty(list));

    }

}