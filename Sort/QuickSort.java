// 1206. [S/W 문제해결 기본] 1일차 - Flatten

package Sort;

import java.util.Scanner;

public class QuickSort {
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

	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                
                String[] list = sc.nextLine().split(" ");

                box = new int[100];
                
                for (int j = 0; j < 100; j++) box[j] = Integer.parseInt(list[j]);

                quickSort(0, 99);

                for (int i = 0; i < 100; i++) System.out.print(box[i] + " ");
                sc.close();
	}
}

// 입력
// 42 68 35 1 70 25 79 59 63 65 6 46 82 28 62 92 96 43 28 37 92 5 3 54 93 83 22 17 19 96 48 27 72 39 70 13 68 100 36 95 4 12 23 34 74 65 42 12 54 69 48 45 63 58 38 60 24 42 30 79 17 36 91 43 89 7 41 43 65 49 47 6 91 30 71 51 7 2 94 49 30 24 85 55 57 41 67 77 32 9 45 40 27 24 38 39 19 83 30 42 