package graphs;

import java.util.ArrayList;
import java.util.*;

public class BipartiteUsingDFS {

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
				if(!checkBipartite(adj, i,color))
					return false;
			}
		}
		return true;
	}
	static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj,int node,int[] color) {
		if(color[node]==-1) color[node]=1;
		for(Integer it:adj.get(node)) {
			if(color[it]==-1) {
				color[it]=1-color[node];
				if(!checkBipartite(adj,it,color)) return false;
			}
			else if(color[it]==color[node]) return false;
		}
		return true;
	}

}
