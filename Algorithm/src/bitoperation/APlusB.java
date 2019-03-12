package bitoperation;
import java.io.PrintStream;
public class APlusB {
    public int aplusb(int a, int b) {
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }
}
