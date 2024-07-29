class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> numList = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (numList.containsKey(res)) {
                int[] result = {i, numList.get(res)};
                return result;
            }
            numList.put(nums[i], i);
        }
        return new int[2];
    }
}