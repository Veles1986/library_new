import java.util.Scanner;

public class ConsoleMenu {

    private boolean isRunning;

    private ListOfBooks listOfBooks;

    private FileEditor fileEditor = new FileEditor();

    public void run(String path) {
        isRunning = true;

        while(isRunning) {
            listOfBooks = fileEditor.readFromFile(path);
            boolean bool = false;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Welcome to our library :)\n\n" +
                        "What did you want to do?;\n" +
                        "1 - add book to library\n" +
                        "2 - remove book from library\n" +
                        "3 - search book\n" +
                        "4 - list of all Books\n" +
                        "5 - edit information about books\n" +
                        "6 - update a text file\n" +
                        "7 - exit\n");
                if (scanner.hasNextInt()) {
                    switch (scanner.nextInt()) {
                        case 1:
                            scanner.nextLine();
                            addBook();
                            break;
                        case 2:
                            scanner.nextLine();
                            remove();
                            break;
                        case 3:
                            scanner.nextLine();
                            search();
                            break;
                        case 4:
                            scanner.nextLine();
                            listOfAllBooks();
                            break;
                        case 5:
                            scanner.nextLine();
                            editInfo();
                            break;
                        case 6:
                            scanner.nextLine();
                            updateFile(path);
                            break;
                        case 7:
                            scanner.nextLine();
                            updateFile(path);
                            return;
                        default:
                            scanner.nextLine();
                            System.out.println("!!...incorrect input...!!");
                            break;
                    }
                    boolean help = true;
                    while (help) {
                        System.out.print("Do you want to do another action? (y/n)  -  ");
                        String str = scanner.nextLine();
                        if (str.equals("y")) {
                            help = false;
                            bool = true;
                        } else if (str.equals("n")) {
                            isRunning = false;
                            help = false;
                            bool = false;
                        } else {
                            System.out.println("!!...incorrect input...!!");
                        }
                    }
                } else {
                    scanner.nextLine();
                    bool = true;
                    System.out.println("incorrect input\n" +
                            "Please, enter a number from the menu\n");
                }
            } while (bool);
            updateFile(path);
        }
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter name of book: ");
        String name = scanner.nextLine();
        System.out.print("Please, enter author of book: ");
        String author = scanner.nextLine();
        System.out.print("Please, enter year of publication: ");
        int yearOfPublication = scanner.nextInt();
        Book book = new Book(name, author, yearOfPublication);
        listOfBooks.add(book);
        System.out.println("Book successfully added to library\n");
    }

    public void remove() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String author;
        System.out.println("Please enter the name of the book you want to delete");
        name = scanner.nextLine();
        System.out.println("Please enter the author of the book you want to delete");
        author = scanner.nextLine();
        listOfBooks.removeByNameAndAuthor(name,author);
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the search option: \n" +
                "1 - search by name\n" +
                "2 - search by author\n" +
                "3 - search by year of publication");
        boolean help1;
        boolean help2;
        do {
            help1 = false;
            if (scanner.hasNextInt()) {
                do {
                    help2 = false;
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    String str;
                    System.out.println("Please enter the text fragment you are looking for:  ");
                    str = scanner.nextLine();
                    switch (number) {
                        case 1:
                            listOfBooks.searchByName(str);
                            break;
                        case 2:
                            listOfBooks.searchByAuthor(str);
                            break;
                        case 3:
                            listOfBooks.searchByYearOfPublication(str);
                            break;
                        default:
                            System.out.println("!!...incorrect input...!!");
                            help2 = true;
                            System.out.println("Please choose the search option: \n" +
                                    "1 - search by name\n" +
                                    "2 - search by author\n" +
                                    "3 - search by year of publication");
                            break;
                    }
                } while (help2);
            } else {
                System.out.println("!!...incorrect input...!!");
                scanner.nextLine();
                System.out.println("Please choose the search option: \n" +
                        "1 - search by name\n" +
                        "2 - search by author\n" +
                        "3 - search by year of publication");
                help1 = true;
            }
        } while(help1);
    }

    public void listOfAllBooks() {
        listOfBooks.printAll();
    }

    public void editInfo() {
        listOfBooks.printAll();
        Scanner scanner = new Scanner(System.in);
        String name,newName;
        String author,newAuthor;
        int yearOfPublication,newYearOfPublication;
        boolean bool = true;
        while (bool) {
            bool = false;
            System.out.print("Please enter the name of the book you want to edit: ");
            name = scanner.nextLine();
            System.out.print("Please enter the author of the book you want to edit: ");
            author = scanner.nextLine();
            System.out.print("Please enter the year of publication of the book you want to edit: ");
            yearOfPublication = scanner.nextInt();
            scanner.nextLine();
            if (listOfBooks.getBook(name, author, yearOfPublication) == -1) {
                System.out.println("Book not found, please try again");
                bool = true;
            } else {
                System.out.print("Please enter the new name of the book: ");
                newName = scanner.nextLine();
                listOfBooks.getListOfBooks().get(listOfBooks.getBook(name, author, yearOfPublication)).setName(newName);
                System.out.print("Please enter the new author of the book: ");
                newAuthor = scanner.nextLine();
                listOfBooks.getListOfBooks().get(listOfBooks.getBook(newName, author, yearOfPublication)).setAuthor(newAuthor);
                System.out.print("Please enter the new year of publication of the book: ");
                newYearOfPublication = scanner.nextInt();
                scanner.nextLine();
                listOfBooks.getListOfBooks().get(listOfBooks.getBook(newName, newAuthor, yearOfPublication)).setYearOfPublication(newYearOfPublication);
                System.out.println("Book edited");
                System.out.println(listOfBooks.getListOfBooks().get(listOfBooks.getBook(newName, newAuthor, newYearOfPublication)).print());
            }
        }
    }

    public void updateFile(String path) {
        fileEditor.writeToFile(listOfBooks, path);
    }
}
