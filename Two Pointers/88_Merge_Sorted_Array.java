class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int ptr1 = m - 1;
        int ptr2 = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (ptr2 < 0) {
                break;
            }
            if (ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]) {
                nums1[p] = nums1[ptr1--];
            } else {
                nums1[p] = nums2[ptr2--];
            }
        }

    }
}