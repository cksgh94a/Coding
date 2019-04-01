// 1206. [S/W 문제해결 기본] 1일차 - 최빈수 구하기

package SW_Test.Basic;

import java.util.Scanner;

public class Mode {
// public class Solution {
        public static int count(String[] arr){
                int[] mArr = new int[101];
                int maxCount = 0;
                int index = 0;

                for (int i = 0; i < 1000; i++) {
                        int value = Integer.valueOf(arr[i]);
                        mArr[value]++;
                        if ((maxCount < mArr[value]) || ((maxCount == mArr[value]) && (index < value))) {
                                maxCount = mArr[value];
                                index = value;
                        }
                }

                return index;
        }

	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                
                int num = Integer.valueOf(sc.nextLine());
                int[] result = new int[num];

                for (int i = 0; i < num; i++) {
                        sc.nextLine();
                        String[] score = sc.nextLine().split(" ");
                        result[i] = count(score);
                        System.out.println("#" + (i+1) + " " + result[i]);       
                }
                sc.close();
	}
}