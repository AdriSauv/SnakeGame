import java.awt.*;
import java.util.LinkedList;
import java.util.SequencedCollection;

public class Snake {
    // body
    private LinkedList<Point> body;
    // direction
    private Direction direction;
    // speed
    private int speed;
    // alive
    private boolean isAlive;

    public Snake(){
        body = new LinkedList<>();
        body.add(new Point(20, 20));
        body.add(new Point(20, 21));
        body.add(new Point(20, 22));
        direction = Direction.UP;
        speed = 1;
        isAlive = true;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head);
        switch (direction) {
            case UP:
                newHead.y -= speed;
                break;
            case DOWN:
                newHead.y += speed;
                break;
            case LEFT:
                newHead.x -= speed;
                break;
            case RIGHT:
                newHead.x += speed;
                break;
        }
        body.addFirst(newHead);
        body.removeLast();
    }

    public void grow() {
        Point head = body.getFirst();
        Point newHead = new Point(head);
        switch (direction) {
            case UP:
                newHead.y -= speed;
                break;
            case DOWN:
                newHead.y += speed;
                break;
            case LEFT:
                newHead.x -= speed;
                break;
            case RIGHT:
                newHead.x += speed;
                break;
        }
        body.addFirst(newHead);
    }

    public void changeDirection(Direction newDirection) {
        if (direction == Direction.UP && newDirection == Direction.DOWN) {
            return;
        }
        if (direction == Direction.DOWN && newDirection == Direction.UP) {
            return;
        }
        if (direction == Direction.LEFT && newDirection == Direction.RIGHT) {
            return;
        }
        if (direction == Direction.RIGHT && newDirection == Direction.LEFT) {
            return;
        }
        direction = newDirection;
    }

    public boolean checkCollision() {
        Point head = body.getFirst();
        if (head.x < 0 || head.x >= 40 || head.y < 0 || head.y >= 40) {
            return true;
        }
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean eatFood(Food food) {
        Point head = body.getFirst();
        if (head.equals(food.getPosition())) {
            return true;
        }
        return false;
    }

    public void update(){
        // update the state of the snake in each game tick
        move();
        if (checkCollision()) {
            isAlive = false;
        }
    }

    public void reset() {
        body.clear();
        body.add(new Point(20, 20));
        body.add(new Point(20, 21));
        body.add(new Point(20, 22));
        direction = Direction.UP;
        speed = 1;
        isAlive = true;
    }

    // Get body
    public LinkedList<Point> getBody() {
        return body;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        for (Point point : body) {
            g.fillRect(point.x * 10, point.y * 10, 10, 10);
        }
    }
}
