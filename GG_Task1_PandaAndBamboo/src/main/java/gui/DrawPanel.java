package gui;

import animal.Panda;
import form.Bamboo;
import form.Fon;
import form.Sign;
import form.Stone;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawPanel extends Application {
    List<Bamboo> bamboos;
    List<Stone> stones;
    Panda panda;
    Sign sign;
    Fon fon;
    Canvas canvas;
    Pane root;
    GraphicsContext gc;

    public void start(Stage primaryStage) {
        canvas = new Canvas(850, 550);

        root = new Pane(canvas);

        fon = new Fon();

        bamboos = new ArrayList<>(Arrays.asList(
                new Bamboo(550, 310, 1),
                new Bamboo(400, 330, 3),
                new Bamboo(700, 400, 4),
                new Bamboo(100, 400, 3),
                new Bamboo(250, 350, 1)
        ));


        stones = new ArrayList<>(Arrays.asList(
                new Stone(450, 380, 0),
                new Stone(520, 350, 0),
                new Stone(500, 400, 1),
                new Stone(700, 420, 0),
                new Stone(100, 450, 0)
        ));

        panda = new Panda(220, 180);
        sign = new Sign(650, 420);

        Scene scene = new Scene(root, 850, 550);

        scene.setFill(Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.show();
        repaint();
    }

    /**
     * Метод для обновления содержмиого класса
     */
    public void repaint() {
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        fon.drawFon(gc);

        for (Bamboo bamboo : bamboos) {
            bamboo.drawBamboo(gc);
        }
        
        for (Stone stone : stones) {
            stone.draw(gc);
        }

        panda.drawPanda(gc);
        sign.drawSign(gc);
    }
}

