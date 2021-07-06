package com.santander.cantina.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AvaliacaoChave implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cliente_id")
	private Integer clienteId;

	@Column(name = "produto_id")
	private Integer produtoId;
	
	public AvaliacaoChave() {
	}

	public AvaliacaoChave(Integer clienteId, Integer produtoId) {
		this.clienteId = clienteId;
		this.produtoId = produtoId;
	}


	public Integer getClienteId() {
		return clienteId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clienteId == null) ? 0 : clienteId.hashCode());
		result = prime * result + ((produtoId == null) ? 0 : produtoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoChave other = (AvaliacaoChave) obj;
		if (clienteId == null) {
			if (other.clienteId != null)
				return false;
		} else if (!clienteId.equals(other.clienteId))
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}

}
