import java.util.ArrayList;

public class Book {

    Book(String name, String author, int yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    Book(ArrayList<Character> nameChars, ArrayList<Character> authorChars, ArrayList<Character> yearOfPublicationChars) {
        setName(nameChars);
        setAuthor(authorChars);
        setYearOfPublication(yearOfPublicationChars);
    }

    private String name;
    private String author;
    private int yearOfPublication = 0;

    public void setName(ArrayList<Character> chars) {
        name = "";
        for (int i = 0; i <chars.size(); i++) {
            name = name.concat(Character.toString(chars.get(i)));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(ArrayList<Character> chars) {
        author = "";
        for (int i = 0; i <chars.size(); i++) {
            author = author.concat(Character.toString(chars.get(i)));
        }
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(ArrayList<Character> chars) {
        String number = "";
        for (int i = 0; i <chars.size(); i++) {
            number = number.concat(Character.toString(chars.get(i)));
        }
        yearOfPublication = Integer.parseInt(number);
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String print() {
        return "Name of book: " + name + "\nAuthor: " + author + "\nYear of publication: " + yearOfPublication + "\n";
    }


}
