package factory.method.simple;

/**
 * @author Modraed Lau
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
