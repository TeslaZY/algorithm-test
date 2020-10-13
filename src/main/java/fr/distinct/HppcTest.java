package fr.distinct;


import com.carrotsearch.hppc.LongHashSet;

public class HppcTest extends AbstractTest{
    public static void main(String[] args) {
        int count = caseCount;
        for (int loop = loopCount; loop > 0; loop--) {
            LongHashSet Set = new LongHashSet();
            long start = System.currentTimeMillis();
            long j = 1;
            for (long i = 0; i < count; i++) {
                Set.add(j++);
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start));
        }
    }
}