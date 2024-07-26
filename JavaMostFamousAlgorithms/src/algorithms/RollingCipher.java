public class RollingCipher {
    public static String rcMethod(String str, int n) {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = Character.toLowerCase((char) (i + 65));
        }
        
        int index = n % 26;
        if (n < 0) index = 26 + n;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        
        while (count < 4) {
            ans.append(alphabet[index]);
            index = (index + 1) % 26;
            count++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(rcMethod("example", 3));
    }
}
