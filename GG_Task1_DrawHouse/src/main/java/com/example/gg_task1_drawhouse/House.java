package com.example.gg_task1_drawhouse;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;

import java.util.Random;

public class House {

    private final int x;
    private final int y;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawHouse(GraphicsContext graphicsContext, int floor) throws IllegalAccessException {
        if (floor != 0) {
            if (floor == 1) {
                drawBasis(graphicsContext, x, y);
                drawRoof(graphicsContext, x + 3, y - 20);
            } else if (floor == 2) {
                drawBasis(graphicsContext, x, y);
                drawFoundation(graphicsContext, x, y - 200);
                drawRoof(graphicsContext, x + 3, y - 210);
            } else if (floor == 3) {
                drawFoundationBrick(graphicsContext, x + 200, y);
                drawBasis(graphicsContext, x, y);
                drawFoundation(graphicsContext, x, y - 200);
                drawRoof(graphicsContext, x + 3, y - 210);
                drawRailings(graphicsContext);
            }
        } else {
            throw new IllegalAccessException("Неправильный формат этажа");
        }
    }

    private void drawRoof(GraphicsContext graphicsContext, int x, int y) {

        LinearGradient gradient = new LinearGradient(
                1, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(233, 150, 122)),
                new Stop(1, Color.rgb(165, 42, 42))
        );

        graphicsContext.setFill(gradient);
        graphicsContext.beginPath();

        // основа крыши
        for (int i = 0; i < 2; i++) {
            graphicsContext.moveTo(x - 35 + i * 120, y + 20 + i * 40);
            graphicsContext.lineTo(x + 100 + i * 100, y - 100 + i * 30);
            graphicsContext.lineTo(x + 230 + i * 100, y + 30 + i * 30);
            graphicsContext.lineTo(x - 35 + i * 120, y + 20 + i * 40);
        }
        graphicsContext.fill();

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        double[] xPoint = {x - 35, x + 100, x + 200, x +85};
        double[] yPoint = {y + 20, y - 100, y - 70, y + 60};
        graphicsContext.fillPolygon(xPoint, yPoint, 4);
        graphicsContext.closePath();

        //оконтовка
        for (int i = 0; i < 2; i++) {
            graphicsContext.strokeLine(x - 35 + i *120, y + 20 + i*40, x + 100 + i*100, y - 100 + i*30);
        }

        graphicsContext.strokeLine(x + 100, y - 100, x + 200, y - 70);
        graphicsContext.strokeLine(x - 35, y + 20, x + 85, y + 60);
        graphicsContext.strokeLine(x + 85, y + 60, x + 330, y + 60);
        graphicsContext.strokeLine(x + 200, y - 70, x + 330, y + 60);

        //труба
        drawPipe(graphicsContext, x + 40, y - 100);
    }

    private void drawPipe(GraphicsContext graphicsContext, int x, int y) {
        graphicsContext.setFill(Color.BLACK);
        double[] pipeXPoint = {x, x + 30, x + 30, x};
        double[] pipeYPoint = {y, y + 10, y + 100, y + 90};

        double[] pipeXPoint2 = {x + 30, x + 60, x + 60, x + 30};
        double[] pipeYPoint2 = {y + 10, y - 10, y + 70, y + 100};


        graphicsContext.fillPolygon(pipeXPoint, pipeYPoint, 4);
        graphicsContext.fillPolygon(pipeXPoint2, pipeYPoint2, 4);

        double[] pipeXPoint3 = {x, x + 30, x + 60, x + 30};
        double[] pipeYPoint3 = {y, y - 20, y - 10, y + 10};

        graphicsContext.setLineWidth(2);
        graphicsContext.setFill(Color.GRAY);
        graphicsContext.fillPolygon(pipeXPoint3, pipeYPoint3, 4);

    }

    private void drawBasis(GraphicsContext graphicsContext, int x, int y) {

        LinearGradient gradientGlass = new LinearGradient(
                2, 0, 0, 0, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.LIGHTBLUE),
                new Stop(0, Color.BLUE)
        );


        //основа
        graphicsContext.setFill(Color.rgb(165, 42, 42));
        graphicsContext.beginPath();

        double[] xPoints = {x, x + 100, x + 100, x};
        double[] yPoints = {y - 10, y + 20, y + 220, y  + 180};
        graphicsContext.fillPolygon(xPoints, yPoints, 4);

        graphicsContext.fillRect(x + 100, y + 20, 200, 200);

        double[] xPoints2 = {x + 300, x + 200, x, x + 100};
        double[] yPoints2 = {y + 20, y - 10, y - 10, y + 20};
        graphicsContext.fillPolygon(xPoints2, yPoints2, 4);

        graphicsContext.strokePolygon(xPoints, yPoints, 4);
        graphicsContext.strokeRect(x + 100, y + 20, 200, 200);
        graphicsContext.strokePolygon(xPoints2, yPoints2, 4);

        drawBrick(graphicsContext, x, y);

        //окна
        graphicsContext.setFill(gradientGlass);
        graphicsContext.fillArc(x + 120, y + 80, 80, 120, 0, 180, ArcType.OPEN);
        graphicsContext.strokeArc(x + 120, y + 80, 80, 120, 0, 180, ArcType.OPEN);
        graphicsContext.strokeLine(x + 160, y + 80, x + 160, y + 140);
        graphicsContext.strokeLine(x + 125, y + 110, x + 195, y + 110);

        double[] glassPointX = {x + 20, x + 80, x + 80, x + 20};
        double[] glassPointY = {y + 55, y + 75, y + 135, y + 115};
        graphicsContext.setFill(gradientGlass);
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.fillPolygon(glassPointX, glassPointY, 4);
        graphicsContext.strokePolygon(glassPointX, glassPointY, 4);

        graphicsContext.strokeLine(x + 20, y + 85, x + 80, y + 105);
        graphicsContext.strokeLine(x + 50, y + 65, x + 50, y + 125);

        //дверь
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillArc(x + 210, y + 100, 80, 240, 0, 180, ArcType.OPEN);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.strokeArc(x + 210, y + 100, 80, 240, 0, 180, ArcType.OPEN);
        graphicsContext.setFill(Color.LIGHTYELLOW);
        graphicsContext.fillArc(x + 225, y + 120, 50, 100, 0, 180, ArcType.OPEN);
        graphicsContext.strokeArc(x + 225, y + 120, 50, 100, 0, 180, ArcType.OPEN);

        graphicsContext.fillOval(x + 260, y + 175, 15, 5);
        graphicsContext.beginPath();
        graphicsContext.setLineWidth(2);
        graphicsContext.setFill(Color.WHITE);
    }

    private void drawBrick(GraphicsContext graphicsContext, int x, int y) {

        LinearGradient gradient = new LinearGradient(
                1, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(233, 150, 122)),
                new Stop(1, Color.rgb(165, 42, 42))
        );

        int width = 200;
        int height = 40;
        int cellWidth = 40;
        int cellHeight = 20;

        int rows = height / cellHeight;
        int cols = width / cellWidth;

        int[][] strokeRect = new int[rows][cols];
        double[] xPoint = {x, x + 100, x + 100, x};
        double[] yPoint = {y + 140, y + 180, y + 220, y + 180};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                strokeRect[i][j] = 1;
            }
        }

        graphicsContext.setFill(gradient);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (strokeRect[i][j] == 1) {
                    graphicsContext.fillRect(x + j * cellWidth + 100, y + i * cellHeight + 180, cellWidth, cellHeight);
                }
            }
        }

        graphicsContext.fillPolygon(xPoint, yPoint, 4);
        graphicsContext.strokeLine(x, y + 160, x + 100, y + 200);

        graphicsContext.strokeLine(x + 20, y + 148, x + 20, y + 188);
        graphicsContext.strokeLine(x + 60, y + 164, x + 60, y + 202);

        for (int i = 0; i < 4; i ++) {
            graphicsContext.strokeLine(x + i*40 +  140, y + 180, x + i*40 + 140, y + 220);
        }

        graphicsContext.strokeLine(x + 100, y + 200, x + 300, y + 200);

    }

    private void drawFoundation(GraphicsContext graphicsContext, int x, int y) {
        LinearGradient gradientGlass = new LinearGradient(
                2, 0, 0, 0, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.LIGHTBLUE),
                new Stop(0, Color.BLUE)
        );


        //основа
        graphicsContext.setFill(Color.rgb(165, 42, 42));
        graphicsContext.setLineWidth(2);
        graphicsContext.beginPath();

        double[] xPoints = {x, x + 100, x + 100, x};
        double[] yPoints = {y, y + 20, y + 220, y  + 190};
        graphicsContext.fillPolygon(xPoints, yPoints, 4);

        graphicsContext.fillRect(x + 100, y + 20, 200, 200);

        double[] xPoints2 = {x + 300, x + 200, x, x + 100};
        double[] yPoints2 = {y + 20, y, y, y + 20};
        graphicsContext.fillPolygon(xPoints2, yPoints2, 4);

        graphicsContext.strokePolygon(xPoints, yPoints, 4);
        graphicsContext.strokeRect(x + 100, y + 20, 200, 200);
        graphicsContext.strokePolygon(xPoints2, yPoints2, 4);

        //окна

        graphicsContext.setFill(gradientGlass);
        for (int i = 0; i < 2; i++) {
            graphicsContext.fillRect(x + i*90 + 130, y + 80, 60, 60);
            graphicsContext.strokeRect(x + i*90 + 130, y + 80, 60, 60);
            graphicsContext.strokeLine(x + i *90 + 160, y + 80, x + i*90 + 160, y + 140);
            graphicsContext.strokeLine(x + i * 90 + 130, y + 110, x + i * 90 + 190, y + 110);
        }

        double[] glassPointX = {x + 20, x + 80, x + 80, x + 20};
        double[] glassPointY = {y + 55, y + 75, y + 135, y + 115};
        graphicsContext.setFill(gradientGlass);
        graphicsContext.fillPolygon(glassPointX, glassPointY, 4);

        graphicsContext.strokeLine(x + 20, y + 85, x + 80, y + 105);
        graphicsContext.strokeLine(x + 50, y + 65, x + 50, y + 125);

        for (int i = 0; i < 2; i++) {
            drawRoots(graphicsContext, x + i*90 + 140, y + 150);
        }

    }

    private void drawFoundationBrick(GraphicsContext graphicsContext, int x, int y) {
        LinearGradient gradientGlass = new LinearGradient(
                2, 0, 0, 0, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.LIGHTBLUE),
                new Stop(0, Color.BLUE)
        );

        //основа
        graphicsContext.setFill(Color.rgb(165, 42, 42));
        graphicsContext.setLineWidth(2);
        graphicsContext.beginPath();

        double[] xPoints = {x, x + 100, x + 100, x};
        double[] yPoints = {y, y + 20, y + 220, y  + 190};
        graphicsContext.fillPolygon(xPoints, yPoints, 4);

        graphicsContext.fillRect(x + 100, y + 20, 200, 200);

        double[] xPoints2 = {x + 300, x + 200, x, x + 100};
        double[] yPoints2 = {y + 20, y - 10, y - 10, y + 20};
        graphicsContext.fillPolygon(xPoints2, yPoints2, 4);

        graphicsContext.strokePolygon(xPoints, yPoints, 4);
        graphicsContext.strokeRect(x + 100, y + 20, 200, 200);
        graphicsContext.strokePolygon(xPoints2, yPoints2, 4);

        //окна
        graphicsContext.setFill(gradientGlass);
        for (int i = 0; i < 2; i++) {
            graphicsContext.fillRect(x + i*90 + 130, y + 80, 60, 60);
            graphicsContext.strokeRect(x + i*90 + 130, y + 80, 60, 60);
            graphicsContext.strokeLine(x + i *90 + 160, y + 80, x + i*90 + 160, y + 140);
            graphicsContext.strokeLine(x + i * 90 + 130, y + 110, x + i * 90 + 190, y + 110);
        }

        double[] glassPointX = {x + 20, x + 80, x + 80, x + 20};
        double[] glassPointY = {y + 55, y + 75, y + 135, y + 115};
        graphicsContext.setFill(gradientGlass);
        graphicsContext.fillPolygon(glassPointX, glassPointY, 4);

        graphicsContext.strokeLine(x + 20, y + 85, x + 80, y + 105);
        graphicsContext.strokeLine(x + 50, y + 65, x + 50, y + 125);

        drawBrick(graphicsContext, x, y);
    }

    private void drawRoots(GraphicsContext graphicsContext, int x, int y) {
        graphicsContext.beginPath();
        graphicsContext.setFill(Color.BLACK);

        double[] xPoint = {x - 11, x, x, x - 11};
        double[] yPoint = {y - 10, y, y + 20, y + 10};

        double[] xPoint2 = {x - 10, x + 50, x + 60, x};
        double[] yPoint2 = {y - 10, y - 10, y, y + 20};

        double[] xPoint3 = {x - 5, x + 50, x + 55, x};
        double[] yPoint3 = {y - 5, y - 5, y, y};

        graphicsContext.setFill(Color.GRAY);
        graphicsContext.fillPolygon(xPoint2, yPoint2, 4);

        graphicsContext.strokePolygon(xPoint2, yPoint2, 4);

        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillPolygon(xPoint3, yPoint3, 4);

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillPolygon(xPoint, yPoint, 4);

        graphicsContext.strokeLine(x + 50, y - 10, x + 50, y - 5);

        Random random = new Random();
        Color color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        for (int i = 0; i < 2; i++) {
            drawFlower(graphicsContext, x + i*30, y + i*5 - 45, color);
        }

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(x, y, 61, 20);
        graphicsContext.strokePolygon(xPoint3, yPoint3, 4);
    }

    private void drawFlower(GraphicsContext graphicsContext, int x, int y, Color color) {
        double angleIncrement = 360.0 / 6;
        graphicsContext.beginPath();
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillOval(x + 2, y + 2, 10, 40);

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(i * angleIncrement);
            int x0 = (int) (x + 10 * Math.cos(angle));
            int y0 = (int) (y + 10 * Math.sin(angle));
            graphicsContext.setFill(color);
            graphicsContext.fillOval(x0, y0, 15, 15);
        }

        graphicsContext.setFill(Color.YELLOW);
        graphicsContext.fillOval(x + 2, y + 2, 10, 10);
        graphicsContext.closePath();
    }

    private void drawRailings(GraphicsContext graphicsContext) {
        graphicsContext.beginPath();

        LinearGradient gradientRailings = new LinearGradient(
                2, 0, 0, 0, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.TAN),
                new Stop(0, Color.DARKORANGE)
        );

        graphicsContext.setFill(gradientRailings);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                graphicsContext.fillArc(x + j * 20 + i*60 + 305, y - 10, 10, 60, 0, 180, ArcType.OPEN);
                graphicsContext.fillOval(x + i * 60 + 300, y, 60, 10);
            }
        }

    }
}
