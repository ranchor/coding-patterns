class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        return validPalindromeUtils(s, 0, s.length() - 1, 0);

    }

    boolean validPalindromeUtils(String s, int left, int right, int totalCharacterDeletedSoFar) {
        if (s == null || s.length() <= 1)
            return true;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {

                if (totalCharacterDeletedSoFar >= 1)
                    return false;

                return validPalindromeUtils(s, left, right - 1, totalCharacterDeletedSoFar + 1)
                        || validPalindromeUtils(s, left + 1, right, totalCharacterDeletedSoFar + 1);

            }

            left++;
            right--;

        }
        return true;

    }
}