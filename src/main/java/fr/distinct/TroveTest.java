package fr.distinct;


import gnu.trove.set.TLongSet;
import gnu.trove.set.hash.THashSet;
import gnu.trove.set.hash.TLongHashSet;
import org.apache.lucene.util.RamUsageEstimator;

public class TroveTest extends AbstractTest{
    public static void main(String[] args) {
        int count = caseCount;
        for (int loop = loopCount; loop > 0; loop--){
            TLongSet Set = new TLongHashSet();
            long start = System.currentTimeMillis();
            long j = 1;
            for (long i = 0; i < count; i++) {
                Set.add(j++);
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start)+"ms    "+ RamUsageEstimator.sizeOf(Set)/1045856+"MB");
        }
    }
}
