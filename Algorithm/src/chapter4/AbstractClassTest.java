package chapter4;

public class AbstractClassTest {
    public static void main(String[] args) {
        Car audiCar = new Audi();
        audiCar.drive();
        audiCar.getColor();

        Car autuoCar = new Autuo();
        autuoCar.drive();
        autuoCar.getColor();
//        Car car = new Car();

        Car hondaCar = new Honda();
        hondaCar.drive();
    }
}

abstract class Car {
    protected String color;
    private String manufacturer;

    public Car() {
        color = "black";
        manufacturer = getManufacturer();
    }
    public void drive() {
        System.out.println(manufacturer + " drive");
    }
    public void stop() {
        System.out.println(manufacturer + " stop");
    }
    public String getColor(){
        return color;
    }

    protected abstract String getManufacturer();
}

//class A {
//    abstract void haha();
//}

class Audi extends Car {

    public Audi() {
        color = "red";
    }

    @Override
    protected String getManufacturer() {
        return "Audi";
    }
}

class Autuo extends Car {

    public Autuo() {
        color = "red";
    }

    @Override
    protected String getManufacturer() {
        return "Autuo";
    }
}

class BMW extends Car {
    public BMW() {
        color = "red";
    }

    @Override
    protected String getManufacturer() {
        return "BMW";
    }
}

class Honda extends Car {

    @Override
    protected String getManufacturer() {
        return "Honda";
    }
}

interface Car1 {
    default void drive() {
      System.out.println(getManufacturer() + " drive");
    }
    default void stop() {
        System.out.println(getManufacturer() + " stop");
    }
    String getColor();
    String getManufacturer();
}

class Bentz implements Car1 {

    @Override
    public String getColor() {
        return "black";
    }

    @Override
    public String getManufacturer() {
        return "Bentz";
    }
}