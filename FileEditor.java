import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileEditor {

    public void writeToFile(ListOfBooks listOfBooks,String path) {

        try(FileWriter writer = new FileWriter(path,false)) {
            for (int i = 0; i < listOfBooks.getListOfBooks().size(); i++) {
                writer.write(listOfBooks.getListOfBooks().get(i).getName());
                writer.write(",");
                writer.write(listOfBooks.getListOfBooks().get(i).getAuthor());
                writer.write(",");
                writer.write(Integer.toString(listOfBooks.getListOfBooks().get(i).getYearOfPublication()));
                writer.write("\n");
            }
            writer.close();
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ListOfBooks readFromFile(String path) {

        ListOfBooks listOfBooks = new ListOfBooks();
        ArrayList<ArrayList<Character>> array = new ArrayList<>();
        ArrayList<Character> arrayFirst = new ArrayList<>();
        ArrayList<Character> arraySecond = new ArrayList<>();
        ArrayList<Character> arrayThird = new ArrayList<>();
        array.add(arrayFirst);
        array.add(arraySecond);
        array.add(arrayThird);
        ArrayList<Character> arrayOfChars = new ArrayList<>();
        char[] buf = new char[256];

        try (FileReader reader = new FileReader(path)) {

            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }

                for (int i = 0; i < buf.length; i++) {
                    arrayOfChars.add(buf[i]);
                }
            }
            boolean bool;
            int k = 0;

            do {
                bool = true;
                for (int i = 0; i < 3; i++) {
                    for (int j = k; j < arrayOfChars.size(); j++) {
                        if ((arrayOfChars.get(j) != ',') && (arrayOfChars.get(j) != '\n') && (arrayOfChars.get(j) != ';') ) {
                            array.get(i).add(arrayOfChars.get(j));
                            k++;
                        } else {
                            k++;
                            break;
                        }
                    }
                }
                Book book = new Book(array.get(0),array.get(1),array.get(2));
                listOfBooks.add(book);
                array.get(0).clear();
                array.get(1).clear();
                array.get(2).clear();
                if (k == arrayOfChars.size()) bool = false;
            } while(bool);
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return listOfBooks;
    }

}
