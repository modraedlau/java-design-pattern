package factory.abstraction;

/**
 * @author Modraed Lau
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
