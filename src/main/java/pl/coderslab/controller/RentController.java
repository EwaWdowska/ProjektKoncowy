package pl.coderslab.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Rent;
import pl.coderslab.service.RentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rents")
public class RentController {

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping
    public String getAllRents(Model model) {
        List<Rent> rent = rentService.get();
        model.addAttribute("rent", rent);
        return "rent/all";
    }

    @GetMapping("/add")
    public String addRentForm(Model model) {
        model.addAttribute("rent", new Rent());
        return "rent/add";
    }

    @PostMapping("/add")
    public String saveRent(@ModelAttribute("rent") @Valid Rent rent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rent/add";
        }
        rentService.save(rent);
        return "redirect:/rents";
    }

    @GetMapping("/edit/{id}")
    public String editRentForm(@PathVariable Long id, Model model) {
        Rent rent = rentService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid rent Id:" + id));
        model.addAttribute("rent", rent);
        return "rent/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateRent(@PathVariable Long id, @ModelAttribute("rent") @Valid Rent rent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "rent/edit";
        }
        rent.setId(id);
        rentService.save(rent);
        return "redirect:/rents";
    }

    @GetMapping("/delete/{id}")
    public String deleteWynajem(@PathVariable Long id) {
        rentService.delete(id);
        return "redirect:/rents";
    }
}
