package zy.distinct;

import it.unimi.dsi.fastutil.longs.LongOpenHashBigSet;
import org.apache.lucene.util.RamUsageEstimator;

public class FastutilTest extends AbstractTest {
    public static void main(String[] args) {
        int count = caseCount;
        LongOpenHashBigSet Set = new LongOpenHashBigSet();
        for (int loop = loopCount; loop > 0; loop--){
            long start = System.currentTimeMillis();
            long j = 1;
            for (long i = 0; i < count; i++) {
                Set.add(j++);
            }
            long end = System.currentTimeMillis();
//            System.out.println((end - start));
            System.out.println((end - start)+"ms    "+RamUsageEstimator.sizeOf(Set)/1045856+"MB");
            Set.clear();
        }
    }
}
