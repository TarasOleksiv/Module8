package ua.goit.java8.module8;

import javafx.application.Application;
import javafx.stage.Stage;
import ua.goit.java8.module8.geometry.Geometry1;

/**
 * Created by t.oleksiv on 07/09/2017.
 */
public class Task3 extends Application{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Потоки");

        Geometry1 geometry1 = new Geometry1(primaryStage);
    }
}