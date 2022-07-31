package src.question8;

import java.util.ArrayList;
import java.util.List;

class Automobile {
}

class Car extends Automobile {
}

class SportsCar extends Car {
}

public class Generics {

    public static void carAndChild(List<? extends Car> l1) {
        System.out.println(l1);
    }

    public static void carAndParent(List<? super Car> l1) {
        System.out.println(l1);
    }

    public static void main(String[] args) {
        List<SportsCar> l1 = new ArrayList<>();
        List<Automobile> l2 = new ArrayList<>();

        l1.add(new SportsCar());
        l1.add(new SportsCar());
        l1.add(new SportsCar());

        // Accepts the values
        carAndChild(l1);

        // Rejects the values
        // carAndParent(l1);

        l2.add(new Automobile());
        l2.add(new Automobile());
        l2.add(new Automobile());

        carAndParent(l2);
    }
}
