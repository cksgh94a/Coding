// 1206. [S/W 문제해결 기본] 1일차 - Flatten

package SW_Test.Basic;

import java.util.Scanner;

public class Flatten {
// public class Solution {
        static int box[];

        public static void quickSort(int left, int right) {
                int temp;
                if (left < right) {
                        int pivot = left;
                        int i = left;
                        int j = right;

                        while (i < j) {
                                while ((box[i] <= box[pivot]) && i < right) i++;
                                while (box[j] > box[pivot]) j--;
                                if (i < j) {
                                        temp = box[i];
                                        box[i] = box[j];
                                        box[j] = temp;
                                }
                        }

                        temp = box[pivot];
                        box[pivot] = box[j];
                        box[j] = temp;

                        quickSort(left, j-1);
                        quickSort(j+1, right);
                }
                
        }


        public static int count(int dump){
                quickSort(0, box.length);

                int temp;
                int topIndex = box.length;
                int botIndex = 0;

                for (int i = 0; i < dump; i++) {
                        box[box.length]--;
                        box[0]++;
                        while (box[topIndex] < box[topIndex-1]) {
                                temp = box[topIndex];
                                box[topIndex] = box[topIndex-1];
                                box[topIndex-1] = temp;
                                topIndex--;
                        }
                        while (box[botIndex] > box[botIndex+1]) {
                                temp = box[botIndex];
                                box[botIndex] = box[botIndex+1];
                                box[botIndex+1] = temp;
                                botIndex++;
                        }
                        topIndex = box.length;
                        botIndex = 0;

                        if ((box[topIndex] - box[botIndex]) == 1) break;
                }

                return box[topIndex] - box[botIndex];
        }

	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                
                int[] result = new int[10];

                for (int i = 0; i < 10; i++) {
                        int dump = Integer.valueOf(sc.nextLine());
                        String[] list = sc.nextLine().split(" ");

                        box = new int[list.length];
                        
                        for (int j = 0; j < list.length; j++) {
                                System.out.println(list[j]);
                                box[j] = Integer.parseInt(list[j]);
                                System.out.println("int = " + list[j]);
                        }
                        result[i] = count(dump);
                        System.out.println("#" + (i+1) + " " + result[i]);       
                }
                sc.close();
	}
}