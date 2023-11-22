package ng.edu.binghamuni.mypro3.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


import java.util.List;

@Entity(name = "drink")
public class Drink {
    public List<Ingredient> getIngredient() {
        return Ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        Ingredient = ingredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drink(int price) {
        this.price = price;
    }

    public Drink(List<Ingredient> ingredient, String name, int capacity, String color, String type, String company, Long id) {
        Ingredient = ingredient;
        this.name = name;
        this.capacity = capacity;
        this.color = color;
        Type = type;
        this.company = company;
        this.id = id;
        this.price = price;

    }


    public Drink(){

    }
    @OneToMany
    private List<Ingredient> Ingredient;

    private String name;
    private int capacity;
    int price;
    private String color;
    private String Type;
    private String company;

    @Id
    private Long id;

    // GETTER
    public String getName() {
        return name;
    }

    public int getCapacity() {

        return capacity;
    }

    public int getPrice() {
        return price;
    }



    public String getColor() {
        return color;
    }

    public String getType() {
        return Type;
    }

    public String getCompany() {
        return company;
    }

    //SETTER
    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setCompany(String company) {
        this.company = company;
    }




    }

