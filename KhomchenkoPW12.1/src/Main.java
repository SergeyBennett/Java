import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static Scanner sc;
	static BufferedReader br;
	static int[][] graph;
	static int N;
	static StringTokenizer connections;
	
	public static void main(String args[]){
		
		try {
			inputData("Test.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mToString(reverseMatrix(graph)));
		
	}
	
	static void inputData(String fileName) throws IOException{
		br=new BufferedReader(new FileReader(fileName));
		N=Integer.parseInt(br.readLine());
		graph=new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<=i;j++){
				graph[i][j]=0;
			}
		}
		for(int i=0;i<N;i++){
			connections=new StringTokenizer(br.readLine());
			while(connections.hasMoreTokens()){
				graph[i][Integer.parseInt(connections.nextToken())-1]=1;
			}
		}
	}
	
	static String mToString(int [][] matrix){
		String res="Result: \n"+N+"\n";
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(matrix[i][j]==1)res+=j+1+" ";
			}
			res+="\n";
		}
		return res;
	}
	
	static int[][] reverseMatrix(int[][] matrix){
		int[][] reversed=new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				reversed[i][j]=matrix[j][i];
			}
		}
		return reversed;
	}
}