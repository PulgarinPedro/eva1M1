package com.example.evaluacion.controller

import com.example.evaluacion.model.Asistente
import com.example.evaluacion.service.AsistenteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/asistente")
class AsistenteController {

    @Autowired
    lateinit var asistenteService: AsistenteService

    @GetMapping
    fun list():List<Asistente>{
        return asistenteService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long):ResponseEntity<Asistente>{
        return ResponseEntity(asistenteService.listById(id), HttpStatus.OK)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return asistenteService.delete(id)
    }


    @PostMapping
    fun save(@RequestBody @Validated asistente: Asistente):Asistente{
        return asistenteService.save(asistente)
    }

    @PutMapping
    fun update (@RequestBody asistente: Asistente): ResponseEntity<Asistente>{
        return ResponseEntity(asistenteService.update(asistente),HttpStatus.OK )
    }

    @PatchMapping
    fun updateName (@RequestBody asistente:Asistente):ResponseEntity<Asistente>{
        return ResponseEntity(asistenteService.updateName(asistente), HttpStatus.OK)
    }

}