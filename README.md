# Tips: Array
|    ID          |      Title      |    Difficulty  |         Java            |
| :------------: | :-------------: | :------------: | :---------------------: |
| 011 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/leetcode%E6%AD%A3%E5%BC%8F%E9%A2%98/Two%20Sum/Solution.java) |
| 015 | [3Sum](https://leetcode.com/problems/3sum/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/leetcode%E6%AD%A3%E5%BC%8F%E9%A2%98/Two%20Sum/Solution.java) |
| 015 | [3Sum](https://leetcode.com/problems/3sum/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/leetcode%E6%AD%A3%E5%BC%8F%E9%A2%98/Two%20Sum/Solution.java) |

### Container With Most Water
#### My Solution
算法的核心在于最短的那根线，即短板理论
1. 从两侧往中间遍历
2. 每次向内移动后，左右边界取最小值往内遍历，确保最短的板永远被更新，否则存储的水只会越来越少
3. 每次向内移动都要对比if pre > now ,now = pre

边界条件：左游标>=右游标

### 3Sum
#### 直接看的别人的算法
算法可以理解成三个指针的遍历，两个指针还可以借鉴快排的思路，3个就不行了，得固定一个，然后剩下两个用快排的思路去处理
1. 题目的核心：不可以有重复的set，但是一个set内可以有重复的集合
2. 为了方便跳过重复成员，先考虑进行一次排序
3. 排序后第一层遍历firsetIndex
4. 第二次遍历secondIndex和ThirstIndex寻找符合对象的成员
5. 跳过重复对象的思路：
    * firsetIndex要保证他和之前的成员只均不同，因为第二层遍历已经把firsetIndex为该值的所有情况都遍历出结果了
    * secondIndex和ThirdIndex每次移动后都要与之前的值不一样，否则第二层遍历出来的结果都是相同的。也就有的自加自减前的跳过相同项
