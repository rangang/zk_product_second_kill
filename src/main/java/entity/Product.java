package entity;

/**
 * @BelongsProject: zk_product_second_kill
 * @Author: RG
 * @CreateTime: 2022/7/6 10:24 上午
 * @Description: 商品表
 */
public class Product {

    private int id;
    private String product_name;
    private int stock;
    private int version;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", stock=" + stock +
                ", version=" + version +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
