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
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		List<List<TreeLinkNode>> wrapList = new ArrayList<List<TreeLinkNode>>();
		List<TreeLinkNode> subList = new ArrayList<TreeLinkNode>();
		queue.add(root);
		root.next = null;
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
         subList = new ArrayList<TreeLinkNode>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.remove());
			}
			wrapList.add(subList);
		}

		for (List<TreeLinkNode> list : wrapList) {
			for (int i = 1; i < list.size(); i++) {
				list.get(i - 1).next = list.get(i);
			}
			list.get(list.size() - 1).next = null;
		}

	}

}
