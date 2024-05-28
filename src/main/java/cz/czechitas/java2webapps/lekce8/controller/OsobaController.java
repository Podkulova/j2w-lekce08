package cz.czechitas.java2webapps.lekce8.controller;

import cz.czechitas.java2webapps.lekce8.entity.Osoba;
import cz.czechitas.java2webapps.lekce8.repository.OsobaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class OsobaController {
    private final OsobaRepository repository;

    private final List<Osoba> seznamOsob = List.of(
            new Osoba(1L, "Božena", "Němcová", LocalDate.of(1820, 2, 4), "Vídeň", null, null)
    );

    public OsobaController(OsobaRepository repository) {
        this.repository = repository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        //prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        //načíst seznam osob
        return new ModelAndView("seznam")
                .addObject("osoby", repository.findAll());
    }

    @GetMapping("/novy")
    public ModelAndView novy() {
        return new ModelAndView("detail")
                .addObject("osoba", new Osoba());
    }

    @PostMapping("/novy")
    public String pridat(@ModelAttribute("osoba") @Valid Osoba osoba, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        //uložit údaj o nové osobě
        repository.save(osoba);
        return "redirect:/";
    }

    @GetMapping("/{id:[0-9]+}")
    public Object detail(@PathVariable long id) {
        //načíst údaj o osobě
        Optional<Osoba> osoba = repository.findById(id);

        if (osoba.isPresent()) {
            return new ModelAndView("detail")
                    .addObject("osoba", osoba.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id:[0-9]+}")
    public String ulozit(@ModelAttribute("osoba") @Valid Osoba osoba, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        //uložit údaj o osobě
        repository.save(osoba);
        return "redirect:/";
    }

    @PostMapping(value = "/{id:[0-9]+}", params = "akce=smazat")
    public String smazat(@PathVariable long id) {
        //smazat údaj o osobě
        repository.deleteById(id);
        return "redirect:/";
    }
}
