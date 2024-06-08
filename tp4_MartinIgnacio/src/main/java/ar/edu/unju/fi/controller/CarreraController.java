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

import ar.edu.unju.fi.collections.CarrerasService;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {
@Autowired
private Carrera carrera;

@GetMapping("/listadocarreras")
public String getCarrerasPage(Model model) {
	model.addAttribute("titulo", "Carreras");
	model.addAttribute("carreras", CarrerasService.getCarreras());
	return "carrera";
}

@GetMapping("/nuevo")
public String getNuevaCarreraPage(Model model) {
	boolean edicion = false;
	model.addAttribute("titulo", "Nueva carrera");
	model.addAttribute("carrera", carrera);
	model.addAttribute("edicion", edicion);
	return "carreraNueva";
}
	
@PostMapping("/guardar")
public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
	ModelAndView modelView = new ModelAndView("carrera");
	modelView.addObject("titulo", "Carreras");
	CarrerasService.agregarCarrera(carrera);
	modelView.addObject("carreras", CarrerasService.getCarreras());
	return modelView;
}

@GetMapping("/modificar/{codigo}")
public String getModificarCarrera(Model model,@PathVariable(value="codigo") int codigo) {
	Carrera carreraEncontrada = new Carrera();
	carreraEncontrada = CarrerasService.buscarCarrera(codigo);
	boolean edicion = true;
	model.addAttribute("edicion",edicion);
	model.addAttribute("titulo", "Modificar Carrera");
	model.addAttribute("carrera", carreraEncontrada);
	return "carreraNueva";
}
	
@PostMapping("/modificar")
public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
	CarrerasService.modificarCarrera(carrera);
	return "redirect:/carreras/listadocarreras";
}

@GetMapping("/eliminar/{codigo}")
public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
	CarrerasService.eliminarCarrera(codigo);
	return "redirect:/carreras/listadocarreras";
}
}
