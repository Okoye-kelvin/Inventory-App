package ng.edu.binghamuni.mypro3.services;

import ng.edu.binghamuni.mypro3.domain.Drink;

import java.util.List;

public interface DrinkService {
Drink saveDrink(Drink drink);
Drink getDrinkById(Long Id);
List<Drink> getAllDrinks();

    List<Drink> getAllDrink();

    Drink UpdateDrink(Drink drink);
void deleteDrink(Long Id);


}
