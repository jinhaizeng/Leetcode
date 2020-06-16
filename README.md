# Tips: Array
|    ID          |      Title      |    Difficulty  |         Java            |
| :------------: | :-------------: | :------------: | :---------------------: |
| 011 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Easy | [Java](https://github.com/jinhaizeng/Leetcode/blob/master/Version%20By%20Java/leetcode%E6%AD%A3%E5%BC%8F%E9%A2%98/Two%20Sum/Solution.java) |

### Container With Most Water
#### My Solution
算法的核心在于最短的那根线，即短板理论
1. 从两侧往中间遍历
2. 每次向内移动后，左右边界取最小值往内遍历，确保最短的板永远被更新，否则存储的水只会越来越少
3. 每次向内移动都要对比if pre > now ,now = pre

边界条件：左游标>=右游标
