//方法一：二维动态数组解决法
public class Solution {
    public String convert(String s, int numRows) {
        //首先检查是否null和为空，节省时间，提高函数执行效率
        if(s == null || s == "")
            return "";
        //特殊情况，如此处理有两个原因：
        //第一个原因：当numRows==1时，2*numRows-2=0，会出现除数为0的情况
        //第二个原因：只有一行，那么就是最后的结果，没必要在生成二维数组，加载再导出这样复杂的操作，太浪费时间
        if(numRows == 1)
            return s;
        List<List<String>> arr = new ArrayList<List<String>>();
        for(int i = 0; i < numRows ; ++i){
            List<String> row = new ArrayList<String>();
            arr.add(row);
        }
        for(int i = 0 ; i < s.length() ; ++i){
            int index = i % (2*numRows-2);
            if(index < numRows)
                arr.get(index).add(s.substring(i,i+1));
            else
                arr.get(2*numRows-2-index).add(s.substring(i,i+1));


        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < numRows ; ++i){
            for(int j=0; j < arr.get(i).size(); ++j){
                sb.append(arr.get(i).get(j));
            }
        }
    return sb.toString();
    }
}


// 方法二：一维StringBuilder类型的数组
//直接copy过来的代码，自己没有重写，有时间要重写额
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}