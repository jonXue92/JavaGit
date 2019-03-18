package backpack;

public class Backpack4 {
    public int backpack4(int[] nums, int target) {
        int n = nums.length;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j <= target; j++) {
                f[j] += f[j - nums[i]];
            }
        }
        return f[target];
    }
}
