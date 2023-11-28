package ng.edu.binghamuni.mypro3.controller;


import ng.edu.binghamuni.mypro3.domain.Drink;
import ng.edu.binghamuni.mypro3.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DrinkController {
    @Autowired
    DrinkService drinkService;
    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("drinks",drinkService.getAllDrinks());
        return "index";
    }
    @GetMapping("/showNewDrinkForm")
    public String showNewDrinkForm(Model model){
        model.addAttribute("drink", drinkService.getAllDrinks());
        return "new_drink";

    }
    @PostMapping("/saveDrink")
    public String saveDrink(@ModelAttribute("drink") Drink drink ){
        drinkService.saveDrink(drink);

        return "redirect:/";
    }
    }



