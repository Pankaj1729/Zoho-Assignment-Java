import java.util.Scanner;
import java.util.Hashtable;

public class PhoneDiary {

    public static boolean checkPresence(Hashtable<String, Long> directory, String name) {
        return directory.containsKey(name);
    }

    public static void addNumber(Hashtable<String, Long> directory, String name, long number) {
        directory.put(name, number);
    }

    public static void deleteNumber(Hashtable<String, Long> directory, String name) {
        directory.remove(name);
    }

    public static void printDirectory(Hashtable<String, Long> directory) {
        for (String name : directory.keySet()) {
            System.out.println(name + ": " + directory.get(name));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int flag = 1;

        Hashtable<String, Long> directory = new Hashtable<>();

        while (flag == 1) {
            System.out.println("1. Add Number.\n2. Delete Number.\n3. List All Number.\n4. Search Number.\n5. Exit.");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                sc.nextLine();
                    Boolean add = true;
                    while (add) {
                        
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.println();
                        if (checkPresence(directory, name)) {
                            System.out.println("Name Already Exist!");
                        } else {
                            System.out.print("Enter the Number: ");
                            long number = sc.nextLong();
                            addNumber(directory, name, number);
                            System.out.println();
                            System.out.println("Number Add Successfully!");
                            add = false;
                        }
                    }
                    break;
                case 2:
                sc.nextLine();
                    System.out.print("Eneter the name: ");
                    String delNumber = sc.nextLine();
                    System.out.println();
                    if (directory.isEmpty()) {
                        System.out.println("Phone Directory is Empty!");
                    } else if (!checkPresence(directory, delNumber)) {
                        System.out.println("Number Doesn't Exist!");
                    } else {
                        deleteNumber(directory, delNumber);
                        System.out.println("Number Deleted Successfully!");
                    }
                    break;

                case 3:
                    if (directory.isEmpty()) {
                        System.out.println("Phone Directory is Empty!");
                    } else {
                        System.out.println("Numbers are: ");
                        printDirectory(directory);
                    }
                    break;
                case 4:
                    if (directory.isEmpty()) {
                        System.out.println("Phone Directory is Empty!");
                    } else {
                        sc.nextLine();
                        System.out.print("Enter name to be searched: ");
                        String searchElement = sc.nextLine();

                        if (checkPresence(directory, searchElement)) {
                            System.out.println("Number Exist!");
                            System.out.println(searchElement + ": " + directory.get(searchElement));
                        } else {
                            System.out.println("Number Doesn't Exist!");
                        }
                    }

                    break;

                case 5:
                    System.out.println("Program Ends Successfully!");
                    flag = 0;
                    break;

            }
        }

        sc.close();
    }
}
