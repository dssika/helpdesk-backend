package com.jessica.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jessica.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}