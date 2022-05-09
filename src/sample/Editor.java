package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.datatransfer.Clipboard;

public class Editor extends Application {

    @Override
    public void start(Stage Stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setControllerFactory(t -> new EditController(new EditModel()));
        Stage.setTitle("Text Box Editor");

        Stage.setScene(new Scene(loader.load()));
        Stage.show();

    }


   public static void main(String[] args)
    {

        launch(args);
    }
}
