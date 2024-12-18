package poo.key_event_loop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import poo.scenario.Scenario;
import poo.snake.Snake;

public class KeyEventLoopTest {

//    private Scenario scenario;
//    private Snake snake;
//    private KeyEventLoop keyEventLoop;
//
//    @BeforeAll
//    public static void initToolkit() {
//        Platform.startup(() -> {});
//    }
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        Platform.runLater(() -> {
//            snake = new TestSnake();
//            scenario = new TestScenario(new Stage(), snake);
//
//            keyEventLoop = new KeyEventLoop(scenario, snake, null, null);
//        });
//        Thread.sleep(1000); // Wait for JavaFX initialization
//    }
//
//    @Test
//    public void testKeyPressedRight() {
//        Platform.runLater(() -> {
//            ((TestScenario) scenario).simulateKeyPress(KeyCode.RIGHT);
//            assertEquals(KeyCode.RIGHT, ((TestScenario) scenario).getCurrentDirection());
//        });
//    }
//
//    @Test
//    public void testKeyPressedLeft() {
//        Platform.runLater(() -> {
//            ((TestScenario) scenario).simulateKeyPress(KeyCode.LEFT);
//            assertEquals(KeyCode.LEFT, ((TestScenario) scenario).getCurrentDirection());
//        });
//    }
//
//    @Test
//    public void testKeyPressedUp() {
//        Platform.runLater(() -> {
//            ((TestScenario) scenario).simulateKeyPress(KeyCode.UP);
//            assertEquals(KeyCode.UP, ((TestScenario) scenario).getCurrentDirection());
//        });
//    }
//
//    @Test
//    public void testKeyPressedDown() {
//        Platform.runLater(() -> {
//            ((TestScenario) scenario).simulateKeyPress(KeyCode.DOWN);
//            assertEquals(KeyCode.DOWN, ((TestScenario) scenario).getCurrentDirection());
//        });
//    }
//
//    @Test
//    public void testGameOver() {
//        // Simulate game over behavior
//        keyEventLoop.gameOver();
//
//        // Verify interactions
//        assertTrue(((TestScenario) scenario).isGameOverShown());
//        assertTrue(((TestSnake) snake).isDead());
//    }
//
//    // Clases internas para simular el comportamiento necesario para las pruebas
//    private class TestScenario extends Scenario {
//        private KeyCode currentDirection;
//        private boolean gameOverShown = false;
//
//        public TestScenario(Stage stage, Snake snake) {
//            super(stage, snake, null, null);
//        }
//
//        public void simulateKeyPress(KeyCode key) {
//            this.currentDirection = key;
//        }
//
//        public KeyCode getCurrentDirection() {
//            return currentDirection;
//        }
//
//        public boolean isGameOverShown() {
//            return gameOverShown;
//        }
//
//        public void showGameOver(Object keyEventLoop) {
//            this.gameOverShown = true;
//        }
//    }
//
//    private class TestSnake extends Snake {
//        private boolean dead = false;
//
//        public boolean isDead() {
//            return dead;
//        }
//
//        @Override
//        public void deadSnake() {
//            this.dead = true;
//        }
//
//        @Override
//        public Integer getPosicionX() {
//            return super.getPosicionX().getValue();
//        }
//
//        @Override
//        public Integer getPosicionY() {
//            return super.getPosicionY().getValue();
//        }
//    }
}
