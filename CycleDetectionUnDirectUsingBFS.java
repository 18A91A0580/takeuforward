package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node{
	int first;
	int second;
	Node(int first,int second) {
		this.first=first;
		this.second=second;
	}
}

public class CycleDetectionUnDirectUsingBFS {

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
		if(isCycle(al,n)) System.out.println("There is a cycle");
		else System.out.println("There is no cycle");

	}
	static boolean isCycle(ArrayList<ArrayList<Integer>> adj,int v) {
		boolean[] vis=new boolean[v+1];
		for(int i=1;i<=v;i++) {
			if(!vis[i])
			if(cycleDetect(adj,vis,i)) return true;
		}
		return false;
	}
	static boolean cycleDetect(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int s) {
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(s,-1));
		vis[s]=true;
		while(!q.isEmpty()) {
			int node=q.peek().first;
			int prev=q.peek().second;
			q.remove();
			for(int it:adj.get(node)) {
				if(!vis[it]) {
					vis[it]=true;
					q.add(new Node(it,node));
				}
				else if(it!=prev) return true;
			}
		}
		return false;
	}
}
