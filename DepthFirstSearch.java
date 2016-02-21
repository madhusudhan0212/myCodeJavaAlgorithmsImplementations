package temp;

public class DepthFirstSearch {

	public boolean[] marked;
	public int[] edgeTo;
	private int s;
	private Graph G;
	
	DepthFirstSearch(Graph G, int s){
		this.G = G;
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for (int i =0; i < G.V(); i++){
			marked[i] = false;
		}
		dfs(G,s);
	}
	
	private void dfs(Graph G, int s){
		marked[s] = true;
		for (Integer i : G.adj(s)){
			if (!marked[i]){
				dfs(G,i);
				edgeTo[i] =s;
			}
		}
	}
	
	public boolean hasPathTo(int x){
		return marked[x];
	}
	
	public void pathTo(int x){
		if(!hasPathTo(x)) { System.out.println("no path exists from " +s+" to "+x) ;}
		Stack<Integer> st = new Stack<Integer>();
		for(int i = x; i != s; i = edgeTo[i]){
			st.push(i);	
		}
		st.push(s);
		
		while(true){
			x = st.pop();
			System.out.print(x +" ");
			if(st.isEmpty()){ break;}
		}
	}
	
	public static void main(String[] args){
		
		Graph G = new Graph(7);
		G.buildTree();
		G.displayGraph();
		
		DepthFirstSearch df = new DepthFirstSearch(G,4);
		System.out.println("Path to given node");
		df.pathTo(3);
	}
}
	

