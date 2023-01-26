package ru.kolodkin.redisexample.controller;

import org.springframework.web.bind.annotation.*;
import ru.kolodkin.redisexample.entity.Product;
import ru.kolodkin.redisexample.repository.ProductDao;

import java.util.List;

@RestController
@RequestMapping("/product")
public class Controller {
    final private ProductDao dao;

    public Controller(ProductDao dao) {
        this.dao = dao;
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return dao.save(product);
    }

    @GetMapping("/list")
    public List<Product> getAllProdutcts(){
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return dao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return dao.deleteProduct(id);
    }

}
