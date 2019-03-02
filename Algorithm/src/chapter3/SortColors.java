package chapter3;

public class SortColors {
    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while (i <= pr) {
//            这里有一个实现上的小细节，当发现一个 0 丢到左边的时候，i需要++，但是发现一个2 丢到右边的时候，i不用++。
//            原因是，从pr 换过来的数有可能是0或者2，需要继续判断丢到左边还是右边。而从 pl 换过来的数，要么是0要么是1，
//            不需要再往右边丢了。因此这里 i 指针还有一个角度可以理解为，i指针的左侧，都是0和1。
            if (a[i] == 0) {
                swap(a, pl, i);
                pl++;
                i++;
            } else if(a[i] == 1) {
                i++;
            } else {
                swap(a, pr, i);
                pr--;
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
