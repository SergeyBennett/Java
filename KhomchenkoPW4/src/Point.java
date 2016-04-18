import java.util.Comparator;

import ua.princeton.lib.StdDraw;

public class Point implements Comparable<Point> {
    public final Comparator<Point> SLOPE_ORDER = new SOrder();

    public double slope=0;
    final int x;
    final int y;
    private static int x2;
    private static int y2;
    
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
        this.x2=x;
        this.y2=y;
    }
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
    public double slopeTo(Point that) {
    	if((x==that.x)&&(y==that.y)) return -1d/0d;
    	if(that.y==this.y) return 0;
    	if(this.x==that.x) return 1f/0f;
    	double slope=((double)that.y-this.y)/(that.x-this.x);
		return slope;
    }

    public int compareTo(Point that) {
    	if (y<that.y) return -1;
    	else if(y>that.y) return +1;
    	else if(x<that.x) return -1;
    	else if(x>that.x) return +1;
		return 0;
    }
    
    
    private static class SOrder implements Comparator<Point>{
    	public int compare(Point p, Point q){
    		double slope1=new Point(x2, y2).slopeTo(p);
    		double slope2=new Point(x2, y2).slopeTo(q);
    		if(slope1<slope2) return -1;
    		else if(slope2>slope1) return +1;
    		else return 0;
    	}
    }
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
}