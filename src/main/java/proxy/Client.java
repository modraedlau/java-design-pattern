package proxy;

/**
 * @author Modraed Lau
 */
public class Client {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Subject subject = (Subject) new Agent().getInstance(realSubject);

        subject.sellBooks();
        subject.speak();
    }
}
