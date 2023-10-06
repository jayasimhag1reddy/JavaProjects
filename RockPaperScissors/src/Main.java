import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
       introduction();
       Scanner sc=new Scanner(System.in);
       String[] com_choice={"R","P","S"};
       Random r= new Random();
       while(true) {
           System.out.println("Enter you choice");
           String user_input = sc.next();
           while (!isValid(user_input)) {
               System.out.println("Please enter a valid Input (R/r or S/s or P/p)");
               user_input = sc.next();
           }
           String com_pick = com_choice[r.nextInt(3)];
           System.out.println("Computer Choice " + com_pick);
           if (com_pick.equalsIgnoreCase(user_input)) {
               System.out.println("Its a Tie");
           }
           else{
               if(Result(user_input,com_pick)){
                   System.out.println("Congrats, You Won!!");
               }
               else{
                   System.out.println("Sorry, You Lost!!");
               }
           }
           System.out.println("Do you Want to play again, Press Y to continue and any other key to quit");
           String choice = sc.next();
           if (!choice.equals("Y")) {
               break;s
           }
       }
    }
    public static boolean Result(String user,String comp){
        if((user.equalsIgnoreCase("R") && comp.equalsIgnoreCase("S")) || (user.equalsIgnoreCase("P") && comp.equalsIgnoreCase("R")) || (user.equalsIgnoreCase("S") && comp.equalsIgnoreCase("P"))) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isValid(String s){
        if(s.equals("R") || s.equals("r") || s.equals("p") || s.equals("P") || s.equals("S") || s.equals("s")){
            return true;
        }
        return false;
    }
    public static void introduction(){
        System.out.println("Welcome!! Let's Play");
    }
}