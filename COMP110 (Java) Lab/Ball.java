//By Bogdan Itsam Dorantes-Nikolaev, COMP110 Lab, Instructor: Mustafa Ersen (February 20th, 2022)

//Ball class for modeling a bouncing ball based on the UML class diagram given in the lab handout.
public class Ball {
    //-x: double
    //-y: double
    //-vx: double
    //-vy: double
    //-r: double
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double r;
    //+Ball(x double, y double, vx double, vy double, r double)
    public Ball(double x, double y, double vx, double vy, double r) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.r = r;
    }
    //+getX():double
    public double getX() {
        return x;
    }
    //+getY():double
    public double getY() {
        return y;
    }
    //+getVx():double
    public double getVx() {
        return vx;
    }
    //+getVy():double
    public double getVy() {
        return vy;
    }
    //+getR():double
    public double getR() {
        return r;
    }
    //+setVx(vx double):void
    public void setVx(double vx) {
        this.vx = vx;
    }
    //+setVy(vy double):void
    public void setVy(double vy) {
        this.vy = vy;
    }
    //+move(): void
    public void move() {
        x += vx;
        y += vy;
    }
}

