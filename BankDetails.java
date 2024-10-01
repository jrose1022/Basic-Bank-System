import java.util.LinkedList;

public class BankDetails {
    private int PinNumber;
    private double Balance;
    private String AccountName;
    private String AccountNumber;
    private LinkedList<String> transactions;

    /* bakit nakaprivate yung variables ko?  Encapsulation and Security*/


    public void setPinNumber(int newPinNumber) { //setter
        this.PinNumber = newPinNumber;
    }

    public void setBalance(double newBalance) { //setter
        this.Balance = newBalance;
    }

    public void setAccountName(String newAccountName) { //setter
        this.AccountName = newAccountName;
    }

    public void setAccountNumber(String newAccountNumber) { //setter
        this.AccountNumber = newAccountNumber;
    }

    public int getPinNumber() { //getter
        return PinNumber;
    }

    public double getBalance() { //getter
        return Balance;
    }

    public String getAccountName() { //getter
        return AccountName;
    }

    public String getAccountNumber() { //getter
        return AccountNumber;
    }

    public BankDetails() { //constructor ko para makagawa me list.
        transactions = new LinkedList<>();
    }


    public void addTransaction(String transaction) { //method para maadd sa list ng transaction sa list ng transactions
        transactions.add(transaction);
    }

    public void printTransactions() { //method dito priprint yung mga transaction pero may condition kasi baka walang laman yung list.
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactions) {
                System.out.println("\t"+transaction);
            }
        }
    }
}