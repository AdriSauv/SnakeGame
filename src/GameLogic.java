import java.awt.*;

public class GameLogic {
    private Snake snake;
    private Food food;
    private boolean gameOver;

    public GameLogic() {
        snake = new Snake();
        food = new Food();
        gameOver = false;
    }

    public void update() {
        if (gameOver) {
            return;
        }
        snake.update();
        if (snake.checkCollision()) {
            gameOver = true;
            return;
        }
        if (snake.eatFood(food)) {
            snake.grow();
            food.respawn();
        }
    }

    public void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case 37:
                snake.changeDirection(Direction.LEFT);
                break;
            case 38:
                snake.changeDirection(Direction.UP);
                break;
            case 39:
                snake.changeDirection(Direction.RIGHT);
                break;
            case 40:
                snake.changeDirection(Direction.DOWN);
                break;
        }
    }

    public void draw(Graphics g) {
        snake.draw(g);
        food.draw(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.drawString("Game Over", 180, 200);
        }
    }

}
