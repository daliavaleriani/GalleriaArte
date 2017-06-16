package it.uniroma3.GalleriaArte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.GalleriaArte.model.Artista;
import it.uniroma3.GalleriaArte.model.Opera;
import it.uniroma3.GalleriaArte.service.ArtistaService;
import it.uniroma3.GalleriaArte.service.OperaService;

@Controller
public class MainController {

	@RequestMapping("artista/new")
	public String newArtista(Model model){
		model.addAttribute("artista", new Artista());
		return "artistaform";
	}
	@RequestMapping("opera/new")
	public String newOpera(Model model){
		model.addAttribute("opera", new Opera());
		return "operaform";
	}


	@Autowired
	private OperaService operaservice;

	@RequestMapping(value = "opera", method = RequestMethod.POST)
	public String saveOpera(Opera opera){
		operaservice.add(opera);
		return "redirect:/opera/" + opera.getId();
	}

	@RequestMapping("opera/edit/{id}")
	public String editOpera(@PathVariable Long id, Model model){
		model.addAttribute("opera", operaservice.getOperaById(id));
		return "operaform";
	}
	@Autowired
	private ArtistaService artistaservice;

	@RequestMapping("artista/edit/{id}")
	public String edit(@PathVariable Long id, Model model){
		model.addAttribute("artista", artistaservice.getArtistaById(id));
		return "artistaform";
	}

	@RequestMapping(value = "artista", method = RequestMethod.POST)
	public String saveArtista(Artista artista){
		artistaservice.add(artista);
		return "redirect:/artista/" + artista.getId();
	}


	@RequestMapping(value = "/artisti", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("artisti", artistaservice.findAll());
		return "artisti";
	}

	@RequestMapping(value = "/opere", method = RequestMethod.GET)
	public String listOpere(Model model){
		model.addAttribute("opere", operaservice.findAll());
		return "opere";
	}



	@RequestMapping("opera/{id}")
	public String showProduct(@PathVariable Long id, Model model){
		model.addAttribute("opera", operaservice.getOperaById(id));
		return "mostraOpera";
	}

	@RequestMapping("artista/{id}")
	public String mostraArtista(@PathVariable Long id, Model model){
		model.addAttribute("artista", artistaservice.getArtistaById(id));
		return "mostraArtista";
	}



	@RequestMapping("artista/delete/{id}")
	public String delete(@PathVariable Long id){
		artistaservice.remove(id);
		return "redirect:/artisti";
	}


}






