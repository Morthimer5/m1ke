package threemonthjunior.morandblack.m1ke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Mine {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Java\\JavaProjects\\NewTextDocument.txt");


        System.out.println(Files.size(path));
        String formatted = String.format("%016d", Files.size(path));
        System.out.println(formatted);
    }
}
