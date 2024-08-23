package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Room;
import pl.coderslab.service.RoomService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAllRooms(Model model) {
        List<Room> room = roomService.get();
        model.addAttribute("room", room);
        return "room/all";
    }

    @GetMapping("/add")
    public String addRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "room/add";
    }

    @PostMapping("/add")
    public String saveRoom(@ModelAttribute("room") @Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "room/add";
        }
        roomService.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/edit/{id}")
    public String editRoomForm(@PathVariable Long id, Model model) {
        Room room = roomService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
        model.addAttribute("room", room);
        return "room/edit"; // Oczekuje na pokoje/edit.jsp
    }

    @PostMapping("/edit/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute("room") @Valid Room room, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "room/edit";
        }
        room.setId(id);
        roomService.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.delete(id);
        return "redirect:/rooms";
    }
}