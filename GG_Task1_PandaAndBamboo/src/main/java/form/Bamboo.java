package form;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
public class Bamboo {
    private final int x;
    private final int y;
    private final int height;

    public Bamboo(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    public void drawBamboo(GraphicsContext graphicsContext) {
        if (height != 0) {
            if (height == 1) {
                drawTopPart(graphicsContext, x, y);
                drawMiddlePart(graphicsContext, x, y);
                for (int i = 0; i < 2; i++) {
                    drawStem(graphicsContext, x + 5, y + i*50 + 70);
                    for (int j = 0; j < 2; j++) {
                        drawStem2(graphicsContext, x + 50, y + i*30 + 70);
                    }
                }
            } else if (height == 2) {
                drawTopPart(graphicsContext, x, y);
                drawBottomPart(graphicsContext, x, y + 80);
                for (int i = 0; i < 2; i++) {
                    drawStem(graphicsContext, x + 5, y + i*70 + 40);
                    for (int j = 0; j < 2; j++) {
                        drawStem2(graphicsContext, x + 50, y + i*60 + 40);
                    }
                }
            } else if (height ==3) {
                drawTopPart(graphicsContext, x, y);
                drawMiddlePart(graphicsContext, x, y);
                drawBottomPart(graphicsContext, x, y);
                for (int i = 0; i < 2; i++) {
                    drawStem( graphicsContext, x + 5, y + i*80 - 30);
                    for (int j = 0; j < 3; j++) {
                        drawStem2( graphicsContext, x + 50, y + j*70 - 30);
                    }
                }
                drawStem(graphicsContext, x + 5, y);
                drawStem( graphicsContext, x, y + 85);
                drawStem2( graphicsContext, x + 55, y + 85);
            } else if (height == 4) {
                drawTopPart(graphicsContext, x, y);
                drawMiddlePart(graphicsContext, x, y);
                drawBottomPart(graphicsContext, x, y);
                drawBottomPart(graphicsContext, x + 5, y - 105);
                for (int i = 0; i < 3; i++) {
                    drawStem( graphicsContext, x + 5, y + i*80 - 50 - 50);
                    for (int j = 0; j < 4; j++) {
                        drawStem2( graphicsContext, x + 50, y + j*70 - 50 - 50);
                    }
                }
                drawStem(graphicsContext, x + 5, y);
                drawStem( graphicsContext, x, y + 85);
                drawStem2( graphicsContext, x + 55, y + 85);
            }
        }
    }

    private void drawTopPart(GraphicsContext graphicsContext, int x, int y) {
        LinearGradient gradient = new LinearGradient(
                1, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTGREEN),
                new Stop(1, Color.DARKGREEN)
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x, y);
        graphicsContext.bezierCurveTo(x, y, x + 20, y - 50, x, y - 100);
        graphicsContext.bezierCurveTo(x, y - 100, x + 50, y - 100, x + 50, y - 100);
        graphicsContext.bezierCurveTo(x + 50, y - 100, x + 45, y - 70, x + 40 , y);
        graphicsContext.bezierCurveTo(x + 40, y, x + 20, y - 10, x, y);
        graphicsContext.fill();
        graphicsContext.closePath();
    }

    private void drawMiddlePart(GraphicsContext graphicsContext, int x, int y) {

        LinearGradient gradient = new LinearGradient(
                1, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTGREEN),
                new Stop(1, Color.DARKGREEN)
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x, y - 110);
        graphicsContext.bezierCurveTo(x, y - 110, x + 25, y - 130, x, y - 160);
        graphicsContext.bezierCurveTo(x, y - 160, x - 10, y - 180, x + 10, y - 180);
        graphicsContext.bezierCurveTo(x + 10, y - 180, x + 20, y - 180, x + 50, y - 180);
        graphicsContext.bezierCurveTo(x + 50, y - 180, x + 70, y - 190, x + 45, y - 110);
        graphicsContext.bezierCurveTo(x + 45, y - 110, x + 20, y - 115, x, y - 110);
        graphicsContext.fill();
        graphicsContext.closePath();
    }

    private void drawBottomPart(GraphicsContext graphicsContext, int x, int y) {

        LinearGradient gradient = new LinearGradient(
                1, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTGREEN),
                new Stop(1, Color.DARKGREEN)
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x, y - 195);
        graphicsContext.bezierCurveTo(x, y - 195, x + 15, y - 250, x, y - 280);
        graphicsContext.bezierCurveTo(x, y - 280, x + 20, y - 285, x + 55, y - 290);
        graphicsContext.bezierCurveTo(x + 55, y - 290, x + 75, y - 305, x + 60, y - 270);
        graphicsContext.bezierCurveTo(x + 60, y - 270, x + 50, y - 250, x + 50, y - 190);
        graphicsContext.bezierCurveTo(x + 50, y - 190, x + 20, y - 193, x, y - 195);
        graphicsContext.fill();
        graphicsContext.closePath();
    }

    private void drawStem(GraphicsContext graphicsContext, int x, double y) {

        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTGREEN),
                new Stop(1, Color.DARKGREEN)
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x + 60, y - 220);
        graphicsContext.bezierCurveTo(x + 60, y - 220, x + 100, y - 260, x + 200, y - 250);
        graphicsContext.bezierCurveTo(x + 200, y - 250, x + 100, y - 250, x + 70, y - 210);
        graphicsContext.bezierCurveTo(x + 70, y - 210, x + 50, y - 215, x + 60, y - 220);
        graphicsContext.fill();
        graphicsContext.closePath();

    }

    private void drawStem2(GraphicsContext graphicsContext, int x, int y) {
        LinearGradient gradient = new LinearGradient(
                0, 0, 0, 2, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.DARKGREEN),
                new Stop(1, Color.LIGHTGREEN)
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x - 60, y - 220);
        graphicsContext.bezierCurveTo(x - 60, y - 220, x - 100, y - 260, x - 200, y - 250);
        graphicsContext.bezierCurveTo(x - 200, y - 250, x - 100, y - 250, x - 70, y - 210);
        graphicsContext.bezierCurveTo(x - 70, y - 210, x - 50, y - 215, x - 60, y - 220);
        graphicsContext.fill();
        graphicsContext.closePath();

    }
}
