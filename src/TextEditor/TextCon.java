package TextEditor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;


public class TextCon {

    @FXML
    private TextArea areaText;
    private TxtFile currentTxtFile;
    private TextModel Model;
    JComboBox fontBox;

    public TextCon(TextModel Model) {
        this.Model = Model;
    }


    @FXML
    private void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null) {
            IO<TxtFile> io = Model.load(file.toPath());
            if(io.isCorrect() && io.hasData()) {
                currentTxtFile = io.getData();
                areaText.clear();
                currentTxtFile.getContent().forEach(line -> areaText.appendText(line + "\n"));
            } else {
                System.out.println("failed");
            }
        }
    }

    @FXML
    private void onClose() {
        Model.close();
    }

    @FXML
    private void onSave() {
        TxtFile txtFile = new TxtFile(currentTxtFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
        Model.save(txtFile);
    }

    @FXML
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("This is a small Text Editor. Users can open, save, delete, and format files through this editor ");
        alert.show();
    }

    @FXML
    public void onCopy() {
        TxtFile txtFile = new TxtFile(currentTxtFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
        Model.copy(txtFile);
    }
    @FXML
    private void onDelete() {
        Model.delete(currentTxtFile);
    }

    @FXML
    private void onFont() {

    }
    @FXML
    public void onFontSize() {
    }

}

