package LibraryManagement;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
//java util* use krleta lekin apne mana kra tha toh nahi kra use

class Book {
    int id;
    String title;
    String author;
    int available;
//jhaki mar book ka algo :)))))
    //constructor me pass
    Book(int id, String title, String author, int available) {
        this.id = id;
        this.title = title;
        //this bole toh current object ko point krna sir ne sekhaya tha
        this.author = author;
        this.available = available;
    }
}

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
// user ka basic function

public class Main {
//main me arraylist and hashmap ka object bnaya

    static List<Book> books = new ArrayList<>();
    static List<User> users = new ArrayList<>();
    static HashMap<Integer, List<Integer>> issued = new HashMap<>();

    static Scanner sc = new Scanner(System.in);
//scanner for user input like cin<<
    static void addBook() {
        if (books.size() >= 10) {
            System.out.println("10 HI BOOK HAI LALA");
            return;
        }
        //loop
        //getter setter
        
        // void setId(int id ){
        // this.id =id;
        //}

//int getId(){
// return id;
// }
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Copies: ");
            int copies = sc.nextInt();

            books.add(new Book(id, title, author, copies));
            System.out.println("✅ Book Added");

        } catch (Exception e) {
            System.out.println("NAHI HAI");
            sc.nextLine();
        }
    }
    //try catch for exception agar aai toh

    static void addUser() {
        if (users.size() >= 5) {
            System.out.println("Max 5 users");
            return;
        }

        try {
            System.out.print("Enter User ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            users.add(new User(id, name));
            issued.put(id, new ArrayList<>());

            System.out.println("User Added");

        } catch (Exception e) {
            System.out.println("NAHI HAI ");
            sc.nextLine();
        }
    }

    static void issueBook() {
        try {
            System.out.print("Enter User ID: ");
            int uid = sc.nextInt();
//uid mtlb userid shortform
            System.out.print("Enter Book ID: ");
            int bid = sc.nextInt();
            // bid mtlb bookid

            int index = -1;

            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).id == bid) {
                    index = i;
                    break;
                }
            }

            if (index == -1 || books.get(index).available == 0) {
                System.out.println("NAHI HAI ");
                return;
            }

            issued.get(uid).add(bid);
            books.get(index).available--;

            System.out.println("BOOK MILGYI");

        } catch (Exception e) {
            System.out.println("GALAT");
            sc.nextLine();
        }
    }

    static void returnBook() {
        try {
            System.out.print("Enter User ID: ");
            int uid = sc.nextInt();

            System.out.print("Enter Book ID: ");
            int bid = sc.nextInt();

            if (!issued.get(uid).contains(bid)) {
                System.out.println("NAHI HAI ");
                return;
            }

            issued.get(uid).remove(Integer.valueOf(bid));

            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).id == bid) {
                    books.get(i).available++;
                }
            }

            System.out.println("Book Returned ;}HAHAHAHA");

        } catch (Exception e) {
            System.out.println("GALAT DALEGA BTAU ABHI");
            sc.nextLine();
        }
    }

    static void viewBooks() {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println(b.id + " | " + b.title + " | " + b.available);
        }
    }

    static void viewUsers() {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            System.out.println(u.id + " | " + u.name);
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n<><><><><> MENU <><><><><>");//jhaki
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Users");
            System.out.println("0. Exit");

            int ch = sc.nextInt();// for user use jaise 1 2 3 dbayega toh kuch function call hona chiye
//menu banane ke liye
            if (ch == 1) {
                addBook();
            } else if (ch == 2) {
                addUser();
            } else if (ch == 3) {
                issueBook();
            } else if (ch == 4) {
                returnBook();
            } else if (ch == 5) {
                viewBooks();
            } else if (ch == 6) {
                viewUsers();
            } else if (ch == 0) {
                return;
            } else {
                System.out.println("GALAT HAI GUDDI LAL KRDUNGA ");

            }
        }
    }
}
//kya kya nahi bana
// book remove from list and kis user ke pass book hai
// book add and book remove from list jab koi user le jaye

