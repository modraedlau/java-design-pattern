package factory.abstraction;

/**
 * @author Modraed Lau
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
