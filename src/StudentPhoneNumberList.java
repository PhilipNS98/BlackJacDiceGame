import java.util.*;
import java.io.*;

public class StudentPhoneNumberList{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        Scanner inputP = new Scanner(new File("C:\\Users\\Phili\\OneDrive\\Skrivebord\\Dokumenter\\IntelliJ\\7. Arrays\\src\\PhoneNames.txt."));
        Scanner inputN = new Scanner(new File("C:\\Users\\Phili\\OneDrive\\Skrivebord\\Dokumenter\\IntelliJ\\7. Arrays\\src\\PhoneNumbers.txt"));

        int[] phoneNumbers = new int[10];
        String[] phoneNames = new String[10];

        System.out.println("**Welcome to the student phonenumber list**");
        System.out.println();

        int answer = 5;
        while(answer != 4){
            System.out.println();
            System.out.println("Enter:\n1 for new entry \n2 for show list \n3 for delete name/number \n4 to quit");
            answer = scan.nextInt();

            switch(answer){

                case 1:
                    addNumber(scan, inputN, inputP, phoneNumbers, phoneNames);
                    int i = 0;
                    for(i = 0; i < phoneNumbers.length; i++){
                        System.out.println("name: " + phoneNames[i] + "\nPhone number: " + phoneNumbers[i]);
                    }

                    break;
                case 2:
                    getPhoneList(inputN, inputP, phoneNumbers, phoneNames);
                    //       int i = 0;
                    for(i = 0; i < phoneNumbers.length; i++){
                        System.out.println("name: " + phoneNames[i] + "\nPhone number: " + phoneNumbers[i]);
                    }

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Thanks for using the student phonenumber list!");
            }
        }
    }
    public static void addNumber(Scanner scan, Scanner inputN, Scanner inputP, int[] phoneNumbers, String[] phoneNames){
        int answer = 0;
        System.out.println("Would you like to add a new number?\n1 for yes\n2 for no");
        answer = scan.nextInt();
        if(answer == 1){

            int newEntryNumber = 0;
            String newEntryName = "";
            System.out.println("Enter new number: ");
            newEntryNumber = scan.nextInt();

            System.out.println("Enter new name: ");
            newEntryName = scan.next();

            int i = 0;
            int j = 0;
            for(i = 0; i < phoneNumbers.length; i++, j++){
                if(phoneNumbers[i] == 0 && phoneNames[j] == null){
                    phoneNumbers[i] = newEntryNumber;
                    i++;
                    phoneNames[j] = newEntryName;
                    j++;

                }
                break;
            }

        }else{
            System.out.println("Enter:\n1 for new entry \n2 for show list \n3 for delete name/number \n4 to quit");
            answer = scan.nextInt();
        }
    }
    public static void getPhoneList(Scanner inputN, Scanner inputP, int[] phoneNumbers, String[] phoneNames) {
        int i = 0;
        int j = 0;
        while(inputN.hasNext()){
            phoneNames[i] = inputN.next();
            i++;
            phoneNumbers[j] = inputP.nextInt();
            j++;
        }
    }
}
