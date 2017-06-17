package it.uniroma3.GalleriaArte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.GalleriaArte.model.Opera;
import it.uniroma3.GalleriaArte.repository.OperaRepository;



@Service
public class OperaService {

	@Autowired
	private OperaRepository operaRepository;

	public Iterable<Opera> findAll() {
		return this.operaRepository.findAll();
	}
	@Transactional
	public void add(final Opera opera) {
		this.operaRepository.save(opera);
	}

	public Opera findbyId(Long id) {
		return this.operaRepository.findOne(id);
	}
	@Transactional
	public void remove(final Long id) {
		this.operaRepository.delete(id);
	}
	public Opera getOperaById(Long id) {
		
		return operaRepository.findOne(id);
	}

}
