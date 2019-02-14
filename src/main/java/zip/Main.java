package zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //write zip
     /*   BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/1.txt"), "UTF8"));
        String s = reader.readLine();
        ZipEntry entry1 = new ZipEntry("D:/1.txt");
        System.out.println(entry1);

        ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream("D:/1.zip"));
        outputStream.putNextEntry(entry1 );
        outputStream.write(s.getBytes());
        outputStream.close();*/

        //read zip

        ZipInputStream inputStream = new ZipInputStream(new FileInputStream("D:/1.zip"));
        ZipEntry zipEntry;
        String name;
        while ((zipEntry = inputStream.getNextEntry())!=null){
            name = zipEntry.getName();
            System.out.println(name);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name),"cp1251"));
            int b;
            while ((b = inputStream.read()) != -1) {
                bufferedWriter.write(b);
            }
            bufferedWriter.flush();
            bufferedWriter.close();



        }

        inputStream.close();

    }
}
