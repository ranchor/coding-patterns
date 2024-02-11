/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //1,2,None,None,3,4,None,None,5,None,None,
    private void serializeHelper(TreeNode root, StringBuffer sb) {
        if(root==null) {
            sb.append("null,");
            return;
        }
        
        sb.append(""+root.val+",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer output = new StringBuffer();
        serializeHelper(root, output);
        return output.toString();
    }

    // [1,2,None,None,3,4,None,None,5,None,None]
    private TreeNode deserializeHelper(List<String> values) {
        if(values==null || values.size()==0){
            return null;
        }
        
        String currValue = values.remove(0);
        if(currValue.equals("null")) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(currValue));
        newNode.left = deserializeHelper(values);
        newNode.right = deserializeHelper(values);
        return newNode;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values= data.split(",");
        TreeNode root = deserializeHelper(new ArrayList<>(Arrays.asList(values)));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));