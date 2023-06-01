package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Biblioteca;
import web.repository.BibliotecaRepository;
@Controller
public class BibliotecaController {
	@Autowired
	private BibliotecaRepository ur;
	
	@RequestMapping(value="/cadastrarLivros",method=RequestMethod.GET)
	public String form(){
		return "usuarios/Biblioteca";
	}
	@RequestMapping(value="/cadastrarLivros", method=RequestMethod.POST)
	public String form(Biblioteca livros){
		
		ur.save(livros);
		return "redirect:/cadastrarLivros";
	}
	@RequestMapping("/listaLivros")
	public ModelAndView listaLivros(){
		
		ModelAndView mv = new ModelAndView("usuarios/listaLivros");
		
		Iterable<Biblioteca> Biblioteca = ur.findAll();
	
		mv.addObject("Biblioteca", Biblioteca);
		return mv;
	}


}
