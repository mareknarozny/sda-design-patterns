package pl.sda.poznan.decorator.shapedecorator;

// ta klasa jest dekoratorem - dekoruje klasę Circle o nowe pole Colour
public class ColoredCircle implements Shape {

    private String colour;
    private Shape circleToDecorate;

    public ColoredCircle(Shape circle, String colour) {
        this.colour = colour;
        this.circleToDecorate = circle;
    }

    @Override
    public String info() {
        return circleToDecorate.info() + " has the colour " + colour;
    }
}
