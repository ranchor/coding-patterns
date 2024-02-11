class CustomNode {
    
    Integer hd;
    Node ref;
    
    CustomNode(Integer hd, Node ref) {
        this.hd = hd;
        this.ref = ref;
    }
    
    Integer getKey() {
        return this.hd;
    }
    
    Node getValue() {
        return this.ref;
    }
    
    
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> output = new ArrayList<>();
        if(root==null) return output;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        Queue<CustomNode> queue = new LinkedList<>();
        
        queue.offer(new CustomNode(0, root));
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for(int index=0;index<levelSize;index++) {
                CustomNode p = queue.poll();
                int mark = p.getKey();
                Node curr = p.getValue();
                
                if(curr.left!=null) {
                    queue.offer(new CustomNode(mark-1, curr.left));
                }
                
                if(curr.right!=null) {
                    queue.offer(new CustomNode(mark+1, curr.right));
                }
                
                map.put(mark, curr.data);
            }
            
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            output.add(entry.getValue());
        }
        
        return output;
    }
}