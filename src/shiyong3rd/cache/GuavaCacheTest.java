package shiyong3rd.cache;

import com.google.common.cache.*;
import guanchazhemoshi.two.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCacheTest {

    /**
     * 最简单的例子
     */
    @Test
    public void test01(){
        Cache<Integer,String> cache = CacheBuilder.newBuilder().build();
        cache.put(1,"a");
        System.out.println(cache.getIfPresent(1));//a
        System.out.println(cache.getIfPresent(2));//null
    }


    /**
     * 如果没有缓存，我也想要一个缓存值
     */
    @Test
    public void test02(){
        LoadingCache<Integer,String> cache = CacheBuilder.newBuilder().build(
                new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return "key-"+key;
                    }
                }
        );
        cache.put(1, "a");
        System.out.println(cache.getIfPresent(1));//a

        System.out.println(cache.getIfPresent(2));//不存在就返回null,不会帮你构造一个缓存

        try {
            System.out.println(cache.get(2));//不存在就返回默认的key-2,并存入缓存中
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(cache.getIfPresent(2));//key-2
    }


    /**
     * 基于容量的回收
     */
    @Test
    public void test03(){
        Cache<Integer, String> cache = CacheBuilder.newBuilder().maximumSize(2).build();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        System.out.println(cache.asMap());
        System.out.println(cache.getIfPresent(2));
        cache.put(4, "d");
        System.out.println(cache.asMap());
    }


    /**
     * 基于权重的回收
     */
    @Test
    public void test04(){
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().maximumWeight(100)
                .weigher((Integer a,Integer b)->{
                    if (a % 2 == 0) { // a是key,b是value
                        return 20;
                    } else {
                        return 5;
                    }
                }).build();
//         放偶数
        for (int i = 0; i <= 20; i += 2) {
            cache.put(i, i);
        }
        System.out.println(cache.asMap());
        cache.invalidateAll();
        for (int i = 1; i < 10; i += 1) {
            cache.put(i, i);
        }
        System.out.println(cache.asMap());
    }

    /**
     * 没有在3秒内被写访问（创建或覆盖）就回收
     * 修改value的值不可以阻止过期
     * 重新以相同的key赋值可以阻止过期
     */
    @Test
    public void test05() throws Exception{
        Person person = new Person();
        person.setName("a");
        person.setAge(25);

        Cache<Integer, Person> cache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();
        cache.put(1,person);
        System.out.println(cache.asMap());

        Thread.sleep(2_000);
        cache.put(1,new Person());
        Thread.sleep(2_000);


        System.out.println(cache.asMap());
        System.out.println(cache.getIfPresent(1));
    }

    @Test
    public void test06(){
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().expireAfterAccess(3, TimeUnit.SECONDS).build();
        cache.put(1,1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cache.getIfPresent(1);
        System.out.println(cache.asMap());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cache.asMap());
    }

    /**
     * 手动清除缓存
     */
    @Test
    public void test07(){
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(3, TimeUnit.SECONDS).build();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.invalidateAll(Arrays.asList(1));//批量清除
        System.out.println(cache.asMap());
        cache.put(3, 3);
        System.out.println(cache.asMap());
        cache.invalidateAll();//清除所有缓存项
        System.out.println(cache.asMap());
    }

}