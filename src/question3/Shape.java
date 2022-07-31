package src.question3;

public class Shape {
    public void draw() {
        System.out.println("Shape Draw");
    }

    public void erase() {
        System.out.println("Shape Erase");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw");
    }

    @Override
    public void erase() {
        System.out.println("Circle erase");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle draw");
    }

    @Override
    public void erase() {
        System.out.println("Triangle erase");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square draw");
    }

    @Override
    public void erase() {
        System.out.println("Square erase");
    }
}