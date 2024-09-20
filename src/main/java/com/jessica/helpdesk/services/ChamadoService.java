package com.jessica.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jessica.helpdesk.domain.Chamado;
import com.jessica.helpdesk.domain.Cliente;
import com.jessica.helpdesk.domain.Tecnico;
import com.jessica.helpdesk.domain.dtos.ChamadoDTO;
import com.jessica.helpdesk.domain.enums.Prioridade;
import com.jessica.helpdesk.domain.enums.Status;
import com.jessica.helpdesk.repositories.ChamadoRepository;
import com.jessica.helpdesk.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository; // faz a comunicação com o banco, metodos jpa
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public List<Chamado> findAll() {

		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		
		oldObj = newChamado(objDTO);
		
		return repository.save(oldObj);
	}
	
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getId_tecnico());
		Cliente cliente = clienteService.findById(obj.getId_cliente());

		Chamado chamado = new Chamado();

		if (obj.getId() != null) { // quer atualizar
			chamado.setId(obj.getId());
		}
		
		if(obj.getCod_status().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}

		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getCod_prioridade()));
		chamado.setStatus(Status.toEnum(obj.getCod_status()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;

	}

	

}
