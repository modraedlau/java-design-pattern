package observer;

import com.google.common.eventbus.Subscribe;

/**
 * @author Modraed Lau
 */
public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Subscribe
    public void onMessageReceived(Question question) {
        System.out.println(name + "老师收到消息：" + question + "（来自" + question.getQuestioner() + "同学的问题）");
    }

    public String getName() {
        return name;
    }
}
