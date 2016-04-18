import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ua.princeton.lib.StdDraw;

public class Fast {
	public static int N;
	static Point point;
	static Point[] points;
	public static void main(String[] args){
		StdDraw.setXscale(0, 32768);StdDraw.setYscale(0, 32768);
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("rs1423.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int N=scanner.nextInt();
		points=new Point[N];
		for(int i=0;i<N;i++){
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			points[i]=new Point(x,y);
		}
		
		for(int i=0;i<N;i++){
			point=points[i];
			sort(points);
			for(int j=0;j<points.length-2;j++){
				double slope1=point.slopeTo(points[j]);
				double slope2=point.slopeTo(points[j+1]);
				double slope3=point.slopeTo(points[j+2]);
				if(slope1==slope2&&slope2==slope3){
					point.draw();
					points[j].draw();
					points[j+1].draw();
					points[j+2].draw();
					point.drawTo(points[j]);
					point.drawTo(points[j+1]);
					point.drawTo(points[j+2]);
					System.out.println("("+point.x+","+point.y+")"
										+"("+points[j].x+","+points[j].y+")"
										+"("+points[j+1].x+","+points[j+1].y+")"
										+"("+points[j+2].x+","+points[j+2].y+")");
				}
			}
		}
	}
	private static void sort(Point[] points_){
		for(int j=0;j<N;j++){
			for(int i=0;i<N-1;i++){
				if(points_[i].slope<points_[i+1].slope){
					swap(points_,i,i+1);
				}
			}
		}
	}
	private static  void swap(Point[] points_,int p,int q){
		Point swap=points_[p];
		points_[p]=points_[q];
		points_[q]=swap;
	}
}