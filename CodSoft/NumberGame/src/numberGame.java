import java.util.*;

public class numberGame {
    public static int roundsPlayed =1; 
    public static int roundsWon =0;
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int MaxNumberOfAttempts=10;
        int numberOfAttempts=1; //a guess is made before the loop starts
        int numToFind = randomNumber();
        System.out.println("You have 10 attempts,to guess a randomly chosen integer.");
        Thread.sleep(1000);
        System.out.println("Enter one guess at a time and press enter.");
        Thread.sleep(1000);
        System.out.println("After each guess you will get hints if your guess isn't correct.");
        Thread.sleep(1000);
        System.out.println("If you run out of attempts,you can choose to play another round.");
        Thread.sleep(1000);
        System.out.println("You may enter your guesses, good luck :)");

        
        System.out.println("********************************************************");
        int userGuess = getGuess(input);

        playGame(input,MaxNumberOfAttempts,numberOfAttempts,userGuess,numToFind);
        input.nextLine();
        Thread.sleep(500);
        
      do{

        System.out.println("Would you like to play another round? Type in yes or no.");
        String decision = getDecision(input);
        if(decision.equals("yes")){
            numberOfAttempts =1;
            numToFind = randomNumber(); 
            roundsPlayed++;
            System.out.println("*************************************");
            System.out.println(String.format("Round %d starts now,enter new guess.", roundsPlayed));
            System.out.println("*************************************");
            userGuess = getGuess(input);
            playGame(input,MaxNumberOfAttempts,numberOfAttempts,userGuess,numToFind);
            input.nextLine();
        }
        
        else{
            System.out.println("***********************************************");
            System.out.println(String.format("You won %d out of %d rounds and you score is %.0f%%.",roundsWon,roundsPlayed,userScore()));
            System.out.println("***********************************************");
            break;
        }
    }while(true);


        input.close(); 

    }
    public static void playGame(Scanner input,int MaxNumberOfAttempts,int numberOfAttempts,int userGuess,int numToFind){
        
        while(MaxNumberOfAttempts>numberOfAttempts){
            if(userGuess>=1&&userGuess<=100){

            
                if(compareGuessToGoal(userGuess,numToFind)){
                    System.out.println("*************************************");
                    System.out.println("you guessed correctly!!!!");
                    System.out.println("*************************************");
                    roundsWon++;
                    break;
                }
                else{
                    if(userGuess>numToFind){
                        System.out.println("Too high.");
                    }
                    else{
                        System.out.println("Too low.");
                    }
                    userGuess = getGuess(input);
                    numberOfAttempts++;
                }
            }
            else{
                System.out.println("Your guess should be between 1 and 100.");
                userGuess = getGuess(input);
            }
        }


    }

    public static int getGuess(Scanner input){
        while(!input.hasNextInt()){
            System.out.println("the guess should be an integer,try again.");
            input.next();
        }
    
        return input.nextInt();
    }
        

    
    public static int randomNumber(){
        int randomNum = new Random().nextInt(1, 101);
        return randomNum;
    }
    public static boolean compareGuessToGoal(int guessValue,int goal){
        return guessValue==goal;
    }
    public static String getDecision(Scanner input) {
        String decision = "";
        while (input.hasNext()) {
            decision = input.next().trim().toLowerCase();
            if (decision.equals("yes") || decision.equals("no")) {
                break;
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }
        return decision;
    }
    
    
    public static double userScore(){
        double score=((double)roundsWon/roundsPlayed)*100;
        return score;
    }
    
}

