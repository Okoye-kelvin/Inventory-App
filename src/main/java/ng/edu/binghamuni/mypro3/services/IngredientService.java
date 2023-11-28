package ng.edu.binghamuni.mypro3.services;

import ng.edu.binghamuni.mypro3.domain.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IngredientService {
    Ingredient saveIngredient(Ingredient ingredient);
    Ingredient getIngredientById(Long Id);

    List<Ingredient> getAllIngredient();

    Ingredient updateIngredient(Ingredient ingredient);
    void deleteIngredient(Long Id);
}
