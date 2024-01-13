import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();


    public static void main(String[] args) {

        int choice;

        while(true){
            displayMenu();
            System.out.println("Your choice: ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    showContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    searchAndDisplay();
                    break;
                case 0:
                    exit(0);

                default:
                    System.out.println("Try again");
            }
        }
    }

    public static void displayMenu(){
        System.out.println("PHONE BOOK");
        System.out.println("Menu:");
        System.out.println("1. Display contacts \n2. Add contact\n3. Delete contact\n4. Update contact \n5. Search and display contact");
    }

    public static void showContacts(){
        int i = 0;
        if(contacts.isEmpty()){
            System.out.println("No contacts were found");
        }
        else{
            for(Contact contact : contacts){
                System.out.print(i);
                System.out.println(contact);
                i++;
            }
        }
    }

    public static void addContact(){
        scanner.nextLine();
        boolean isAdded = false;

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        for(Contact contact : contacts){
            if(Objects.equals(contact.getPhoneNumber(), phoneNumber)){
                isAdded = true;
                break;
            }
        }

        if(isAdded){
            System.out.println("This number has already been added");
        }
        else{
            contacts.add(new Contact(name,phoneNumber));
            System.out.println("Contact has been added");
        }
    }

    public static void deleteContact(){
        scanner.nextLine();
        boolean isDeleted = false;
        System.out.print("Enter name of contact that you would like to delete: ");
        String name = scanner.nextLine();

        for(Contact contact : contacts){
            if(Objects.equals(contact.getName(), name)){
                System.out.println(contact);
                break;
            }
        }

        System.out.println("Which contact you would like to delete: ");
        int choice = scanner.nextInt();

        contacts.remove(choice);
        System.out.println("Contact has been deleted");
        isDeleted = true;

        if(!isDeleted){
            System.out.println("Contact has not been found");
        }
    }

    public static void updateContact(){
        scanner.nextLine();
        showContacts();
        System.out.println("Which contact you would like to change: ");
        int choice = scanner.nextInt();

        System.out.println("Press 1 in order to change name or 2 in order to change phone number");
        int update = scanner.nextInt();
        scanner.nextLine();
        if(update == 1){
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            contacts.get(choice).setName(newName);
        }
        else if(update == 2){
            System.out.print("Enter new number: ");
            String newPhoneNumber = scanner.nextLine();
            contacts.get(choice).setPhoneNumber(newPhoneNumber);
        }
        else{
            System.out.println("Error!");
        }
    }

    public static void searchAndDisplay(){
        scanner.nextLine();
        boolean isFound = false;
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        for(Contact contact : contacts){
            if(contact.getName() == name){
                System.out.println(contact);
                isFound = true;
            }
        }

        if(!isFound){
            System.out.println("No contacts were found");
        }
    }
}