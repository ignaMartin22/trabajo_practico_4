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

import ar.edu.unju.fi.collections.AlumnoService;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
@Autowired
private Alumno alumno;

	@GetMapping("/listadealumnos")
	public String getAlumnosPage(Model model) {
		model.addAttribute("alumnos", AlumnoService.getAlumnos());
		model.addAttribute("titulo", "Alumnos");
		return "alumno";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("alumno", alumno);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Alumno");
		return "nuevoAlumno";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		ModelAndView modelView = new ModelAndView("alumno");
		AlumnoService.agregarAlumno(alumno);
		modelView.addObject("alumnos", AlumnoService.getAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificar/{dni}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="dni")Long dni) {
		Alumno alumnoEncontrado = new Alumno();
		boolean edicion = true;
		alumnoEncontrado = AlumnoService.buscarAlumno(dni);
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontrado);
		model.addAttribute("titulo", "Modificar Alumno");
		return "nuevoAlumno";
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		AlumnoService.modificarAlumno(alumno);
		return "redirect:/alumnos/listadealumnos";
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable(value="dni") Long dni) {
		AlumnoService.eliminarAlumno(dni);
		return "redirect:/alumnos/listadealumnos";
	}
}
