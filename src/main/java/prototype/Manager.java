package prototype;

import java.util.HashMap;

/**
 * @author Modraed Lau
 */
public class Manager {
    private HashMap<String, Product> showcase = new HashMap<>();

    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }
    public Product create(String protoName) {
        Product p = showcase.get(protoName);
        return p.createClone();
    }
}
