package Quiz;

import java.util.*;
import java.util.Scanner;

public class User {
    int score = 0;
    int wrong_count = 0;
    int quesAttempted = 0;
    String name;
    Set<Question> questions = new HashSet<>(10);
    Question [] attempted = new Question[8];

    public User(String name){
        this.name = name;
        System.out.println(this.name);
    }


    //function to receive random element from the set of questions
    public Question getRandomElement(Set<Question> questionSet){
        int size = new Random().nextInt(questionSet.size());
        Iterator<Question> iter = questionSet.iterator();
        for(int i=0; i<size; i++){
            iter.next();
        }
        Question q = iter.next();
        questions.remove(q);
        return q;
    }

    //function defining the question set and calling function to give and review test
    public void questionSet(){

        String q1 = "\nWho is known as father of Java Programming Language?\n"
                + "(a)James Gosling\n(b)M. P Java\n(c)Charel Babbage\n(d)Blais Pascal\n";

        String q2 = "\t\n" +
                "\nIn java control statements break, continue, return, try-catch-finally and assert belongs to?\n"
                + "(a)Selection statements\n(b)Loop Statements\n(c)Transfer statements\n(d)Pause Statement\n";

        String q3 = "\nWhich provides runtime environment for java byte code to be executed?\n"
                + "(a)JDK\n(b)JVM\n(c)JRE\n(d)JAVAC\n";

        String q4 = "\nWhat is byte code in Java?\n"
                + "(a)Code generated by a Java compiler\n(b)Code generated by a Java Virtual Machine\t\n"
                + "(c)Name of Java source code file\n(d)Block of code written inside a class\n";

        String q5 = "\t\n" +
                "\nWhich of the following are not Java keywords ?\n"
                + "(a)double\n(b)switch\n(c)then\n(d)instanceof\n";

        String q6 = "\t\n" +
                "\nWhich of these have highest precedence?\n"
                + "(a)()\n(b)++\n(c)*\n(d)>>\n";

        String q7 = "\t\n" +
                "\nWhich of these is returned by operator '&' ?\n"
                + "(a)Integer\n(b)Character\n(c)Boolean\n(d)Float\n";

        String q8 = "\nData type long literals are appended by _____\n"
                + "(a)Uppercase L\n(b)Lowercase L\n(c)Long\n(d)Both A and B\n";

        String q9 = "\nWhich variables are created when an object is created with the use of the keyword 'new' and destroyed when the object is destroyed?\n"
                + "(a)Local variables\n(b)Instance variables\n(c)Class Variables\n(d)Static variables\n";

        String q10 = "\nJava language was initially called as ________\n"
                + "(a)Sumatra\n(b)J++\n(c)Oak\n(d)Pine\n";


        questions.add(new Question(q1, "a"));
        questions.add(new Question(q2, "c"));
        questions.add(new Question(q3, "b"));
        questions.add(new Question(q4, "a"));
        questions.add(new Question(q5, "c"));
        questions.add(new Question(q6, "a"));
        questions.add(new Question(q7, "b"));
        questions.add(new Question(q8, "d"));
        questions.add(new Question(q9, "b"));
        questions.add(new Question(q10, "c"));

        takeTest(questions);

        reviewQuiz(attempted);
        System.out.println("\ntotal score: "+this.score);
    }

    //function to select question from the set and give it to user for test attempt
    public void takeTest(Set<Question> questions){

        Scanner keyboardInput = new Scanner(System.in);
        Question q;

        int i = 0;
        while(i<8) {
            quesAttempted++;
            q = getRandomElement(questions);
            System.out.println(q.getPrompt());
            String input = keyboardInput.nextLine();

            boolean y = (input.equals("a")||input.equals("b")||input.equals("c")||input.equals("d"));

            if(!y) {
                while (!y) {
                    //System.out.println(input == "a" || input == "b" || input == "c" || input == "d");
                    System.out.println("The option entered is invalid...input one of these(a/b/c/d)!\n");
                    input = keyboardInput.nextLine();
                    y = (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d"));
                }
            }

            q.setInput(input);
            if (input.equals(q.answer)) {
                q.setCorrect(true);
                this.score++;
            } else {
                q.setCorrect(false);
                this.wrong_count++;
            }
            attempted[i] = q;

            if (wrong_count >= 4) {
                System.out.println("Oops..you have already given 4 wrong answers!!");
                System.out.println("You got " + this.score + "/" + ++i + "\n");
                break;
            }

            i++;

            q = null;
        }
        if(wrong_count < 4) {
            System.out.println("Hurrah!...You passed the quiz!");
            System.out.println("You got " + this.score + "/" + attempted.length + "\n");
        }
    }

    //function to review the quiz
    public void reviewQuiz(Question [] attempted){
        for(int i=0; i<this.quesAttempted; i++){
            System.out.println(attempted[i].getPrompt());
            if(attempted[i].getCorrect() == true){
                System.out.println("your answer is correct");
            }
            else {
                System.out.println("your answer is incorrect");
                System.out.println("your answer: " + attempted[i].getInput() + "   correct answer: " + attempted[i].answer);
            }
        }
    }
}
