package ua.me.lab02.logic;


import java.util.ArrayList;
import java.util.List;
public class LogicImplementation implements Logic {
    private List<Apple> apples;

    public LogicImplementation() {
        apples = new ArrayList<>();
    }


    @Override
    public boolean add(Apple apple) {
        return apples.add(apple);
    }

    @Override
    public List<Apple> getAll() {
        return apples;
    }

    @Override
    public List<Apple> getAllPriceMore(double minPrice) {
        List<Apple> list = new ArrayList<>();
        for(Apple apple: apples){
            if(apple.getPrice()>minPrice){
                list.add(apple);
            }
        }
        return list;
    }

    @Override
    public List<Apple> getAllPriceLess(double maxPrice) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Apple getByNumber(int number) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addToPlace(Apple apple, int place) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean replace(Apple apple, int place) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
