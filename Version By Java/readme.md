**本篇markdown主要来记录下自己刷leetcode的一点反思**
## Binary Tree章节做的题目
### 1. Binary Tree Preorder Travel
#### 1.1 方法一：递归法，使用list作为返回值
采用递归的方法实现先序遍历  
代码实现如下：  
```java
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if(root == null)    //递归循环终止条件（这个是重中之重，老是容易被忽略）
            return pre;
        //从递归的角度看整个函数，根节点加入List，再左子树加入List，最后右子树加入List
        pre.add(root.val);
        pre.addAll(preorderTraversal(root.left));
        pre.addAll(preorderTraversal(root.right));
        return pre;
    }
}
```
有三个小点需要注意：  
* 1. 遍历需要返回的对象是List（列表），所以需要创建一个List的对象，后面好返回
* 2. 注意采用递归方法的时候一定要注意，想清楚递归的终止条件到底是什么
* 3. 注意先序遍历的思想核心是：先访问根节点，然后访问左子树，然后右子树，本题添加根节点到list没什么大问题，但是对于左右子树而言，他们添加的时候就是一个已经遍历完成的list了，所以应该采用的方法是`.addALL()`，而不是简单的`.add()`（`.add()`是向集合中添加一个元素，`.addALL()`是向集合中添加一个集合）

## 2. Binary Tree Inorder Travel
递归的思路和1. Binary Tree Preorder Travel相同，故此省略

## 3. Binary Tree Postoreder Travel
递归的思路和1. Binary Tree Preorder Travel相同，故此省略

## 4. Binary Tree Level Order Travel
本题一刷的时候主要的难点在于：怎么辨别操作在哪一层
初步想到的方法：
* BFS，用队列实现，但是一定要注意打标签的问题，就是打上层数的问题
* DFS，直接用先序遍历的思路实现二叉树的DFS，但是一定要注意入口参数那边一定要加上层数，这样遍历的时候才知道谁是哪一层的  
一定要注意本题返回值类型为`List<List<Integer>>`,对于这种类型的实例化只能使用以下两种方法，**要点：泛类的类型参数必须相同！！！**：
    1. 方法一：
    ```java
    List<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
    或
    List<List<Integer>> list = new LinkedList<List<Integer>>();
    ```
    2. 方法二
    ```java
    ArrayList<ArrayList<Integer>> = new ArrayList<ArrayList<Integer>>();
    或
    LinkedList<LinkedList<Integer>> = new LinkedList<LinkedList<Integer>>();
    ```
## 方法一：采用BFS实现直接形式的层次遍历
此处有几个注意事项：
* 判断队列是否为空:`queue.isEmpty()`
* 判断元素在哪一层，怎么保证每一层元素都被准确遍历到。这个用到了`queue.size()`
* 本题的返回值是`List<List<Integer>>`，注意每一层的元素会组成一个List，然后每一个List再添加进一个List，就变成了一个双层嵌套的List。所以算法的思路很清晰了，就是遍历到该层的所有元素然后加入一个List，将所有的List再加入一个大的List。
## 方法二：采用DFS（代码形式就是先序遍历的形式）
利用好levelhelper这个函数，通过在入口函数添加一个参数height，来表明遍历到哪一层了。
```java
if(height >= list.size())
    list.add(new LinkedList<Integer>());
```
这句话很关键，list里面行不足的话，再使用`list.get(行号).add(数据)`是会报错的，所以一定要在不足的时候添加行号。