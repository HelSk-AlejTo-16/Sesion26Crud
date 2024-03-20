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
import mx.utng.session26.model.entity.Directivo;
import mx.utng.session26.model.service.IDirectivoService;

@Controller
@SessionAttributes("directivo")
public class DirectivoController {
    
    @Autowired
    private IDirectivoService service;

    @GetMapping({"/directivo", "/directivo/", "/directivo/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Directivos");
        model.addAttribute("directivos", service.list());
        return "directivo-list";
    }

    @GetMapping("/directivo/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Directivos");
        model.addAttribute("directivo", new Directivo());
        return "directivo-form";
    }

    @PostMapping("/directivo/form")
    public String save(@Valid Directivo directivo, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Directivo");
            return "directivo-form";
        }
        service.save(directivo);
        return "redirect:/directivo/list";
    }

    @GetMapping("/directivo/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Directivo directivo = null;
        if(id>0){
            directivo = service.getById(id);
        }else{
            return "redirect:/directivo/list";
        }
        model.addAttribute("title", "Editar Directivo");
        model.addAttribute("directivo", directivo);
        return "directivo-form";
    }

    @GetMapping("/directivo/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/directivo/list";
    }



}
