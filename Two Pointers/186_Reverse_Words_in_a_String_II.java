class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1)
            return;

        // Reverse the whole string
        reverse(s, 0, s.length - 1);

        int left = 0, right = 1;
        while (right < s.length) {
            if (s[right] == ' ') {
                reverse(s, left, right - 1);
                while (s[right] == ' ')
                    right++;
                left = right;
            } else {
                right++;
            }
        }

        // [VERY IMPORTANT] to reverse the last word outside the loop.
        reverse(s, left, right - 1);

    }

    void reverse(char[] s, int left, int right) {
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }

    }

    void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}