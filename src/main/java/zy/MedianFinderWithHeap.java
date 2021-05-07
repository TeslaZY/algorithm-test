package zy;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.util.PriorityQueue;

/**
 * @Author: Tesla.Z
 * @Date: 2021/5/6 17:45
 * @Description
 */
public class MedianFinderWithHeap {
    private static PriorityQueue<Integer>
            smallHeap = new PriorityQueue<>(5000000,(n1, n2) -> n1 - n2),
            bigHeap = new PriorityQueue<>(5000000,(n1, n2) -> n2 - n1);

    private static void addNum(int num) {
        if (bigHeap.size() != smallHeap.size()) {
            if (bigHeap.peek() > num) {
                smallHeap.offer(bigHeap.poll());
                bigHeap.offer(num);
            }
            else {
                smallHeap.offer(num);
            }
        }
        else {
            if (bigHeap.isEmpty() || smallHeap.peek() > num) {
                bigHeap.offer(num);
            }
            else {
                bigHeap.offer(smallHeap.poll());
                smallHeap.offer(num);
            }
        }
    }

    private static int findMedian() {
        return bigHeap.size() == smallHeap.size()
                ? ((int) bigHeap.peek() + smallHeap.peek()) / 2
                : bigHeap.peek();
    }


    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(System.in))) {
            for (int i = 0; i < 10000000; i ++) {
                int num = in.readInt();
                addNum(num);
            }
        } catch (Exception ignore) {

        }
        System.out.println(findMedian());

    }
}
