package mapper;

import entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: zk_product_second_kill
 * @Author: RG
 * @CreateTime: 2022/7/6 10:27 上午
 * @Description: 订单操作类
 */
@Mapper
@Component
public interface OrderMapper {

    /**
     * 生成订单
     * @param order
     * @return
     */
    @Insert("insert into `order`(id,pid,userid) values(#{id},#{pid},#{userid})")
    int insert(Order order);

}
