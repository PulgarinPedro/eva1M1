package com.example.evaluacion.service

import com.example.evaluacion.model.Asistente
import com.example.evaluacion.repository.AsistenteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException
import javax.xml.ws.ResponseWrapper
import javax.xml.ws.soap.AddressingFeature.Responses

@Service
class AsistenteService {

    @Autowired
    lateinit var asistenteRepository: AsistenteRepository

    fun list():List<Asistente>{
        return asistenteRepository.findAll()
    }

    fun save(asistente:Asistente):Asistente{
        return asistenteRepository.save(asistente)
        asistenteRepository.findById(asistente.id) ?: throw Exception("10 no existe")
    }

    fun update(asistente: Asistente):Asistente{
        try{
        asistenteRepository.findById(asistente.id)
            ?: throw Exception("ID no existe")
        return asistenteRepository.save(asistente)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun updateName(asistente:Asistente): Asistente {
        try{
            val response = asistenteRepository.findById(asistente.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombres=asistente.nombres
            }
            return asistenteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}