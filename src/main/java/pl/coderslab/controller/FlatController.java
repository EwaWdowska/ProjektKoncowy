package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Flat;
import pl.coderslab.entity.PersonRent;

import pl.coderslab.service.JpaFlatService;
import pl.coderslab.service.PersonRentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/flats")
public class FlatController {


    private final JpaFlatService jpaFlatService;
    private final PersonRentService personRentService;


    @Autowired
    public FlatController(JpaFlatService jpaFlatService, PersonRentService personRentService) {
        this.jpaFlatService = jpaFlatService;
        this.personRentService = personRentService;
    }

    @GetMapping("/allFlats")
    public String  getAllFlats (Model model) {
        List<Flat> flats = jpaFlatService.getF();
        model.addAttribute("flats", flats);
        return "flat/allF";
    }




    @GetMapping("/add")
    public String addFlatForm(Model model) {
        model.addAttribute("flat", new Flat());
        return "flat/addF";
    }

    @PostMapping("/add")
    public String saveFlat(@ModelAttribute("flat") @Valid Flat flat, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "flat/addF";
        }
        jpaFlatService.saveF(flat);
        return "redirect:/flats/allFlats";
    }

    @GetMapping("/edit/{id}")
    public String editFlatForm(@PathVariable Long id, Model model) {
        Flat flat = jpaFlatService.getByIdF(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid flat Id:" + id));
        model.addAttribute("flat", flat);
        return "flat/editF";
    }

    @PostMapping("/edit/{id}")
    public String updateMieszkanie(@PathVariable Long id, @ModelAttribute("flat") @Valid Flat flat, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "flat/editF";
        }
        flat.setId(id);
        jpaFlatService.saveF(flat);
        return "redirect:/flats/allFlats";
    }


    @GetMapping("/delete/{id}")
    public String deleteFlat(@PathVariable Long id) {
        jpaFlatService.deleteF(id);
        return "redirect:/flats/allFlats";
    }

    @GetMapping("/details/{id}")
    public String detailsPersonRent(@PathVariable Long id, Model model) {
        Flat flat  = jpaFlatService.getByIdF(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid flat Id:" + id));
        List <PersonRent> personRent = personRentService.findPersonRentById(id);
        model.addAttribute("flat",flat);
        model.addAttribute("personRent", personRent);

        return "flat/details";
    }



}
