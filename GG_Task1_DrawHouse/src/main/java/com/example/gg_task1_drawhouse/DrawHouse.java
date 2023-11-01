package com.example.gg_task1_drawhouse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DrawHouse extends Application {
    Canvas canvas;
    GraphicsContext graphicsContext;
    Pane root;
    House house;
    Fon fon;
    List<Tree> trees;
    ChildrensPayground childrensPayground;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IllegalAccessException {
        primaryStage.setTitle("House Drawing");
        canvas = new Canvas(1000, 800);
        graphicsContext = canvas.getGraphicsContext2D();
        root = new Pane(canvas);

        fon = new Fon();

        trees = new ArrayList<>(List.of(
                new Tree(500, 70, "null"),
                new Tree(400, 80, "face"),
                new Tree(750, 100, "null"),
                new Tree(0, 120, "null")));

        house = new House(150, 430);
        childrensPayground = new ChildrensPayground(680, 650);


        Scene scene = new Scene(root, 1000, 800);
        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
        repaint();
    }

    public void repaint() throws IllegalAccessException {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        fon.drawFon(graphicsContext);

        for (Tree tree : trees) {
            tree.drawTree(graphicsContext);
        }
        house.drawHouse(graphicsContext, 3);
        childrensPayground.draw(graphicsContext);
    }
}
