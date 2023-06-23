import javax.imageio.IIOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        //В папке Games создайте несколько директорий: src, res, savegames, temp.
        File dir1 = new File("/home/oem/work/Games", "src");
        if (dir1.mkdir())
            sb.append("Каталог: " + dir1.getName() + " - создан\n");
        File dir2 = new File("/home/oem/work/Games", "res");
        if (dir2.mkdir())
            sb.append("Каталог " + dir2.getName() + " - создан\n");
        File dir3 = new File("/home/oem/work/Games", "savegames");
        if (dir3.mkdir())
            sb.append("Каталог " + dir3.getName() + " - создан\n");
        File dir4 = new File("/home/oem/work/Games", "temp");
        if (dir4.mkdir())
            sb.append("Каталог " + dir4.getName() + " - создан\n");

        //В каталоге src создайте две директории: main, test.
        File src = new File(dir1, "main");
        if (src.mkdir())
            sb.append("Каталог " + src.getName() + " - создан\n");

        File test = new File(dir1, "test");
        if (test.mkdir())
            sb.append("Каталог " + test.getName() + " - создан\n");

        //В подкаталоге main создайте два файла: Main.java, Utils.java.
        File myFile1 = new File("/home/oem/work/Games/src/main/Main.java");
        try {
            if (myFile1.createNewFile())
                sb.append(myFile1.getName() + " Файл был создан\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        File myFile2 = new File("/home/oem/work/Games/src/main/Utils.java");
        try {
            if (myFile2.createNewFile())
                sb.append(myFile2.getName() + " Файл был создан\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //В каталог res создайте три директории: drawables, vectors, icons.
        File res1 = new File("/home/oem/work/Games/res", "drawables");
        if (res1.mkdir())
            sb.append("Каталог: " + res1.getName() + " создан\n");
        File res2 = new File("/home/oem/work/Games/res", "vectors");
        if (res2.mkdir())
            sb.append("Каталог: " + res2.getName() + " создан\n");
        File res3 = new File("/home/oem/work/Games/res", "icons");
        if (res3.mkdir())
            sb.append("Каталог: " + res3.getName() + " создан\n");

        //В директории temp создайте файл temp.txt.
        File tempFile = new File("/home/oem/work/Games/temp/temp.txt");
        try {
            if (tempFile.createNewFile())
                sb.append(tempFile.getName() + " Файл был создан\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Файл temp.txt будет использован для записиси в него информации
        // об успешноном или неуспешном создании файлов и директорий.
        // откроем байтовый поток записи в файл
        try (FileOutputStream fos = new FileOutputStream("/home/oem/work/Games/temp/temp.txt")) {
// перевод строки в массив байтов
            byte[] bytes = sb.toString().getBytes();
// запись байтов в файл
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}