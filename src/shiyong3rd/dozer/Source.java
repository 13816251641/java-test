package shiyong3rd.dozer;

import lombok.Data;
import org.dozer.Mapping;

import java.util.Date;
import java.util.List;

@Data
public class Source extends Father {
    private String name;
    private Integer age;
    private List<Long> list;
    @Mapping("friends11")
    private List<Friend> friends;
    private Date birth;

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", friends=" + friends +
                '}';
    }
}
