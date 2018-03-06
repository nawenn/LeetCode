import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
			return result;
		}
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
        	int n =queue.size();
        	subList = new ArrayList<>();
        	for(int i = 0; i<n;i++){
        		if(queue.peek().left!= null) queue.add(queue.peek().left);
        		if(queue.peek().right != null) queue.add(queue.peek().right);
        		//if level is marked as reverse
        		if(level%2==0){
        			//always insert in to beginning of the list
        			subList.add(0, queue.poll().val);
        		}else{
        			subList.add(queue.poll().val);
        		}
        	}
        	level++;
        	result.add(subList);
        }
		return result;
    }

}