import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void setName() {
        Book book = new Book("Capitaine Casse-Cou","Louis Boussenard",1901);
        ArrayList<Character> nameChars = new ArrayList<>();
        nameChars.add('G');
        nameChars.add('o');
        nameChars.add('n');
        nameChars.add('e');
        nameChars.add(' ');
        nameChars.add('w');
        nameChars.add('i');
        nameChars.add('t');
        nameChars.add('h');
        nameChars.add(' ');
        nameChars.add('t');
        nameChars.add('h');
        nameChars.add('e');
        nameChars.add(' ');
        nameChars.add('w');
        nameChars.add('i');
        nameChars.add('n');
        nameChars.add('d');
        book.setName(nameChars);
        assertEquals("Gone with the wind",book.getName());
    }

    @Test
    void setAuthor() {
        Book book = new Book("Capitaine Casse-Cou","Louis Boussenard",1901);
        ArrayList<Character> authorChars = new ArrayList<>();
        authorChars.add('M');
        authorChars.add('a');
        authorChars.add('r');
        authorChars.add('g');
        authorChars.add('a');
        authorChars.add('r');
        authorChars.add('e');
        authorChars.add('t');
        authorChars.add(' ');
        authorChars.add('M');
        authorChars.add('i');
        authorChars.add('t');
        authorChars.add('c');
        authorChars.add('h');
        authorChars.add('e');
        authorChars.add('l');
        authorChars.add('l');
        book.setAuthor(authorChars);
        assertEquals("Margaret Mitchell",book.getAuthor());
    }

    @Test
    void setYearOfPublication() {
        Book book = new Book("Capitaine Casse-Cou","Louis Boussenard",1901);
        ArrayList<Character> yearOfPublicationChars = new ArrayList<>();
        yearOfPublicationChars.add('1');
        yearOfPublicationChars.add('9');
        yearOfPublicationChars.add('3');
        yearOfPublicationChars.add('6');
        book.setYearOfPublication(yearOfPublicationChars);
        assertEquals(1936,book.getYearOfPublication());
    }
}