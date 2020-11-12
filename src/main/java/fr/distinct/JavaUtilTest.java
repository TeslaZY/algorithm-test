package fr.distinct;

import java.util.HashSet;

public class JavaUtilTest extends AbstractTest{
    public static void main(String[] args) {
        int count = caseCount;
        long timeSpend = 0l;
        for (int loop = loopCount; loop > 0; loop--){
            HashSet<Long> Set = new HashSet();
            long start = System.currentTimeMillis();
            long j = 1;
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
