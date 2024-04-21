import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int userEntersNumber()
    {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true)
        {
            try
            {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid number");
            }
            scanner.nextLine();
        }
        return number;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProfileFactory profileFactory = null;
        Profile selectedProfile = null;
        boolean valid = false;
        HashMap hashMap = new HashMap<String, Profile>();
        //key = Username
        //value = Profile
        int choice = -1;
        int innerChoice= -1;
        while(choice!=3)
        {
            System.out.println("Welcome to task manager" +
                    "\n[1] Sign up an account" +
                    "\n[2] Sign into an account" +
                    "\n[3] Log off Task Manager");
            choice = userEntersNumber();
            switch (choice)
            {
                case 1:
                    String userName="";
                    String userPass="";
                    valid=false;
                        System.out.println("Please enter your account username:");
                    while (!valid) {
                        userName = scanner.nextLine();
                        if (hashMap.containsKey(userName))
                            System.out.println("Username Already Taken Please try another");
                        else
                            valid = true;
                    }
                    valid=false;
                    System.out.println("Now please enter the password for your account:");
                    while (!valid) {
                        userPass = scanner.nextLine();
                        System.out.println("For security purposes please enter that password again.");
                        String passAttempt = scanner.nextLine();
                        if (userPass.equals(passAttempt))
                            valid=true;
                        else
                            System.out.println("The password's did not match please try again:");
                    }
                    System.out.println("Lastly do you want your account to have:" +
                            "\n[1] Repeating Daily Tasks" +
                            "\nMore to be added in the future...");
                    int num = userEntersNumber();
                    if (num==1)
                        selectedProfile=profileFactory.createProfile(userName,userPass);
                    System.out.println("Account Successfully Created\n"+selectedProfile.toString());
                    hashMap.put(selectedProfile.getAccountName(),selectedProfile);
                    selectedProfile=null;
                    break;
                case 2:
                    innerChoice=-1;
                    valid=false;
                    if (hashMap.isEmpty())
                        System.out.println("We currently have no users in our database, please create an account");
                    else {
                        while(!valid) {
                            System.out.println("Please enter the username of your account. Or type 'Quit' to stop searching");
                            String tempUser=scanner.nextLine();
                            if (tempUser.equals("Quit"))
                            {
                                valid=true;
                                innerChoice=4;
                            }
                            else if (hashMap.containsKey(tempUser))
                            {
                                selectedProfile = (Profile) hashMap.get(tempUser);
                                String tempPass="";
                                System.out.println("User found please enter password or access will not be allowed");
                                tempPass = scanner.nextLine();
                                while (!tempPass.equals(selectedProfile.getAccountPassword())) {
                                    System.out.println("Wrong password entered; Type 'Return' to search a new account");
                                    tempPass = scanner.nextLine();
                                    if (tempPass.equals("Return"))
                                        break;
                                }
                                if (tempPass.equals(selectedProfile.getAccountPassword())) {
                                    System.out.println("Login successful");
                                    valid = true;
                                }
                            }
                            else
                                System.out.println("No account could be found with this username. Try again");
                        }
                        while (innerChoice != 4) {
                            System.out.println("Welcome, "+selectedProfile.getAccountName()+
                                    "\n[1] View current tasks" +
                                    "\n[2] Add a new task to your list" +
                                    "\n[3] Complete a task from your list" +
                                    "\n[4] Log out of account");
                            innerChoice = userEntersNumber();
                            switch (innerChoice) {
                                case 1:
                                    System.out.println(selectedProfile.getTasks().toString());
                                    break;
                                case 2:
                                    String addTask = "";
                                    System.out.println("Please enter the task you want add.");
                                        addTask+= scanner.nextLine();
                                    selectedProfile.getTasks().enqueue(addTask);
                                    System.out.println(selectedProfile.getTasks().toString());
                                    break;
                                case 3:
                                    if (!selectedProfile.getTasks().isEmpty())
                                        System.out.println("Task: "+selectedProfile.getTasks().dequeue()+", has been completed");
                                    else
                                        System.out.println("No tasks left to be completed.");

                                    break;
                                case 4:
                                    System.out.println("Logging out of account, come back soon.");
                                    break;
                                default:
                                    System.out.println("Please enter a valid number");
                                    break;
                            }

                        }
                    }
                    break;
                case 3:
                    System.out.println("Please have a great day.");
                    break;
                default:
                    System.out.println("Please enter a valid number");
                    break;
            }
        }

    }
}
