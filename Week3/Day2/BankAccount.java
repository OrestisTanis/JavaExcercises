// Week3_Day2_Exc

/*
 * DESCRIPTION
 * BankAccount class
 * Instance vars: number(int), amount(double), name(String), active(boolean), transactions(ArrayList<String>)
 * Methods: deposit(), withdraw()
 * Store each action (deposit, withdraw, creation) in the transactions list.
 * Create a variable(accountsOpened) that counts the number of accounts opened.
 * Create 3 contructors (default, name-number, all(except transactions)).
 */

package exc_bankaccount;

import java.util.ArrayList;

public class BankAccount {
    /* Fields */
    private int number;
    private double amount;
    private String name;
    private boolean active;
    private ArrayList<String> transactions;
    // Number of created accounts
    private static int accountsOpened;
    
    /* Constructors */
    public BankAccount(){
        // An account must be active when created
        this.active = true;
        this.amount = 0;
        accountsOpened++;
        this.name = "No name";
        // Use the number of accounts opened as a unique ID
        this.number = accountsOpened;
        this.transactions = new ArrayList<String>();
        this.transactions.add("Account creation");
        System.out.println("Account created.");
    }
    
    public BankAccount(String name, int number){
        this();
        this.name = name;
        if (number > accountsOpened){
            this.number = number;
        }
        else if (number <= 0) {
            System.out.printf("Account number must be positive. Setting number to: %d%n", accountsOpened);
        }
        else {
            System.out.printf("Account number is taken. Setting number to: %d%n", accountsOpened);
        }
    }
    
    public BankAccount(int number, double initialAmount, String name){
        this(name, number);
        if (initialAmount > 0){
            deposit(initialAmount);
        }
        else {
            System.out.printf("The initial amount must be positive. Setting balance to %.2f€%n", amount);
        }
        
    }

    /* Accessor properties */
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
       if (number > accountsOpened){
            this.number = number;
        }
    }
    
    public double getBalance() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @param active Pass 'true' to make the account active or 'false' to make the account inactive
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    
    /**
     * @return True if the account is active
     */
    public boolean isActive() {
        return active;
    }
    
    /**
     * @return An ArrayList of strings representing the account's transaction history
     */
    public ArrayList<String> getTransactions() {
        return transactions;
    }
    
    /* Methods */   
    public void deposit(double amount){
        if (amount > 0){
           this.amount += amount;
           this.transactions.add("Deposit: " + String.format("%.2f", amount) + "€");
        }
    }
    
    public void withdraw(double amount){
        if (amount <= this.amount){
            this.amount -= amount;
            this.transactions.add("Withdraw: " + String.format("%.2f", amount) + "€");
        }
    }
}
