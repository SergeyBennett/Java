import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

import lib.StdDraw;

public class Degrees {
    private int V, pathCount;
    private int[] path;     
    private int[][] graph;
 
	private Stack<Integer> cycle = null;
	Digraph digraph;

	public Degrees(Digraph G) {
		digraph=G;
		if (G.E() == 0)
			return;
		for (int v = 0; v < G.V(); v++)
			if (G.outdegree(v) != G.indegree(v))
				return;
		Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
		for (int v = 0; v < G.V(); v++)
			adj[v] = G.adj(v).iterator();
		int s = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);
		cycle = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int v = stack.pop();
			while (adj[v].hasNext()) {
				stack.push(v);
				v = adj[v].next();
			}
			cycle.push(v);
		}
	}
	public Iterable<Integer> cycle() {
		return cycle;
	}
	public boolean hasEulerianCycle() {
		return cycle != null;
	}
	public void draw() throws IOException{
		double[] coords=new double[digraph.V()*2];
		StdDraw.setXscale(0, 20);
		StdDraw.setYscale(0, 20);
		StreamTokenizer st=new StreamTokenizer(new FileReader("test1"));
		st.nextToken();
		for(int i=0;i<digraph.V()*2;i++){
			coords[i]=st.nval;
			st.nextToken();
			if(i%2==1) StdDraw.point(coords[i-1], coords[i]);
		}
		for(int i=0;i<digraph.V();i++){
			for(Integer j:digraph.adj(i)) StdDraw.line(coords[i*2], coords[i*2+1], coords[j*2], coords[j*2+1]);
		}
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.01);
		int i=-1;
			for(Integer j:cycle){
				if(i==-1){
					i++;
					continue;
				}
				StdDraw.line(coords[i*2], coords[i*2+1], coords[j*2], coords[j*2+1]);
				i=j;
				StdDraw.show(1000);
			}
		StdDraw.show(6000);
	}
		
		public boolean findHamiltonianCycle(Digraph g) throws IOException{
			int[][] mass = new int[g.V()][g.V()];
			for(int i=0;i<g.V();i++){
				for(Integer j:g.adj(i)){
					mass[i][j]=1;
				}
			}
			return findHamiltonianCycle(mass);
		}
	    /** Function to find cycle 
	     * @throws IOException **/
	    private boolean findHamiltonianCycle(int[][] g) throws IOException
	    {
	        V = g.length;
	        path = new int[V];
	 
	        Arrays.fill(path, -1);
	        graph = g;        
	        try
	        {            
	            path[0] = 0;
	            pathCount = 1;            
	            solve(0);
	            System.out.println("No solution");
	            return false;
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	            display();
	            return true;
	        }
	    }
	    /** function to find paths recursively **/
	    public void solve(int vertex) throws Exception
	    {
	        /** solution **/
	        if (graph[vertex][0] == 1 && pathCount == V)
	            throw new Exception("Solution found");
	        /** all vertices selected but last vertex not linked to 0 **/
	        if (pathCount == V)
	            return;
	 
	        for (int v = 0; v < V; v++)
	        {
	            /** if connected **/
	            if (graph[vertex][v] == 1 )
	            {
	                /** add to path **/            
	                path[pathCount++] = v;    
	                /** remove connection **/            
	                graph[vertex][v] = 0;
	                graph[v][vertex] = 0;
	 
	                /** if vertex not already selected  solve recursively **/
	                if (!isPresent(v))
	                    solve(v);
	 
	                /** restore connection **/
	                graph[vertex][v] = 1;
	                graph[v][vertex] = 1;
	                /** remove path **/
	                path[--pathCount] = -1;                    
	            }
	        }
	    }    
	    /** function to check if path is already selected **/
	    public boolean isPresent(int v)
	    {
	        for (int i = 0; i < pathCount - 1; i++)
	            if (path[i] == v)
	                return true;
	        return false;                
	    }
	    /** display solution 
	     * @throws IOException **/
	    public void display() throws IOException{
	    	double[] coords=new double[path.length*2];
			StdDraw.setXscale(0, 20);
			StdDraw.setYscale(0, 20);
			StreamTokenizer st=new StreamTokenizer(new FileReader("Coords2"));
			st.nextToken();
			for(int i=0;i<path.length*2;i++){
				coords[i]=st.nval;
				st.nextToken();
				if(i%2==1) StdDraw.point(coords[i-1], coords[i]);
			}
	        System.out.print("\nPath : ");
	        for(int i=0;i<path.length;i++){
				for(Integer j:digraph.adj(i)) StdDraw.line(coords[i*2], coords[i*2+1], coords[j*2], coords[j*2+1]);
			}
	        StdDraw.setPenColor(StdDraw.RED);
			StdDraw.setPenRadius(0.01);
	        for (int i = 0; i <= V; i++){
	        	StdDraw.line(coords[(i+1)%V*2], coords[(i+1)%V*2+1], coords[i%V*2], coords[i%V*2+1]);
	            System.out.print(path[i % V] +" ");
				StdDraw.show(1000);
	        }
			}
	    public static void main(String[] args) throws IOException {
	    	Digraph g;
			StreamTokenizer st=new StreamTokenizer(new FileReader("test3"));
			st.nextToken();
			g=new Digraph((int)st.nval);
			while(st.nextToken()!=StreamTokenizer.TT_EOF){
				int f=(int) st.nval;
				st.nextToken();
				g.addEdge(f, (int)st.nval);
			}
		Degrees mc=new Degrees(g);
		for(Integer i:mc.cycle()){
			System.out.print(i+" ");
		}
		mc.draw();
		}
}
	