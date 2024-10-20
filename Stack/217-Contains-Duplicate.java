class Solution {
    public boolean containsDuplicate(int[] nums) {
        var freq = new HashMap<Integer,Integer>();

        for (int num : nums) {
            if (freq.get(num) != null) {
                return true;
            }
            freq.put(num, num);
        }
        return false;
    }
}