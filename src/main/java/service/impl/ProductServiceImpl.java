package service.impl;

import entity.Order;
import entity.Product;
import mapper.OrderMapper;
import mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProductService;

import java.util.UUID;

/**
 * @BelongsProject: zk_product_second_kill
 * @Author: RG
 * @CreateTime: 2022/7/6 10:35 上午
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    public void reduceStock(int id) {
        // 1.获取库存（根据商品ID查询商品）
        Product product = productMapper.getProduct(id);

        if (product.getStock() <= 0) {
            throw new RuntimeException("已抢光！");
        }

        // 2.减库存
        int i = productMapper.reduceStock(id);
        if (i == 1) {
            // 3.生成订单
            Order order = new Order();
            order.setId(UUID.randomUUID().toString());
            order.setPid(id);
            order.setUserid(666);
            orderMapper.insert(order);
        } else {
            throw new RuntimeException("减库存失败！");
        }
    }
}
