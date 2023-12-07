package ng.edu.binghamuni.mypro3.services;

import ng.edu.binghamuni.mypro3.Repository.DrinkRepository;
import ng.edu.binghamuni.mypro3.domain.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {
    @Autowired
    DrinkRepository drinkRepository;

    @Override
    public Drink saveDrink(Drink drink) {

        return drinkRepository.save(drink);
    }

    @Override
    public Drink getDrinkById(long id) {
        Optional<Drink> drink = drinkRepository.findById(id);

        Drink emptyDrink = null;
        if (drink.isPresent()){
            emptyDrink = drink.get();
            return emptyDrink;
        } else {
            throw new RuntimeException("Drink Not Found");
        }
    }
    @Override
    public List<Drink> getAllDrinks() {

        return drinkRepository.findAll();
    }


    @Override
    public Drink updateDrink(Drink drink) {
        Optional<Drink> optionalDrink = drinkRepository.findById(drink.getId()); //this is to check if the drink exist
        if (optionalDrink.isPresent()) {
            Drink updateDrink = new Drink();
            updateDrink.setCapacity(drink.getCapacity());
            updateDrink.setColor(drink.getColor());
            updateDrink.setCompany(drink.getCompany());
            updateDrink.setId(drink.getId());
            updateDrink.setName(drink.getName());
            updateDrink.setType(drink.getType());
            updateDrink.setIngredient(drink.getIngredient());
            updateDrink.setPrice(drink.getPrice());

            drinkRepository.save(updateDrink);
            return updateDrink;
        } else {
            throw new RuntimeException("Drink not found");
        }
    }
        @Override
        public void deleteDrink (long id){
            drinkRepository.deleteById(id);

        }
    }
