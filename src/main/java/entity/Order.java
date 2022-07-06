package entity;

/**
 * @BelongsProject: zk_product_second_kill
 * @Author: RG
 * @CreateTime: 2022/7/6 10:23 上午
 * @Description: 订单表
 */
public class Order {

    private String id;
    private int pid;
    private int userid;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", pid=" + pid +
                ", userid=" + userid +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
