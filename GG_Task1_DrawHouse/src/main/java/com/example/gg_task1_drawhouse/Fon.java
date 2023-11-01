package com.example.gg_task1_drawhouse;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class Fon {

    public Fon() {

    }

    public void drawFon(GraphicsContext graphicsContext) {
        drawClouds(graphicsContext);
        drawMountains(graphicsContext);
        drawGrass(graphicsContext);
        drawSun(graphicsContext);
    }

    private void drawClouds(GraphicsContext graphicsContext) {
        graphicsContext.beginPath();
        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.TRANSPARENT),
                new Stop(1, Color.ALICEBLUE)
        );
        graphicsContext.setFill(gradient);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                graphicsContext.fillOval(120 + j * 10 + i*40, 20 + i*50, 80, 70);
            }
        }

        for (int j = 0; j < 3; j++) {
            graphicsContext.fillOval(300 + j * 10, 20, 80, 70);
        }

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    graphicsContext.fillOval(500 + j * 10 + i * 40 + k*200, 20 + i * 50, 80, 70);
                }
            }
        }
    }
    private void drawSun(GraphicsContext graphicsContext) {

        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTYELLOW),
                new Stop(1, Color.YELLOW)
        );

        graphicsContext.setFill(gradient);
        graphicsContext.fillOval(10, 10, 100, 100);
    }

    private void drawMountains(GraphicsContext graphicsContext) {

        graphicsContext.beginPath();
        LinearGradient gradient1 = new LinearGradient(
                1, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.DARKGRAY),
                new Stop(1, Color.BLACK)
        );

        graphicsContext.setFill(gradient1);
        graphicsContext.moveTo(500, 230);
        graphicsContext.lineTo(600, 100);
        graphicsContext.bezierCurveTo(600, 100, 680, 150, 700, 200);
        graphicsContext.lineTo(650, 250);

        graphicsContext.moveTo(0, 150);
        graphicsContext.lineTo(50, 180);
        graphicsContext.lineTo(100, 150);
        graphicsContext.lineTo(200, 150);
        graphicsContext.lineTo(225, 160);
        graphicsContext.lineTo(250, 100);
        graphicsContext.bezierCurveTo(250, 100, 300, 130, 320, 170);
        graphicsContext.lineTo(400, 170);
        graphicsContext.lineTo(500, 230);
        graphicsContext.lineTo(600, 230);
        graphicsContext.lineTo(650, 250);
        graphicsContext.lineTo(700, 200);
        graphicsContext.lineTo(730, 200);
        graphicsContext.lineTo(780, 100);
        graphicsContext.lineTo(790, 50);
        graphicsContext.bezierCurveTo(790, 50, 820, 100, 810, 120);
        graphicsContext.lineTo(900, 120);
        graphicsContext.lineTo(1200, 50);
        graphicsContext.lineTo(1200, 800);
        graphicsContext.lineTo(0, 800);
        graphicsContext.lineTo(0, 150);
        graphicsContext.fill();
        graphicsContext.closePath();

        graphicsContext.beginPath();
        LinearGradient gradient2 = new LinearGradient(
                0, 0, 1, 2, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(100, 100, 100)),
                new Stop(1, Color.rgb(0, 0, 0))
        );
        graphicsContext.setFill(gradient2);
        graphicsContext.moveTo(0, 250);
        graphicsContext.lineTo(50, 200);
        graphicsContext.lineTo(100, 260);
        graphicsContext.lineTo(200, 240);
        graphicsContext.lineTo(300, 260);
        graphicsContext.bezierCurveTo(300, 260, 320, 240, 400, 230);
        graphicsContext.lineTo(430, 260);
        graphicsContext.lineTo(600, 270);
        graphicsContext.lineTo(650, 300);
        graphicsContext.lineTo(700, 250);
        graphicsContext.lineTo(750, 250);
        graphicsContext.lineTo(800, 200);
        graphicsContext.lineTo(830, 250);
        graphicsContext.lineTo(900, 250);
        graphicsContext.lineTo(1000, 150);
        graphicsContext.lineTo(1200, 250);
        graphicsContext.lineTo(1200, 800);
        graphicsContext.lineTo(0, 800);
        graphicsContext.lineTo(0 ,250);
        graphicsContext.fill();
        graphicsContext.closePath();
    }

    private void drawGrass(GraphicsContext graphicsContext) {

        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.PALEGREEN),
                new Stop(1, Color.DARKGREEN)
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.fillOval(-100, 300, 1300, 400);
        graphicsContext.fill();

        graphicsContext.beginPath();
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillOval(-50, 400, 1200, 400);
        graphicsContext.fill();

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.fillOval(-50, 500, 1200, 500);
        graphicsContext.fill();

    }
}
