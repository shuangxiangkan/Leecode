package twoPointers;

public class P26 {
	public static void main(String[] args) {
		int[] tree= {3,3,3,1,2,1,1,2,3,3,4};
		P904 p=new P904();
		System.out.println(p.totalFruit(tree));
	}
	public int totalFruit(int[] tree) {
		int begin=0,end=0;
		int ans=0;
		for(int i=1;i<tree.length;i++) {
			if(tree[i]!=tree[begin]) {
				end=i;
				break;
			}
		}
		if(end==tree.length)
			return tree.length;
		for(int i=end+1;i<tree.length;i++) {
			if(tree[i]!=tree[begin]&&tree[i]!=tree[end]) {
				ans=Math.max(ans, i-begin);
				begin=end-1;
				end=i;
				while(begin>=0) {
					if(tree[begin]==tree[--begin]);
				}
			}
		}
		return Math.max(ans,end-begin);
	}
}
