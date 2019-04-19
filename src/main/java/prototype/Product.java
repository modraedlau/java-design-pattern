package prototype;

/**
 * @author Modraed Lau
 */
public interface Product extends Cloneable {
    void use(String s);
    Product createClone();
}
