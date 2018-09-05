package micoding;

public class FindCharAppearOnce extends  SuperCodeClass{
    @Override
    public String solution(String line){
        String[] array= line.split(" ");
        int result=0;
        result=Integer.valueOf(array[0])^Integer.valueOf(array[1]);
        for(int i=2;i<array.length;i++){
            result=result^Integer.valueOf(array[i]);
        }
        return Integer.toString(result);

    }

    public static void main(String[] args) {
        String line = input();
        System.out.println(new BigNumberSub().solution(line));
    }
}
