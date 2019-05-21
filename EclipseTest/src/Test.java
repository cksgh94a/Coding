import java.util.Scanner;
import java.util.Arrays;

public class Test {
	
	public static int road(int[][] map, int k, int posX, int posY, int prevX, int prevY) {
		int length = 0;

		if (map[posX][posY] == 1 ) return 1;	// ���� �� ����
		else {
			if (k > 0) {	// ���� ���� ����
			} else {	// ���� ���� �Ұ�
			}

			return length+1;	
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int t = Integer.parseInt(sc.nextLine());
		int n,k;
		
		String nk[];
		String temp[];
		int map[][];		
		int maxH = 0 ;	// ���츮 ����
		int maxLength = 0;	// ���� ����
		int length = 0;
		
		for (int i = 0 ; i < t; i ++) {
			nk = sc.nextLine().split(" ");
			n = Integer.parseInt(nk[0]);
			k = Integer.parseInt(nk[1]);
			
			map = new int[n][n];
			
			// �� ����
			for (int y = 0; y < n; y++) {
				temp = sc.nextLine().split(" ");
				for (int x = 0; x < n; x++) {
					map[x][y] = Integer.parseInt(temp[y]);
					if (map[x][y] > maxH) maxH = map[x][y];
				}
			}
			
			// ���� Ž��
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (map[x][y] == maxH) length = road(map, k, x, y, x, y);
					if (length > maxLength) maxLength = length;
				}
			}
			
			System.out.println("#" + (i+1) + " " + (maxLength-1));
		}
		
		sc.close();
	}
}

/*
*/