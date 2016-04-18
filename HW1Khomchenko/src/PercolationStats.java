//http://introcs.cs.princeton.edu/java/24percolation/
import java.util.Scanner;

public class PercolationStats { 

	static Percolation percolTest;
	static int randomCell;
	static int N;
	static int T;
	static int totalOpenCells;
	static int[] openCells;
	static double stddev;
	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in );
		System.out.println("Enter matrix size:");
		N = input.nextInt();
		System.out.println("Enter quantity of tests:");
		T = input.nextInt();

		openCells=new int[T];
		for(int i=0;i<T;i++){
			percolTest=new Percolation(N);
			do{
				do{
					randomCell=(int)Math.rint(Math.random()*(Math.pow(N, 2)-1));
				}while (percolTest.isOpened(randomCell));
				percolTest.open(randomCell);
			}while(!percolTest.percolates());
			openCells[i]=percolTest.getOpenedCount();
		}

		System.out.println("Percolation stats "+N+" "+T+":");
		System.out.println("mean = "+mean());
		stddev=stddev();
		System.out.println("stddev = "+stddev);
		System.out.println("95% confidence interval : "+(mean()-stddev)+" - "+(mean()+stddev));
	}
	// запускаємо експерименти і рахуємо відповідні значення середнє, відхилення, інтервал довіри, та виводимо на екран


	public static double mean() {
		totalOpenCells=0;
		for(int i=0;i<T;i++){
			totalOpenCells+=openCells[i];
		}
		return (double)totalOpenCells/(T*Math.pow(N, 2));
	}
	// рахує середнє


	public static double stddev() {
		double sum=0;
		double mean=mean()*Math.pow(N, 2);
		for(int i=0;i<T;i++){
			sum+=Math.pow((openCells[i]-mean),2);
		}
		return Math.sqrt(sum/(T-1)/Math.pow(N, 4));
	}
	// рахує відхилення

}
