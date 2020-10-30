package fr.distinct;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: Tesla.Z
 * @Date: 2020/10/29 11:39
 * @Description
 */
public class UnsafeOps {
    private static Unsafe unsafe;

    public static Unsafe getUnsafeInstance() throws Exception
    {
        if(unsafe==null) {
            // 通过反射获取rt.jar下的Unsafe类
            Field instance = Unsafe.class.getDeclaredField("theUnsafe");
            instance.setAccessible(true);
            // return (Unsafe) theUnsafeInstance.get(null);是等价的
            unsafe = (Unsafe) instance.get(Unsafe.class);
        }
        return unsafe;
    }
}
