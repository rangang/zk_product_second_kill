# zk_product_second_kill

使用zookeeper实现商品秒杀效果

```java
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static String connectString ="172.16.167.11:2181,172.16.167.20:2181";

    @RequestMapping("/reduce")
    public Object reduce(int id) throws Exception {

        // 重试策略（1000毫秒1次，最多试3次）
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        // 1.创建curator工具对象
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        client.start();
        // 2.根据工具对象创建"内部互斥锁"
        InterProcessMutex lock = new InterProcessMutex(client,"/product_"+id);
        try {
            // 3.加锁
            lock.acquire();
            productService.reduceStock(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.释放锁
            lock.release();
        }

        return "ok";
    }

}
```
