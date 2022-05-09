package sample;

import java.nio.file.Path;
import java.util.List;

public class TxtFile {
    private final Path file;
    private final List<String> content;

    public TxtFile(Path file, List<String> content) {
        this.file = file;
        this.content = content;
    }

    public Path getFile() {
        return file;
    }
    public List<String> getContent(){
        return content;
    }

}
