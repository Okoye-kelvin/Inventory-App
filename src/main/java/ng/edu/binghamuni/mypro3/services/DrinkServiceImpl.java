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
    public Drink getDrinkById(Long id) {
        Optional<Drink> drink = drinkRepository.findById(id);
        Drink emptyDrink = null;
        if (drink.isPresent()) {
            emptyDrink = drink.get();
            return emptyDrink;
        } else {
            throw new RuntimeException("Drink not found");
        }
    }

    @Override
    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink UpdateDrink(Drink drink) {
        Optional<Drink> optionalDrink = drinkRepository.findById(drink.getId());
        if (optionalDrink.isPresent()) {
            Drink updateDrink = new Drink();
            updateDrink.setCapacity(drink.getCapacity());
            updateDrink.setColor(drink.getColor());
            updateDrink.setCompany(drink.getCompany());
            updateDrink.setId(drink.getId());
            updateDrink.setName(drink.getName());
            updateDrink.setType(drink.getType());
            updateDrink.setIngredient(drink.getIngredient());
            return updateDrink;
        } else {
            throw new RuntimeException("Drink not found");
        }

    }

        @Override
        public void deleteDrink (Long id){
            drinkRepository.deleteById(id);

        }
    }
