package ua.goit.java8.module8.geometry;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ua.goit.java8.module8.Task3;

import java.util.Random;

/**
 * Created by t.oleksiv on 07/09/2017.
 */
public class Geometry1 {
    private Pane root = new Pane();
    private Random random = new Random();

    public Geometry1(Stage primaryStage){
        drawInterface(primaryStage);
    }

    private void drawInterface(Stage primaryStage){
        Button multyThreads = new Button();
        multyThreads.setTranslateX(10);
        multyThreads.setTranslateY(10);
        multyThreads.setText("Multy Threads");
        root.getChildren().addAll(multyThreads);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        multyThreads.setOnMouseClicked(event -> {
            drawRectangles();
        });
    }

    private void drawRectangles(){
        int count = random.nextInt(8) + 3;
        MyRectangle[] myRectangles = new MyRectangle[count];
        for (MyRectangle myRectangle: myRectangles){
            drawRectangle();
        }
    }

    private void drawRectangle(){
        double x = random.nextInt((int) Task3.WIDTH/2);
        double y = random.nextInt((int)Task3.HEIGHT/2);
        double width = random.nextInt((int)Task3.WIDTH/2);
        double height = random.nextInt((int)Task3.HEIGHT/2);
        int typeXint = random.nextInt(2)+1;
        int typeYint = random.nextInt(2)+1;
        boolean typeX = (typeXint == 1);
        boolean typeY = (typeYint == 1);
        new Thread(new MyRectangle(root,x,y,width,height,getColor(),typeX,typeY)).start();

    }

    private Color getColor(){
        Color color = Color.color(random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                0.6f);
        return color;
    }
}