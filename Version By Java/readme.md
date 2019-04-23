本篇由两部分组成第一部分是OJ题对应的链接，第二部分是OJ题的解题思路  
| ID | Title | Difficulty | Java |
| :--------: | :------: | :---------: | :-------: |
| Binary Tree001 | Preorder Travel |  1 | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Preorder%20Travel/Solution.java) |



|  ID  |                            Title                             | Difficulty |                             Java                             |                            Python                            |                             Ruby                             |                     C++                      |                     Swift                      |
| :--: | :----------------------------------------------------------: | :--------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :------------------------------------------: | :--------------------------------------------: |
| 001  |      [Two Sum](https://leetcode.com/problems/two-sum/)       |    Easy    | [Java](https://github.com/corpsepiges/leetcode/blob/master/Algorithms/001.%20Two%20Sum/Solution.java) | [Python](https://github.com/corpsepiges/leetcode/blob/master/Algorithms/001.%20Two%20Sum/Solution.py) | [Ruby](https://github.com/corpsepiges/leetcode/blob/master/Algorithms/001.%20Two%20Sum/Solution.rb) | [C++](http://www.liuchuo.net/archives/1006)  |                       no                       |

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