package com.example.campusexpensese06205.model;

public class BudgetModel {
    public int id;
    public String name;
    public int price;
    public String description;
    public int icon;
    public BudgetModel(int _id,
                       String _name,
                       int _price,
                       String _des,
                       int _icon){
        id= _id;
        name= _name;
        price = _price;
        description = _des;
        icon = _icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getAmount() {
        return price;
    }
}
