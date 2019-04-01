// 1206. [S/W 문제해결 기본] 1일차 - View

package SW_Test.Basic;

import java.util.Arrays;
import java.util.Scanner;

public class View {
// public class Solution {
        public static int count(int length, String[] arr){
                int[] buildings = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
                int count = 0;

                for (int i = 0; i < length; i++) {
                        int gap = 255;
                        for (int j = -2; j < 3; j++) {
                                if (j == 0);
                                else if ((i+j) > 0 && (i+j) < length) {
                                        if (buildings[i] - buildings[i+j] < gap) gap = buildings[i] - buildings[i+j];
                                }
                                if (gap < 0) {
                                        gap = 0;
                                        break;
                                }
                        }
                        count += gap;
                }
                return count;
        }

	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                
                int[] result = new int[10];

                for (int i = 0; i < 10; i++) {
                        String length = sc.nextLine();
                        String[] bLine = sc.nextLine().split(" ");
                        result[i] = count(Integer.valueOf(length), bLine);
                        System.out.println("#" + (i+1) + " " + result[i]);       
                }
                sc.close();
	}
}