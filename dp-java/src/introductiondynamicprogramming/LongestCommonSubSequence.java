package introductiondynamicprogramming;

public class LongestCommonSubSequence {
    static int lcs(String string1, String string2, int n, int m){
        if (n==0 || m==0){
            return 0;
        }

        if (string1.charAt(n-1) == string2.charAt(m-1)){
            return lcs(string1, string2, n-1, m-1) + 1;
        } else {
            int ans1 = lcs(string1, string2, n-1, m);
            int ans2 = lcs(string1, string2, n, m-1);
            return Math.max(ans2, ans1);
        }
    }
    public static void main(String[] args) {
        String string1 = "abcdge";
        String string2 = "abedg";
        System.out.println(lcs(string1, string2, string1.length(), string2.length()));

    }
}
