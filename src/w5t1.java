import java.util.Scanner;

public class w5t1 {
	public static void sort(int[] a, int l, int r) {
		if (l >= r) return;
		int x = a[(l + r) / 2];
		int i = l - 1, j = r + 1;
		while (i < j) {
			do ++i; while (a[i] < x);
			do --j; while (a[j] > x);
			if (i < j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		sort(a, l, j);
		sort(a, j + 1, r);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many numbers you will input: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i)
			arr[i] = sc.nextInt();
		sort(arr, 0, n - 1);
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
	}
}
