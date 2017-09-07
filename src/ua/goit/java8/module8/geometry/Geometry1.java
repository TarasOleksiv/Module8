package ua.goit.java8.module8.geometry;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by t.oleksiv on 07/09/2017.
 */
public class Geometry1 {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 825;
    private Pane root = new Pane();
    private Random random = new Random();
    //private final Thread[] threads = new Thread[10];

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


        /*
        final Thread thread = new Thread(() -> {
                Random random = new Random();
                double x = random.nextInt((int)WIDTH/2);
                double y = random.nextInt((int)HEIGHT/2);
                double width = random.nextInt((int)WIDTH/2);
                double height = random.nextInt((int)HEIGHT/2);
                MyRectangle myRectangle = new MyRectangle(root,x,y,width,height,getColor());

                while(true) {
                    final double xx = myRectangle.getTranslateX() + 1;

                    Platform.runLater(() -> {
                        myRectangle.setTranslateX(xx);
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });
        */


        multyThreads.setOnMouseClicked(event -> {
            //thread.start();
            //drawRectangle();
            drawRectangles();
        });
    }

    private void drawRectangles(){
        //Random random = new Random();
        int count = random.nextInt(7) + 3;
        MyRectangle[] myRectangles = new MyRectangle[count];
        for (MyRectangle myRectangle: myRectangles){
            drawRectangle();
        }
    }

    private void drawRectangle(){
        //Random random = new Random();
        double x = random.nextInt((int)WIDTH/2);
        double y = random.nextInt((int)HEIGHT/2);
        double width = random.nextInt((int)WIDTH/2);
        double height = random.nextInt((int)HEIGHT/2);
        int type = random.nextInt(3)+1;
        //MyRectangle myRectangle = new MyRectangle(root,x,y,width,height,getColor());

        new Thread(new MyRectangle(root,x,y,width,height,getColor(),type)).start();

    }

    private Color getColor(){
        //Random random = new Random();
        Color color = Color.color(random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                0.6f);
        return color;
    }
}
