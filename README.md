本篇Readme则是leetcode正式刷题的开始，按照老惯例，主要由两部分组成，第一部分是OJ题对应的链接，第二部分则是本道题目主要的算法思路  
|    ID          |      Title      |    Difficulty  |         Java            |
| :------------: | :-------------: | :------------: | :---------------------: |
| 001 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Preorder%20Travel/Solution.java) |
| 002 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | Medium | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/BinaryTree/Preorder%20Travel/Solution.java) |
## 001 Two Sum
### 方法一：较笨的方法，利用两层遍历找到这两个元素
这种方法能解决问题，但是方法执行的速度较慢，需要45ms

### 方法二：改进型，一层遍历+map
这个方法只需要2ms  
算法的主要思路：一次遍历，每次遍历结束以后，都将遍历过的元素以键值对的形式存储在Map中，然后拿target-本次遍历到的元素值，该结果如果能够在map找到，就表示这两个元素和就是目标。除此以外，因为本算法要根据数组的值查到到对应的下标，所以应该把数组的值作为key，对应的下标作为value，这样用get方法时，可以直接得到。

## 002 Add Two Numbers
### 方法一:直接计算
链表取出第一对，计算，大于10则进1，否则不进位，然后依次取出后面的几位，每次计算出的结果的各位放到栈里面，然后出栈和入栈以后就是最后的结果了。  
基本方法写出来了，明天要优化下代码结构，减少无用的臃肿信息，除此以外还需要整理下值传递和引用传递的问题