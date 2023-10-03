package nio.notepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FileText implements I_File {

    private File file;

    public FileText(File file) {
        this.file = file;
    }
    
    public FileText(String file){
        this.file=new File(file);
    }

    public File getFile() {
        return file;
    }
    
//    print(): Imprime el contenido del archivo en la consola.
    @Override public void print() {
        int car;
        //Try with resources jdk 7 o superior
        //solo es valido para implementaciones de AutoCloseable
        try (FileReader in=new FileReader(file)){
           while((car=in.read())!=-1){
               System.out.print((char)car);
           }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println();
    }

//    getText(): Devuelve el contenido del archivo como una cadena de texto.
    @Override public String getText() {
        StringBuilder sb=new StringBuilder();
        int car;
        try (FileReader in=new FileReader(file)) {
            while((car=in.read())!=-1){
                sb.append((char)car);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();
    }

//    setText(String text): Establece el contenido del archivo a la cadena de texto especificada.
    @Override public void setText(String text) {
        try (FileWriter out=new FileWriter(file)) {
            out.write(text);
        } catch (Exception e) { System.out.println(e); }
    }

//    appendText(String text): Agrega la cadena de texto especificada al final del archivo.
    @Override public void appendText(String text) {
        try (FileWriter out=new FileWriter(file,true)) {
            out.write(text);
        } catch (Exception e) { System.out.println(e); }
    }

//    addLine(String line): Agrega la línea especificada al final del archivo.
    @Override public void addLine(String line) {
        try (BufferedWriter out=new BufferedWriter(new FileWriter(file,true))){
            out.write(line);
            out.newLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    getLines(): Devuelve una lista de todas las líneas en el archivo.
    @Override public List<String> getLines() {
        List<String> lineas=new ArrayList();
        try (BufferedReader in=new BufferedReader(new FileReader(file))){
            in.lines().forEach(lineas::add);
        } catch (Exception e) { System.out.println(e); }
        return lineas;
    }

//    getLinkedHashSetLines(): Devuelve un conjunto de todas las líneas en el archivo, 
//    eliminando los duplicados y manteniendo el orden de inserción.
    @Override public Set<String> getLinkedHashSetLines() {
        Set<String> lines=new LinkedHashSet();
        lines.addAll(getLines());
        return lines;
    }

//    getTreeSetLines(): Devuelve un conjunto de todas las líneas en el archivo, 
//    eliminando los duplicados y ordenándolas alfabéticamente.
    @Override public Set<String> getTreeSetLines() {
        Set<String> lines=new TreeSet();
        lines.addAll(getLines());
        return lines;
    }

//    addLines(List<String> lines): Agrega las líneas especificadas al final del 
//    archivo.
    @Override public void addLines(List<String> lines) {
        try(BufferedWriter out=new BufferedWriter(new FileWriter(file,true))){
            for(String st:lines){
                out.write(st);
                out.newLine();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

//    removeLine(String line): Elimina la línea especificada del archivo.
    @Override public void removeLine(String line) {
        List<String>lista=getLines();
        lista.remove(line);
        setText("");
        addLines(lista);
    }
    
}
