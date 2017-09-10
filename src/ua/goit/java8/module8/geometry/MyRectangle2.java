package ua.goit.java8.module8.geometry;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by t.oleksiv on 07/09/2017.
 */
public class MyRectangle2 extends Rectangle{
    private Pane root;
    private double xStart;
    private double yStart;
    private boolean typeX;
    private boolean typeY;

    public MyRectangle2(Pane root, double x, double y, double width, double height, Color color, boolean typeX, boolean typeY){
        super(x, y, width, height);
        this.root = root;
        this.xStart = x;
        this.yStart = y;
        this.typeX = typeX;
        this.typeY = typeY;
        this.setFill(color);
        Platform.runLater(() -> {
            root.getChildren().addAll(this);
        });
    }

    public boolean getTypeX(){
        return typeX;
    }

    public boolean getTypeY(){
        return typeY;
    }

    public double getxStart(){
        return xStart;
    }

    public double getyStart(){
        return yStart;
    }

    public Pane getRoot(){
        return root;
    }

    public void setTypeX(boolean typeX){
        this.typeX = typeX;
    }

    public void setTypeY(boolean typeY){
        this.typeY = typeY;
    }

}
