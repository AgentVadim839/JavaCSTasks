package ua.me.lab02.logic;

public class Apple {

    private String name;
    private int price;

    public Apple(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }



    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}
