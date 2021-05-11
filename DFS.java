package graphs;

import java.util.ArrayList;
import java.util.Scanner;


public class DFS {

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
		
		System.out.println(dfis(n,al));

		
	}
	static ArrayList<Integer> dfis(int v,ArrayList<ArrayList<Integer>> adj){
		ArrayList<Integer> store=new ArrayList<>();
		boolean vis[]=new boolean[v+1];
		for(int i=1;i<=v;i++) {
			if(!vis[i]) {
				
				dfs(i,adj,vis,store);
			}
		}
		return store;
	}
	static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> store) {
		
		store.add(node);
		vis[node]=true;
		for(int it:adj.get(node)) {
		if(!vis[it])
		dfs(it,adj,vis,store);
		}
		
	}

}
