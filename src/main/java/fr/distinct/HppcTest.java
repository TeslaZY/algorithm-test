package fr.distinct;


import com.carrotsearch.hppc.LongHashSet;
import org.apache.lucene.util.RamUsageEstimator;

public class HppcTest extends AbstractTest{
    public static void main(String[] args) {
        int count = caseCount;
        LongHashSet Set = new LongHashSet(100000000);
        for (int loop = loopCount; loop > 0; loop--) {
            long start = System.currentTimeMillis();
            long j = 1;
            for (long i = 0; i < count; i++) {
                Set.add(j++);
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start)+"ms    "+ RamUsageEstimator.sizeOf(Set)/1045856+"MB");
            Set.clear();
        }
    }
}