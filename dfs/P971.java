package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P971 {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		int[] voyage= {2,1};
		
		P971 p=new P971();
		List<Integer> list=p.flipMatchVoyage(root, voyage);
		for (int i : list) {
			System.out.println(i);
		}
	}
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		List<Integer> list=new ArrayList<>();
		
		int index=0;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode p=root;
		while(p!=null||!stack.isEmpty()) {
			if(p!=null) {
				//��ǰ����������ǰ�ڵ�
				//��ǰ�ڵ㲻����voyage[index]��ֵ�����ܷ�ת������-1
				//����indexָ��voyage����һ��ֵ���ȴ���һ�εıȽ�
				if(p.val!=voyage[index]) {
					list.clear();
					list.add(-1);
					break;
				}else {
					index++;
				}
				stack.push(p);
				
				//��Ϊÿһ���ڵ��ֵ����ͬ
				//ֻ�е������ӽڵ㶼��Ϊ�գ����������ڵ����voyage[index]ʱ��������ǰ�ڵ�������ӽڵ㡣
				//���ӽڵ㲻���ж�ֵ�Ƿ���ȣ���Ϊ������һ�α����ж�(if(p.val!=voyage[index])).
				//���ӽڵ�Ϊ��ʱ����һ�α��������������ӽڵ㣬���Ҳ�����������ж�.
				if(p.left!=null&&p.right!=null&&p.right.val==voyage[index]) {
					list.add(p.val);
					TreeNode swap=p.right;
					p.right=p.left;
					p.left=swap;
				}
				//ǰ�������ָ�����ӽڵ�
				p=p.left;
				
			}
			else {
				p=stack.pop().right;
			}
		}
		return list;
    }
}
