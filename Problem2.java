/**
 * take the str parameter being passed, which will be a positive 
 * integer, take its binary representation, reverse that 
 * string of bits, and then finally return the new reversed string 
 * in decimal form.
 * @author Siyang Wu
 */
public class BinaryReversal {
    public static int binaryReversal(String str) {
        int num = Integer.parseInt(str);
        // 8-bit binary 
        int[] b = new int[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i ++) {
            b[i] = (num % 2) | 0 ; // XNOR
            num = num / 2;
            sb.append(b[i]);
        }
        // System.out.println(sb.toString());
        int res = Integer.parseInt(sb.toString(), 2);
        return res;
    }
    public static void main(String[] args) {
        String s = "47";
        int res = binaryReversal(s);
        System.out.println(res);
    }
}
