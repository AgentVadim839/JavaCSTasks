package ua.me.lab02.logic;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LogicTest {
    private Logic logic = new LogicImplementation();

    @BeforeMethod
    public void beforeMethod(){
        logic.add(new Apple("Антонівка",25));
        logic.add(new Apple("Кортланд",45));
        logic.add(new Apple("Семеренка",37));
    }

    @AfterMethod
    public void AfterMethod(){
        logic = new LogicImplementation();
    }

    @Test
    public void checkCount() {
        Assert.assertEquals(logic.getAll().size(), 3); // Comparing int values
    }

    @Test
    public void checkAllPriceLess(){ // 1
        List <Apple> list = logic.getAllPriceLess(40);
        SoftAssert asert = new SoftAssert();
        asert.assertNotEquals(list.size(), 1);
        asert.assertEquals(list.get(0).getName(),"Антонівка");
        asert.assertAll();
    }

    @Test
    public void checkByNumber() { // 2
        List <Apple> list = logic.getAll();
        Assert.assertEquals(list.get(2).getName(), "Семеренка");
    }

    @Test
    public void checkReplace() { // 3
        List <Apple> list = logic.getAll();
        Apple apple = new Apple("Legenko", 8);
        Assert.assertEquals(logic.replace(apple, 3), true);
    }

    @Test
    public void checkAllPriceMore(){
        List <Apple> list = logic.getAllPriceMore(41);
        SoftAssert asert = new SoftAssert();
        asert.assertEquals(list.size(), 1);
        asert.assertEquals(list.get(0).getName(),"Кортланд");
        asert.assertAll();
    }
}







