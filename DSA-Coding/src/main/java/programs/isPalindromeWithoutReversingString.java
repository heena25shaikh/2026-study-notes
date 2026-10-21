package programs;


import java.util.stream.IntStream;

/**
 *
 * Deloitte
 * Q49. How can we check if a given string is a palindrome using Java 8 Streams,
 * without explicitly reversing the string?
 *
 */

public class isPalindromeWithoutReversingString {

    public static void main(String[] args) {

        //String str = "12345";  //false
        String str = "12321";  //true

        System.out.println("isStringPalindrome : : " + isStringPalindrome(str));
    }

    public static boolean isStringPalindrome(String str) {

        if (str.isEmpty() || str == null){
            return false;
        }

        return IntStream.range(0,str.length()/2).allMatch(i ->str.charAt(i)
                == str.charAt(str.length()-i-1));

    }
}

/**
 * Interview Answer
 *
 * "Instead of reversing the string, I use IntStream.range() to iterate over the first half
 * of the string and compare each character with its corresponding character from the end using allMatch(). This avoids creating
 * an extra string and checks the palindrome in O(n) time and O(1) extra space."
 */
