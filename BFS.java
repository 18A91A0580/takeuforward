package graphs;
import java.util.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class BFS {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of nodes:");
		int n=sc.nextInt();
		ArrayList<ArrayList<Integer>> al=new ArrayList<>();
		for(int i=0;i<=n;i++) {
			al.add(new ArrayList<>());
		}
//		int i=1;
//		while(i<=n) {
//			System.out.println("for node "+i+" :" );
//			int e=sc.nextInt();
//			if(e!=-1) {
//			al.get(i).add(e);
//			continue;
//			}
//			i++;
//		}
		al.get(1).add(2);
		al.get(2).add(1);
		al.get(2).add(3);
		al.get(2).add(7);
		al.get(3).add(2);
		al.get(3).add(5);
		al.get(4).add(6);
		al.get(5).add(3);
		al.get(5).add(7);
		al.get(6).add(4);
		al.get(7).add(2);
		al.get(7).add(5);
		
		System.out.println(brfs(7,al));
	}
	static ArrayList<Integer> brfs(int v,ArrayList<ArrayList<Integer>> adj  )
	{
		ArrayList<Integer> bfs=new ArrayList<>();
		boolean vis[]=new boolean[v+1];
		for(int i=1;i<=v;i++) {
			if(!vis[i]) {
				vis[i]=true;
				Queue<Integer> q=new LinkedList<>();
				q.add(i);
				while(!q.isEmpty()) {
					int node=q.remove();
					bfs.add(node);
					for(Integer it:adj.get(node)) {
						if(!vis[it]) {
							vis[it]=true;
							q.add(it);
						}
					}
				}
			}
		}
		return bfs;
	}

}
