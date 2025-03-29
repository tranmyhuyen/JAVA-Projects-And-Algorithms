# Simplified Bank Account for Beginners

Here's a beginner-friendly version of the `BankAccount` class that's easier to understand while still maintaining good practices:

```java
package Lab1;

public class BankAccount {
    // Account details
    private String accountNumber;
    private double balance;
    
    // Constructor to create a new account
    public BankAccount(String accountNumber, double startingBalance) {
        this.accountNumber = accountNumber;
        this.balance = startingBalance;
    }
    
    // Add money to account
    public void deposit(double amount) {
        if (amount > 0) {  // Only deposit positive amounts
            balance = balance + amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit failed - must be positive amount");
        }
    }
    
    // Take money from account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {  // Check if enough money exists
            balance = balance - amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Withdrawal failed - check amount or balance");
        }
    }
    
    // Check current balance
    public double getBalance() {
        return balance;
    }
    
    // Show account info
    public void showAccount() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
```

## Simple Test Program

```java
package Lab1;

import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to Simple Bank!");
        System.out.print("Enter account number: ");
        String accNum = input.next();
        
        System.out.print("Enter starting balance: $");
        double startBal = input.nextDouble();
        
        // Create the bank account
        BankAccount myAccount = new BankAccount(accNum, startBal);
        myAccount.showAccount();
        
        // Deposit test
        System.out.print("\nEnter deposit amount: $");
        double depositAmt = input.nextDouble();
        myAccount.deposit(depositAmt);
        
        // Withdrawal test
        System.out.print("Enter withdrawal amount: $");
        double withdrawAmt = input.nextDouble();
        myAccount.withdraw(withdrawAmt);
        
        // Show final balance
        System.out.println("\nFinal Account Status:");
        myAccount.showAccount();
        
        input.close();
    }
}
```

## Key Features for Beginners:

1. **Simple Structure**:
   - Only 2 fields (accountNumber and balance)
   - 4 easy-to-understand methods

2. **Clear Feedback**:
   - Prints messages for every transaction
   - Explains why operations might fail

3. **Basic Protection**:
   - Prevents negative deposits
   - Prevents overdrafts
   - Uses private variables

4. **Interactive Testing**:
   - Step-by-step console interface
   - Shows account status before and after transactions

## Example Run:

```
Welcome to Simple Bank!
Enter account number: 12345
Enter starting balance: $1000
Account: 12345
Balance: $1000.0

Enter deposit amount: $500
Deposited: $500.0
Enter withdrawal amount: $200
Withdrew: $200.0

Final Account Status:
Account: 12345
Balance: $1300.0
```

This version is perfect for beginners because:
1. It's short and easy to read
2. Each method does just one thing
3. It provides immediate feedback
4. It demonstrates basic OOP concepts without complexity
5. The test program shows exactly how to use the class
