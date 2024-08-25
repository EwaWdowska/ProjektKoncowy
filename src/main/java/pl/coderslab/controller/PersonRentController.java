package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.PersonRent;
import pl.coderslab.entity.Rent;
import pl.coderslab.service.PersonRentService;
import pl.coderslab.service.RentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/personRents")
public class PersonRentController {

    private final PersonRentService personRentService;
    private final RentService rentService;


    @Autowired
    public PersonRentController(PersonRentService personRentService, RentService rentService) {
        this.personRentService = personRentService;
        this.rentService = rentService;
    }

    @GetMapping
    public String getAllPersonRent(Model model ) {
        List<PersonRent> personRent = personRentService.get();
        List<Rent> rent = rentService.get();
        model.addAttribute("personRent", personRent);
        model.addAttribute("rent",rent);
        return "personRent/all";
    }

    @GetMapping("/add")
    public String addPersonRentForm(Model model) {
        model.addAttribute("personRent", new PersonRent());
      model.addAttribute("rent",new Rent());
        return "personRent/add";
    }

    @PostMapping("/add")
    public String savPersonRent(@ModelAttribute("personRent") @Valid PersonRent personRent, BindingResult bindingResult,@ModelAttribute("rent") @Valid Rent rent, BindingResult bindingResult1) {
        if (bindingResult.hasErrors()) {
            return "personRent/add";
        }
        if (bindingResult1.hasErrors()) {
            return "personRent/add";
        }
        rentService.save(rent);
        personRentService.save(personRent);
        return "redirect:/personRents";
    }

    @GetMapping("/edit/{id}")
    public String editPersonRentForm(@PathVariable Long id, Model model) {
        PersonRent personRent = personRentService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid personRent Id:" + id));
        Rent rent = rentService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rent Id:" + id));
        model.addAttribute("personRent", personRent);

        model.addAttribute("rent", rent);
        return "personRent/edit";
    }

    @PostMapping("/edit/{id}")
    public String updatePersonRent(@PathVariable Long id, @ModelAttribute("personRent") @Valid PersonRent personRent, BindingResult bindingResult,@ModelAttribute("rent") @Valid Rent rent) {
        if (bindingResult.hasErrors()) {
            return "personRent/edit";
        }
       personRent.setId(id);
        rent.setId(id);
        personRentService.save(personRent);
        rentService.save(rent);
        return "redirect:/personRents";
    }



    @GetMapping("/delete/{id}")
    public String deletePersonRent(@PathVariable Long id) {
        personRentService.delete(id);
        return "redirect:/personRents";
    }

    @GetMapping("/details/{id}")
    public String deletePersonRent(@PathVariable Long id, Model model) {
        PersonRent personRent = personRentService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid personRent Id:" + id));
        model.addAttribute("personRent", personRent);
     model.addAttribute("rent", rentService.findRentById(id));
        return "personRent/details";
    }
}
