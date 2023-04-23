import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner fs = new Scanner(System.in);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			Integer[] a = new Integer[n], indices = new Integer[n];
			for (int i = 0; i < n; i++) {
				a[i] = fs.nextInt();
				indices[i] = i;
			}
			Arrays.sort(indices, new Comparator<Integer>() {
				public int compare(Integer ind1, Integer ind2) {
					return a[ind1].compareTo(a[ind2]);
				}
			});
			for (int i = 0; i + 1 < n; i++) {
				int min = Math.min(a[indices[i]], a[indices[i+1]]);
				a[indices[i]] -= min;
				a[indices[i+1]] -= min;
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				if (a[indices[i]] > 0) {
					ans = indices[i] + 1;
					break;
				}
			}
			System.out.println(ans);
		}
		fs.close();
	}
}
