package chapter3;

public class SortColors2 {
    public void sortColors2(int[] colors, int k) {
        if (colors.length == 0 || colors == null) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int start, int end, int colorFrom, int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }
        int colorMid = (colorFrom + colorTo) / 2;
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && colors[left] <= colorMid) {
                left ++;
            }
            while (left <= right && colors[right] > colorMid) {
                right --;
            }
            if (left <= right) {
                int temp = colors[right];
                colors[right] = colors[left];
                colors[left] = temp;
                left ++;
                right --;
            }
        }
        rainbowSort(colors, start, right, colorFrom, colorMid);
        rainbowSort(colors, left, end, colorMid + 1, colorTo);
    }
}
