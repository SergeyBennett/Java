import ua.princeton.lib.StdDraw;

public class BouncingBalls{
	public static void main(String[] args){
		StdDraw.setXscale(1.0/22.0, 21.0/22.0);
		StdDraw.setYscale(1.0/22.0, 21.0/22.0);
		int N = Integer.parseInt("50"/*args[0]*/);
		Ball[] balls = new Ball[N];
		for (int i = 0; i < N; i++)
			balls[i] = new Ball();
		while(true){
			StdDraw.clear();
			for (int i = 0; i < N; i++){
				balls[i].move(0.5);
				balls[i].draw();
			}
			StdDraw.show(20);
		}
	}
}
