package fr.distinct;

/**
 * @Author: Tesla.Z
 * @Date: 2020/10/29 11:08
 * @Description
 */

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception {
        byte[] data = new byte[]{
                (byte) 0x00,(byte) 0x01,(byte) 0x02,(byte) 0x03,(byte) 0x04,(byte) 0x05,(byte) 0x06,(byte) 0x07,
                (byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,
                (byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff,(byte) 0xff
        };
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = UnsafeOps.getUnsafeInstance();
        byte a = unsafe.getByte(data, (long)(Unsafe.ARRAY_BYTE_BASE_OFFSET + Unsafe.ARRAY_BYTE_INDEX_SCALE * 8));
        long b = unsafe.getLong(data, (long)(Unsafe.ARRAY_BYTE_BASE_OFFSET + Unsafe.ARRAY_BYTE_INDEX_SCALE * 1));

//        unsafe.putLong(data,1l,0x00000000ed000ec021l);
        System.out.printf("%x\n",b);//按16进制输出
//        a = unsafe.getLong(data,1l);
//        System.out.printf("%x\n",a);//按16进制输出

    }
}


