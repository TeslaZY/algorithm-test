package fr;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.HashSet;

/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/2
 */
public class Test {
    public static void main(String[] args){
        HashFunction hf = Hashing.murmur3_128();
        String str = "test12345";
        long start = System.currentTimeMillis();
        HashSet<Long> set =new HashSet<>();
        for(int i=0;i<100000000;i++) {
//                hf.newHasher().putString(str, Charsets.UTF_8).hash().asLong();
            set.add(hf.newHasher().putString(str+i, Charsets.UTF_8).hash().asLong());
        }
        long end = System.currentTimeMillis();
        System.out.println("spend "+ (end-start)/1000+ "s");
    }
}
