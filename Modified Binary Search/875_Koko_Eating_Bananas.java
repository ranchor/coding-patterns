class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = findMax(piles), mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (speedCheck(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean speedCheck(int[] piles, int value, int h) {
        int maxHour = 0;
        for (int pile : piles) {
            maxHour += Math.ceil((double) pile / value);
            if (maxHour > h) {
                return false;
            }
        }
        return true;
    }

    int findMax(int[] piles) {
        int max = 0;
        for (int index = 0; index < piles.length; index++) {
            max = Math.max(piles[index], max);
        }
        return max;
    }
}