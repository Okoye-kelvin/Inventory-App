package ng.edu.binghamuni.mypro3.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity( name = "ingredient")
public class Ingredient {
    public Ingredient(){

    }
    public Ingredient(Long id, String name, String Ingredient){
        this.id = id;
        this.name = name;
        this.Ingredient = Ingredient;
    }
    @Id
    private  Long id;
    private String name;
    private String Ingredient;

    public void setId (Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public String getName(){
    return name;
}
public void setName(String Name){

        this.name = Name;
}
public String getIngredient(){

        return Ingredient;
}
public String setIngredient(String Ingredient){
    this.Ingredient = Ingredient;
    return Ingredient;
}

}


