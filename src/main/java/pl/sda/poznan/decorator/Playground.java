package pl.sda.poznan.decorator;

import pl.sda.poznan.decorator.shapedecorator.Circle;
import pl.sda.poznan.decorator.shapedecorator.ColoredCircle;
import pl.sda.poznan.decorator.shapedecorator.Shape;
import pl.sda.poznan.decorator.shapedecorator.TransparentCircle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Playground {
    public static void main(String[] args) throws FileNotFoundException {

//        FileReader fileReader = new FileReader("plik.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        bufferedReader.readLine();
//        BufferedReader br = new BufferedReader(new FileReader("fille.txt"));
        Circle circle = new Circle(4);
        System.out.println(circle.info()); // A circle of a radious 4

        ColoredCircle coloredCircle = new ColoredCircle(circle, "red");
        System.out.println(coloredCircle.info());

        //obiekt kolo który ma kolor
        ColoredCircle cc = new ColoredCircle(new Circle(10), "green");
        //Koło które ma przezroczystość
        TransparentCircle transparentCircle = new TransparentCircle(new Circle(14), 60);
        //Koło które ma kolor i przezroczystość
        Shape mostDecoratedShape = new TransparentCircle(new ColoredCircle(new Circle(20), "red"), 80);
        System.out.println(mostDecoratedShape.info());

    }
}
