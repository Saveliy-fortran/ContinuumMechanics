package main.things;

abstract public class Thing {
    protected double diametr;
    protected double q;
    protected double x,y;
    protected int timeForFire;
    protected String name;

    private boolean fire = false;

    public Thing(double diametr, double x, double y, String name) {
        this.diametr = diametr;
        this.x = x;
        this.y = y;
        this.name = name;
    }


    public void setFire(boolean fire, int timeForFire) {
        this.timeForFire = timeForFire;
        this.fire = fire;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDiametr() {
        return diametr;
    }

    public boolean isFire() {
        return fire;
    }

    public String getName() {
        return name;
    }

    abstract public double getQ(int time);

}
