package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.PersonRent;
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
        public String getAllPersonRent(Model model) {
            List<PersonRent> personRent = personRentService.get();
            model.addAttribute("personRent", personRent);
            //znajduje wynajmy  przez rentService do rentRepository i tam metody // nie widzi mi w pliku jsp personRent dostępu do rent
//            model.addAttribute("rent", rentService.findAllByPersonRent());
            return "personRent/all";
        }

        @GetMapping("/add")
        public String addPersonRentForm(Model model) {
            model.addAttribute("personRent", new PersonRent());
            return "personRent/all";
        }

        @PostMapping("/add")
        public String savPersonRent(@ModelAttribute("personRent") @Valid PersonRent personRent, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "personRent/add";
            }
            personRentService.save(personRent);
            return "redirect:/personRents";
        }

        @GetMapping("/edit/{id}")
        public String editPersonRentForm(@PathVariable Long id, Model model) {
            PersonRent personRent = personRentService.getById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid personRent Id:" + id));
         model.addAttribute("personRent", personRent);
//            //znajduje wynajmy  przez rentService do rentRepository i tam metody) // nie widzi mi w pliku personRent.jsp dostępu do rent
//         model.addAttribute("rent", rentService.findByPersonRentId(id));
            return "personRent/edit";
        }

        @PostMapping("/edit/{id}")
        public String updatePersonRent(@PathVariable Long id, @ModelAttribute("personRent") @Valid PersonRent personRent, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return "personRent/edit";
            }
            personRentService.save(personRent);
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

            model.addAttribute("rent", rentService.findByPersonRentId(id));


            // model.addAttribute("posciel", poscielService.findByWynajmujacyId(id));
            // model.addAttribute("sprzatanie", sprzatanieService.findByWynajmujacyId(id));
            // model.addAttribute("czynsz", czynszService.findByWynajmujacyId(id));
            // model.addAttribute("kaucja", kaucjaService.findByWynajmujacyId(id));

            return "personRent/details";
        }
    }
