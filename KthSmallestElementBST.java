class Solution {
     public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		if(root!= null){
		    inorder(root,list);
		}else{
		    return 0;
		}
			return list.get(k-1);
		}
     //inorder travsal which sorts all node by their value.
     //inorder (left, root, right)
	public void inorder(TreeNode root, List<Integer> list){
		if(root.left != null){
		    inorder(root.left, list);
		}
		    list.add(root.val);
		if(root.right != null){
		    inorder(root.right, list);
		}
	}    

}