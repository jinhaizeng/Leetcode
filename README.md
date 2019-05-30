本篇Readme则是leetcode正式刷题的开始，按照老惯例，主要由两部分组成，第一部分是OJ题对应的链接，第二部分则是本道题目主要的算法思路  




|    ID          |      Title      |    Difficulty  |         Java            |
| :------------: | :-------------: | :------------: | :---------------------: |
| 001 | [Two Sum](https://leetcode.com/problems/two-sum/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/leetcode%E6%AD%A3%E5%BC%8F%E9%A2%98/Two%20Sum/Solution.java) |
| 002 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | Medium | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/leetcode%E6%AD%A3%E5%BC%8F%E9%A2%98/Add%20Two%20Numbers/Solution.java) |
| 003 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/leetcode%E6%AD%A3%E5%BC%8F%E9%A2%98/Longest%20Substring%20Without%20Repeating%20Characters/Solution.java) |


## 001 Two Sum
### 方法一：较笨的方法，利用两层遍历找到这两个元素
这种方法能解决问题，但是方法执行的速度较慢，需要45ms

### 方法二：改进型，一层遍历+map
这个方法只需要2ms  
算法的主要思路：一次遍历，每次遍历结束以后，都将遍历过的元素以键值对的形式存储在Map中，然后拿target-本次遍历到的元素值，该结果如果能够在map找到，就表示这两个元素和就是目标。除此以外，因为本算法要根据数组的值查到到对应的下标，所以应该把数组的值作为key，对应的下标作为value，这样用get方法时，可以直接得到。

## 002 Add Two Numbers
**柳神的方法真的简洁，直接看代码里面的方法三吧**
### 方法一:直接计算
链表取出第一对，计算，大于10则进1，否则不进位，然后依次取出后面的几位，每次计算出的结果的各位放到栈里面，然后出栈和入栈以后就是最后的结果了。  
基本方法写出来了，明天要优化下代码结构，减少无用的臃肿信息，除此以外还需要整理下值传递和引用传递的问题。

### 方法三：柳神的方法
柳神的代码特别简洁，运行的效率要比我的方法一还要快，多学学柳神的解题思路和方法。  
今天学的新手法：对于空结点的处理
```java
ListNode l1;
boolean a = l1 == null;
a? : ;
//递归的时候用如上方法既简洁又高效
```


## 003 Longest Substring Without Repeating Characters
### 方法一：leetcode官方的第一个方法，算法时间复杂度比较高，不推荐
本算法一开始并没有得出最后的算法思路，是看的leetcode的solution才有的思路。思路如下：将算法分成两个部分，第一个部分是检查子串中是否有重复元素，第二个部分是枚举出所有的子串依次放到第一个部分中。  
检查子串部分的算法实现可以使用set，利用set不存储重复元素的性质来解决问题。 


### 方法二：大佬的解题思路
算法从左至右开始寻找不重复子串，可以用两个指针i、j，i指向不重复子串的头（用一个变量存储最大长度），j指向不重复子串的尾，最开始的时候子串为空，然后j向右移动，此时会出现两种情况：
* j目前指向的元素在子串中没有，那么直接添加进来，如果当前子串长度>最长子串的长度，那么就更新最长子串的长度
* 如果j目前指向的元素在子串中有，那么为了保证算法的核心，指针i就一定要从这个重复的元素的下一个开始，保证这个子串中没有该元素，否则后面的运算都不能添加该子串了。  
为了方便进行指针i的重定位，考虑使用键值对的方法（map），通过get操作或者重复元素的位置  
map的put函数有个小特性：如果是重复添加键值对，即key已经存在了，则直接减value更新至最新即可。（多去查查oracle的库，没坏处） 

### 方法三：柳神的思路，没看懂，要重写