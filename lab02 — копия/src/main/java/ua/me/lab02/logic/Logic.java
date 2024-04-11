package ua.me.lab02.logic;

import java.util.List;

public interface Logic {
    boolean add(Apple apple);
    List<Apple> getAll();
    List<Apple> getAllPriceMore(double minPrice);
    List<Apple> getAllPriceLess(double maxPrice);
    Apple getByNumber(int number);
    void removeAll();
    boolean addToPlace(Apple apple, int place);
    boolean replace(Apple apple, int place);
}
