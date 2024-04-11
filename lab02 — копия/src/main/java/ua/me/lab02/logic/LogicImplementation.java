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
        FileServices file = new FileServices();
        file.setFileName("list.txt");
        file.setFilePath("logs/");
        file.writeFile((ArrayList<Apple>) apples);
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
        List<Apple> list = new ArrayList<>();
        for(Apple apple: apples){
            if(apple.getPrice()<maxPrice){
                list.add(apple);
            }
        }
        return list;
    }

    @Override
    public Apple getByNumber(int number) {
        return apples.get(number-1);
    }

    @Override
    public void removeAll() {
        apples.clear();
    }

    @Override
    public boolean addToPlace(Apple apple, int place) {
        apples.add(place-1, apple);
        return true;
    }

    @Override
    public boolean replace(Apple apple, int place) {
        apples.set(place-1, apple);
        return true;
    }
}
