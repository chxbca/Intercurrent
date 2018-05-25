package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application implements EventHandler<WindowEvent> {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("并发控制实例");
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(this);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void handle(WindowEvent event) {
        System.exit(0);
    }
}
