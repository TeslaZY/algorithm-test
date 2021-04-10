package zy;

import java.util.Scanner;

public class ChangeToAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] startCountArray = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            startCountArray[i] = sc.nextInt();
            sum += startCountArray[i];
        }
        int average = sum / n;
        int[] differenceArray = new int[n];
        for (int i = 0; i < n; i++) {
            differenceArray[i] = startCountArray[i] - average;
        }
        int steps = 0;
        for (int i = 0; i < n; i++) {
            if(differenceArray[i] > 0){
                steps += differenceArray[i];
            }
        }
        System.out.println(steps);
    }
}
