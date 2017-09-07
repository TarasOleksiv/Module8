package ua.goit.java8.module8.geometry;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by t.oleksiv on 07/09/2017.
 */
public class MyRectangle extends Rectangle implements Runnable{
    private Pane root;
    //private double x;
    //private double y;
    //private double width;
    //private double height;
    private Color color;
    private int type;

    public MyRectangle(Pane root, double x, double y, double width, double height, Color color, int type){
        super(x, y, width, height);
        this.root = root;
        this.type = type;
        //this.x = x;
        //this.y = y;
        //this.width = width;
        //this.height = height;
        //this.color = color;
        this.setFill(color);
        Platform.runLater(() -> {
            root.getChildren().addAll(this);
        });
    }

    @Override
    public void run() {

        while(true) {
            final double x = this.getTranslateX();
            final double y = this.getTranslateY();

            Platform.runLater(() -> {
                switch (type){
                    case 1:
                        this.setTranslateX(x+1);
                        this.setTranslateY(y+1);
                        break;
                    case 2:
                        this.setTranslateX(x+1);
                        this.setTranslateY(y-1);
                        break;
                    case 3:
                        this.setTranslateX(x-1);
                        this.setTranslateY(y+1);
                        break;
                    case 4:
                        this.setTranslateX(x-1);
                        this.setTranslateY(y-1);
                        break;
                    default:
                        this.setTranslateX(x+1);
                        this.setTranslateY(y+1);
                }
            });

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
