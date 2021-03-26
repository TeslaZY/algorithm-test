package fr.distinct;

import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;
import net.openhft.hashing.LongHashFunction;

/**
 * @Author: Tesla.Z
 * @Date: 2020/10/27 10:27
 * @Description
 */
public class xxHashTest {
    public static void main(String[] args) throws Exception {
//        HashFunction hf = Hashing.murmur3_128();
        String str = "test123451jkhjkm你好";
        int count = 100;
        byte[][] dataByte = new byte[count][];
        long[][] dataLong = new long[count][];
//        String[] data = new String[count];
        for (int i = 0; i < count; i++) {
            dataByte[i] = String.valueOf(i+"12").getBytes();
//            data[i] = String.valueOf(str+i);
            dataLong[i] = new long[3];
            dataLong[i][0] = i;
            dataLong[i][1] = 1;
            dataLong[i][2] = 2;
        }
        long start = System.currentTimeMillis();
//        HashSet<Long> set =new HashSet<>();
        for (int i = 0; i < count; i++) {
            long hash = LongHashFunction.xx().hashBytes(dataByte[i]);
//            set.add(hash);
        }
        long end = System.currentTimeMillis();
        System.out.println("spend " + (end - start) + "ms");
        XXHash32 hasher = XXHashFactory.unsafeInstance().hash32();
        for (int i = 0; i < count; i++) {
            long hash = LongHashFunction.xx().hashLongs(dataLong[i]);
//            data[i].hashCode();
//            long hash = hasher.hash(data[i],0,0,0);
//            set.add(hash);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("spend " + (end2 - end) + "ms");
    }

}
