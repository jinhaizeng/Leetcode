package zigzag_conversion;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "A";
//        System.out.println(str.substring(13,14));
        String res = sol.convert(str,1);
        System.out.println(res);
    }
}
