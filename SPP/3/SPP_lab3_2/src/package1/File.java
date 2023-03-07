package package1;
import java.util.Random;
public class File {
    public static int FileSystemSize = 1440;
    private int FileSize;
    private String FileExtension;
    private String FileName;

    public int ID;
    public int NumOfFiles;
    public Boolean Empty;

    public int getFileSize() {
        return FileSize;
    }

    public void setFileSize(int value) {
        FileSize = value;
    }


    public String getFileExtension() {
        return FileExtension;
    }

    public void setFileExtension(String value) {
        FileExtension = value;
    }


    public String getFileName() {
        return FileName;
    }

    public void setFileName(String value) {
        FileName = value;
    }

    static String randomString(int lenght) {
        Random rand = new Random();
//        Console.OutputEncoding = System.Text.Encoding.UTF8;

        String a = "";

        for (int i = 0; i < lenght; i++) {
            a += (char)rand.nextInt(26) + 'a';
        }
        return a;
    }

    public void Print() {
        System.out.println("Название файла: "+getFileName() + "\t Расширение: "+getFileExtension()+"\t Размер: "+getFileSize());
    }

    public void CheckFreeSpace() {
        for(int i = 0; i < FileSystemSize; i++) {}
    }

    public void FillingFreeSpace(int[] FreeSpace) {
        if (ID == 1) {
            for (int i = 0; i < getFileSize(); i++) {
                FreeSpace[i] = ID;
            }
        }
        else {
            int index = getArrayFirstOccurIndex(FreeSpace, 0);
            int total = 0;
            for (int i = index; i < FreeSpace.length - 1; i++) {
                if (FreeSpace[i] == 0) {
                    total++;
                    if (total == getFileSize()) {
                        for (int j = index; j < getFileSize() + index; j++) {
                            FreeSpace[j] = ID;
                        }
                        break;
                    }
                }
                else {
                    total = 0;
                    index = getArrayFirstOccurIndexFromCurrent(FreeSpace, 0, i);
                }
            }
            if (total < getFileSize()) {
                System.out.println("Не хватает места для файла!");
                Empty = true;
            }
            else Empty = false;
        }
    }

    public static int getArrayFirstOccurIndex(int[] arr, int elem){
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public static int getArrayFirstOccurIndexFromCurrent(int[] arr, int ind, int elem){
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                for(int j = i; j < arr.length; j++) {
                    if (arr[j]==ind)
                        return j;
                }
            }
        }
        return -1;
    }

    public File(int id, int[] FreeSpace) {
        Random temp = new Random();
        String[] fe = new String[] { ".txt", ".rar", ".bat", ".dox", ".exe" };
        String[] fn = new String[] { "tre", "da", "net", "ladno" };
        ID = id;
        setFileSize(temp.nextInt(150, 250));
        setFileExtension(fe[temp.nextInt(0, 5)]);
        setFileName(fn[temp.nextInt(0, 4)]); //randomString(temp.Next(3, 8));

        FillingFreeSpace(FreeSpace);
    }
}


