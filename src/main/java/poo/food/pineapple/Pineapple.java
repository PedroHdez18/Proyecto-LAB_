package poo.food.pineapple;

import poo.canvas_utils_square.CanvasUtilsSquares;
import poo.config.Config;
import poo.food.Food;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

//Clase para comida Pineapple - Piña
public class Pineapple extends Food {

    private Canvas pineapple;

    public Pineapple() {
        creatingFood();
        setRandomPosition();
    }

    @Override
    protected void creatingFood() {
        this.pineapple = CanvasUtilsSquares.buildingSquare(Color.YELLOW);
    }

    public void setRandomPosition() {
        this.pineapple
                .setTranslateX(randomNumbers(Config.oneQuarterWidthDown, Config.oneQuarterWidthUp - Config.squareSize));
        this.pineapple.setTranslateY(
                randomNumbers(Config.oneQuarterfHeightUp, Config.oneQuarterfHeightDown - Config.squareSize));
    }

    public Canvas getPineapple() {
        return pineapple;
    }

    @Override
    public Integer getPosicionX() {
        return (int) this.pineapple.getTranslateX(); // Obtiene la posición X y hace el Casting de double a int
    }

    @Override
    public Integer getPosicionY() {
        return (int) this.pineapple.getTranslateY();
    }

}
