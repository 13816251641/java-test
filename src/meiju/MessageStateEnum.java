package meiju;

public enum MessageStateEnum {

    OK("ok",11),
    ERROR("error",12);

    private String status;

    private Integer num;

    MessageStateEnum(String status,Integer num){
        this.status=status;
        this.num = num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
