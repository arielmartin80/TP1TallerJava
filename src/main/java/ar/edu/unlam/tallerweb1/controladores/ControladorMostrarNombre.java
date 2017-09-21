package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMostrarNombre {

	@RequestMapping("/miprimerejemplo")
	public ModelAndView irMostrarNombre(){
		
		ModelMap modelo = new ModelMap();
		ArrayList<String> lista=new ArrayList<String>();
		lista.add("Ariel");
		lista.add("Jenifer");
		lista.add("Eze");
		
		modelo.put("key",lista);
		
		return new ModelAndView("miprimerejemplo", modelo)	;
		
	}
//query Parameter
	@RequestMapping("/saludar")
	public ModelAndView irMostrarNombreURL(@RequestParam("nombre")String nombre){
			
			ModelMap modelo = new ModelMap();
			modelo.put("key",nombre);
			
			return new ModelAndView("nombreDesdeUrl", modelo);
			
		}
	@RequestMapping("/saludar2")
	public ModelAndView irMostrarNombreYApellido(@RequestParam("nombre")String nombre,
												 @RequestParam(name="apellido",required=false)String apellido )
	
	{
			
			ModelMap modelo = new ModelMap();
			modelo.put("key",nombre);
			modelo.put("key2",apellido);
			
			return new ModelAndView("nombreDesdeUrl", modelo);
			
		}
	
//Path Variable
	@RequestMapping("/saludar/{nombre}")
	public ModelAndView MostrarNombrePath(@PathVariable String nombre){
				
				ModelMap modelo = new ModelMap();
				modelo.put("key",nombre);
				
				return new ModelAndView("nombreDesdeUrl", modelo);
				
		}
}
