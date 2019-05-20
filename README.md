本篇由两部分组成第一部分是OJ题对应的链接，第二部分是OJ题的解题思路  


|    ID          |      Title      |    Difficulty  |         Java            |
| :------------: | :-------------: | :------------: | :---------------------: |
| Binary Tree001 | [Preorder Travel](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Preorder%20Travel/Solution.java) |
| Binary Tree002 | [Inorder Travel](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Inorder%20Travel/Solution.java) |
| Binary Tree003 | [Postorder Travel](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Postorder%20Travel/Solution.java) |
| Binary Tree004 | [Level-order Travel](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Level%20Order%20Travel/Solution.java) |
| Binary Tree005 | [Maximum Depth of Binary Tree](https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Maxium%20Depth%20of%20Binary%20Tree/Solution.java) |
| Binary Tree006 | [Symmetric Tree](https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Symmetric%20Tree/Solution.java) |
| Binary Tree007 | [Path Sum](https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Path%20Sum/Solution.java) |
| Binary Tree008 | [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Construct%20Binary%20Tree%20from%20Inorder%20and%20Postorder%20Traversal/Solution.java) |
| Binary Tree009 | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/943/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Construct%20Binary%20Tree%20from%20Preorder%20and%20Inorder%20Traversal/Solution.java) |









-------------------------------------------
**以下部分markdown主要来记录下自己刷leetcode的一点反思**
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

### 2. Binary Tree Inorder Travel
递归的思路和1. Binary Tree Preorder Travel相同，故此省略

### 3. Binary Tree Postoreder Travel
递归的思路和1. Binary Tree Preorder Travel相同，故此省略

### 4. Binary Tree Level Order Travel
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
#### 方法一：采用BFS实现直接形式的层次遍历
此处有几个注意事项：
* 判断队列是否为空:`queue.isEmpty()`
* 判断元素在哪一层，怎么保证每一层元素都被准确遍历到。这个用到了`queue.size()`
* 本题的返回值是`List<List<Integer>>`，注意每一层的元素会组成一个List，然后每一个List再添加进一个List，就变成了一个双层嵌套的List。所以算法的思路很清晰了，就是遍历到该层的所有元素然后加入一个List，将所有的List再加入一个大的List。
#### 方法二：采用DFS（代码形式就是先序遍历的形式）
利用好levelhelper这个函数，通过在入口函数添加一个参数height，来表明遍历到哪一层了。
```java
if(height >= list.size())
    list.add(new LinkedList<Integer>());
```
这句话很关键，list里面行不足的话，再使用`list.get(行号).add(数据)`是会报错的，所以一定要在不足的时候添加行号。

### 5 Maxium Depth of Binary Tree
本题拿到手首先的思路是前面四种遍历算法都行，那个临时遍历存储深度，如果比他大就更新，最后返回结果就好了。  
其他的遍历方法也可以直接拿来用，没什么大的问题，都是套壳子。  
**我想出来的方法还是太复杂了，leetcode上面大佬写的代码确实简洁。。。**

### 6.Symmetric Tree
本题实质是判断一个颗树是不是对称树。  
一刷时的初步思路：采用BFS,每一层遍历的时候存到一个数组里面，看是不是对称的。即逐层遍历是否对称  
[本题大佬的代码](https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/discuss/33054/Recursive-and-non-recursive-solutions-in-Java)  

### 7.Path Sum
一刷遇到的问题，就是递归的终止条件怎么写

#### 方法二：递归（网上大神些的代码）
使用递归的思路解决问题，初步整理的算法思路是这样的。提炼下函数功能：就是判断这颗树里面里有没有满足sum值的一条路径。  
整个算法的思路是自顶而下的。
1. 将二叉树抽象成三个部分：根节点、左子树和右子树
2. 思考递归终止条件，函数运行到这一层就代表了之前所有的递归的结果都是false，那么如果这个节点为空，那么整个二叉树肯定不存在这个路径
3. 接下来就是判断是否存在这么一个路径，因为是自顶向下的判断思路，上一层判断结束的话，往下判断是否存在这个路径，那么就要减去这个节点，再往下遍历该节点的左右子树，那么自顶向下的过程就是sum不断减去上一个节点。由此可以得出存在这么一个路径的判定方式：节点的左子树和右子树都为空并且sum被减至零。
4. 该节点遍历结束了，接下来就是递归结果他的左右子树了，下来来辨析下我之前的解法思路（即为什么会得不出想要的结果）  
我之前想用DFS直接暴力的解决这个问题的，以下是我最开始的思路：
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return root!=null && hasPathSumHelper(root,sum,0);
    }
    public boolean hasPathSumHelper(TreeNode root , int sum, int presentSum){
        
        presentSum += root.val;
        if(root.left == null && root.right == null){
            if(presentSum == sum)
                return true;
            
        }
        
        if(root.left != null) hasPathSumHelper(root.left,sum,presentSum);
        if(root.right != null) hasPathSumHelper(root.right,sum,presentSum);
        return false;
        
    }
}
```
如果采用上述的算法的话，一味的往深度的方向走，那么走到叶子节点的时候，必须要返回到上一层，那么此时就会出现一个问题。如果到了这个节点，sum被减至零，那么直接`return true`那么没什么大问题，但是如果sum没有被减至零，那么`return false`就出现问题了，因为你没有遍历完其他的路径，就直接flase是一直不负责的遍历算法。  
那么如何改善这个问题呢，我从网上看到了其他大神的代码：
```java
class Solution{
    public boolean hasPathSum(TreeNode root, int sum){
        if(root == null)    return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
```
核心部分的代码`return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);`,这段代码核心部分这个||是关键，就是在递归过程中，只要有一个结果是true，那么最外层return的就是true。如果用我第一次写出来的思路，就无法实现这么个功能。

### 8. Construct Binary Tree from Inoder and Postorder
[相关知识链接](https://blog.csdn.net/u011068702/article/details/51914220)  
本题的相关理解方式直接看第九题  
注意理解整个递归的思想，比如
```java
root.left = buildTreeHelp(in,inStart,i-1,post,postStart,postStart+i-inStart-1);
root.right = buildTreeHelp(in,i+1,inEnd,post,postStart+i-inStart,postEnd-1);
```
这个就是典型的递归的思想，把整个函数理解成返回整颗子树，然后就可以递归的得到根节点的左子树和右子树。

### 9. Construct Binary Tree from Preorder and Inorder Traversal
本地关键点：
1. 中序遍历由于其特性，输出序列可以根据根节点划分，根节点左边的序列在根节点的左子树上，根节点右边的序列在根节点的右子树上。
2. 三种遍历方法利用其中的两种然后建立一个二叉树，那么一定要有中序遍历，因为中序遍历可以利用根节点很自然的将序列划分成两部分，根节点的左边是左子树，根节点的右边为右子树。
相关知识点的总结归纳：
已知前序、中序遍历，求后序遍历  
利用其前序遍历性质来解决问题，前序遍历首先访问的是根节点，得到根节点以后，利用中序遍历的性质：左子树——根节点——右子树，在得到根节点以后，利用中序遍历的序列，可以将原序列划分为左子树，根节点，右子树，然后再分别对左右子树进行如上的操作就可以直接得到整棵树了。  
由此我们可以得到以上逻辑思路：  
    1. 确定根，确定左右子树
    2. 在左子树中递归
    3. 在右子树中递归
    4. 打印当前根

### 10. Populating Next Right Pointers in Each Node
看到同一层之间的操作首先想到的是层次遍历，然后按层填充next这个指针就可以了，接下来思考下有没有更简单的实现方法  
更简单的解决问题的方法，从“Symmetric Tree”这个问题得到了启发，对于这种按层进行操作的递归方法，应该从左右子树的根节点开始考虑问题，
但是具体的解题思路还是没有理清楚，在此处留个坑位  
看本题的input和output看错了，一定要注意id只是个编号，而val才是真正二叉树的值，对应图中树节点的数字  
**第一次按照递归的思路瞎鸡儿写，还AC了，开心，哈哈哈哈**


### 11. Populating Next Right Pointers in Each Node II
本题由10题给出的思路，初步想出了增加判定条件的解决方案，即判断右子树是否存在，不存在就不递归了，找到存在的那个。初步想出的这个思路没用！  
再次思考下：决定用BFS，其实也就是层次遍历的方法，用队列来实现，每次就直接入队和出队，**但是还有个问题没有解决：我怎么知道我遍历到哪一层了呢——这个是基础题，知识点又遗忘了，回头看第四题**  
**会看第四题，判定层数的方式：取该层的大小，就可以得出该层的数目了，即该层拥有的元素个数。**  
使用BFS，利用pre和now来相邻的两个节点的对象地址，然后依次赋值即可

## 补充知识点：
### 1. 递归
#### 1.1 欧几里得算法，又被称为辗转相除法。
![欧几里得算法的实例](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/%E5%9B%BE%E5%BA%8A/%E6%AC%A7%E5%87%A0%E9%87%8C%E5%BE%97%E7%AE%97%E6%B3%95.png?raw=true)



### 1.2递归的思想
递归和循环的例子  
**递归**：你打开面前这扇门，看到屋里面还有一扇门（这门可能跟前面打开的门一样大小（静），也可能门小了些（动）），你走过去，发现手中的钥匙还可以打开它，你推开门，发现里面还有一扇门，你继续打开，。。。， 若干次之后，你打开面前一扇门，发现只有一间屋子，没有门了。 你开始原路返回，每走回一间屋子，你数一次，走到入口的时候，你可以回答出你到底用这钥匙开了几扇门。  
**循环**：你打开面前这扇门，看到屋里面还有一扇门，（这门可能跟前面打开的门一样大小（静），也可能门小了些（动）），你走过去，发现手中的钥匙还可以打开它，你推开门，发现里面还有一扇门，（前面门如果一样，这门也是一样，第二扇门如果相比第一扇门变小了，这扇门也比第二扇门变小了（动静如一，要么没有变化，要么同样的变化）），你继续打开这扇门，。。。，一直这样走下去。 入口处的人始终等不到你回去告诉他答案。  
**总结：递归就是有去（递）有回（归）**  
**为什么可以“有去”**  
这要求递归的问题需要是可以用同样的解题思路来回答除了规模大小不同其他完全一样的问题。  
**为什么可以“有回”**  
这要求这些问题不断从大到小，从近及远的过程中，会有一个终点，一个临界点，一个baseline，一个你到了那个点就不用再往更小，更远的地方走下去的点，然后从那个点开始，原路返回到原点。  
**递归的思想：**  
递归的基本思想是把规模大的问题转化为规模小的相似的子问题来解决。在函数实现时，因为解决大问题的方法和解决小问题的方法往往是同一个方法，所以就产生了函数调用它自身的情况。另外这个解决问题的函数必须有明显的结束条件，这样就不会产生无限递归的情况了。  
需要注意的是，规模大转化为规模小是核心思想，但递归并非是只做这步转化，而是把规模大的问题分解为规模小的子问题和可以在子问题解决的基础上剩余的可以自行解决的部分。而后者就是归的精髓所在，是在实际解决问题的过程。  
所以递归的三要素:递+结束条件+归，注意写递归一定不要忘记结束条件，反正程序就跑死了