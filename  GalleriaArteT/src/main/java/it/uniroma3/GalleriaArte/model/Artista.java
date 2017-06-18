package it.uniroma3.GalleriaArte.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Artista {

	@Version
	private Integer version;


	@Override
	public String toString() {
		return (this.nome+this.cognome);
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@NotNull
	@Size(min=2, max=20)
	private String nome;
	@Column(nullable = false)
	@NotNull
	@Size(min=2, max=20)
	private String cognome;

	@NotNull
	@Size(min=2, max=20)
	private String nazionalita;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataMorte;


	@OneToMany(mappedBy="artista")
	private List<Opera> opere;

	public Artista(){
		this.opere= new ArrayList<Opera>();
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}





	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) { 
		this.dataMorte = dataMorte;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}



	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}


}

