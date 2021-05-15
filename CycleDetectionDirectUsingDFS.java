package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetectionDirectUsingDFS {

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
		if(cycle(al,n)) System.out.println("There is a cycle");
		else System.out.println("There is no cycle");
	}
	static boolean cycle(ArrayList<ArrayList<Integer>> adj,int v) {
		int[] vis=new int[v+1];
		int[] dfsVis=new int[v+1];
		for(int i=1;i<=v;i++) {
			if(vis[i]==0) {
				if(checkCycle(adj,vis,dfsVis,i)) return true;
			}
		}
		return false;
	}
	static boolean checkCycle(ArrayList<ArrayList<Integer>> adj,int[] vis,int[] dfsVis,int node) {
		vis[node]=1;
		dfsVis[node]=1;
		for(int it:adj.get(node)) {
			if(vis[it]==0) {
				
				if(checkCycle(adj, vis, dfsVis, it)) return true;
			}
			else if(dfsVis[it]==1) return true;
			
		}
		dfsVis[node]=0;
		return false;
	}
}
