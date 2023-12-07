package ng.edu.binghamuni.mypro3.controller;


import ng.edu.binghamuni.mypro3.domain.Drink;
import ng.edu.binghamuni.mypro3.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DrinkController {
    @Autowired
    DrinkService drinkService;
    @GetMapping("/homepage")
    public String homepage(Model model){
        model.addAttribute("drinks",drinkService.getAllDrinks());
        return "home";
    }
    @GetMapping("/showNewDrinkForm")
    public String showNewDrinkForm(Model model){
        Drink drink =new Drink();
        model.addAttribute("drink", drink);
        model.addAttribute("nextPage","Add new drink");
        return "new_drink";

    }
    @PostMapping("/saveDrink")
    public String saveDrink(@ModelAttribute("drink") Drink drink, RedirectAttributes redirectAttributes){
        drinkService.saveDrink(drink);
        redirectAttributes.addFlashAttribute("message", "Drink update");
        redirectAttributes.addFlashAttribute("color", "success");

        return "redirect:/homepage";
    }
    @GetMapping("/updateDrink/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Drink drink = drinkService.getDrinkById(id);
            model.addAttribute("drink", drink);
            model.addAttribute("pageTitle", "Edit Drink Id:" + id);
            return "new_drink";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");

            return "redirect:/homepage";
        }
    }
        @PostMapping("/updateDrink")
        public String updateDrink(@ModelAttribute("drink") Drink drink, RedirectAttributes redirectAttributes){
            try {
                drinkService.saveDrink(drink);
                redirectAttributes.addFlashAttribute("message", "Drink updated successfully");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", "Error updating drink: " + e.getMessage());
            }
            return "redirect:/homepage";
        }
    @GetMapping("deleteDrink/{id}")
    public String deleteDrink(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            drinkService.deleteDrink(id);
            redirectAttributes.addFlashAttribute("message", "Drink Deleted successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");
        }

        return "redirect:/homepage";
    }
}



