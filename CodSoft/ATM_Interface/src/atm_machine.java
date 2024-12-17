import java.util.Scanner;

public class atm_machine {

    
    public static void main(String[] args) throws Exception {
        int numTries = 0;
        userBankAccount account = new userBankAccount(5000);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number corresponding with the action you wish to do");
        Thread.sleep(500);
        System.out.println("*****************");
        System.out.println("OPTIONS");
        System.out.println("*****************");
        System.out.println("1:Withdrawal \n2:Deposit \n3:Check Balance");
        
        int userChosenOption = userOption(input);
        atmDriver(userChosenOption,input,account,numTries);
        

    }

    public static void atmDriver(int userChosenOption, Scanner input, userBankAccount account, int numTries) throws InterruptedException {
        int maxTries = 3;
    
        while (numTries < maxTries) {
            if (userChosenOption >= 1 && userChosenOption <= 3) {
                if (userChosenOption == 1) { 
                    numTries = 0;
                    System.out.println("Enter Withdrawal amount.");
                    int withdrawalAmount = getAmount(input);
                    if(withdrawalAmount == -1){
                        return;
                    }
                    else if (validAmount(withdrawalAmount)) {
                        if (account.withdraw(withdrawalAmount)) {
                            System.out.println("Withdrawal approved, please wait for your cash.");
                            return;
                        } else {
                            System.out.println("Insufficient funds.");
                            return;
                        }
                    }
                } 
                else if (userChosenOption == 2) { 
                    System.out.println("Enter Deposit amount.");
                    int depositAmount = getAmount(input);
                    if(depositAmount == -1){
                        return;
                    }
                    else if (validAmount(depositAmount)) {
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                        return;
                    }
                } 
                else if (userChosenOption == 3) {
                    System.out.println(String.format("Your balance is R%.2f", account.getBalance()));
                    System.out.println("What would you like to do next? \n *************************");
                    System.out.println("1: Withdrawal \n2: Deposit \n3: Exit");
                    userChosenOption = userOption(input);
                    if (userChosenOption == 3) {
                        System.out.println("Exiting. Thank you!");
                        return;
                    }
                }
            } else { 
                numTries++;
                if (numTries >= maxTries) {
                    System.out.println("Too many invalid attempts. Exiting.");
                    return;
                }
                System.out.println("Please choose one of the options: 1, 2, or 3.");
                userChosenOption = userOption(input);
            }
        }
    }
    
    public static int userOption(Scanner input) throws InterruptedException{
        
        while(!input.hasNextInt()){
            System.out.println("the input should be an integer, please try again.");
            input.next();
        }
        return input.nextInt();  
    }
    public static int getAmount(Scanner input) {
        int numTries = 0;
        int maxTries = 3;
    
        while (numTries < maxTries) {
            if (input.hasNextInt()) {
                return input.nextInt(); 
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); 
                numTries++;
            }
        }
    
        System.out.println("Too many invalid attempts. Returning to main menu.");
        return -1;
    }
    
    public static boolean validAmount(int amount){
        if(amount%10 !=0){
            System.out.println("Invalid amount, enter amount an amount that is an multiple of 10");
            return false;
        }
        else if(amount<=0){
            System.out.println("Invalid amount, enter amount greater than 0");
            return false;
        }
        else{
            return true;
        }

    }

    
}
