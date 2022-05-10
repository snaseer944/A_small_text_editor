package TextEditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TextModel {
    public void save(TxtFile txtfile) {
        try {
            Files.write(txtfile.getFile(), txtfile.getContent(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public IO<TxtFile> load(Path file) {
        try{
            List<String> lines = Files.readAllLines(file);
            return new IO<> (true, new TxtFile(file, lines));
        } catch (IOException e) {
            e.printStackTrace();
            return new IO<>(false, null);
        }
    }
    public void close() {
        System.exit(0);
    }

    public void copy(TxtFile txtfile) {
        try {
            Files.write(txtfile.getFile(), txtfile.getContent(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delete(TxtFile txtfile){
        try{
            Files.delete(txtfile.getFile());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
