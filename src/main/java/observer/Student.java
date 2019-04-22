package observer;

import com.google.common.eventbus.EventBus;

/**
 * @author Modraed Lau
 */
public class Student {
    private EventBus eventBus;

    private String name;

    public Student(EventBus eventBus, String name) {
        this.eventBus = eventBus;
        this.name = name;
    }

    public void ask(Question question) {
        System.out.println(name + "提出问题：" + question);
        eventBus.post(question);
    }

    public String getName() {
        return name;
    }
}
