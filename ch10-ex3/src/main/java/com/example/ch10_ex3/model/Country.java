package com.example.ch10_ex3.model;

public class Country {
    private String name;
    private int population;

    // static method: 객체 없이 클래스명으로 호출 가능
    public static Country of(String name, int population) {
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}