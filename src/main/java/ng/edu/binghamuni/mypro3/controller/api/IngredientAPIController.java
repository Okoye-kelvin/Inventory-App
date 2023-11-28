package ng.edu.binghamuni.mypro3.controller.api;

import ng.edu.binghamuni.mypro3.Repository.IngredientRepository;
import ng.edu.binghamuni.mypro3.domain.Ingredient;
import ng.edu.binghamuni.mypro3.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class IngredientAPIController {
   @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    IngredientService ingredientService;
    @RequestMapping("ingredient")
    @GetMapping("ingredient")


    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        return ResponseEntity.ok().body(ingredientService.getAllIngredient());

    }
}
