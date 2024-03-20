package mx.utng.session26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.session26.model.entity.Paraescolar;
import mx.utng.session26.model.service.IParaEscolarService;

@Controller
@SessionAttributes("paraescolar")
public class ParaEscolarController {
    
    @Autowired
    private IParaEscolarService service;

    @GetMapping({"/paraescolar", "/paraescolar/", "/paraescolar/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Paraescolares");
        model.addAttribute("paraescolares", service.list());
        return "paraescolar-list";
    }

    @GetMapping("/paraescolar/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Paraescolares");
        model.addAttribute("paraescolar", new Paraescolar());
        return "paraescolar-form";
    }

    @PostMapping("/paraescolar/form")
    public String save(@Valid Paraescolar paraescolar, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Paraescolares");
            return "paraescolar-form";
        }
        service.save(paraescolar);
        return "redirect:/paraescolar/list";
    }

    @GetMapping("/paraescolar/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Paraescolar paraescolar = null;
        if(id>0){
            paraescolar = service.getById(id);
        }else{
            return "redirect:/paraescolar/list";
        }
        model.addAttribute("title", "Editar Paraescolar");
        model.addAttribute("paraescolar", paraescolar);
        return "paraescolar-form";
    }

    @GetMapping("/paraescolar/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/paraescolar/list";
    }



}
