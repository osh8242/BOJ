class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long start = toSec(h1, m1, s1);
        long end = toSec(h2, m2, s2);

        // 초침-분침: t = (3600/59) * k
        long cntSM = countEvents(3600L, 59L, start, end);

        // 초침-시침: t = (43200/719) * k
        long cntSH = countEvents(43200L, 719L, start, end);

        // 세 바늘 동시(중복 제거): t = 43200 * k
        long cntBoth = countEvents(43200L, 1L, start, end);

        long ans = cntSM + cntSH - cntBoth;
        return (int) ans;
    }

    private long toSec(int h, int m, int s) {
        return (long) h * 3600L + (long) m * 60L + (long) s;
    }

    private long countEvents(long P, long Q, long start, long end) {
        // k_min = ceil(start*Q / P) = (start*Q + P - 1) / P
        long left = start * Q;
        long kMin = (left + P - 1) / P;

        // k_max = floor(end*Q / P)
        long right = end * Q;
        long kMax = right / P;

        if (kMax < kMin) return 0L;
        return kMax - kMin + 1L;
    }
}
