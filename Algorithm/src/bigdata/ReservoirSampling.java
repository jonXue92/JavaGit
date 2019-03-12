package bigdata;

import java.util.Random;

public class ReservoirSampling {
    Random rand = new Random();
    int sampling(int[] file) {
        int res = 0;
        for (int i = 0; i < file.length; i++) {  //i表示第几行
            if (rand.nextInt(i) == 0) res = i;
        }
        return res;
    }
}
