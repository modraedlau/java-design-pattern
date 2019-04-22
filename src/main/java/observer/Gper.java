package observer;

import com.google.common.eventbus.EventBus;

/**
 * @author Modraed Lau
 */
public class Gper {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        Teacher teacher = new Teacher("Tom");
        eventBus.register(teacher);
        Student student = new Student(eventBus, "小明");
        student.ask(new Question(student.getName(), "观察者模式", "观察者模式实际应用场景有哪些？"));
    }
}
