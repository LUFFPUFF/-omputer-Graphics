package com.example.gg_task1_drawhouse;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;

public class Tree {

    private final int x;
    private final int y;
    private final String type;

    public Tree(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void drawTree(GraphicsContext graphicsContext) {
        if (type.equals("face")) {
            drawOakFace(graphicsContext);
        } else {
            drawOak(graphicsContext);
        }
    }

    private void drawOakFace(GraphicsContext graphicsContext) {

        graphicsContext.beginPath();

        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.CHOCOLATE),
                new Stop(1, Color.SADDLEBROWN)
        );

        graphicsContext.setFill(Color.GREEN);

        for (int i = 0; i< 2; i++) {
            graphicsContext.setLineWidth(2);
            graphicsContext.fillOval(x + i*100, y, 150, 150);
            graphicsContext.strokeOval(x + i*100, y, 150, 150);
            graphicsContext.fillOval(x + 50, y - 20, 150, 150);
            graphicsContext.strokeArc(x + 75, y - 18, 100, 50, 0, 180, ArcType.OPEN);
        }

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x + 70, y + 300);
        graphicsContext.bezierCurveTo(x + 70, y + 300, x + 100, y + 150, x + 100, y + 100);
        graphicsContext.lineTo(x + 150, y + 100);
        graphicsContext.bezierCurveTo(x + 150, y + 100, x + 130, y + 100, x + 170, y + 300);
        graphicsContext.fill();

        graphicsContext.beginPath();
        graphicsContext.setFill(Color.DARKGREEN);
        for (int i = 0; i < 2; i++) {
            graphicsContext.setLineWidth(2);
            graphicsContext.fillOval(x + i*85 + 40, y + 50, 80, 80);
            graphicsContext.strokeOval(x + i*85 + 40, y + 50, 80, 80);
        }
        graphicsContext.fill();

        graphicsContext.beginPath();
        for (int i = 0; i < 2; i++) {
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.fillOval(x + i*30 + 95, y + 160, 30, 40);
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillOval(x + i*30 + 100, y + 165, 20, 20);
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.fillOval(x + i*30 + 107, y + 162, 10, 10);

            graphicsContext.strokeArc(x + i*30 + 100, y + 150, 20, 10, 0, 150, ArcType.OPEN);
        }
        graphicsContext.fill();

        graphicsContext.strokeArc(x + 108, y + 210, 30, 10, 180, 180, ArcType.OPEN);
        for (int i = 0; i < 2; i ++) {
            graphicsContext.strokeArc(x + i*40 + 98, y + 210, 10, 10, 270 + i*180, 180, ArcType.OPEN);
        }
    }

    private void drawOak(GraphicsContext graphicsContext) {

        graphicsContext.beginPath();

        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.CHOCOLATE),
                new Stop(1, Color.SADDLEBROWN)
        );

        graphicsContext.setFill(Color.GREEN);

        for (int i = 0; i< 2; i++) {
            graphicsContext.setLineWidth(2);
            graphicsContext.fillOval(x + i*100, y, 150, 150);
            graphicsContext.strokeOval(x + i*100, y, 150, 150);
            graphicsContext.fillOval(x + 50, y - 20, 150, 150);
            graphicsContext.strokeArc(x + 75, y - 18, 100, 50, 0, 180, ArcType.OPEN);
        }

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x + 70, y + 300);
        graphicsContext.bezierCurveTo(x + 70, y + 300, x + 100, y + 150, x + 100, y + 100);
        graphicsContext.lineTo(x + 150, y + 100);
        graphicsContext.bezierCurveTo(x + 150, y + 100, x + 130, y + 100, x + 170, y + 300);
        graphicsContext.fill();

        graphicsContext.beginPath();
        graphicsContext.setFill(Color.DARKGREEN);
        for (int i = 0; i < 2; i++) {
            graphicsContext.setLineWidth(2);
            graphicsContext.fillOval(x + i*85 + 40, y + 50, 80, 80);
            graphicsContext.strokeOval(x + i*85 + 40, y + 50, 80, 80);
        }
        graphicsContext.fill();
    }
}
