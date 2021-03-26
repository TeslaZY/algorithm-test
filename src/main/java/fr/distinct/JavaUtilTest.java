package fr.distinct;

import com.koloboke.collect.set.hash.HashIntSet;
import com.koloboke.collect.set.hash.HashIntSets;

import java.util.HashSet;

public class JavaUtilTest extends AbstractTest{
    public static void main(String[] args) {
        int count = caseCount;
        long timeSpend = 0l;
        for (int loop = loopCount; loop > 0; loop--){
//            HashSet<Long> Set = new HashSet();
            HashIntSet Set = HashIntSets.newUpdatableSet();
            long start = System.currentTimeMillis();
            int j = 1;
            for (long i = 0; i < count; i++) {
                Set.add(j++);
            }
            long end = System.currentTimeMillis();
            timeSpend += end - start;
            System.out.println((end - start));
        }
        System.out.println("average ：" + timeSpend/loopCount);
    }
}
