package animal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

import static javafx.scene.paint.Color.*;

public class Panda {

    private final int x;
    private final int y;

    public Panda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawPanda(GraphicsContext graphicsContext) {
        drawTors(graphicsContext);
        drawHead(graphicsContext);
    }

    private void drawTors(GraphicsContext gc) {
        gc.setFill(BLACK);
        gc.fillOval(x - 22, y + 90, 200, 179);

        gc.setFill(LIGHTGRAY);
        gc.fillOval(x - 5, y + 160, 166, 109);

        gc.beginPath();
        gc.setFill(BLACK);
        gc.moveTo(x, y + 125);
        gc.bezierCurveTo(x - 15, y + 150, x - 100, y + 180, x + 20, y + 210);
        gc.bezierCurveTo(x + 20, y + 210, x + 60, y + 210, x + 40, y + 180);
        gc.bezierCurveTo(x + 40, y + 180, x + 20, y + 150, x, y + 125);

        gc.moveTo(x + 155, y + 125);
        gc.bezierCurveTo(x + 155 + 15, y + 150, x + 155 + 100, y + 180, x + 155 - 20, y + 210);
        gc.bezierCurveTo(x + 155 - 20, y + 210, x + 155 - 60, y + 210, x + 155 - 40, y + 180);
        gc.bezierCurveTo(x + 155 - 40, y + 180, x + 155 - 20, y + 150, x + 155, y + 125);
        gc.closePath();
        gc.fill();

        gc.beginPath();
        for (int i = 0; i < 2; i++) {
            gc.setFill(BLACK);
            gc.fillOval(x + i*80 + 10, y + 220, 50, 60);
            gc.setFill(LIGHTGRAY);
            gc.fillOval(x + i*81 + 12, y + 230, 45, 50);
        }

        for (int i = 0; i < 2; i++) {
            gc.setFill(PINK);
            gc.fillOval(x + i * 83 + 21, y + 248, 25, 25);
            for (int j = 0; j < 3; j++) {
                gc.setFill(PINK);
                gc.fillOval(x + j * 10 + 21 + i * 82, y + 239, 6, 6);
            }
        }

    }

    private void drawHead(GraphicsContext gc) {

        //овал головы
        gc.setFill(LIGHTGRAY);
        gc.fillOval(x - 15,  y + 40, 180, 100);
        gc.strokeOval(x - 15, y + 40, 180, 100);


        //уши
        for (int i = 0; i < 2; i++) {
            gc.setFill(LIGHTGRAY);
            gc.fillOval( x + i*108 - 4, y - 12, 50, 50);
            gc.setFill(BLACK);
            gc.strokeOval(x + i*108 - 4, y - 12, 50, 50);
            gc.fillOval(x + i*105 + 8, y, 30, 30);

            gc.setFill(PINK);
            gc.fillOval(x + i*104 + 17, y + 10, 13, 13);
            gc.setFill(WHITE);
            gc.strokeOval(x + i*104 + 17, y + 10, 13, 13);
        }

        //продолжение головы
        gc.setFill(LIGHTGRAY);
        gc.fillOval(x, y, 150, 130);
        gc.setFill(BLACK);
        gc.strokeArc(x, y, 150, 125, 0, 180, ArcType.OPEN);

        //глаза
        for (int i = 0; i < 2; i++) {
            gc.setFill(BLACK);
            gc.fillOval(x + i*70 + 20, y + 35, 40, 40);
            gc.setFill(WHITE);
            gc.fillOval(x + i*70 + 30, y + 42, 20, 20);
            gc.setFill(BLACK);
            gc.fillOval(x + i*70 + 35, y + 45, 12, 12);
            gc.setFill(WHITE);
            gc.fillOval(x + i*70 + 35, y + 47, 5, 5);
        }

        //рот
        gc.setFill(BLACK);
        gc.fillOval(x + 59, y + 75, 35, 20);
        gc.strokeArc(x + 75, y + 50, 30, 60, 195, 120, ArcType.OPEN);
        gc.strokeArc(x + 48, y + 50, 30, 60, 230, 120, ArcType.OPEN);
        gc.strokeArc(x + 63,  y + 96, 25, 30, 180, 180, ArcType.OPEN);
        gc.setFill(WHITE);
        gc.fillOval(x + 66, y + 77, 20, 10);

        gc.setFill(PINK);
        gc.fillOval(x + 66, y + 111, 20, 15);
        gc.setFill(BLACK);
        gc.strokeOval(x + 66, y + 111, 20, 15);
    }
}
