package fr.distinct;

import com.fr.stable.collections.map.IntSet;
import com.koloboke.collect.set.hash.HashLongSet;
import com.koloboke.collect.set.hash.HashLongSets;
import net.openhft.hashing.LongHashFunction;
//import org.apache.lucene.util.RamUsageEstimator;

import java.util.Random;


public class KolobokeTest extends AbstractTest {

    public static void main(String[] args) {
        int count = caseCount;
        int data[] = new int[caseCount];
        Random r = new Random(1);
        String[] sa = new String[count];
//        for(int i = 0; i<caseCount;i++){
//            data[i] = r.nextInt();
//        }
        for (int i = 0; i < sa.length; i++) {
            sa[i] = String.valueOf(i);
        }
        long timeSpend = 0l;
        for (int loop = loopCount; loop > 0; loop--) {
            HashLongSet Set = HashLongSets.newUpdatableSet();

            long start = System.currentTimeMillis();
            int j = 1;
            for (int i = 0; i < count; i++) {
                Set.add(LongHashFunction.xx().hashChars(sa[i]));
            }
            long end = System.currentTimeMillis();
            timeSpend += end - start;
            System.out.println((end - start));
//            String memory = RamUsageEstimator.humanSizeOf(Set);
//            System.out.println((end - start)+"ms    "+RamUsageEstimator.sizeOf(Set)/KB);
            Set.clear();
        }
        System.out.println("average ：" + timeSpend/loopCount);

        System.out.println("--------------------");
//        for (int loop = loopCount; loop > 0; loop--) {
//            IntSet Set = new IntSet();
//            long start = System.currentTimeMillis();
//            int j = 1;
//            for (int i = 0; i < data.length; i++) {
//                Set.add(data[i]);
//            }
//            long end = System.currentTimeMillis();
//            System.out.println((end - start));
////            String memory = RamUsageEstimator.humanSizeOf(Set);
////            System.out.println((end - start)+"ms    "+RamUsageEstimator.sizeOf(Set)/KB);
//            Set.clear();
//        }
    }
}
