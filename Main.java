package LibraryManagement;
import java.util.HashMap;
import java.util.ArrayList;


public class Main {

    static HashMap<Integer, Book> books = new HashMap<>();
    static HashMap<Integer, User> users = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> issued = new HashMap<>();

    static void loadData() {

        books.put(1, new Book(1, "Java", "amit", 5));
        books.put(2, new Book(2, "Python", "piyush", 3));
        books.put(3, new Book(3, "C++", "dhaplasur ", 2));
        books.put(4, new Book(4, "DSA", "chacha420", 4));

        users.put(101, new User(101, "bhaiya"));
        users.put(102, new User(102, "pappa"));
        users.put(103, new User(103, "mummy"));

        issued.put(101, new ArrayList<>());
        issued.put(102, new ArrayList<>());
        issued.put(103, new ArrayList<>());
    }

    static void showBooks() {
        System.out.println("\n Books:");
        for (int id : books.keySet()) {
            Book b = books.get(id);
            System.out.println(id + " → " + b.title + " | Available: " + b.available);
        }
    }

    static void showUsers() {
        System.out.println("\n Users:");
        for (int id : users.keySet()) {
            System.out.println(id + " → " + users.get(id).name);
        }
    }

    static void issueBook(int userId, int bookId) {

        if (!books.containsKey(bookId) || !users.containsKey(userId)) {
            System.out.println("Invalid");
            return;
        }

        Book b = books.get(bookId);

        if (b.available == 0) {
            System.out.println("Not Available");
            return;
        }

        issued.get(userId).add(bookId);
        b.available--;

        System.out.println("Book Issued: " + b.title);
    }

    static void returnBook(int userId, int bookId) {

        if (!issued.get(userId).contains(bookId)) {
            System.out.println(" Not Issued");
            return;
        }

        issued.get(userId).remove(Integer.valueOf(bookId));
        books.get(bookId).available++;

        System.out.println("Book Returned");
    }

    static void searchBook(String name) {

        for (Book b : books.values()) {
            if (b.title.toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Found: " + b.title);
                return;
            }
        }

        System.out.println(" Not Found");
    }

    static void showIssued(int userId) {
        System.out.println("\nIssued Books of " + users.get(userId).name);
        System.out.println(issued.get(userId));
    }

    public static void main(String[] args) {

        loadData();

        System.out.println("===== MENU =====");
        System.out.println("1 → View Books");
        System.out.println("2 → Issue Book");
        System.out.println("3 → Return Book");
        System.out.println("4 → Search Book");
        System.out.println("5 → View Users");

        int choice = 1;

        if (choice == 1) {
            showBooks();
        } else if (choice == 2) {
            issueBook(101, 1);
        } else if (choice == 3) {
            returnBook(101, 1);
        } else if (choice == 4) {
            searchBook("java");
        } else if (choice == 5) {
            showUsers();
        }

     // System.out.println(books);
      // System.out.println(users);
       //System.out.println(issued);
// keys and addresses stored outputs


    }
}
