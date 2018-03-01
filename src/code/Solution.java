package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		//add queue to store node at each level
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		//all list to store all of the node and group by level
		List<List<TreeLinkNode>> wrapList = new ArrayList<List<TreeLinkNode>>();
		List<TreeLinkNode> subList = new ArrayList<TreeLinkNode>();
		queue.add(root);
		root.next = null;
		while (!queue.isEmpty()) {
			//declare how many node to test at each level
			int levelNum = queue.size();
			subList = new ArrayList<TreeLinkNode>();
			for (int i = 0; i < levelNum; i++) {
				//see if each node has child
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				//add child node and delete parent node
				subList.add(queue.remove());
			}
			wrapList.add(subList);
		}

		//go through all of the node and connect them by level
		for (List<TreeLinkNode> list : wrapList) {
			for (int i = 1; i < list.size(); i++) {
				list.get(i - 1).next = list.get(i);
			}
			//if last node is reached, set its next pointer to null
			list.get(list.size() - 1).next = null;
		}

	}

}
