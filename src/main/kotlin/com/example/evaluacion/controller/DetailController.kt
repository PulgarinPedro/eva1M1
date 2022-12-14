package com.example.evaluacion.controller

import com.example.evaluacion.service.DetailService
import com.example.evaluacion.model.Detail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/detail")
class DetailController {

    @Autowired
    lateinit var detailService: DetailService

    @GetMapping
    fun list():List<Detail>{
        return detailService.list()
    }


    @PostMapping
    fun save(@RequestBody @Valid detail:Detail):Detail{
        return detailService.save(detail)
    }

    @PutMapping
    fun update (@RequestBody detail: Detail): ResponseEntity<Detail>{
        return ResponseEntity(detailService.update(detail),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.updateQuantity(detail), HttpStatus.OK)
    }

}