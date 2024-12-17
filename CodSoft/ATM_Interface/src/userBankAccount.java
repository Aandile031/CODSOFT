public class userBankAccount {
    public double accountBalance;
    
    public userBankAccount(double initialBalance) {
        this.accountBalance = initialBalance;
    }
    
    public double getBalance(){
        return accountBalance;
    }
    public boolean withdraw(int amount){
        boolean outcome;
        if(amount<=accountBalance){
            this.accountBalance -= amount;
            outcome = true;
        }
        else{
            outcome = false;
        }
        return outcome;
        
    }
    public void deposit(int amount){
        this.accountBalance += amount;
    }
    
}
