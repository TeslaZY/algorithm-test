package fr.distinct;

import com.fr.stable.collections.map.IntSet;
import com.koloboke.collect.set.hash.*;
//import org.apache.lucene.util.RamUsageEstimator;

import java.util.Random;


public class KolobokeTest extends AbstractTest {

    public static void main(String[] args) {
        int count = caseCount;
        int data[] = new int[caseCount];
        Random r = new Random(1);
        for(int i = 0; i<caseCount;i++){
            data[i] = r.nextInt();
        }
        for (int loop = loopCount; loop > 0; loop--) {
            HashIntSet Set = HashIntSets.newUpdatableSet();

            long start = System.currentTimeMillis();
            int j = 1;
            for (int i = 0; i < count; i++) {
                Set.add(data[i]);
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start));
//            String memory = RamUsageEstimator.humanSizeOf(Set);
//            System.out.println((end - start)+"ms    "+RamUsageEstimator.sizeOf(Set)/KB);
            Set.clear();
        }
        System.out.println("--------------------");
        for (int loop = loopCount; loop > 0; loop--) {
            IntSet Set = new IntSet();
            long start = System.currentTimeMillis();
            int j = 1;
            for (int i = 0; i < data.length; i++) {
                Set.add(data[i]);
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start));
//            String memory = RamUsageEstimator.humanSizeOf(Set);
//            System.out.println((end - start)+"ms    "+RamUsageEstimator.sizeOf(Set)/KB);
            Set.clear();
        }
    }
}
