package graphs;
import java.util.*;
public class BipartiteUsingBFS {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of nodes:");
		int n=sc.nextInt();
		ArrayList<ArrayList<Integer>> al=new ArrayList<>();
		for(int i=0;i<=n;i++) {
			al.add(new ArrayList<>());
		}
		int i=1;
		while(i<=n) {
			System.out.println("for node "+i+" :" );
			int e=sc.nextInt();
			if(e!=-1) {
			al.get(i).add(e);
			continue;
			}
			i++;
		}
		if(bi(al,n)) System.out.println("Bipartite");
		else System.out.println("Not Bipartite");
	}
	static boolean bi(ArrayList<ArrayList<Integer>> adj,int v) {
		int[] color=new int[v+1];
		Arrays.fill(color,-1);
		for(int i=1;i<=v;i++) {
			if(color[i]==-1) {
				if(isBipartite(adj,color,i)) return true;
			}
		}
		return false;
	}
	static boolean isBipartite(ArrayList<ArrayList<Integer>> adj,int[] color,int node) {
		Queue<Integer> q=new LinkedList<>();
		q.add(node);
		color[node]=0;
		while(!q.isEmpty()) {
			int e=q.remove();
			for(Integer it:adj.get(e)) {
				if(color[it]==-1) {
					q.add(it);
					color[it]=1-color[e];
				}
				else if(color[it]==color[e]) return false;
			}
		}
		return true;
	}

}
