package threemonthjunior.morandblack.m1ke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class Mine {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Path path = Paths.get("D:\\Java\\JavaProjects\\NewTextDocument.txt");
        Path path2 = Paths.get("D:\\Java\\JavaProjects\\NewTextDocument2.txt");


//        System.out.println(Files.size(path));
//        String formatted = String.format("%016d", Files.size(path));
//        System.out.println(FileUtils.calculateHash(path));

        System.out.println(FileUtils.contentEquals(path, path2));
    }
}
