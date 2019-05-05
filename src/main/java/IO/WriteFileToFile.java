package IO;


import org.apache.commons.io.FileUtils;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;



import static java.nio.file.StandardCopyOption.*;


//four methods for copy file to file
//https://www.journaldev.com/861/java-copy-file
public class WriteFileToFile {
    public static File SOURCEFILE = new File("src/main/java/IO/1.doc");
    public static File TARGETFILE = new File("src/main/java/IO/2.doc");


    //reading and writing by bytes
    public static void writeFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
        while (inputStream.available() != 0) {
            outputStream.write(inputStream.read());
        }
        inputStream.close();
        outputStream.close();

    }

    //copying files using FileChanel
    public static void copyByFileChanel() throws IOException {
        FileChannel sourceChannel = null;
        FileChannel targetChanel = null;
        try {
            sourceChannel = new FileInputStream(SOURCEFILE).getChannel();
            targetChanel = new FileOutputStream(TARGETFILE).getChannel();
            targetChanel.transferFrom(sourceChannel,0,sourceChannel.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            sourceChannel.close();
            targetChanel.close();
        }



    }

    //copying file using Files.class
    public static void writeFileToFileUsingFILESCLASS() throws IOException {
        //we must explicitly point on Copy option in method parameters
        Files.copy(SOURCEFILE.toPath(), TARGETFILE.toPath(), REPLACE_EXISTING);
    }

    //copying file using FileUtils
    public static void copyByFileUtils() throws IOException {
        FileUtils.copyFile(SOURCEFILE, TARGETFILE);

    }

    public static void main(String[] args) throws IOException {
       //writeFile(new File(SOURCEFILE), new File(TARGETFILE));
       // copyByFileUtils();
       //writeFileToFileUsingFILESCLASS();
       copyByFileChanel();


    }

}
