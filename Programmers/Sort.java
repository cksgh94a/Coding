// 코딩테스트 연습 - 정렬 - K번째 수

package Programmers;

public class Sort {
        static int[] array = {1, 5, 2, 6, 3, 7, 4};
        static int[] sliced = {};


        public static void quickSort(int l, int r) {
                int temp;

                if (l < r){
                        int pivot = l;
                        int f = l;
                        int b = r;
                        
                        while (f < b) {
                                while (sliced[f] <= sliced[pivot] && f < r) f++;
                                while (sliced[pivot] < sliced[b]) b--;
                                if (f < b) {
                                        temp = sliced[f];
                                        sliced[f] = sliced[b];
                                        sliced[b] = temp;
                                }
                        }
        
                        temp = sliced[pivot];
                        sliced[pivot] = sliced[b];
                        sliced[b] = temp;
        
                        quickSort(l, b-1);
                        quickSort(b+1, r);
                }
        }

	public static void main(String args[]) {
                int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
                
                int[] answer = new int[commands.length];

                int slicedLen;
                
                for (int i = 0; i < commands.length; i++) {

                        slicedLen = commands[i][1] - commands[i][0] + 1;
                        
                        sliced = new int[slicedLen];
                        for (int j = 0; j < slicedLen; j++) sliced[j] = array[j + commands[i][0] - 1];
                        quickSort(0, slicedLen - 1);
                        
                        answer[i] = sliced[commands[i][2] - 1];
                }

                for (int e : answer) System.out.println(e);
	}
}