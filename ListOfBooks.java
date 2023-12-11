
import java.util.ArrayList;
import java.util.Scanner;


public class ListOfBooks {

    private ArrayList<Book> listOfBooks = new ArrayList<>();

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void add(Book book) {
        listOfBooks.add(book);
        System.out.println("Successfully added: \n" + book.print());
    }

    public void removeByNameAndAuthor (String name, String author) {
        boolean bool = true;
        int help = 0;
        for (int i = 0; i <listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getName().equals(name)) {
                if (listOfBooks.get(i).getAuthor().equals(author)) {
                    System.out.println("Found:");
                    System.out.println(listOfBooks.get(i).print());
                    Scanner scanner = new Scanner(System.in);
                    do {
                        System.out.print("Are you sure you want to delete this book? (y/n) - ");
                        if (scanner.nextLine().equals("y")) {
                            listOfBooks.remove(i);
                            help++;
                            bool = false;
                        } else if (scanner.nextLine().equals("n")) {
                            System.out.println("Position skipped.");
                            bool = false;
                        } else System.out.println("!!...incorrect input...!!");
                    } while (bool);
                    bool = true;
                }
            }
        }
        System.out.println(help + " position(s) successfully deleted");
    }

    public void searchByName(String searchableText) {
        int help = 0;
        System.out.println("Result of search");
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getName().toLowerCase().contains(searchableText.toLowerCase())) {
                System.out.println(listOfBooks.get(i).print());
                help++;
            }
        }
        System.out.println(help + " matches found");
    }

    public void searchByAuthor(String searchableText) {
        int help = 0;
        System.out.println("Result of search");
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getAuthor().toLowerCase().contains(searchableText.toLowerCase())) {
                System.out.println(listOfBooks.get(i).print());
                help++;
            }
        }
        System.out.println(help + " matches found");
    }

    public void searchByYearOfPublication(String searchableText) {
        int help = 0;
        System.out.println("Result of search");
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (Integer.toString(listOfBooks.get(i).getYearOfPublication()).contains(searchableText)) {
                System.out.println(listOfBooks.get(i).print());
                help++;
            }
        }
        System.out.println(help + " matches found");
    }

    public void printAll() {
        System.out.println("List of all books in library:\n");
        for (int i = 0; i < listOfBooks.size(); i++) {
            System.out.println(listOfBooks.get(i).print());
        }
        System.out.println(listOfBooks.size() + " books in total\n");
    }

    public int getBook(String name, String author, int yearOfPublication) {
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getName().equalsIgnoreCase(name)) {
                if (listOfBooks.get(i).getAuthor().equalsIgnoreCase(author)) {
                    if (listOfBooks.get(i).getYearOfPublication() == yearOfPublication) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

}
