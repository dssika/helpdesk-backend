package com.jessica.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jessica.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}