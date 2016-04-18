import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import ua.princeton.lib.StdDraw;

public class Brute {
	public static int N;
	static Point point;
	static Point arrPoint;
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
		Point[] points=new Point[N];
		for(int i=0;i<N;i++){
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			points[i]=new Point(x,y);
		}
		for(int p=0;p<N;p++){
			Point point=points[p];
			for(int q=p+1;q<N;q++){
				for(int r=q+1;r<N;r++){
					for(int s=r+1;s<N;s++){
						double slope1=points[p].slopeTo(points[q]);
						double slope2=points[p].slopeTo(points[r]);
						double slope3=points[p].slopeTo(points[s]);
						double slope4=points[q].slopeTo(points[r]);
						double slope5=points[q].slopeTo(points[s]);
						double slope6=points[r].slopeTo(points[s]);
						
						if(slope1==slope2
							&&slope2==slope3
							&&slope3==slope4
							&&slope4==slope5
							&&slope5==slope6
							&&(p!=q)&&(q!=r)&&(p!=r)&&(p!=s)&&(q!=s)&&(r!=s)){
							points[p].draw();
							points[q].draw();
							points[r].draw();
							points[s].draw();
							points[p].drawTo(points[q]);
							points[p].drawTo(points[r]);
							points[p].drawTo(points[s]);
							System.out.println("("+points[p].x+","+points[p].y+")"
												+"("+points[q].x+","+points[q].y+")"
												+"("+points[r].x+","+points[r].y+")"
												+"("+points[s].x+","+points[s].y+")");
						}
					}
				}
			}
		}
	}
}
