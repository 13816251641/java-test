package shiyong3rd.dozer;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *  Dozer依赖slf4j-api-1.5.11.jar&slf4j-simple-1.5.11.jar&commons-lang3-3.1.jar
 */
public class DozerTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final DozerBeanMapper beanMapper;
    /*线程安全*/
    static{
        beanMapper = new DozerBeanMapper();
        /* 这里一定要加file */
        List<String> mappingFileUrls = Arrays.asList("file:D:/IdeaWorkSpace/java-test/src/shiyong3rd/dozer/dozer-date.xml");
        beanMapper.setMappingFiles(mappingFileUrls);
    }

    /**
     * 测试对象的拷贝 OK
     * 源对象必须要有无参构造方法,成员变量当中有List也可以拷贝
     * 在拷贝后修改了源的成员变量List的值后,拷贝对象也不会被修改,
     * 证明基于dozer的拷贝的是深拷贝的
     */
    @Test
    public void testCopyObject(){
        Source source = new Source();
        source.setAge(25);
        source.setName("a");
        List<Long> list = new ArrayList<>();
        list.add(1L);
        source.setList(list);
        Source sourceCopy = copyTo(source);
        source.getList().add(2L);//证明是深拷贝
        logger.info("source:{}",source);
        logger.info("sourceCopy:{}",sourceCopy);
        logger.info("{}",source == sourceCopy);
    }

    /**
     * 测试复杂转换 OK
     * 基于dozer的转换是支持复杂转换的
     */
    @Test
    public void testComplicatedConvert(){
        Source source = new Source();
        source.setAge(25);
        source.setName("a");
        source.setList(Arrays.asList(1L,2L));
        Friend friend1 = new Friend();
        friend1.setHobby(Arrays.asList("sleep","eat"));
        Friend friend2 = new Friend();
        friend2.setHobby(Arrays.asList("smile","cry"));
        source.setFriends(Arrays.asList(friend1,friend2));
        Source sourceCopy = copyTo(source);
        logger.info("sourceCopy:{}",sourceCopy);
    }

    /**
     * 测试原生类型集合的直接拷贝(有问题)
     * 发现返回的结果为空,推测是dozer调用了无参构造方法,
     * 但没有发现set方法导致的,但在成员变量中是好的
     */
    @Test
    public void testCollectionConvertDirectly(){
        List<String> originList = new ArrayList<>();
        originList.add("a");
        originList.add("b");
        List<String> resultList = copyTo(originList, String.class);
        logger.info("resultList:{}",resultList);
    }

    /**
     * 测试自定义类型集合的直接拷贝 OK
     */
    @Test
    public void testCollectionConvertDirectly2(){
        List<Source> originList = new ArrayList<>();
        Source source = new Source();
        source.setAge(25);
        source.setName("a");
        source.setList(Arrays.asList(1L,2L));
        originList.add(source);
        List<Source> resultList = copyTo(originList, Source.class);
        logger.info("resultList:{}",resultList);
    }

    /**
     * 测试一个对象到另一个对象的映射 OK
     * 同名属性都会被复制
     */
    @Test
    public void testSourceToDest(){
        Source source = new Source();
        source.setAge(25);
        source.setName("a");
        source.setList(Arrays.asList(1L,2L));
        Friend friend1 = new Friend();
        friend1.setHobby(Arrays.asList("sleep","eat"));
        Friend friend2 = new Friend();
        friend2.setHobby(Arrays.asList("smile","cry"));
        source.setFriends(Arrays.asList(friend1,friend2));
        Dest dest = copyTo(source, Dest.class);
        logger.info("dest:{}",dest);
    }

    /**
     * 测试一个对象到另一个对象的映射并使用@Mapping OK
     * @Mapping标签是写在Source或Dest都可以,此外复杂转换它
     * 也是支持的
     */
    @Test
    public void testSourceToDestByMapping(){
        Source source = new Source();
        source.setAge(25);
        source.setName("a");
        source.setList(Arrays.asList(1L,2L));
        Friend friend1 = new Friend();
        friend1.setHobby(Arrays.asList("sleep","eat"));
        Friend friend2 = new Friend();
        friend2.setHobby(Arrays.asList("smile","cry"));
        source.setFriends(Arrays.asList(friend1,friend2));
        Dest dest = copyTo(source, Dest.class);
        logger.info("dest:{}",dest);
    }


    /**
     * 测试source类存在继承情况下是否能进行映射 OK
     * 即使Source类存在父类,父类中的属性也会映射到Dest类的相同属性名中去
     */
    @Test
    public void testSourceToDestWhenExtends(){
        Source source = new Source();
        source.setType("A");
        source.setAge(25);
        source.setName("a");
        source.setList(Arrays.asList(1L,2L));
        Friend friend1 = new Friend();
        friend1.setHobby(Arrays.asList("sleep","eat"));
        Friend friend2 = new Friend();
        friend2.setHobby(Arrays.asList("smile","cry"));
        source.setFriends(Arrays.asList(friend1,friend2));
        Dest dest = copyTo(source, Dest.class);
        logger.info("dest:{}",dest);
    }

    /**
     * 测试日期类型转换为字符类型 OK
     * 利用配置文件可以方便指定date转换为string的格式
     */
    @Test
    public void testDateToString(){
        Source source = new Source();
        source.setType("A");
        source.setAge(25);
        source.setName("a");
        source.setBirth(new Date());
        source.setList(Arrays.asList(1L,2L));
        Friend friend1 = new Friend();
        friend1.setHobby(Arrays.asList("sleep","eat"));
        Friend friend2 = new Friend();
        friend2.setHobby(Arrays.asList("smile","cry"));
        source.setFriends(Arrays.asList(friend1,friend2));
        Dest dest = copyTo(source, Dest.class);
        logger.info("dest:{}",dest);
    }



    /**
     * 对象到类，目标类可以不是源对象的类
     *
     * @param source   复制源
     * @param destclas Class可以不是source的Class
     * @return
     */
    public static <T> T copyTo(Object source, Class<T> destclas) {
        return beanMapper.map(source, destclas);
    }

    
    /**
     * 集合复制,集合当中的元素必须要有无参构造方法,
     * 原生类型如Long,String无法拷贝或为空
     *
     * @param sources
     * @param destclas
     * @return
     */
    private <T> List<T> copyTo(List<?> sources, Class<T> destclas) {
        List<T> destList = new ArrayList<>(sources.size());
        for (Object source : sources) {
            T dest = beanMapper.map(source, destclas);
            destList.add(dest);
        }
        return destList;
    }

    /**
     * 对象到对象
     *
     * @param source
     * @param dest
     */
    public static void copyTo(Object source, Object dest) {
        beanMapper.map(source, dest);
    }

    /**
     * 对象的自我复制
     *
     * @param source
     * @return
     */
    @SuppressWarnings("unchecked")
    private static <T> T copyTo(T source) {
        return (T) beanMapper.map(source, source.getClass());
    }
}
