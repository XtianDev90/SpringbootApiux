package com.apiux.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Tarea {
	@Id
	@NotNull(message = "El campo IDENTIFICADOR es obligatorio.")
	private Integer identificador;
	
	@NotNull(message = "El campo DESCRIPCION es obligatorio.")
	@Column
	private String descripcion;
	
	@Column
	private Date fechaCreacion;
	
	@NotNull(message = "El campo VIGENCIA es obligatorio.")
	@Column
	private boolean vigente;
	
	public Integer getIdentificador() {
		return identificador;
	}
	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isVigente() {
		return vigente;
	}
	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
	
	
}
