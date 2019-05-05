package IO;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class WriteFileToFile {
    public static String SOURCEFILE = "D:/1.txt";
    public static String TARGETFILE = "D:/2.txt";

    public static void writeFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
        while (inputStream.available() != 0) {

            outputStream.write(inputStream.read());
        }
        inputStream.close();
        outputStream.close();

    }

    public static void main(String[] args) throws IOException {
        WriteFileToFile.writeFile(new File(SOURCEFILE), new File(TARGETFILE));
    }

}
