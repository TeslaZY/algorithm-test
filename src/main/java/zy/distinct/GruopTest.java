package zy.distinct;

import com.carrotsearch.hppc.LongHashSet;
import com.koloboke.collect.set.hash.HashLongSet;
import com.koloboke.collect.set.hash.HashLongSets;
import gnu.trove.set.TLongSet;
import gnu.trove.set.hash.TLongHashSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashBigSet;
import org.apache.lucene.util.RamUsageEstimator;

import java.util.HashSet;

public class GruopTest extends AbstractTest {

    public static int KB = 1024;
    public static int MB = 1045856;

    public static void main(String[] args) {
        int count = caseCount;
        HashSet<Long> JavaSet = new HashSet();
        LongOpenHashBigSet FastUtilSet = new LongOpenHashBigSet();
        TLongSet TroveSet = new TLongHashSet();
        LongHashSet HPPCSet = new LongHashSet();
        HashLongSet KoloBokeSet = HashLongSets.newUpdatableSet();

        for (int loop = loopCount; loop > 0; loop--) {
            long start = System.currentTimeMillis();


            long j = 1;
            for (long i = 0; i < count; i++) {
                JavaSet.add(j);
                j++;
            }
            System.out.println(RamUsageEstimator.sizeOf(JavaSet) / KB);
            JavaSet = null;


            j = 1;
            for (long i = 0; i < count; i++) {
                FastUtilSet.add(j);
                j++;
            }
            System.out.println(RamUsageEstimator.sizeOf(FastUtilSet) / KB);
            FastUtilSet = null;


            j = 1;
            for (long i = 0; i < count; i++) {
                KoloBokeSet.add(j);
                j++;
            }
            System.out.println(RamUsageEstimator.sizeOf(KoloBokeSet) / KB);
            KoloBokeSet = null;


            j = 1;
            for (long i = 0; i < count; i++) {
                TroveSet.add(j);
                j++;
            }
            System.out.println(RamUsageEstimator.sizeOf(TroveSet) / KB);
            TroveSet = null;


            j = 1;
            for (long i = 0; i < count; i++) {

                HPPCSet.add(j);
                j++;
            }
            System.out.println(RamUsageEstimator.sizeOf(HPPCSet) / KB);
            HPPCSet = null;

            long end = System.currentTimeMillis();
//            System.out.println("JavaSet "+(end - start)+"ms    "+ RamUsageEstimator.sizeOf(JavaSet)/1045856+"MB");
//            System.out.println("FastUtilSet "+(end - start)+"ms    "+ RamUsageEstimator.sizeOf(FastUtilSet)/1045856+"MB");
//            System.out.println("KoloBokeSet "+(end - start)+"ms    "+ RamUsageEstimator.sizeOf(KoloBokeSet)/1045856+"MB");
//            System.out.println("TroveSet "+(end - start)+"ms    "+ RamUsageEstimator.sizeOf(TroveSet)/1045856+"MB");
//            System.out.println("HPPCSet "+(end - start)+"ms    "+ RamUsageEstimator.sizeOf(HPPCSet)/1045856+"MB");
        }
    }
}
