package com.example.evaluacion.repository

import com.example.evaluacion.model.Asistente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AsistenteRepository:JpaRepository<Asistente, Long> {

    fun findById(id: Long?):Asistente?

}