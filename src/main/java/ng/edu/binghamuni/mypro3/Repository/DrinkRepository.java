package ng.edu.binghamuni.mypro3.Repository;

import ng.edu.binghamuni.mypro3.domain.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Long> {
//    @Query("")
//    List <Drink> findDrinkByPriceGreaterThan(Int price);
}

