package org.sjcdigital.seguranca.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@XmlRootElement
@Entity
@Table(name = "municipio")
@Cacheable
@NamedQueries({ @NamedQuery(name = "Municipio.porNome", query = "select m from Municipio m where m.nome = :nome"),
	@NamedQuery(name = "Municipio.porSiglaEstado", query = "select m from Municipio m where m.estado.sigla = :sigla")	

})
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "cache-classes-basicas")
public class Municipio {

	@Id
	@Column(name = "mun_id")
	private long id;

	@Column(name = "mun_nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "estado_est_id")
	private Estado estado;

	public Municipio() {
		super();
	}

	@Override
	public String toString() {
		return nome + " - " + estado.getSigla();
	}

	public Municipio(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

}
