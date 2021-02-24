package Quiz;

public class Question {
    private String prompt;
    private String input;
    String answer;
    private boolean correct;

    public Question(String prompt, String answer){
        this.prompt = prompt;
        this.answer = answer;
    }

    public String getPrompt(){
        return prompt;
    }

    public void setInput(String input){
        this.input = input;
    }

    public String getInput(){
        return this.input;
    }

    public void setCorrect(boolean correct){
        this.correct = correct;
    }

    public boolean getCorrect(){
        return this.correct;
    }
}
