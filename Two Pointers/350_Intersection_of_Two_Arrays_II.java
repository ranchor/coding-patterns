class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0) return nums2;
        else if(nums2.length==0) return nums1;

        int ptr1=0;
        int ptr2=0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // [1, 1, 2, 2]
        // [2, 2]
        // [4, 5, 9]
        // [4, ,4, 8, 9, 9]
        List<Integer> output = new ArrayList<>();
        while(ptr1<nums1.length && ptr2<nums2.length){
            if(nums1[ptr1]<nums2[ptr2]) {
                ptr1++; 
            } else if(nums2[ptr2]<nums1[ptr1]) {
                ptr2++;
            } else {
                output.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
        }

        return  output.stream().mapToInt(Integer::intValue).toArray();
        
    }
}