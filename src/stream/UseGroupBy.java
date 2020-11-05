package stream;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther lujieni
 * @Date 2020/6/23
 * 测试使用stream的group by进行分组
 * 这里特别要注意,分组后对数据的修改是对象传递,原本的list也会受到影响!!!
 */
public class UseGroupBy {
    @Test
    public void test3(){
        Stream <String> stream = Stream.of("I", "love", "you", "too");
        List<Integer> result = stream.map(e -> e.length()).collect(Collectors.toList());
        System.out.println(result);
    }


    @Test
    public void test2(){
        Student s1 = new Student(22,"张三");
        Student s2 = new Student(22,"李四");
        Student s3 = new Student(8,"阿虎");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Map<Integer, List<Student>> result = list.stream().collect(Collectors.groupingBy(e -> e.getAge()));
        for (Map.Entry<Integer,List<Student>> entry : result.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }




    @Test
    public void test(){
        Student s1 = new Student(22,"张三");
        Student s2 = new Student(22,"李四");
        Student s3 = new Student(8,"阿虎");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        for (Map.Entry<Integer, List<Student>> entry: map.entrySet()) {
            List<Student> value = entry.getValue();
            for (Student s: value) {
                if(Objects.equals(s.getAge(),22)){
                    s.setSchool("大学");
                }
                if(Objects.equals(s.getAge(),8)){
                    s.setSchool("小学");
                }
            }
        }
        System.out.println(map);
        System.out.println(list);
    }

    //静态内部类
    static class Student{
        private int age;
        private String name;
        private String school;

        private Student(int age,String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", school='" + school + '\'' +
                    '}';
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }
    }

}
