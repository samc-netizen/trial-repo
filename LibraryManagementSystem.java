import java.io.*;
import java.util.*;

// ---------------- BOOK CLASS ----------------
class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId, String title, String author, boolean isIssued) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }
}

// ---------------- INTERFACE ----------------
interface LibraryInterface {
    void addBook(Book book);
    void searchBook(String title);
    void issueBook(int bookId);
    void returnBook(int bookId, int daysLate);
}

// ---------------- LIBRARY CLASS ----------------
class Library implements LibraryInterface {

    ArrayList<Book> books = new ArrayList<>();
    final String FILE_NAME = "books.txt";

    // Constructor
    Library() {
        loadFromFile();
    }

    // Add Book
    @Override
    public void addBook(Book book) {
        books.add(book);
        saveToFile();
        System.out.println("Book added successfully!");
    }

    // Search Book
    @Override
    public void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + b.title + " by " + b.author);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Issue Book
    @Override
    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId && !b.isIssued) {
                b.isIssued = true;
                saveToFile();
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    // Return Book + Fine
    @Override
    public void returnBook(int bookId, int daysLate) {
        for (Book b : books) {
            if (b.bookId == bookId && b.isIssued) {
                b.isIssued = false;

                if (daysLate > 0) {
                    int fine = daysLate * 5;
                    System.out.println("Late fine: ₹" + fine);
                }

                saveToFile();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid Book ID or book was not issued!");
    }

    // Display Books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            System.out.println("ID: " + b.bookId +
                    " | Title: " + b.title +
                    " | Author: " + b.author +
                    " | Issued: " + b.isIssued);
        }
    }

    // Save to File (Fixed)
    void saveToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            for (Book b : books) {
                fw.write(b.bookId + "," + b.title + "," + b.author + "," + b.isIssued + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    // Load from File (Fixed)
    void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                books.add(new Book(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Boolean.parseBoolean(data[3])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading file!");
        }
    }
}

// ---------------- MAIN CLASS ----------------
public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        library.addBook(new Book(id, title, author, false));
                        break;

                    case 2:
                        System.out.print("Enter Book Title: ");
                        library.searchBook(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        library.issueBook(Integer.parseInt(sc.nextLine()));
                        break;

                    case 4:
                        System.out.print("Enter Book ID: ");
                        int bookId = Integer.parseInt(sc.nextLine());

                        System.out.print("Days Late: ");
                        int days = Integer.parseInt(sc.nextLine());

                        library.returnBook(bookId, days);
                        break;

                    case 5:
                        library.displayBooks();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid input!");
            }
        }
    }
}
