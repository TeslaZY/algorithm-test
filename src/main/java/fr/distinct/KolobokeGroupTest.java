package fr.distinct;

import com.koloboke.collect.set.hash.HashLongSet;
import com.koloboke.collect.set.hash.HashLongSets;
import org.apache.lucene.util.RamUsageEstimator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class KolobokeGroupTest extends AbstractTest {
    public static void main(String[] args) {
        int count[] = new int[gruopCount];
        Random r = new Random(1);
        int average = caseCount / gruopCount;
        int caseNum = caseCount;
        for (int i = 0; i < gruopCount; i++) {
            int random = r.nextInt(average * 100);
            if (caseNum - random > 0) {
                count[i] = random;
                caseNum -= random;
            } else {
                count[i] = caseNum;
                caseNum = 0;
            }
        }

        int sum = 0;
        for (int i = 0; i < gruopCount; i++) {
            sum += count[i];
        }

        long memory = 0;
        long result = 0;
        for (int loop = 0; loop < loopCount; loop++) {
            for (int k = 0; k < gruopCount; k++) {
                HashLongSet Set = HashLongSets.newUpdatableSet();

                long start = System.currentTimeMillis();
                long j = 1;
                for (int i = 0; i < count[k]; i++) {
                    Set.add(j++);
                }
//                for (int i = 0; i < average; i++) {
//                    Set.add(j++);
//                }
                long end = System.currentTimeMillis();
                memory += RamUsageEstimator.sizeOf(Set);
                Set = null;
            }
            System.out.println(memory / MB);
            result += memory;
            memory = 0;
        }
        System.out.println(result / (MB * loopCount));
    }
}
