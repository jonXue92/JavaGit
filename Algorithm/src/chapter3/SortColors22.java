package chapter3;

public class SortColors22 {
    public void sortColors2(int[] colors, int k) {
        for (int i = 0; i < colors.length; i++) {
            // Means need to deal with A[i]
            while (colors[i] > 0) {
                int pos = colors[i] - 1;
                if (colors[pos] > 0) {
                    // 1. There is a number in the bucket,
                    // Store the number in the bucket in position i;
                    colors[i] = colors[pos];
                    colors[pos] = -1;
                } else {
                    // 2. Bucket is using or the bucket is empty.
                    colors[i] = 0;
                    // delete the A[i];
                    colors[pos]--;
                }
            }
        }

        for (int i = colors.length - 1, color = k; color >= 1; color--) {
            for (int count = -colors[color - 1]; count > 0; i--) {
                colors[i] = color;
                count--;
            }
        }
    }
}
