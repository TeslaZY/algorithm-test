package fr.distinct;


import gnu.trove.set.TLongSet;
import gnu.trove.set.hash.THashSet;
import gnu.trove.set.hash.TLongHashSet;

public class TroveTest extends AbstractTest{
    public static void main(String[] args) {
        int count = caseCount;
        THashSet Set = new THashSet();
        //        TLongSet TSet = new TLongHashSet();
        long start = System.currentTimeMillis();
        long j = 1;
        for (long i = 0; i < count; i++) {
            Set.add(String.valueOf(j++));
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
    }
}
