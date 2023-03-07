import java.io.*;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] buf = new char[512];
        String[] arrayString = new String[100];
        try(FileReader reader = new FileReader("file.txt")) {
            int c;
            System.out.println("Input: ");
            while((c=reader.read(buf))>0) {
                if(c<256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.println(buf);
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nOutput:");
        String help = "";
        int count = 0;
        for (int j = 0; j < buf.length; j++) {
            boolean flag = false;
            if ((buf[j] >= 'а')&&(buf[j] <= 'я')) {
                help += buf[j];
            }
            else {
                for(int r = 0; r < count; r++) {
                    if (help.equals(arrayString[r])) flag = true;
                }
                if(flag == false) {
                    arrayString[count] = help;
                    count++;
                }
                help = "";
            }
        }

        String[] arrayString1 = new String[count];
        for (int i = 0; i < arrayString1.length; i++) {
            arrayString1[i] = arrayString[i];
        }
        Arrays.sort(arrayString1);
        for (int i = 0; i < count; i++) {
            System.out.println(arrayString1[i]);
        }
    }
}