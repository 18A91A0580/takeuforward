package graphs;
import java.util.*;
class Node implements Comparator<Node>{
	int v;
	int w;
	Node(int V,int W){
		v=V;
		w=W;
	}
	Node(){}
	int getV() {
		return v;
	}
	int getW() {
		return w;
	}
	public int compare(Node node1,Node node2) {
		if(node1.w<node2.w) return -1;
		if(node1.w>node2.w) return 1;
		return 0;
	}
}
public class ShortestPathUnDirectUsingDijkstras {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of nodes: ");
		int n=sc.nextInt();
		ArrayList<ArrayList<Node>> al=new ArrayList<>();
		for(int i=0;i<n;i++) al.add(new ArrayList<>());
		al.get(0).add(new Node(1,2));
		al.get(1).add(new Node(0,2));
		al.get(1).add(new Node(2,4));
		al.get(2).add(new Node(1,4));
		al.get(0).add(new Node(3,1));
		al.get(3).add(new Node(0,1));
		al.get(3).add(new Node(2,3));
		al.get(2).add(new Node(3,3));
		al.get(1).add(new Node(4,5));
		al.get(4).add(new Node(1,5));
		al.get(2).add(new Node(4,1));
		al.get(4).add(new Node(2,1));
		dij(n,al,1);
	}
	static void dij(int n,ArrayList<ArrayList<Node>> adj,int s) {
		int[] dis=new int[n];
		for(int i=0;i<n;i++) {
			dis[i]=Integer.MAX_VALUE;
		}
		dis[s]=0;
		PriorityQueue<Node> pq=new PriorityQueue<>(n, new Node());
		pq.add(new Node(s,0));
		while(!pq.isEmpty()) {
			Node node=pq.remove();
			for(Node it:adj.get(node.getV())) {
				if(dis[node.getV()]+it.getW()<dis[it.getV()]) {
					dis[it.getV()]=dis[node.getV()]+it.getW();
					pq.add(new Node(it.getV(),dis[it.getV()]));
				}
			}
		}
		for(int i=0;i<n;i++) System.out.print(dis[i]+" ");
	}

}
