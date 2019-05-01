package IO;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class WriteStringToFile {
    static File file = new File("src/main/java/IO/1.txt");

    public static void usingWriter(String string) throws IOException {

        //Запись с помощью FileWriter (для ускорения завернутій в BufferedWriter) Кодировка UTF -8
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(string);
        writer.flush();
        writer.close();
    }

    public static void usingOutputStreamWriter(String string) throws IOException {


        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file, true), "UTF8");
        writer.write(string);
        writer.flush();
        writer.close();
    }

    public static void usingBufferedOutputStreamWriter(String string) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
        writer.write(string);
        writer.flush();
        writer.close();
    }

    public static void usingCommonIO(String string) throws IOException {
        FileUtils.writeStringToFile(file, string, "UTF8", true);
    }


    public static void main(String[] args) throws IOException {

        WriteStringToFile.usingWriter("--Hello друзья from FileWriter-- \r\n");
        WriteStringToFile.usingOutputStreamWriter("--Hello друзья from OutputStreamWriter--\r\n");
        WriteStringToFile.usingOutputStreamWriter("--Hello друзья from BufferedOutputStreamWriter--\r\n");;
        WriteStringToFile.usingCommonIO("--Hello друзья from FILEUTILS--\r\n");


    }
}

