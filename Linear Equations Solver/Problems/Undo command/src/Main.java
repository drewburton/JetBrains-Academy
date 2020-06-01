interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Movable, Command{
    Movable entity;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);
    }

    @Override
    public void undo() {
        entity.setX(entity.getX() - xMovement);
        entity.setY(entity.getY() - yMovement);
    }

    @Override
    public int getX() {
        return entity.getX();
    }

    @Override
    public int getY() {
        return entity.getY();
    }

    @Override
    public void setX(int newX) {
        xMovement = newX - entity.getX();
    }

    @Override
    public void setY(int newY) {
        yMovement = newY - entity.getY();
    }
}

class CommandPutItem implements Storable, Command{
    Storable entity;
    String item;
    int index;

    @Override
    public void execute() {
        for (int i = 0; i < getInventoryLength(); i++) {
            String retrieved = getInventoryItem(i);
            if (retrieved == null) {
                index = i;
                setInventoryItem(i, item);
                break;
            }
        }
    }

    @Override
    public void undo() {
        setInventoryItem(index, null);
    }

    @Override
    public int getInventoryLength() {
        return entity.getInventoryLength();
    }

    @Override
    public String getInventoryItem(int index) {
        return entity.getInventoryItem(index);
    }

    @Override
    public void setInventoryItem(int index, String item) {
        entity.setInventoryItem(index, item);
    }
}