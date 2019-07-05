package com.lypgod.test.g01.creational.patterns.p04.builder.pattern;

/**
 * @author richard
 */
class MealBuilder {
    Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new BurgerVegBurger());
        meal.addItem(new ColdDrinkCoke());
        return meal;
    }

    Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new BurgerChickenBurger());
        meal.addItem(new ColdDrinkPepsi());
        return meal;
    }
}