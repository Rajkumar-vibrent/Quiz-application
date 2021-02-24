package Quiz;

import java.util.Scanner;

public class App{
    public static void main(String args[]){

        boolean attempt = true;
        System.out.println("Welcome to quiz-mania!!");
        System.out.println("Enter your nickname(8-20 chars):");
        Scanner input = new Scanner(System.in);

        String name = null;
        boolean inputValidated = false;

        while (!inputValidated){
            try {
                name = input.nextLine();
                inputValidate(name);
                inputValidated = true;
            }
            catch (newException e){
                System.out.println(e.getMessage());
            }
        }

        do{
            User person1 = new User(name);
            person1.questionSet();
            System.out.println("Would you like to give another attempt?");
            System.out.println("(0 for exit and 1 to continue!)");
            Scanner Input = new Scanner(System.in);
            int i = Input.nextInt();
            if(i == 0){attempt = false;} else if(i == 1){attempt = true;}

        }while(attempt == true);
    }

    //inputValidate function to validate the input name
    public static void inputValidate(String input) throws newException{
        if(input.length() < 8 || input.length() > 20){
            throw new newException("input nickname not belonging in the size range(8-20).. \nPlease retry!");
        }
    }
}

