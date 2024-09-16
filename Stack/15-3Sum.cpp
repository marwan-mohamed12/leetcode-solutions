class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int length = nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        for (int i  = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = length - 1;
            while(left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                //cout<<sum<<\ \<<nums[i]<<\ \<<nums[left]<<\ \<<nums[right]<<endl;

                if (sum == 0) {
                    res.push_back({nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1])left++;
                    while(left < right && nums[right] == nums[right + 1])right--; 
                    
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }

        return res;

    }
};