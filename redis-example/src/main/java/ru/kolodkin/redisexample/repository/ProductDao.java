package ru.kolodkin.redisexample.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.kolodkin.redisexample.entity.Product;

import java.util.List;

@Repository
public class ProductDao {
    private final RedisTemplate redisTemplate;

    public ProductDao(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public Product save(Product product) {
        redisTemplate.opsForHash().put("Product", product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return redisTemplate.opsForHash().values("Product");
    }

    public Product findProductById(int id) {
        return (Product) redisTemplate.opsForHash().get("Product", id);
    }

    public String deleteProduct(int id) {
        redisTemplate.opsForHash().delete("Product", id);
        return "product delete;";
    }
}
