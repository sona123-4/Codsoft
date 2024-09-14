import java.util.Random;
import java.util.Scanner;

public class NumberGame_task1 {
    public static void main(String[] args) {

        String hints[]={"You can count me on your fingers",    //1-10
                        "Teenage drama, acne, and angst",      //10-20
                        "The new Adult Age",                //20-30
                        "The number of days in a typical month, plus a few.",   //30-40
                        "Four decades of life, love, and adventure",      //40-50
                        "Halfway to 100",    //50-60
                        "Retirement, relaxation, and... bingo nights?",  //60-70
                        "Seventy and still kicking, with a walking stick",      //70-80
                        "The octogenarian club, exclusive membership",     //80-90
                        "Just few more to century"};    //90-99
       
        boolean play=true;
        Scanner obj=new Scanner(System.in);

        while (play) {
            
            Random random=new Random();
            int random_number=random.nextInt(100);
        
            int max_attempts=5;
            int curr_attempts=0;
            int hint=random_number/10;

            System.out.println("\nGuess a number between 1 to 100\n");

            while(curr_attempts<max_attempts){

                if(curr_attempts>0){
                    System.out.println("Hint: "+ hints[hint]);
                    }

                System.out.print("Your guess: ");
                int guess=obj.nextInt();

                if(guess==random_number){
                    System.out.println("Congratulations! you guessed it right");
                    break;
                }

        else{
            System.out.println("Wrong Guess!");
            System.out.println();
        }

        curr_attempts++;

    }
    System.out.println("\nDo you want to play again? Yes/No");

    if(obj.next().equalsIgnoreCase("no")){
        System.out.println("End");
        play=false;
    }
    }
    obj.close();
}
    
}
