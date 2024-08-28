public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));

    }

    public static boolean isPalindrome(String s) {
        boolean isValid = true;

        String cleanString = preProcessString(s);

        for (int i = 0, j = cleanString.length() - 1; i < j; i++, j--) {
            if (cleanString.charAt(i) != cleanString.charAt(j)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static String preProcessString(String s) {
        StringBuilder cleanedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isNumber(s.charAt(i)) || isLowerCase(s.charAt(i))) {
                cleanedString.append(s.charAt(i));
            } else if (isUpperCase(s.charAt(i))) {
                cleanedString.append((char) (s.charAt(i) + 32));
            }
        }
        return cleanedString.toString();
    }

    public static boolean isLowerCase(char c) {
        int convertedToInt = (int) c;
        return convertedToInt >= 97 && convertedToInt <= 122;

    }

    public static boolean isUpperCase(char c) {
        int convertedToInt = (int) c;
        return convertedToInt >= 65 && convertedToInt <= 90;

    }

    public static boolean isNumber(char c) {
        int convertedToInt = (int) c;
        return convertedToInt >= 48 && convertedToInt <= 57;
    }

}
