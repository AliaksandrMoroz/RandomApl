package sample;


public class Student {
    private int id;
    private String name;
    private String lastname;
    private String team;
    private String question;
    private String answer;
    private String bonusBall;

    public Student() {
    }

    public Student(String name, String lastname, String team, String question, String answer, String bonusBall) {
        this.name = name;
        this.lastname = lastname;
        this.team = team;
        this.question = question;
        this.answer = answer;
        this.bonusBall = bonusBall;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(String bonusBall) {
        this.bonusBall = bonusBall;
    }
}
