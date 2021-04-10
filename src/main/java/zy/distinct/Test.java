package zy.distinct;

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
                (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01,
        };
        // 通过反射得到theUnsafe对应的Field对象
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        // 设置该Field为可访问
        field.setAccessible(true);
        // 通过Field得到该Field对应的具体对象，传入null是因为该Field为static的
        Unsafe unsafe = UnsafeOps.getUnsafeInstance();
        int capacity = data.length/12;
        for (int i = 0; i < capacity; i++) {
            long b = getLongByIndex(data, i);
            long a = getIntByIndex(data, i);
//        unsafe.putLong(data,1l,0x00000000ed000ec021l);
            System.out.printf("long i : %x\n", b);//按16进制输出
//        a = unsafe.getLong(data,1l);
            System.out.printf("int i : %x\n", a);//按16进制输出
        }

    }

    private static long getLongByIndex(byte[] set, int index) throws Exception {
        Unsafe unsafe = UnsafeOps.getUnsafeInstance();
        long value = unsafe.getLong(set, (long)(Unsafe.ARRAY_BYTE_BASE_OFFSET + Unsafe.ARRAY_BYTE_INDEX_SCALE * 12 * index));
        return value;
    }

    private static int getIntByIndex(byte[] set, int index) throws Exception {
        Unsafe unsafe = UnsafeOps.getUnsafeInstance();
        int value = unsafe.getInt(set, (long)(Unsafe.ARRAY_BYTE_BASE_OFFSET + (Unsafe.ARRAY_BYTE_INDEX_SCALE * 12 * index) + 8));
        return value;
    }
}


