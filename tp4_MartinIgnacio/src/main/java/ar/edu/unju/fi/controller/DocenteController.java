package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.DocenteService;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
@Autowired Docente docente;
	
	@GetMapping("/listadocentes")
	public String getDocentesPage(Model model) {
		model.addAttribute("titulo", "Lista de Docentes");
		model.addAttribute("docentes", DocenteService.getDocentes());
		return "docentes";
	}
	@GetMapping("/nuevo")
	public String getNuevoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("docente", docente);
		model.addAttribute("titulo", "Agregar Docente");
		model.addAttribute("edicion",edicion);
		
		return "nuevoDocente";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docente")Docente docente) { //aqui va el nombre del objeto que se vincula
		ModelAndView modelView = new ModelAndView("docentes"); // aqui va el nombre del html 
		DocenteService.agregarDocente(docente);
		modelView.addObject("docentes", DocenteService.getDocentes());
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarDocentePage(Model model, @PathVariable(value="legajo") int legajo) {
		Docente docenteBuscar = new Docente();
		boolean edicion = true;
		docenteBuscar = DocenteService.buscarDocente(legajo);
		model.addAttribute("titulo", "Modificar Docente");
		model.addAttribute("edicion",edicion);
		model.addAttribute("docente", docenteBuscar);
		
		return "nuevoDocente";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") Docente docente) {
		DocenteService.modificarDocente(docente);
		return "redirect:/docentes/listadocentes";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarAlumno(@PathVariable(value="legajo") int legajo) {
		DocenteService.eliminarDocente(legajo);
		return "redirect:/docentes/listadocentes";
	}
}
