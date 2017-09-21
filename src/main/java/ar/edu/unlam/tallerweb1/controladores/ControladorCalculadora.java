package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorCalculadora {

	
		@RequestMapping("/calcular/sumar/{primerOperando}/{segundoOperando}")
		public ModelAndView MostrarSuma(		
												@PathVariable double primerOperando,
												@PathVariable double segundoOperando	)
		{
				String operacion="sumar";
			
					ModelMap modelo = new ModelMap();
					modelo.put("operacion", operacion);
					modelo.put("key1",primerOperando);
					modelo.put("key2",segundoOperando);
					
					double resultado=primerOperando+segundoOperando;
					modelo.put("resultado",resultado);
					
					return new ModelAndView("calcular", modelo);
							
		}
		
		@RequestMapping("/calcular/restar/{primerOperando}/{segundoOperando}")
		public ModelAndView MostrarResta(		
												@PathVariable double primerOperando,
												@PathVariable double segundoOperando	)
		{
				String operacion="restar";
			
					ModelMap modelo = new ModelMap();
					modelo.put("operacion", operacion);
					modelo.put("key1",primerOperando);
					modelo.put("key2",segundoOperando);
					
					double resultado=primerOperando-segundoOperando;
					modelo.put("resultado",resultado);
					
					return new ModelAndView("calcular", modelo);
							
		}
		
		@RequestMapping("/calcular/multiplicar/{primerOperando}/{segundoOperando}")
		public ModelAndView MostrarMultiplicar(		
												@PathVariable double primerOperando,
												@PathVariable double segundoOperando	)
		{
				String operacion="multiplicar";
			
					ModelMap modelo = new ModelMap();
					modelo.put("operacion", operacion);
					modelo.put("key1",primerOperando);
					modelo.put("key2",segundoOperando);
					
					double resultado=primerOperando*segundoOperando;
					modelo.put("resultado",resultado);
					
					return new ModelAndView("calcular", modelo);
							
		}
		
		@RequestMapping("/calcular/dividir/{dividendo}/{divisor}")
		public ModelAndView MostrarDivision(	
												@PathVariable float dividendo,
												@PathVariable float divisor	)
		{
					
			String operacion="dividir";
			
					ModelMap modelo = new ModelMap();
					modelo.put("operacion", operacion);
					modelo.put("key1",dividendo);
					modelo.put("key2",divisor);
					
					if(divisor==0){
						String mje="No se puede dividir por 0";
						modelo.put("error",mje);
						return new ModelAndView("errorDeCal", modelo);
					}
					
					float resultado=dividendo/divisor;
					modelo.put("resultado",resultado);
					
						return new ModelAndView("calcular", modelo);
							
		}
		
		
		
	
}
