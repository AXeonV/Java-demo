import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), ans = 0;
		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = sc.nextInt();
		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j < n; ++j)
				for (int k = j + 1; k < n; ++k)
					for (int l = k + 1; l < n; ++l)
						if (a[i] + a[j] + a[k] + a[l] == 24)
							++ans;
		System.out.println(ans);
	}
}
