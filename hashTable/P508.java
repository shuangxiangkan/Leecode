package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class P508 {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(2);
		root.right=new TreeNode(-5);
		
		P508 p=new P508();
		int[] results=p.findFrequentTreeSum(root);
		for (int i : results) {
			System.out.println(i);
		}
	}
	Map<Integer, Integer> map;
	public int count(TreeNode root) {
		if(root==null)
			return 0;
		int num=root.val+count(root.left)+count(root.right);
		int count=map.getOrDefault(num, 0)+1;
		map.put(num, count);
		return num;
	}
	public int[] findFrequentTreeSum(TreeNode root) {
		map=new HashMap<Integer, Integer>();
		count(root);
		int max=Integer.MIN_VALUE;
		for(int i:map.keySet()) {
			if(max<map.get(i))
				max=map.get(i);
		}
		int[] results=new int[map.keySet().size()];
		int index=0;
		for(int i:map.keySet()) {
			if(map.get(i)==max) {
				results[index++]=i;
			}
		}
		return Arrays.copyOfRange(results, 0, index);
    }
}
