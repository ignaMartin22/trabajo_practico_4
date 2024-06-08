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
import ar.edu.unju.fi.collections.DocenteService;
import ar.edu.unju.fi.collections.MateriaService;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	private Carrera carrera;
	@Autowired
	private Docente docente;
	@GetMapping("/listadomaterias")
	public String getMateriasPage(Model model) {
		model.addAttribute("titulo", "Lista de Materias");
		model.addAttribute("materias",MateriaService.getMateria());
		return "materias";
	}
	@GetMapping("/nuevo")
	public String getNuevoPage(Model model) {
		boolean edicion = false;
		Materia materia = new Materia();
		model.addAttribute("modalidad", Modalidad.values());
		model.addAttribute("docentes", DocenteService.getDocentes());
		model.addAttribute("carreras", CarrerasService.getCarreras());
		model.addAttribute("materia", materia);
		model.addAttribute("titulo", "Agregar Materia");
		model.addAttribute("edicion",edicion);
		
		return "nuevaMateria";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia")Materia materia) { //aqui va el nombre del objeto que se vincula
		ModelAndView modelView = new ModelAndView("materias"); // aqui va el nombre del html
		 carrera =  CarrerasService.buscarCarrera(materia.getCarrera().getCodigo());
		 docente =  DocenteService.buscarDocente(materia.getDocente().getLegajo());
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		MateriaService.agregarMateria(materia);
		modelView.addObject("materias", MateriaService.getMateria());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") int codigo) {
		Materia materiaBuscar = new Materia();
		boolean edicion = true;
		materiaBuscar = MateriaService.buscarMateria(codigo);
		model.addAttribute("modalidad",Modalidad.values());
		model.addAttribute("edicion",edicion);
		model.addAttribute("materia", materiaBuscar);
		model.addAttribute("docentes", DocenteService.getDocentes());
		model.addAttribute("carreras", CarrerasService.getCarreras());
		
		return "nuevaMateria";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") Materia materia) {
		 carrera = CarrerasService.buscarCarrera(materia.getCarrera().getCodigo());
		 docente = DocenteService.buscarDocente(materia.getDocente().getLegajo());
		 materia.setCarrera(carrera);
		 materia.setDocente(docente);
		MateriaService.modificarMateria(materia);
		return "redirect:/materias/listadomaterias";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMaterias(@PathVariable(value="codigo") int codigo) {
       MateriaService.eliminarMateria(codigo);
       return "redirect:/materias/listadomaterias";
	}
}
