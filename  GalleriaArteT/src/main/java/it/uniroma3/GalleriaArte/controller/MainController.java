package it.uniroma3.GalleriaArte.controller;



import java.text.SimpleDateFormat;


import java.util.Date;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.GalleriaArte.model.Artista;
import it.uniroma3.GalleriaArte.model.Opera;
import it.uniroma3.GalleriaArte.service.ArtistaService;
import it.uniroma3.GalleriaArte.service.OperaService;

@Controller
public class MainController  {



	@InitBinder
	public void initBinder(WebDataBinder binder) {


		String format = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat,true,format.length());

		binder.registerCustomEditor(Date.class, customDateEditor);
	}




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
	public String saveOpera(@ModelAttribute(value="opera") @Valid Opera opera,
			BindingResult bindingResultArtista ){
		if (bindingResultArtista.hasErrors()) {
			return "operaform";
		}
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
	public String saveArtista(@ModelAttribute(value="artista") @Valid Artista artista , BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return "artistaform";
		}
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
	public String mostraOpera(@PathVariable Long id, Model model){
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

	@RequestMapping("opera/delete/{id}")
	public String deleteOpera(@PathVariable Long id){
		operaservice.remove(id);
		return "redirect:/opere";
	}


}






