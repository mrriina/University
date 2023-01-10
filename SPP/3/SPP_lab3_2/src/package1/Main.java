package package1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void GenerateFileSystem(List<File> file, int[] freeSpace, int numFiles)
    {
        for (int i = 0; i < numFiles; i++)
        {
            File file1 = new File(i + 1, freeSpace);
            if (!file1.equals(null))
            {
                file.add(file1);
            }
        }
    }

    public static void DeleteFile(List<File> file, int[] freeSpace, String fileName)
    {
        for(int i = 0; i < file.size(); i++)
        {
            if(file.get(i).getFileName() == fileName)
            {
                int temp1 = File.getArrayFirstOccurIndex(freeSpace, file.get(i).ID);
                int temp2 = File.getArrayFirstOccurIndex(freeSpace, file.get(i).ID) + file.get(i).getFileSize();
                file.remove(i);
                for(int j = temp1; j < temp2; j++)
                {
                    freeSpace[j] = 0;
                }
                i--;
                System.out.println("Файл удален!");
                //break; //Если нужно удалять только один файл
            }
        }
    }

    public static void AddFile(List<File> file, int[] freeSpace)
    {
        int[] tempArr = freeSpace;
//        IEnumerable<Integer> nums = IntStream.of(tempArr).distinct();
        tempArr = IntStream.of(tempArr).toArray();
        int j = 0;
        for(; j < tempArr.length + 1; j++)
        {
            if (!Arrays.asList(tempArr).contains(j))
            {
                break;
            }
        }

        File file1 = new File(j, freeSpace);
        if (!file1.Empty)
        {
            file.add(file1);
        }
    }

    public static void main(String[] args) {
        int[] FreeSpace = new int[1440];
        int NumFiles = 10;
        ArrayList<File> FileSystem = new ArrayList<File>();
        GenerateFileSystem(FileSystem, FreeSpace, NumFiles);
        for(int i = 0; i < FileSystem.size(); i++)
        {
            FileSystem.get(i).Print();
        }
        DeleteFile(FileSystem, FreeSpace, "da");

        AddFile(FileSystem, FreeSpace);

        for (int i = 0; i < FileSystem.size(); i++)
        {
            FileSystem.get(i).Print();
        }
    }
}