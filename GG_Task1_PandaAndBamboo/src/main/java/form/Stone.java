package form;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;

public class Stone {
    private final int x;
    private final int y;
    private final int type;

    public Stone(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(GraphicsContext graphicsContext) {
        if (type == 1) {
            drawStoneFace(graphicsContext);
        } else {
            drawStone(graphicsContext);
        }
    }

    public void drawStone(GraphicsContext graphicsContext) {
        drawStoneBasis(graphicsContext);
    }
    public void drawStoneFace(GraphicsContext graphicsContext) {
        drawStoneBasis(graphicsContext);
        drawFace(graphicsContext);
    }

    public void drawFace(GraphicsContext graphicsContext) {
        for (int i = 0; i < 2; i++) {
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.fillOval(x + i*25 + 30, y - 15, 20, 25);
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillOval(x + i*25 + 30, y - 14, 10, 15);
            graphicsContext.strokeArc(x + i*30 + 30, y - 20, 15, 10, 30, 150, ArcType.OPEN);
        }
        graphicsContext.strokeArc(x + 40, y + 15, 30, 10, 180, 180, ArcType.OPEN);
        graphicsContext.strokeArc(x + 50, y + 30, 10, 3, 180, 180, ArcType.OPEN);
        graphicsContext.strokeArc(x + 30, y + 15, 10, 10, 270, 180, ArcType.OPEN);
        graphicsContext.strokeArc(x + 70, y + 15, 10, 10, 90, 180, ArcType.OPEN);
    }

    public void drawStoneBasis(GraphicsContext graphicsContext) {

        LinearGradient gradient = new LinearGradient(
                1, 0, 0, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.rgb(100, 100, 112)),
                new Stop(1, Color.rgb(200, 200, 200))
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x, y);
        graphicsContext.bezierCurveTo(x, y, x + 50, y - 80, x + 100, y);
        graphicsContext.bezierCurveTo(x  + 100, y, x + 120, y + 30, x + 100, y + 40);
        graphicsContext.bezierCurveTo(x + 100, y + 40, x + 50, y + 60, x - 20, y + 50);
        graphicsContext.bezierCurveTo(x - 20, y + 50, x - 50, y - 30, x + 30, y + 10);
        graphicsContext.fill();
        graphicsContext.closePath();
    }
}
