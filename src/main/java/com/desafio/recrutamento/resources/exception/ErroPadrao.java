package com.desafio.recrutamento.resources.exception;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer statusErro;
	private String mensagemErro;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone="GMT-3")
	private Date dataHoraErro;
	
	public ErroPadrao(Integer statusErro, String mensagemErro, Date dataHoraErro) {
		super();
		this.statusErro = statusErro;
		this.mensagemErro = mensagemErro;
		this.dataHoraErro = dataHoraErro;
	}

	public Integer getStatusErro() {
		return statusErro;
	}

	public void setStatusErro(Integer statusErro) {
		this.statusErro = statusErro;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public Date getDataHoraErro() {
		return dataHoraErro;
	}

	public void setDataHoraErro(Date dataHoraErro) {
		this.dataHoraErro = dataHoraErro;
	}

}
