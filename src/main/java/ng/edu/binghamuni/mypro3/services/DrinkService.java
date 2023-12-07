package ng.edu.binghamuni.mypro3.services;

import ng.edu.binghamuni.mypro3.domain.Drink;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DrinkService {
Drink saveDrink(Drink drink);
Drink getDrinkById(long Id);
List<Drink> getAllDrinks();
Drink updateDrink(Drink drink);
void deleteDrink(long Id);


}
