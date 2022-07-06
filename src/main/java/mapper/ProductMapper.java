package mapper;

import entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: zk_product_second_kill
 * @Author: RG
 * @CreateTime: 2022/7/6 10:27 上午
 * @Description: 商品操作类
 */
@Mapper
@Component
public interface ProductMapper {

    /**
     * 查询商品（目的查询库存）
     * @param id
     * @return
     */
    @Select("select * from product where id = #{id}")
    Product getProduct(@Param("id") int id);

    /**
     * 减库存
     * @param id
     * @return
     */
    @Update("update product set stock = stock-1 where id = #{id}")
    int reduceStock(@Param("id") int id);

}
