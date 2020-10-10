package fr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteData {

    static String newLine = "\n";//
    static StringBuffer sbrNew = new StringBuffer(1000000);// 创建sbrNew
    static int count = 1;
    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        System.err.println("开始时间：" + startTime);
        // 1. 创建文本所在目录，建议提前建好 D:\\test_data
        File file = new File("/Users/zhangyuyu/Downloads/test.txt");
        // 2. 获取该文件的缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        // 3. 写入信息
        int flagCount = 1;
        // 制定StringBuffer大小，防止扩容产生不必要的开销
        StringBuffer sbr = new StringBuffer(1000000);
        while (true) {
            if(flagCount <= 10000) {
                // 4. 递归拼接需要写入文件的文本
                sbr = getJoinStr(count,"fr","test");
                bufferedWriter.write(sbr.toString());
                bufferedWriter.flush();// 清空缓冲区
                count = count + 10000;
                flagCount++;
            }else {
                break;
            }
        }
        bufferedWriter.close();// 关闭输出流
        long endTime = System.currentTimeMillis();
        System.err.println("结束时间：" + (endTime -startTime) +"ms");
    }

    /**
     * count 当前起始数量，
     * clazz 组装名称，可按照需求改写
     * name 第二个字段，也可自定义
     * 拼接不重要，内容随时可以更改，所以传参也没有要求。
     */
    public static StringBuffer getJoinStr(int count, String clazz, String name) {
        int flagCount = 1;
        StringBuffer sbr = new StringBuffer(100000);
        while (flagCount <= 1000){
            sbr.append(clazz + count + name + count + newLine);
            count++;
            flagCount++;
        }
        // System.out.println("第" + count +"次进入");
        return sbr;
    }
}
