package factory.method.multiple;

/**
 * @author Modraed Lau
 */
public class ShapeFactory {

    public Shape getCircle() {
        return new Circle();
    }

    public Shape getSquare() {
        return new Square();
    }

    public Shape getRectangle() {
        return new Rectangle();
    }
}
