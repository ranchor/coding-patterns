/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {

        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        int mid;
        int value = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            value = reader.get(mid);
            if (value == target) {
                return mid;
            } else if (value > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;

    }
}