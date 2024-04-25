import java.awt.*;

public class Food {
    private Point position;
    private int pointsValue;

    public Food() {
        position = new Point(10, 10);
        pointsValue = 1;
    }

    public void generatePosition() {
        int x = (int) (Math.random() * 40);
        int y = (int) (Math.random() * 40);
        position.setLocation(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(position.x * 10, position.y * 10, 10, 10);
    }

    public boolean checkCollision(Snake snake) {
        Point head = snake.getBody().getFirst();
        return head.equals(position);
    }

    public void respawn() {
        generatePosition();
    }

    public Point getPosition() {
        return position;
    }

    public int getPointsValue() {
        return pointsValue;
    }
}
