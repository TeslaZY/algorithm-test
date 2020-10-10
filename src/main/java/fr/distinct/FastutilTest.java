package fr.distinct;

import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashBigSet;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet;

public class FastutilTest extends AbstractTest {
    public static void main(String[] args) {
        int count = caseCount;
//        LongOpenHashBigSet Set = new LongOpenHashBigSet();
        ReferenceOpenHashBigSet Set = new ReferenceOpenHashBigSet();
        long start = System.currentTimeMillis();
        long j = 1;
        for (long i = 0; i < count; i++) {
            Set.add(String.valueOf(j++));
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }
}
