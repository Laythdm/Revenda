package com.ativ.atividade2.controller;
import com.ativ.atividade2.data.CarroEntity;
import com.ativ.atividade2.data.CarroRepository;
import com.ativ.atividade2.service.CarroService;
import jakarta.validation.Valid; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.PostMapping; 

@Controller 

public class FrontController { 
@Autowired 
CarroService carroService; 
@Autowired
private CarroRepository carroRepository;

@GetMapping("/index") 
public String index(Model model) { 
model.addAttribute("listaCarros", carroService.listarTodosCarros()); 
return "index"; 
} 
@GetMapping("/lista") 
public String lista(Model model) { 
model.addAttribute("listaCarros", carroService.listarTodosCarros()); 
return "lista"; 
} 
@PostMapping("/carro/status/{id}")
    public String alternarStatus(@PathVariable Integer id, @ModelAttribute("disponivel") String disponivel, Model model) {
        Optional<CarroEntity> optional = carroRepository.findById(id);
        if (optional.isPresent()) {
            CarroEntity carro = optional.get();
            carro.setDisponivel(disponivel); 
            carroRepository.save(carro);
        }
        model.addAttribute("listaCarros", carroService.listarTodosCarros());
        return "lista";
    }

@GetMapping("/criarCarroForm") 
public String criarFormulario(Model model) {
    model.addAttribute("carro", new CarroEntity());
    return "registro";
}

@GetMapping("/carro/status/{id}")
public String alternarStatus(@PathVariable Integer id) {
    Optional<CarroEntity> optional = carroRepository.findById(id);
    if (optional.isPresent()) {
        CarroEntity carro = optional.get();
        carro.setDisponivel(carro.getDisponivel().equalsIgnoreCase("Sim") ? "Não" : "Sim");
        carroRepository.save(carro);
    }
    return "redirect:/lista";
}

@PostMapping("/salvarCarro") 



public String salvarCarro(@Valid @ModelAttribute("carro") CarroEntity func, BindingResult result) { 


if (result.hasErrors()) { 

return "registro"; 

} 

if (func.getId()==null) { 

carroService.criarCarro(func); 
 

} else { 


} 

return "redirect:/index"; 

} 


} 
