package com.example.evaluacion.service

import com.example.evaluacion.model.Product
import com.example.evaluacion.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException
import javax.xml.ws.ResponseWrapper
import javax.xml.ws.soap.AddressingFeature.Responses

@Service
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    fun list():List<Product>{
        return productRepository.findAll()
    }

    fun save(product:Product):Product{
        productRepository.findById(product.id) ?: throw Exception("10 no existe")
        return productRepository.save(product)

    }

    fun update(product:Product):Product{
        try{
        productRepository.findById(product.id)
            ?: throw Exception("ID no existe")
        return productRepository.save(product)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(product:Product): Product {
        try{
            val response = productRepository.findById(product.id)
                ?: throw Exception("ID no existe")
            response.apply {
                descripcion=product.descripcion
            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}