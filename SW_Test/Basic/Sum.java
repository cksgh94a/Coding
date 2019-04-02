// 1206. [S/W 문제해결 기본] 1일차 - Sum

package SW_Test.Basic;

import java.util.Scanner;

public class Sum {
// public class Solution {
        static int arr[][] = new int[100][100];
	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                String temp[];
                int max = 0;
                int rowSum = 0;
                int culSum = 0;
                int diaSum = 0;

                for (int i = 0; i < 10; i++) {
                        sc.nextLine();
                        for (int j = 0; j < 100; j++) {
                                temp = sc.nextLine().split(" ");
                                for (int k = 0; k < 100; k++) {
                                        arr[j][k] = Integer.parseInt(temp[k]);
                                        rowSum += arr[j][k];
                                }
                                if (rowSum > max) max = rowSum;
                                rowSum = 0;                               
                        }

                        for (int j = 0; j < 100; j++) {
                                for (int k = 0; k < 100; k++) {
                                        culSum += arr[k][j];
                                        if (j==k) diaSum += arr[j][j];
                                }
                                if (diaSum > max) max = diaSum;
                                if (culSum > max) max = culSum;
                                culSum = 0;
                                diaSum = 0;
                        }
                        System.out.println("#" + (i+1) + " " + max);
                        max = 0;
                }
                sc.close();
	}
}