package zy.distinct;

import com.koloboke.collect.set.hash.HashObjSet;
import com.koloboke.collect.set.hash.HashObjSets;
import gnu.trove.set.hash.TCustomHashSet;
import gnu.trove.set.hash.THashSet;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashBigSet;

import java.util.HashSet;

public class HashTest {
    public static void main(String[] args) {
        int caseCount = 30000000;
//        HashFunction hf = Hashing.murmur3_128();
         String[] sa = new String[caseCount];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = String.valueOf(i);
        }
        THashSet TSet = new THashSet();
        TCustomHashSet TCSet = new TCustomHashSet();
        HashObjSet KSet = HashObjSets.newMutableSet();
        ReferenceOpenHashBigSet FSet = new ReferenceOpenHashBigSet();
        HashSet<String> JSet = new HashSet();


        long start = System.currentTimeMillis();
        for (int i = 0; i < caseCount; i++) {
            JSet.add(sa[i]);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Java Util spends " + (end1 - start) + "ms");
        for (int i = 0; i < caseCount; i++) {
            FSet.add(sa[i]);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("FastUtil spends " + (end2 - end1) + "ms");
        for (int i = 0; i < caseCount; i++) {
            KSet.add(sa[i]);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("KoloBoke spends " + (end3 - end2) + "ms");
        for (int i = 0; i < caseCount; i++) {
            TSet.add(sa[i]);
        }
        long end4 = System.currentTimeMillis();
        System.out.println("Trove spends " + (end4 - end3) + "ms");
    }
}
