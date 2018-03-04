package pl.sda.poznan.decorator.shapedecorator;

public class Circle implements Shape {

    private float radious;

    public Circle(float radious) {
        this.radious = radious;
    }

    @Override
    public String info() {
        return "A circle of radious: " + radious;
    }

}
