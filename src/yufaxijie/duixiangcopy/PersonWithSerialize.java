package yufaxijie.duixiangcopy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/*
    使用序列化完成深拷贝
    解决多层克隆问题
 */
@Data
@AllArgsConstructor
public class PersonWithSerialize implements Serializable {
    private String name;
    private AddressWithSerialize addressWithSerialize;

    public PersonWithSerialize cloneWithSerialize(){
        PersonWithSerialize personWithSerialize = null;
        try(
            /*
                将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
             */
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)
        ) {

            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            personWithSerialize = (PersonWithSerialize)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personWithSerialize;
    }

}

@Data
@AllArgsConstructor
/*
   AddressWithSerialize也必须实现Serializable，否则无法序列化：
 */
class AddressWithSerialize implements Serializable {
    private String name;
}
