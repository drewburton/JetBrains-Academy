// Posted from EduTools plugin
/**
    Box for cakes
*/
class CakeBox<Cake> {

    private Cake cake;

    public void put(Cake cake) {
    	this.cake = cake;
    }

    public Cake get() {
        return this.cake;
    }
}

/**
    Box for pies
*/
class PieBox<Pie> {

    private Pie pie;

    public void put(Pie pie) {
    	this.pie = pie;
    }

    public Pie get() {
        return this.pie;
    }
}


/**
    Box for tarts
*/
class TartBox<Tart> {

    private Tart tart;

    public void put(Tart tart) {
    	this.tart = tart;
    }

    public Tart get() {
        return this.tart;
    }
}

/*
    Hundred more such boring classes OR ...
    magic class for everything everybody is waiting for
*/
class Box<T> {
    private T item;

    public void put(T item) { 
        this.item = item;
    }

    public T get() {
        return this.item; 
    }
}
