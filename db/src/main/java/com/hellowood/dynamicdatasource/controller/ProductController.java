package com.hellowood.dynamicdatasource.controller;

import com.hellowood.dynamicdatasource.common.CommonResponse;
import com.hellowood.dynamicdatasource.common.ResponseUtil;
import com.hellowood.dynamicdatasource.modal.Product;
import com.hellowood.dynamicdatasource.service.ProductService;
import com.hellowood.dynamicdatasource.utils.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Title :测试类
 * @Description :测试类
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Get product by id
     *
     * @param productId
     * @return
     * @throws ServiceException
     */
    @GetMapping("/{id}")
    public CommonResponse getProduct(@PathVariable("id") Long productId) throws ServiceException {
        return ResponseUtil.generateResponse(productService.select(productId));
    }

    /**
     * Get all product
     *
     * @return
     * @throws ServiceException
     */
    @GetMapping
    public CommonResponse getAllProduct() {
        return ResponseUtil.generateResponse(productService.getAllProduct());
    }

    /**
     * Update product by id
     *
     * @param productId
     * @param newProduct
     * @return
     * @throws ServiceException
     */
    @PutMapping("/{id}")
    public CommonResponse updateProduct(@PathVariable("id") Long productId, @RequestBody Product newProduct) throws ServiceException {
        return ResponseUtil.generateResponse(productService.update(productId, newProduct));
    }

    /**
     * Delete product by id
     *
     * @param productId
     * @return
     * @throws ServiceException
     */
    @DeleteMapping("/{id}")
    public CommonResponse deleteProduct(@PathVariable("id") long productId) throws ServiceException {
        return ResponseUtil.generateResponse(productService.delete(productId));
    }

    /**
     * Save product
     *
     * @param newProduct
     * @return
     * @throws ServiceException
     */
    @PostMapping
    public CommonResponse addProduct(@RequestBody Product newProduct) throws ServiceException {
        return ResponseUtil.generateResponse(productService.add(newProduct));
    }
}
