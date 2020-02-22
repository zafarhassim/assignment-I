import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Artist {

    private String name;
    public Artist next;

    public Artist(String string) {
        name = string;
    }

    public String displayLink() {
        return name;
    }
}
 class TopStreamingArtists{
    private Artist first;


    public void TopStreamingArtists(){
        first = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(String string) throws IOException {
        Artist newLink = new Artist(string);
        newLink.next = first;
        first = newLink;
    }

    public Artist deleteFirst(){
        Artist temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() throws IOException {
        String homework = "data/homework.txt";
        File f = new File(homework);
        FileWriter fw = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(fw);

        Artist current = first;
        while(current != null){
            pw.println(current.displayLink());
            System.out.println(current.displayLink());
            current = current.next;
        }
        pw.println();
        pw.close();
    }

    public void insert(String string)  {
        Artist newLink = new Artist(string);
        Artist previous = null;
        Artist current = first;
        while(current != null && string.compareTo(current.displayLink()) >= 0) {
            previous = current;
            current = current.next;
        }if (previous == null)
            first = newLink;
            else{
            previous.next = newLink;
            newLink.next = current;
        }
}
}
