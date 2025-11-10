import java.util.Arrays;

public class PatternMatcher {
	public static int[] findPatternMatches1(String text, String pattern) {
		int idx = 0;
		int[] ret = new int[text.length()];
		for (int i = 0; i < text.length(); ++i) {
			boolean found = true;
			for (int j = 0; j < pattern.length(); ++j) {
				if (i + j >= text.length() || text.charAt(i + j) != pattern.charAt(j)) {
					found = false;
					break;
				}
			}
			if (found) ret[idx++] = i;
		}
		int[] ans = new int[idx];
		System.arraycopy(ret, 0, ans, 0, idx);
		return ans;
	}
	public static int[] findPatternMatches2(String text, String pattern) {
		int idx = 0;
		int[] ret = new int[text.length()];
		for (int i = 0; i < text.length(); ++i) {
			if (text.charAt(i) != pattern.charAt(0)) continue;
			boolean found = true;
			for (int j = 0, k = i; j < pattern.length(); ) {
				if (k >= text.length()) {
					found = false;
					break;
				}
				if (text.charAt(k) != pattern.charAt(j)) {
					++k;
					continue;
				}
				++k; ++j;
			}
			if (found) ret[idx++] = i;
		}
		int[] ans = new int[idx];
		System.arraycopy(ret, 0, ans, 0, idx);
		return ans;
	}

	public static void main(String[] args) {
		String text = "aabaa";
		String pattern = "aba";
		System.out.println(Arrays.toString(findPatternMatches1(text, pattern)));// [1]
		System.out.println(Arrays.toString(findPatternMatches2(text, pattern)));// [0,1]
	}
}
