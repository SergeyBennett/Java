//Check graph for orientation by its matrix
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphOrientation {
	
	static Scanner sc;
	static int[][] matrix;
	static int N;
	
	public static void main(String args[]){
		inputData("Test.txt");
		System.out.println(mToString(matrix));
		if(checkForNonOrientation(matrix)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
	
	static void inputData(String fileName){
		try {
			sc=new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		N=sc.nextInt();
		matrix=new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				matrix[i][j]=sc.nextInt();
			}
		}
	}
	
	static String mToString(int [][] matrix){
		String res="";
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				res+=matrix[i][j]+" ";
			}
			res+="\n";
		}
		return res;
	}
	static boolean checkForNonOrientation(int[][] matrix){
		for(int i=0;i<N;i++){
			for(int j=0;j<=i;j++){
				if(matrix[i][j]!=matrix[j][i])return false;
			}
		}
		return true;
	}
}
