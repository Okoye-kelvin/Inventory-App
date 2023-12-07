package ng.edu.binghamuni.mypro3.controller.api;

import ng.edu.binghamuni.mypro3.Repository.DrinkRepository;
import ng.edu.binghamuni.mypro3.domain.Drink;
import ng.edu.binghamuni.mypro3.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DrinkAPIController {

@Autowired
    DrinkRepository drinkRepository;
@Autowired
    DrinkService drinkService;
@RequestMapping("/drink")
@GetMapping("/drink")
public ResponseEntity<List<Drink>> getAllDrink(){
    return ResponseEntity.ok().body(drinkService.getAllDrinks());
}
@GetMapping
public ResponseEntity<Drink> getDrinkById(@PathVariable long id){
    return ResponseEntity.ok().body(drinkService.getDrinkById(id));
}
@PostMapping("/drink")
public ResponseEntity<Drink> saveDrink(@RequestBody Drink drink){
    return ResponseEntity.ok().body(drinkService.saveDrink(drink));
}
@PutMapping("/drink/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable long id, @RequestBody Drink drink){
    return ResponseEntity.ok().body(drinkService.updateDrink(drink));
    }
    @DeleteMapping("/drink/{id}")
    public HttpStatus deleteDrink(@PathVariable long id ){
    drinkService.deleteDrink(id);
    return HttpStatus.OK;
    }



}
