package com.example.gg_task1_drawhouse;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;

public class ChildrensPayground {

    private final int x;
    private final int y;

    public ChildrensPayground(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext graphicsContext) {
        drawSlide(graphicsContext, x, y);
        drawSandbox(graphicsContext, x + 70, y + 100);
        drawSwing(graphicsContext, x - 100, y - 100);
    }

    private void drawSwing(GraphicsContext graphicsContext, int x, int y) {

        graphicsContext.beginPath();
        graphicsContext.setFill(Color.GREEN);
        for (int i = 0; i < 2; i++) {
            graphicsContext.fillRect(x + i*150, y, 10, 180);
        }
        graphicsContext.fillRect(x - 10, y + 10, 180, 10);
        graphicsContext.closePath();

        graphicsContext.beginPath();
        graphicsContext.setFill(Color.GREEN);
        double[] xPoint = {x + 30, x + 120, x + 135, x + 40};
        double[] yPoint = {y + 120, y + 120, y + 150, y + 150};
        graphicsContext.fillPolygon(xPoint, yPoint, 4);
        graphicsContext.closePath();

        graphicsContext.beginPath();
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(3);
        for (int i = 0; i < 2; i++) {
            graphicsContext.strokeLine(x + i*60+ 50, y + 10, x + i*60 + 50, y + 135);
        }
        graphicsContext.stroke();
        graphicsContext.closePath();

    }

    private void drawSlide(GraphicsContext graphicsContext, int x, int y) {

        graphicsContext.setFill(Color.RED);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.beginPath();
        graphicsContext.setLineWidth(2);

        for (int i = 0; i < 2; i++) {
            graphicsContext.fillRect(x + i *40 + 200, y - 100, 10, 100);
            graphicsContext.strokeRect(x + i *40 + 200, y - 100, 10, 100);

            for (int j = 0; j < 4; j++) {
                graphicsContext.fillRect(x + 200, y + j * 20 - 80, 50, 10);
                graphicsContext.strokeRect(x + 200, y + j * 20 - 80, 50, 10);
            }
        }

        graphicsContext.moveTo(x, y);
        graphicsContext.bezierCurveTo(x, y, x + 100, y - 20, x + 200, y - 100);
        graphicsContext.lineTo(x + 250, y - 100);
        graphicsContext.bezierCurveTo(x + 250, y - 100, x + 150, y - 20, x + 80, y);
        graphicsContext.lineTo(x, y);
        graphicsContext.closePath();
        graphicsContext.fill();


        for (int i = 0; i < 2; i++) {

            graphicsContext.beginPath();
            graphicsContext.moveTo(x + i * 80, y);
            graphicsContext.bezierCurveTo(x + i * 80, y, x + i * 50 + 100, y - 20, x + i * 50 + 200, y - 100);
            graphicsContext.moveTo(x + 200, y - 100);
            graphicsContext.lineTo(x + 250, y - 100);
            graphicsContext.moveTo(x, y);
            graphicsContext.lineTo(x + 80, y);
            graphicsContext.setLineWidth(3);
            graphicsContext.closePath();
            graphicsContext.stroke();
        }

        graphicsContext.beginPath();
        graphicsContext.strokeArc(x + 200, y - 125, 50, 50, 0, 180, ArcType.OPEN);
        graphicsContext.stroke();
        graphicsContext.closePath();
    }

    private void drawSandbox(GraphicsContext graphicsContext, int x, int y) {

        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(233, 150, 122)),
                new Stop(1, Color.rgb(165, 42, 42))
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(Color.rgb(165, 42, 42));

        double[] xPoint = {x, x + 20, x + 200, x + 200 + 20};
        double[] yPoint = {y, y - 100 + 20, y - 100 + 20, y};
        graphicsContext.fillPolygon(xPoint, yPoint, 4);

        double[] xPoint2 = {x + 16, x + 28, x + 200 - 8, x + 200 + 5};
        double[] yPoint2 = {y - 13, y - 100 + 30, y - 100 + 30, y - 13};
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.fillPolygon(xPoint2, yPoint2, 4);

        graphicsContext.setFill(gradient);
        graphicsContext.fillRect(x + 10, y, 200, 10);

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.beginPath();


        graphicsContext.bezierCurveTo(x + 30, y - 100 + 50, x + 40, y - 120 + 50, x + 70, y - 90 + 50);
        graphicsContext.bezierCurveTo(x + 70, y - 90 + 50, x + 80, y - 80 + 50, x + 100, y - 100 + 50);
        graphicsContext.bezierCurveTo(x + 100, y - 100 + 50, x + 120, y - 80, x + 140, y - 50);
        graphicsContext.strokeArc(x + 140, y - 50, 40, 20, 0, 180, ArcType.OPEN);

        graphicsContext.stroke();

        drawBucket(graphicsContext, x + 70, y - 10);
    }

    private void drawBucket(GraphicsContext graphicsContext, int x, int y) {
        graphicsContext.beginPath();
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillArc(x - 10, y - 50, 70, 30, 270, 180, ArcType.OPEN);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillOval(x + 20, y - 50, 15, 30);

        graphicsContext.beginPath();
        graphicsContext.setStroke(Color.BLUE);
        graphicsContext.setLineWidth(5);
        graphicsContext.strokeOval(x + 20, y - 50, 15, 30);
        graphicsContext.closePath();

        graphicsContext.beginPath();
        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.bezierCurveTo(x + 25, y - 50, x + 50, y - 70, x + 35, y - 40);

        graphicsContext.setStroke(Color.GREEN);
        graphicsContext.setLineWidth(2);

        graphicsContext.stroke();
        graphicsContext.closePath();
    }
}
