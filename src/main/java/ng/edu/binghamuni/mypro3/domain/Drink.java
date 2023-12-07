package ng.edu.binghamuni.mypro3.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.List;

@Entity(name = "drink")

public class Drink {
    @OneToMany
    private List<Ingredient> Ingredient;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "capacity", nullable = true)
    private int capacity;
    @Column(name = "price", nullable = true)
    private int price;
    private String color;
    private String Type;
    private String company;
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


    public Drink(Long id, List<Ingredient> ingredient, String name, int capacity, String color, String type, String company, int price) {
        this.Ingredient = ingredient;
        this.name = name;
        this.capacity = capacity;
        this.color = color;
        this.Type = type;
        this.company = company;
        this.id = id;
        this.price = price;

    }
    public Drink(){

    }


    // GETTER
    public String getName() {
        return name;
    }

    public int getCapacity() {

        return capacity;
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

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    }

