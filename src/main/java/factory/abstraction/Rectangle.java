package factory.abstraction;

/**
 * @author Modraed Lau
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}