package graphs;
import java.util.*;
import java.util.ArrayList;

public class CycleDetectionUnDirectUsingDFS {

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
			System.out.println("For node "+i+" :");
			int e=sc.nextInt();
			if(e!=-1) {
			al.get(i).add(e);
			continue;
			}
			i++;
		}
		if(isCycle(al,n)) System.out.println("There is a cycle");
		else System.out.println("There is no cycle");
	}
	static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int v) {
		boolean[] vis=new boolean[v+1];
		for(int i=1;i<=v;i++) {
			if(!vis[i]) {
				
				if(cycleDetect(adj,vis,i,-1)) return true;
			}
		}
		return false;
	}
	static boolean cycleDetect(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node,int prev) {
		
		vis[node]=true;
		for(int it:adj.get(node)) {
			if(!vis[it]) {
				vis[it]=true;
				if(cycleDetect(adj,vis,it,node)==true) return true;
			}
			else if(it!=prev) return true;
		}
		return false;
	}
}
