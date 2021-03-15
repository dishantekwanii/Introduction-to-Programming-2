package test3;
public class Line {
    Point p1;
    Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Line(int x1, int y1, int x2, int y2) {
      p1 = new Point(x1, y1);
      p2   = new Point(x2, y2);
    }
    
    public double slope(Point p) {
        if (this.p2.x == this.p1.x) {
            throw new IllegalArgumentException();
        } else {
            double dy = (double)(this.p2.y - this.p1.y);
            double dx = (double)(this.p2.x - this.p1.x);
            return dy / dx;
	       }
    }
    
}
