package TextEditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args)
    {

        launch(args);
    }
    @Override
    public void start(Stage Stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TextEditor.fxml"));
        loader.setControllerFactory(t -> new TextCon(new TextModel()));
        Stage.setTitle("Small Text Editor");
        Stage.setScene(new Scene(loader.load()));
        Stage.show();

    }

}
