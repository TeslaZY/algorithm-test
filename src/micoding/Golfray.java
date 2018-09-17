package micoding;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Golfray extends  SuperCodeClass {
    @Override
    public String solution(String line) {
        int i=0,j=0;
        String[] arrays = line.split(" ");
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(arrays.length+1);
        ArrayBlockingQueue<String> bullet = new ArrayBlockingQueue<String>(arrays.length+1);
        for(i=0;i<arrays.length;i++){
            queue.add(Integer.valueOf(arrays[i]));
        }
        queue.add(-1);
        int temp;
        int bullet_num = 0;
        while(!queue.isEmpty()){
            bullet.add("bullet");
            bullet_num++;
            while(!bullet.isEmpty()) {
                temp = queue.poll();
                if (temp == -1&&!queue.isEmpty()) {
                    bullet.poll();
                    queue.add(-1);
                } else if(queue.isEmpty()){
                    break;
                }else {
                    temp = temp - 2;
                    if (temp <= 0) {
                        bullet.add("bullet");
                    } else {
                        queue.add(temp);
                    }
                }
            }
        }
        return Integer.toString(bullet_num);
    }


        public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new Golfray().solution(line));
        }
    }

}
