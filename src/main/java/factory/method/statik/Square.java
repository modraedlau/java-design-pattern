package factory.method.statik;

/**
 * @author Modraed Lau
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
