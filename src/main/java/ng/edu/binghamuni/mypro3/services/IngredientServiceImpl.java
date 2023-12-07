package ng.edu.binghamuni.mypro3.services;

import ng.edu.binghamuni.mypro3.Repository.IngredientRepository;
import ng.edu.binghamuni.mypro3.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {

        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        Ingredient emptyIngredient = null;
        if (ingredient.isPresent()) {
            emptyIngredient = ingredient.get();
            return emptyIngredient;

        } else {
            throw new RuntimeException("Ingredient not found");
        }
    }

    @Override
    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }


    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(ingredient.getId());
        if (optionalIngredient.isPresent()) {

            Ingredient updateIngredient = new Ingredient();
            updateIngredient.setName(ingredient.getName());
            updateIngredient.setIngredient(ingredient.getIngredient());
            updateIngredient.setId(ingredient.getId());


            return updateIngredient;
        }
        else {
            throw new RuntimeException("Ingredient not Found");
        }
    }

    @Override
    public void  deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
