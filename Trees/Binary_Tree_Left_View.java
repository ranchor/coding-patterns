class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> output = new ArrayList<>();
        if(root==null) return output;

       
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int index=0; index<size; index++) {
                Node curr = queue.poll();
                if(curr.left!=null) {
                    queue.offer(curr.left);
                }
                if(curr.right!=null) {
                    queue.offer(curr.right);
                }

                if(index==0) {
                    output.add(curr.data);
                }
            }
        }

        return output;
    }
}