package it.uniroma3.GalleriaArte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.GalleriaArte.model.Artista;
import it.uniroma3.GalleriaArte.model.Opera;
import it.uniroma3.GalleriaArte.repository.ArtistaRepository;


@Service
public class ArtistaService {
	@Autowired
	private ArtistaRepository artistaRepository;

	public Iterable<Artista> findAll() {
		return this.artistaRepository.findAll();
	}
	@Transactional
	public void add(final Artista artista) {
		this.artistaRepository.save(artista);
	}
	public Artista findbyId(Long id) {
		return this.artistaRepository.findOne(id);
	}
	@Transactional
	public void remove(final Artista artista) {
		this.artistaRepository.delete(artista);
	}
	
public Artista getArtistaById(Long id) {
		
		return artistaRepository.findOne(id);
	}


}
