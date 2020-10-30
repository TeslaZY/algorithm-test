package fr.distinct;

import net.openhft.hashing.LongHashFunction;

/**
 * @Author: Tesla.Z
 * @Date: 2020/10/27 10:27
 * @Description
 */
public class xxHashTest {
    public static void main(String[] args) {
//        HashFunction hf = Hashing.murmur3_128();
        String str = "test123451jkhjkm你好";
        int count = 10000000;
        String[] sa = new String[count];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = String.valueOf(i);
        }
        long start = System.currentTimeMillis();
//        HashSet<Long> set =new HashSet<>();
        for (int i = 0; i < count; i++) {
            sa[i].hashCode();
//            long hash = LongHashFunction.xx().hashChars();
//            set.add(hash);
        }
        long end = System.currentTimeMillis();
        System.out.println("spend " + (end - start) + "ms");
        for (int i = 0; i < count; i++) {
//            String.valueOf(i).hashCode();
            long hash = LongHashFunction.xx().hashChars(sa[i]);
//            set.add(hash);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("spend " + (end2 - end) + "ms");
    }

}
