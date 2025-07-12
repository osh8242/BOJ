import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final double EPS = 1e-9;

    static boolean canMake(double target, double[] nums) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) if (i != j) {
                double x = nums[i], y = nums[j];
                if (Math.abs(x + y - target) < EPS) return true;
                if (Math.abs(x - y - target) < EPS) return true;
                if (Math.abs(x * y - target) < EPS) return true;
                if (Math.abs(y) > EPS && Math.abs(x / y - target) < EPS) return true;
            }
        }
        int[] perm = new int[3];
        boolean[] used = new boolean[3];
        return permuteAndTest(nums, target, perm, used, 0);
    }

    static boolean permuteAndTest(double[] nums, double target,
                                  int[] perm, boolean[] used, int depth) {
        if (depth == 3) {
            double x = nums[perm[0]];
            double y = nums[perm[1]];
            double z = nums[perm[2]];

            for (int op1 = 0; op1 < 4; op1++) {
                double xy;
                switch (op1) {
                    case 0: xy = x + y; break;
                    case 1: xy = x - y; break;
                    case 2: xy = x * y; break;
                    default:
                        if (Math.abs(y) < EPS) continue;
                        xy = x / y;
                }
                for (int op2 = 0; op2 < 4; op2++) {
                    double val;
                    switch (op2) {
                        case 0: val = xy + z; break;
                        case 1: val = xy - z; break;
                        case 2: val = xy * z; break;
                        default:
                            if (Math.abs(z) < EPS) continue;
                            val = xy / z;
                    }
                    if (Math.abs(val - target) < EPS) return true;
                }
            }
            for (int op1 = 0; op1 < 4; op1++) {
                for (int op2 = 0; op2 < 4; op2++) {
                    double yz;
                    switch (op2) {
                        case 0: yz = y + z; break;
                        case 1: yz = y - z; break;
                        case 2: yz = y * z; break;
                        default:
                            if (Math.abs(z) < EPS) continue;
                            yz = y / z;
                    }
                    double val;
                    switch (op1) {
                        case 0: val = x + yz; break;
                        case 1: val = x - yz; break;
                        case 2: val = x * yz; break;
                        default:
                            if (Math.abs(yz) < EPS) continue;
                            val = x / yz;
                    }
                    if (Math.abs(val - target) < EPS) return true;
                }
            }
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = i;
                if (permuteAndTest(nums, target, perm, used, depth + 1))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine().trim());
        double target = d;
        for (int a = 1; a <= 100; a++) {
            if (a == d) continue;
            for (int b = a + 1; b <= 100; b++) {
                if (b == d) continue;
                for (int c = b + 1; c <= 100; c++) {
                    if (c == d) continue;
                    double[] nums = {a, b, c};
                    if (!canMake(target, nums)) {
                        System.out.printf("%d %d %d\n", a, b, c);
                        return;
                    }
                }
            }
        }
    }
}
