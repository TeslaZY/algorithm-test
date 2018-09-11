package micoding;

import java.util.Scanner;

public class TopKFrequentElements extends SuperCodeClass {
    @Override
    public String solution(String line) {
        StringBuilder return_line = new StringBuilder();
        String[] arrays = line.split(" ");
        String[] str_numbers = arrays[0].split(",");
        int[] numbers = new int[str_numbers.length];
        int k = Integer.valueOf(arrays[1]);
        int i=0;
        for(i=0;i<str_numbers.length;i++){
            numbers[i]=Integer.valueOf(str_numbers[i]);
        }


        int max = 0;
        for(i=0;i<numbers.length;i++){
            max = numbers[i]>max ? numbers[i] : max;
        }
        int[] fre_records = new int[max+1];
        for(i=0;i<numbers.length;i++){
            fre_records[numbers[i]]++;
        }
        int max_freq=0;
        int result=0;
        for(i=0;i<k;i++){
            for(int j=0;j<fre_records.length;j++){
                if(fre_records[j]!=0&&fre_records[j]>max_freq){
                    max_freq=fre_records[j];
                    result=j;
                }
            }
            return_line.append(result);
            fre_records[result]=0;
            max_freq=0;
            if(i!=k-1){
                return_line.append(",");
            }
        }
        return return_line.toString();
    }

        public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new TopKFrequentElements().solution(line));
        }
    }
}
