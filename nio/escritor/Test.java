package nio.escritor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Test {

    public static void main(String[] args) throws IOException {
        
        Path ruta = Paths.get("src/nio/escritor/usuarios.txt");
        
        String nombre = "Juan";
        String nombre2 = "Maria";
        
        Charset conjuntoCaracteres = Charset.forName("ISO-8859-1");
        
        try (BufferedWriter writer = Files.newBufferedWriter(ruta,
                conjuntoCaracteres, StandardOpenOption.APPEND)){
            writer.newLine();
//            writer.write(nombre, 0, nombre.length());
            writer.write(nombre2);
        }
        
        
//        Nota: StandardOpenOption.APPEND --> agrega texto al final del archivo
    }
}
