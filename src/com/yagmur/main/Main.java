package com.yagmur.main;


import com.yagmur.model.books.Book;
import com.yagmur.model.books.Journals;
import com.yagmur.model.books.Magazines;
import com.yagmur.model.books.Study_Books;
import com.yagmur.model.library.Library;
import com.yagmur.model.person.Author;
import com.yagmur.model.person.Reader;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. List All Books");
            System.out.println("3. Search Book by Name");
            System.out.println("4. Add Reader");
            System.out.println("5. Lend Book");
            System.out.println("6. Return Book");
            System.out.println("7. Update or Delete Book");
            System.out.println("8. List Books With Categories");
            System.out.println("9. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter book details (ID, Author, Name, Price, Status, Edition, Date of Purchase):");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    String authorName = scanner.nextLine();
                    Author author = new Author(authorName);
                    String name = scanner.nextLine();
                    double price;
                    do {
                        System.out.println("Enter book price (must be greater than 0):");
                        price = scanner.nextDouble();
                    } while (price <= 0);
                    scanner.nextLine();
                    String status = scanner.nextLine();
                    String edition = scanner.nextLine();
                    Date dateOfPurchase = new Date();
                    Book book = new Book(id, author, name, price, status, edition, dateOfPurchase);
                    library.addBook(book);
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.println("Enter book name:");
                    String bookName = scanner.nextLine();
                    for (Book b : library.getBooks()) {
                        if (b.getName().equalsIgnoreCase(bookName)) {
                            b.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter reader name:");
                    String readerName = scanner.nextLine();
                    Reader reader = new Reader(readerName);
                    library.addReader(reader);
                    break;

                case 5:
                    System.out.println("Enter book ID and reader name:");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine();
                    String rName = scanner.nextLine();
                    Reader r = null;
                    for (Reader readerObj : library.getReaders()) {
                        if (readerObj.getName().equalsIgnoreCase(rName)) {
                            r = readerObj;
                            break;
                        }
                    }
                    if (r != null) {
                        for (Book b : library.getBooks()) {
                            if (b.getBookId().equals(bookId)) {
                                library.lendBook(b, r);
                            }
                        }
                    } else {
                        System.out.println("Reader not found.");
                    }
                    break;

                case 6:
                    System.out.println("Enter book ID and reader name:");
                    Long bId = scanner.nextLong();
                    scanner.nextLine();
                    String readerN = scanner.nextLine();
                    Reader read = null;
                    for (Reader readerObj : library.getReaders()) {
                        if (readerObj.getName().equalsIgnoreCase(readerN)) {
                            read = readerObj;
                            break;
                        }
                    }
                    if (read != null) {
                        for (Book b : library.getBooks()) {
                            if (b.getBookId().equals(bId)) {
                                library.takeBackBook(b, read);
                            }
                        }
                    } else {
                        System.out.println("Reader not found.");
                    }
                    break;


                case 7:
                    System.out.println("What do you want to do?");
                    System.out.println("1. Update book details");
                    System.out.println("2. Delete book");
                    int actionChoice = scanner.nextInt();
                    scanner.nextLine(); // Dummy nextLine to consume newline character
                    switch (actionChoice) {
                        case 1:
                            // Update book details
                            System.out.println("Enter the book ID to update:");
                            Long bookIdToUpdate = scanner.nextLong();
                            scanner.nextLine(); // Dummy nextLine to consume newline character
                            Book bookToUpdate = library.findBookById(bookIdToUpdate);
                            if (bookToUpdate != null) {
                                System.out.println("What do you want to update?");
                                System.out.println("1. Price");
                                System.out.println("2. Status");
                                System.out.println("3. Edition");
                                int updateChoice = scanner.nextInt();
                                scanner.nextLine(); // Dummy nextLine to consume newline character
                                switch (updateChoice) {
                                    case 1:
                                        System.out.println("Enter the new price:");
                                        double newPrice = scanner.nextDouble();
                                        bookToUpdate.updatePrice(newPrice);
                                        System.out.println("Price updated successfully.");
                                        break;
                                    case 2:
                                        System.out.println("Enter the new status:");
                                        String newStatus = scanner.nextLine();
                                        bookToUpdate.updateStatus(newStatus);
                                        System.out.println("Status updated successfully.");
                                        break;
                                    case 3:
                                        System.out.println("Enter the new edition:");
                                        String newEdition = scanner.nextLine();
                                        bookToUpdate.updateEdition(newEdition);
                                        System.out.println("Edition updated successfully.");
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                        break;
                                }
                            } else {
                                System.out.println("Book not found.");
                            }
                            break;
                        case 2:
                            // Delete book
                            System.out.println("Enter the book ID to delete:");
                            Long bookIdToDelete = scanner.nextLong();
                            scanner.nextLine(); // Dummy nextLine to consume newline character
                            if (library.deleteBookById(bookIdToDelete)) {
                                System.out.println("Book deleted successfully.");
                            } else {
                                System.out.println("Book not found.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Which category do you want to display?");
                    System.out.println("1. Journals");
                    System.out.println("2. Magazines");
                    System.out.println("3. Study Books");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine(); // Dummy nextLine to consume newline character
                    switch (categoryChoice) {
                        case 1:
                            System.out.println("Journals:");
                            library.displayBooksByCategory(Journals.class);
                            break;
                        case 2:
                            System.out.println("Magazines:");
                            library.displayBooksByCategory(Magazines.class);
                            break;
                        case 3:
                            System.out.println("Study Books:");
                            library.displayBooksByCategory(Study_Books.class);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 9:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }
    }
}
