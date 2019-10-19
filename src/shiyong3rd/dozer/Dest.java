package shiyong3rd.dozer;

import lombok.Data;
import org.dozer.Mapping;

import java.util.List;

@Data
public class Dest {

    private String name;
    @Mapping("age")
    private Integer nian;
    private String hobby;
    private List<Friend> friends11;
    private String type;
    private String birth;

}
