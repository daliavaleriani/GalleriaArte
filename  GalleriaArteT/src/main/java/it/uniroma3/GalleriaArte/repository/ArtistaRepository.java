package it.uniroma3.GalleriaArte.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.GalleriaArte.model.Artista;



public interface ArtistaRepository extends CrudRepository<Artista, Long>  {

	List<Artista> findByNome(String nome);
	List<Artista> findByDataNascita(String dataNascita);
	List<Artista> findByCognome(String cognome);
	List<Artista> findByNazionalita(String nazionalita);
	


}
