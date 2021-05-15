package graphs;
import java.util.ArrayList;
public class StoreNodes {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> al=new ArrayList<>();
		for(int i=0;i<=5;i++)
			al.add(new ArrayList<>());
		al.get(1).add(2);
		al.get(1).add(3);
		System.out.println(al);
	}

}
