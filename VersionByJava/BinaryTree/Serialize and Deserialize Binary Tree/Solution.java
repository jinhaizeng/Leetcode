/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//方法一：这个是利用层次遍历做序列化和反序列化
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //先写出终止条件
        if(root == null)    return null;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList list = new ArrayList(); 
        que.offer(root);
        while(!root.isEmpty()){
            TreeNode temp = que.poll();
            if(temp.left != null) que.offer(temp.left);
            if(temp.right != null) que.offer(temp.right);
            list.add(temp.val);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//方法二：大佬的方法，主要是没有大佬那样的思维方式：

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
    String strNull = "NN";
    String strSplit = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        StringBuild(root,str);
        return str.toString();
    }
    public void StringBuild(TreeNode root, StringBuilder str){
        
        if(root == null)
            str.append(strNull).append(strSplit);
        else{
            str.append(root.val).append(strSplit);
            StringBuild(root.left,str);
            StringBuild(root.right,str);
        }
       
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deq = new LinkedList<>();
        deq.addAll(Arrays.asList(data.split(strSplit)));
        return treeBulid(deq);
    }
    public TreeNode treeBulid(Deque<String> deq){
        String val = deq.remove();
        if(val.equal(strNull)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = treeBulid(deq);
        root.right = treeBulid(deq);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));