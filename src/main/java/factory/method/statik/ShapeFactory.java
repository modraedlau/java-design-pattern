package factory.method.statik;

/**
 * @author Modraed Lau
 */
public class ShapeFactory {

    public static Shape getCircle() {
        return new Circle();
    }

    public static Shape getSquare() {
        return new Square();
    }

    public static Shape getRectangle() {
        return new Rectangle();
    }
}
