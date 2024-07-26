package algorithms;

import java.util.function.Predicate;

public class BruteForceAlgo {

    @FunctionalInterface
    public interface BruteForceTest {
        boolean test(char[] testChars);
    }

    public static boolean bruteForce(String testChars, int startLength, int endLength, BruteForceTest testCallback) {
        for (int len = startLength; len <= endLength; ++len) {
            char[] chars = new char[len];

            for (int i = 0; i < len; ++i) {
                chars[i] = testChars.charAt(0);
            }

            if (testCallback.test(chars)) {
                return true;
            }

            outerBreak:
            for (int i1 = len - 1; i1 > -1; --i1) {
                int i2 = 0;

                for (i2 = testChars.indexOf(chars[i1]) + 1; i2 < testChars.length(); ++i2) {
                    chars[i1] = testChars.charAt(i2);

                    if (testCallback.test(chars)) {
                        return true;
                    }

                    for (int i3 = i1 + 1; i3 < len; ++i3) {
                        if (chars[i3] != testChars.charAt(testChars.length() - 1)) {
                            i1 = len;
                            break outerBreak;
                        }
                    }
                }

                if (i2 == testChars.length()) {
                    chars[i1] = testChars.charAt(0);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BruteForceTest testCallback = (char[] testChars) -> {
            String str = new String(testChars);
            return "bbc".equals(str);
        };

        boolean result = bruteForce("abcde", 1, 5, testCallback);
        System.out.println(result);
    }
}
