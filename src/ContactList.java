import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        this.contacts = new ArrayList<Person>();
        run();
    }

    public static void main(String[] args) {
        ContactList list = new ContactList();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person p) {
        contacts.add(p);
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    public void sort(int sortBy) {
        int size = contacts.size();
        switch (sortBy) {
            case 0:
                for (int i = 0; i < size - 1; i++) {
                    for (int j = 0; j < size - 1 - i; j++) {
                        String name1 = contacts.get(j).getFirstName();
                        String name2 = contacts.get(j+1).getFirstName();
                        if (name1.compareTo(name2) > 0) {
                            String temp = name1;
                            name1 = name2;
                            name2 = temp;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < size - 1; i++) {
                    for (int j = 0; j < size - 1 - i; j++) {
                        String name1 = contacts.get(j).getLastName();
                        String name2 = contacts.get(j+1).getLastName();
                        if (name1.compareTo(name2) > 0) {
                            String temp = name1;
                            name1 = name2;
                            name2 = temp;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < size - 1; i++) {
                    for (int j = 0; j < size - 1 - i; j++) {
                        String number1 = contacts.get(j).getPhoneNumber();
                        String number2 = contacts.get(j+1).getPhoneNumber();
                        if (number1.compareTo(number2) > 0) {
                            String temp = number1;
                            number1 = number2;
                            number2 = temp;
                        }
                    }
                }
                break;
        }
    }

    public Person searchByLastName(String LastName) {
        for(Person person : contacts) {
            if (person.getLastName().equals(LastName)){
                return person;
            }
        }
        return null;
    }

    public Person searchByFirstName(String firstName) {
        for(Person person : contacts) {
            if (person.getFirstName().equals(firstName)){
                return person;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String PhoneNumber) {
        boolean found = false;
        for(Person person : contacts) {
            if (person.getPhoneNumber().equals(PhoneNumber)){
                return person;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person person : contacts) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println(
                    "Menu:\n" +
                            "1. Add Contact\n" +
                            "2. List All Contacts By First Name\n" +
                            "3. List All Contacts By Last Name\n" +
                            "4. List All Contacts By Phone Number\n" +
                            "5. List All Students\n" +
                            "6. Search By First Name\n" +
                            "7. Search By Last Name\n" +
                            "8. Search by Phone Number\n" +
                            "0. Exit\n"
            );

            Scanner input = new Scanner(System.in);

            int choice = input.nextInt();

            String userInput = "";
            Person p = null;

            switch (choice) {
                case 0:
                    return;
                case 1:
                    userAddContact();
                    break;
                case 2:
                    System.out.println("Enter First Name:");
                    input.nextLine();
                    userInput = input.nextLine();
                    listContacts(userInput, 0);
                    break;
                case 3:
                    System.out.println("Enter Last Name:");
                    input.nextLine();
                    userInput = input.nextLine();
                    listContacts(userInput, 1);
                    break;
                case 4:
                    System.out.println("Enter Phone Number:");
                    input.nextLine();
                    userInput = input.nextLine();
                    listContacts(userInput, 2);
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    System.out.println("Enter First Name:");
                    input.nextLine();
                    userInput = input.nextLine();
                    p = searchByFirstName(userInput);
                    if (p == null) {
                        System.out.println(userInput + " is not in the list");
                    } else {
                        System.out.println(p);
                    }
                    break;
                case 7:
                    System.out.println("Enter Last Name:");
                    input.nextLine();
                    userInput = input.nextLine();
                    p = searchByLastName(userInput);
                    if (p == null) {
                        System.out.println(userInput + " is not in the list");
                    } else {
                        System.out.println(p);
                    }
                    break;
                case 8:
                    System.out.println("Enter Phone Number:");
                    input.nextLine();
                    userInput = input.nextLine();
                    p = searchByPhoneNumber(userInput);
                    if (p == null) {
                        System.out.println(userInput + " is not in the list");
                    } else {
                        System.out.println(p);
                    }
                    break;
            }
        }
    }

    public void userAddContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select the type of contact to add: \n1. Student\n2. Hooper");
        boolean hooper = false;
        String firstName = "";
        String lastName = "";
        String phoneNumber = "";
        int misc = -1;
        if (input.nextInt() == 2) {
            hooper = true;
        }

        System.out.println("Please fill in the following information.");
        System.out.println("First Name:");
        input.nextLine();
        firstName = input.nextLine();

        System.out.println("Last Name:");
        lastName = input.nextLine();

        System.out.println("Phone Number:");
        phoneNumber = input.nextLine();

        System.out.println(firstName + lastName + phoneNumber);

        Person p;

        if (hooper) {
            System.out.println("Overall Rating:");
            misc = input.nextInt();
            p = new Hooper(firstName, lastName, phoneNumber, misc);
        } else {
            System.out.println("Grade Level:");
            misc = input.nextInt();
            p = new Student(firstName, lastName, phoneNumber, misc);
        }

        addContact(p);
    }

    public void listContacts(String key, int type) {
        boolean found = false;
        switch (type) {
            case 0:
                for (Person person : contacts) {
                    if (person.getFirstName().equals(key)) {
                        System.out.println(person);
                        found = true;
                    }
                }
                break;
            case 1:
                for (Person person : contacts) {
                    if (person.getLastName().equals(key)) {
                        System.out.println(person);
                        found = true;
                    }
                }
                break;
            case 2:
                for (Person person : contacts) {
                    if (person.getPhoneNumber().equals(key)) {
                        System.out.println(person);
                        found = true;
                    }
                }
                break;
        }
        if (!found) {
            System.out.println(key + " is not in the list.");
        }

    }
}

