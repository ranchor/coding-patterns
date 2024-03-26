/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> output = new ArrayList<>();
        if(root==null || target==null || k<0) return output;

        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        preOrder(root, map);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);
        
        Set<TreeNode> visitedNodes = new HashSet<>();
        visitedNodes.add(target);
        // // map = {3->{5, 1}, 5->{3, 6, 2}, 1->{3, 0, 8}, 6->{5}, 2->{5, 7, 4}, 7->{2}, 4->{2}}
        // queue = {3, 6, 2}
        // size=1
        // k=1
        if(k==0 && map.containsKey(target.val)) {
            output.add(target.val);
            return output;
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            k--;
            for(int index=0;index<size;index++) {
                int value = queue.poll();
                List<TreeNode> children = map.get(value);
                if(children!=null && children.size()>0) {
                    for(TreeNode child:children) {
                        if(!visitedNodes.contains(child)) {
                            queue.add(child.val);
                            if(k==0) {
                                output.add(child.val);
                            }
                            visitedNodes.add(child);
                        }
                        
                    }
                }
                
            }

            if(k==0) {
                break;
            }
        }

        return output;
        
    }


    
    void preOrder(TreeNode curr, HashMap<Integer, List<TreeNode>> map) {
        if(curr==null) return;
        List<TreeNode> values = map.computeIfAbsent(curr.val, k -> new ArrayList<>());

        if(curr.left!=null) {
            values.add(curr.left);
            map.computeIfAbsent(curr.left.val, k ->new ArrayList<>()).add(curr);

        } 

        if(curr.right!=null) {
            values.add(curr.right);
            map.computeIfAbsent(curr.right.val, k ->new ArrayList<>()).add(curr);
        } 

        preOrder(curr.left, map);
        preOrder(curr.right, map);
    }
}