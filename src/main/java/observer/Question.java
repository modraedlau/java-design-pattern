package observer;

/**
 * @author Modraed Lau
 */
public class Question {

    private String questioner;

    private String title;

    private String content;

    public Question(String questioner, String title, String content) {
        this.questioner = questioner;
        this.title = title;
        this.content = content;
    }

    public String getQuestioner() {
        return questioner;
    }

    public void setQuestioner(String questioner) {
        this.questioner = questioner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "【" + title + "】" + content;
    }
}
