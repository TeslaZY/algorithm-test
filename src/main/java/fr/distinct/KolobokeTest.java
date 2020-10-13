package fr.distinct;

import com.koloboke.collect.set.hash.HashLongSet;
import com.koloboke.collect.set.hash.HashLongSets;
import com.koloboke.collect.set.hash.HashObjSet;
import com.koloboke.collect.set.hash.HashObjSets;
import org.apache.lucene.util.RamUsageEstimator;


public class KolobokeTest extends AbstractTest {

    public static void main(String[] args) {
        int count = caseCount;
        for (int loop = loopCount; loop > 0; loop--) {
            HashLongSet Set = HashLongSets.newUpdatableSet(100000000);
            long start = System.currentTimeMillis();
            long j = 1;
            for (long i = 0; i < count; i++) {
                Set.add(j++);
            }
            long end = System.currentTimeMillis();
//            System.out.println((end - start));
            String memory = RamUsageEstimator.humanSizeOf(Set);
            System.out.println((end - start)+"ms    "+RamUsageEstimator.sizeOf(Set)+"bytes");
        }
    }
}
