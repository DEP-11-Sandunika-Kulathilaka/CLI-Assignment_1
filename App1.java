import java.util.Scanner;

public class App1 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "Welcome to Smart Banking";
        final String CREATE_ACCOUNT = "Create New Account";
        final String DEPOSITS = "Deposits";
        final String WITHDRAWLS = "Withdrawls"; 
        final String TRANSFER = "Transfer";
        final String CHECK_BALANCE = "Check Account Balance";
        final String DELETE_ACCOUNT = "Delete Accounts";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        String screen = DASHBOARD;
        String[] holders = {};
        int deposit = 0;

        do{
            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen) {
                case DASHBOARD:
                System.out.println("\n[1] Create New Account");
                System.out.println("[2] Deposits");
                System.out.println("[3] Withdrawls");
                System.out.println("[4] Transfer");
                System.out.println("[5] Check Account Balance");
                System.out.println("[6] Delete Accounts");
                System.out.println("[7] Exit\n");
                System.out.println("Enter the option: ");
                int option = scanner.nextInt();
                scanner.nextLine();


                switch (option){
                    case 1:screen = CREATE_ACCOUNT; break;
                    case 2:screen = DEPOSITS; break;
                    case 3:screen = WITHDRAWLS; break;
                    case 4:screen = TRANSFER; break;
                    case 5:screen = CHECK_BALANCE; break;
                    case 6:screen = DELETE_ACCOUNT ; break;
                    case 7:System.out.println(CLEAR); System.exit(0);
                    default: continue;
                }
                break;

            case CREATE_ACCOUNT:
                System.out.printf("ID: SDB-%05d \n", (holders.length + 1));

                boolean valid = true;
                String name;
                

                // Name Validation
                do{
                    valid = true;
                    System.out.print("Name: ");
                    name = scanner.nextLine().strip().toUpperCase();
                    if (name.isBlank()) {
                        System.out.printf(ERROR_MSG, "Can't be Empty");
                        valid = false;
                        continue;
                        
                    } 
                    for (int i = 0; i < holders.length; i++) {
                        if (!(Character.isLetter(name.charAt(i)) ||
                        Character.isSpaceChar(name.charAt(i)))) {
                            System.out.printf(ERROR_MSG, "Invalid Name");
                            valid = false;
                            continue;
                
                        }
                    }
                    //Deposit Amount Validation
                    System.out.print("Initial Deposit: ");
                    deposit = scanner.nextInt();
                    if (deposit <= 5000) {
                        System.out.printf(ERROR_MSG, "Insufficient Balance");
                        valid = false;
                        continue;
                        
                    }else System.out.printf(SUCCESS_MSG,
                                String.format("SDB-%05d:%s has been succesfully created. Do you want to add another (Y/n) ? ", (holders.length + 1), name));

                    if (scanner.nextLine().strip().toUpperCase().equals("Y"))
screen = DASHBOARD;
                   // break;
                }while(!valid);

                case DEPOSITS:

                int initialAmount = 0;
                String spaces;
                
                do{
                    //Account Number Validation
                    valid = true;
                    System.out.print("Enter Account No: ");
                    initialAmount = scanner.nextInt();
                    
                       if (Character.isWhitespace(initialAmount)){///
                        System.out.printf(ERROR_MSG, "Can't be Empty");
                        valid = false;
                        break;
                    }
                    
                    int depositAmount;
                    //Current Balance Validation
                    System.out.printf("Current Balance: %d", deposit);

                    System.out.print("Deposit Amount: ");
                    depositAmount = scanner.nextInt();
                    if (depositAmount < 500) {
                        System.out.printf(ERROR_MSG, "Insufficient Balance");
                        valid = false;

                    }else System.out.println("New Balance");

 
                }while(!valid);
            }

        }while(true);
    }

}