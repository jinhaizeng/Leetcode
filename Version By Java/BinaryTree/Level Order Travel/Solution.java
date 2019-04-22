/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 第一种方法，采用队列实现的BFS
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //创建一个嵌套list，当做返回值
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        //创建一个TreeNode类型的队列，用队列实现二叉树的层次遍历（即BFS），方便二叉树节点的插入队和出队
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        //存储出队的对象的临时对象
        TreeNode temp = new TreeNode(0);            //TreeNode这个类只有有参的构造方法，如果使用午餐构造会直接报错
        
        if(root == null )   return list;
        que.offer(root);
        //循环终止条件
        while(!que.isEmpty()){
            //重中之重：levelnum用来记录该层的元素的个数，方便在该层进行遍历
            int levelNum = que.size();
           //level用来存储一层中的节点的值
            List<Integer> level = new LinkedList<Integer>();
            for(int i=0; i < levelNum; ++i){
                //队首元素出队
                temp = que.poll();
                if(temp.left != null)   que.offer(temp.left);
                if(temp.right != null)  que.offer(temp.right);
                //将在该层中的元素加进去
                level.add(temp.val);
                
            }
            list.add(level);
        }
        return list;
    }
}
/**
 * 第二种方法，直接使用DFS，但是在入口参数那边要加一个层数，这样遍历的时候，根据层数添加到对应的嵌套list
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //注意双层嵌套的list写法，在readme中有写明
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        levelHelper(root,list,0);
        return list;
    }
    //一定要注意入口参数部分，用height来表明遍历到哪一层
    public void levelHelper(TreeNode root,List<List<Integer>> list,int height){
        if(root == null)    return;
        // 注意对于嵌套list的size(),他计算的是第一层嵌套的内的个数
        if(height >= list.size())
            list.add(new LinkedList<Integer>());
        list.get(height).add(root.val);
        if(root.left != null)   levelHelper(root.left,list,height+1);
        if(root.right != null)  levelHelper(root.right,list,height+1);
    }
}