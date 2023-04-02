package my.study.coder.path.leetcode;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("010", "010"));
        System.out.println(addBinary("0", "0"));
        System.out.println(addBinary("101", "11"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
