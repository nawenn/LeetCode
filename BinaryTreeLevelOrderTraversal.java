class Solution {
   public List<List<Integer>> levelOrder(TreeNode root) {
	   //using queue as to temp store node at each level.
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
       if(root == null) return wrapList;
       queue.add(root);
       while(!queue.isEmpty()){
    	   //test to see how many node need to be tested at each level
           int levelNum = queue.size();
           List<Integer> sulist = new LinkedList<Integer>();
           for(int i=0; i< levelNum; i++){
           if(queue.peek().left!=null) queue.add(queue.peek().left);
           if(queue.peek().right!= null) queue.add(queue.peek().right);
           //store each child and delete parent node.
               sulist.add(queue.remove().val);
           }
           wrapList.add(sulist);
       }

       return wrapList;
	    }
	        
    }
