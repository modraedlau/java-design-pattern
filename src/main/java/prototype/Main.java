package prototype;

/**
 * @author Modraed Lau
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning message", mbox);
        manager.register("slash message", sbox);

        Product p1 = manager.create("strong message");
        p1.use("This is a strong message.");
        Product p2 = manager.create("warning message");
        p2.use("This is a warning message.");
        Product p3 = manager.create("slash message");
        p3.use("This is a slash message.");
    }
}
