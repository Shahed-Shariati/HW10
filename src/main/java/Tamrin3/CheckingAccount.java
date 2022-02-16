package Tamrin3;

public class CheckingAccount {
    private int balance;
    public CheckingAccount(int initialBalance)
    {
        this.balance =initialBalance;
    }

    public synchronized boolean withdraw(int amount)
    {
        if(amount <= balance){
            try {
                Thread.sleep((int)(Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            return true;
        }
        return false;
    }
}
