package it.uniroma3.GalleriaArte.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Opera {
	
	@Version
	private Integer version;

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable=false)
	private int annoRealizzazione;
	@Column(nullable = false)
	private String tecnica;
	@Column(nullable = false)
	private int dimensione;


	@ManyToOne
	private Artista artista;
	public Long getId() {
		return id;
	}
	public int getAnnoRealizzazione() {
		return annoRealizzazione;
	}
	public void setAnnoRealizzazione(int annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public int getDimensione() {
		return dimensione;
	}
	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}





}
