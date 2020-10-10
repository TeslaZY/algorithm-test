package fr.distinct;

import com.koloboke.collect.set.hash.HashLongSet;
import com.koloboke.collect.set.hash.HashLongSets;
import com.koloboke.collect.set.hash.HashObjSet;
import com.koloboke.collect.set.hash.HashObjSets;


public class KolobokeTest extends AbstractTest{
    public static void main(String[] args) {
        int count = caseCount;
//        HashLongSet Set = HashLongSets.newUpdatableSet();
        HashObjSet Set = HashObjSets.newMutableSet();

        long start = System.currentTimeMillis();
        long j = 1;
        for (long i = 0; i < count; i++) {
            Set.add(String.valueOf(j++));
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
    }
}
