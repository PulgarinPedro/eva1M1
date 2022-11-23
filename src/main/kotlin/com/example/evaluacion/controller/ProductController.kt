package com.example.evaluacion.controller

import com.example.evaluacion.model.Product
import com.example.evaluacion.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/product")
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list():List<Product>{
        return productService.list()
    }

    @PostMapping
    fun save(@RequestBody product:Product):Product{
        return productService.save(product)
    }

    @PutMapping
    fun update (@RequestBody product:Product): ResponseEntity<Product>{
        return ResponseEntity(productService.update(product),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.updateName(product), HttpStatus.OK)
    }

}