import java.util.Scanner;

//Julierose Obias UCOS 2-1
public class Main {
    public static void main(String[] args) {


            Scanner input = new Scanner(System.in);
            int choice;
            boolean looping = true;
            boolean loop =true;
            BankDetails BD = new BankDetails();
            BD.setPinNumber(1234);
            BD.setBalance(0);
            BD.setAccountName("Julie Cute");
            BD.setAccountNumber("121212");

            while (looping) {
                try {
                    System.out.println("");
                    System.out.println("-----=Welcome to Bank Account=----");
                    System.out.println("[1] Enter Your Pin Number\n" +
                            "[2] Exit\n");
                    choice = input.nextInt();

                    switch (choice) {

                        case 1: //pin number
                            looping = false;//pang exit ng first loop
                            System.out.println("");
                            System.out.println("Good Day! Please input your Pin Number!");
                            System.out.println("");
                            int pin = input.nextInt();

                            if (pin == BD.getPinNumber()) {
                                while (loop) {
                                    System.out.println("");
                                    System.out.println("Welcome, " + BD.getAccountName() + "!");
                                    System.out.println("Account Number: " + BD.getAccountNumber());
                                    System.out.println("");
                                    System.out.println("Balance: " + BD.getBalance());
                                    System.out.println("");
                                    System.out.println("[1] Deposit\n[2] Withdraw\n[3] Transaction \n[4] Exit to Main Menu");

                                    int selection = input.nextInt();

                                    switch (selection) {

                                        case 1: //deposit

                                            System.out.println("Deposit: ");
                                            double deposit = input.nextDouble();
                                            double currentBalance = BD.getBalance(); // kung ilan yung balance niya.
                                            BD.addTransaction("Deposit: " + deposit); //i-add lang yung in-add niya sa transaction list.
                                            double newBalance = currentBalance + deposit;

                                            BD.setBalance(newBalance);
                                            //babaguhin niya yung nakaset na balance kasi nag math na.//
                                            System.out.println("");
                                            System.out.println("New Balance: " + BD.getBalance());
                                            break;
                                        case 2: //withdraw
                                            System.out.println("Withdraw: ");
                                            double withdraw = input.nextDouble();
                                            currentBalance = BD.getBalance(); //igeget kung ilan laman nung balance or kung magkano na yung naset if nag-add ba.

                                            if (withdraw <= currentBalance) { /*conditin kasi need mas maliit or equal
                                            lang yung laman ng balance, kasi mag nenegative pag hindi mo sinet yung condition ng maayos which is bawal sa bank.*/
                                                newBalance = currentBalance - withdraw;
                                                BD.addTransaction("Withdraw: " + withdraw); //i-add ulit sa transaction list.
                                                BD.setBalance(newBalance);
                                                System.out.println("Withdrawal successful. \n New Balance: " + BD.getBalance());
                                            } else {
                                                System.out.println("Insufficient balance. Transaction failed.");
                                            }
                                            break;
                                        case 3:
                                            BD.printTransactions(); //print niya lang yung list.
                                            continue;
                                        case 4: //pang balik sa main menu- kung saan iinput ka ng pin.
                                            loop = false;
                                            looping = true;
                                            break;
                                        default:
                                            System.out.println("invalid input");

                                    }
                                }


                            } else {
                                System.out.println("Incorrect PIN. Please try again.");
                                looping = true;
                            }
                            break;

                        case 2:
                            System.out.println("Thank you for using our service. Goodbye!");
                            return;

                        default:
                            System.out.println("Invalid input");
                    }
                } catch (Exception e){
                    System.out.println("INVALID INPUT!") ;
                    input.nextLine();

                }
            }

    }
}