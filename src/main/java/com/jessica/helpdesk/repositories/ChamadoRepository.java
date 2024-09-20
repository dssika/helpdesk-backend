package com.jessica.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jessica.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}