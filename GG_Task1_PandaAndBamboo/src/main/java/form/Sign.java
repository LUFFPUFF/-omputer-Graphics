package form;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class Sign {

    private final int x;
    private final int y;

    public Sign(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawSign(GraphicsContext graphicsContext) {

        LinearGradient gradient = new LinearGradient(
                1, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.TAN),
                new Stop(0, Color.SIENNA)
        );

        LinearGradient gradient2 = new LinearGradient(
                1, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(1, Color.SADDLEBROWN),
                new Stop(0, Color.BLACK)
        );

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient2);
        graphicsContext.moveTo(x + 50, y);
        graphicsContext.lineTo(x + 50, y - 10);
        graphicsContext.lineTo(x + 60, y - 10);
        graphicsContext.lineTo(x + 60, y + 110);
        graphicsContext.lineTo(x + 50, y + 110);
        graphicsContext.fill();
        graphicsContext.closePath();

        graphicsContext.beginPath();
        graphicsContext.setFill(gradient);
        graphicsContext.moveTo(x, y);
        graphicsContext.lineTo(x + 100, y);
        graphicsContext.lineTo(x + 100, y + 20);
        graphicsContext.lineTo(x + 90, y + 25);
        graphicsContext.lineTo(x + 100, y + 30);
        graphicsContext.bezierCurveTo(x + 100, y + 30, x + 90, y + 40, x + 100, y + 60);
        graphicsContext.lineTo(x, y + 60);
        graphicsContext.lineTo(x + 20, y + 50);
        graphicsContext.lineTo(x, y + 40);
        graphicsContext.bezierCurveTo(x, y + 40, x + 10, y + 35, x, y + 30);
        graphicsContext.lineTo(x + 10, y + 20);
        graphicsContext.lineTo(x, y + 10);
        graphicsContext.fill();
        graphicsContext.closePath();

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillText("Панда около", x + 15, y + 25);
        graphicsContext.fillText("бамбука", x + 25, y + 40);
    }
}
