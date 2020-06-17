class Move {
    public static void moveRobot(Robot robot, int toX, int toY) {
        int dx = toX - robot.getX();
        int dy = toY - robot.getY();

        turnHorizontal(robot, dx);
        moveToTarget(robot, dx);
        turnVertical(robot, dy);
        moveToTarget(robot, dy);
    }

    private static void turnHorizontal(Robot robot, int dx) {
        if (dx > 0 && robot.getDirection() == Direction.DOWN) {
            robot.turnLeft();
        } else if (dx > 0 && robot.getDirection() == Direction.UP) {
            robot.turnRight();
        } else if (dx > 0 && robot.getDirection() == Direction.LEFT) {
            robot.turnRight();
            robot.turnRight();
        } else if (dx < 0 && robot.getDirection() == Direction.DOWN) {
            robot.turnRight();
        } else if (dx < 0 && robot.getDirection() == Direction.UP) {
            robot.turnLeft();
        } else if (dx < 0 && robot.getDirection() == Direction.RIGHT) {
            robot.turnRight();
            robot.turnRight();
        }
    }

    private static void turnVertical(Robot robot, int dy) {
        if (dy > 0 && robot.getDirection() == Direction.DOWN) {
            robot.turnRight();
            robot.turnRight();
        } else if (dy > 0 && robot.getDirection() == Direction.LEFT) {
            robot.turnRight();
        } else if (dy > 0 && robot.getDirection() == Direction.RIGHT) {
            robot.turnLeft();
        } else if (dy < 0 && robot.getDirection() == Direction.UP) {
            robot.turnRight();
            robot.turnRight();
        } else if (dy < 0 && robot.getDirection() == Direction.LEFT) {
            robot.turnLeft();
        } else if (dy < 0 && robot.getDirection() == Direction.RIGHT) {
            robot.turnRight();
        }
    }

    private static void moveToTarget(Robot robot, int d) {
        while (d != 0) {
            robot.stepForward();
            d = d > 0 ? d - 1 : d + 1;
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}