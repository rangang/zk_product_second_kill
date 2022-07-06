package service;

/**
 * @BelongsProject: zk_product_second_kill
 * @Author: RG
 * @CreateTime: 2022/7/6 10:35 上午
 * @Description:
 */
public interface ProductService {

    /**
     * 减库存
     * @param id
     */
    void reduceStock(int id);

}
