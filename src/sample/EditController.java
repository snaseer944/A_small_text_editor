package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.util.Arrays;


public class EditController {

    @FXML
    private TextArea areaText;
    private TxtFile currentTxtFile;
    private EditModel Model;

    public EditController(EditModel Model) {
        this.Model = Model;
    }

    @FXML
    private void onSave() {
        TxtFile txtFile = new TxtFile(currentTxtFile.getFile(), Arrays.asList(areaText.getText().split("\n")));
        Model.save(txtFile);
    }

    @FXML
    private void onOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null) {
            IOResult<TxtFile> io = Model.load(file.toPath());
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
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setContentText("This is a simple text editor");
        alert.show();
    }

    @FXML
    private void onCut() {
    }
    @FXML
    public void onCopy() {
    }
    @FXML
    private void onPaste() {
    }
    @FXML
    private void onDelete() {

    }
    @FXML
    private void onFind() {

    }
    @FXML
    private void onFindNext() {

    }
    @FXML
    private void onFindPrevious() {

    }
    @FXML
    private void onFindInFiles() {

    }
    @FXML
    private void onSelectAndFindNext() {

    }
    @FXML
    private void onSelectAndFindPrevious() {

    }
    @FXML
    private void onWordWrap() {

    }
    @FXML
    private void onFont() {

    }
    @FXML
    private void onZoom() {

    }
    @FXML
    private void onStatusBar() {

    }
    @FXML
    private void onViewHelp() {

    }
    @FXML
    private void onSendFeedback() {

    }


}
