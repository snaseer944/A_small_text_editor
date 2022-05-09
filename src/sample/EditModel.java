package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EditModel {
    public void save(TxtFile txtfile) {
        try {
            Files.write(txtfile.getFile(), txtfile.getContent(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public IOResult<TxtFile> load(Path file) {
        try{
            List<String> lines = Files.readAllLines(file);
            return new IOResult<> (true, new TxtFile(file, lines));
        } catch (IOException e) {
            e.printStackTrace();
            return new IOResult<>(false, null);
        }
    }
    public void close() {
        System.exit(0);
    }
}
