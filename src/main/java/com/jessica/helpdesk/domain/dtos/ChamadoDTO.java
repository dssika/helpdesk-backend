package com.jessica.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jessica.helpdesk.domain.Chamado;

import jakarta.validation.constraints.NotNull;

public class ChamadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	@NotNull(message = "O campo PRIORIDADE é requerido")
	private Integer cod_prioridade;
	@NotNull(message = "O campo STATUS é requerido")
	private Integer cod_status;
	@NotNull(message = "O campo TITULO é requerido")
	private String titulo;
	@NotNull(message = "O campo OBSERVACOES é requerido")
	private String observacoes;
	@NotNull(message = "O campo TECNICO é requerido")
	private Integer id_tecnico;
	@NotNull(message = "O campo CLIENTE é requerido")
	private Integer id_cliente;
	private String nome_tecnico;
	private String nome_cliente;

	public ChamadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChamadoDTO(Chamado obj) {
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.cod_prioridade = obj.getPrioridade().getCodigo();
		this.cod_status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.id_tecnico = obj.getTecnico().getId();
		this.id_cliente = obj.getCliente().getId();
		this.nome_cliente = obj.getCliente().getNome();
		this.nome_tecnico = obj.getTecnico().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getCod_prioridade() {
		return cod_prioridade;
	}

	public void setCod_prioridade(Integer cod_prioridade) {
		this.cod_prioridade = cod_prioridade;
	}

	public Integer getCod_status() {
		return cod_status;
	}

	public void setCod_status(Integer cod_status) {
		this.cod_status = cod_status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getId_tecnico() {
		return id_tecnico;
	}

	public void setId_tecnico(Integer id_tecnico) {
		this.id_tecnico = id_tecnico;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_tecnico() {
		return nome_tecnico;
	}

	public void setNome_tecnico(String nome_tecnico) {
		this.nome_tecnico = nome_tecnico;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	
	
}
