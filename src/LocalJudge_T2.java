import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class LocalJudge_T2 {

    private static void assertEq(int[] got, int[] want, String msg) {
        assertArrayEquals(want, got, () -> msg + " => got=" + Arrays.toString(got) + ", want=" + Arrays.toString(want));
    }

    // M1：连续匹配
    @Test @DisplayName("M1 基础与重叠")
    void m1_basic() {
        assertEq(PatternMatcher.findPatternMatches1("ababa", "aba"), new int[]{0,2}, "overlap");
        assertEq(PatternMatcher.findPatternMatches1("aaaaa", "aaa"), new int[]{0,1,2}, "many overlaps");
        assertEq(PatternMatcher.findPatternMatches1("abcde", "f"), new int[]{}, "no match");
    }

    @Test @DisplayName("M1 大小写/边界/Unicode")
    void m1_edges() {
        assertEq(PatternMatcher.findPatternMatches1("aaAAaA", "aaa"), new int[]{}, "case");
        assertEq(PatternMatcher.findPatternMatches1("", "a"), new int[]{}, "empty text");
        assertEq(PatternMatcher.findPatternMatches1("ab", "abc"), new int[]{}, "pat>text");
        assertEq(PatternMatcher.findPatternMatches1("abc", "abc"), new int[]{0}, "exact");
        assertEq(PatternMatcher.findPatternMatches1("短短短短", "短短"), new int[]{0,1,2}, "unicode");
    }

    // M2：非连续匹配（子序列，起点需匹配首字符）
    @Test @DisplayName("M2 基础与多起点")
    void m2_basic() {
        assertEq(PatternMatcher.findPatternMatches2("aababa", "aaa"), new int[]{0,1}, "basic subseq");
        assertEq(PatternMatcher.findPatternMatches2("abcabc", "abc"), new int[]{0,3}, "two starts");
        assertEq(PatternMatcher.findPatternMatches2("aaaaa", "aaa"), new int[]{0,1,2}, "dense");
    }

    @Test @DisplayName("M2 大小写/边界/Unicode/混合")
    void m2_edges() {
        assertEq(PatternMatcher.findPatternMatches2("AaAaA", "aaa"), new int[]{}, "case");
        assertEq(PatternMatcher.findPatternMatches2("abc", "abcd"), new int[]{}, "pat too long");
        assertEq(PatternMatcher.findPatternMatches2("短长短长长", "短长长"), new int[]{0,2}, "unicode subseq"); // 修正期望
        assertEq(PatternMatcher.findPatternMatches2("a_ba-ba_a", "b_a"), new int[]{2,5}, "mixed chars");    // 修正期望
    }

    @Test @DisplayName("规模接近上限 (~5000)")
    void scale() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5000; i++) sb.append(i % 2 == 0 ? 'a' : 'b');
        String big = sb.toString();
        assertTrue(PatternMatcher.findPatternMatches1(big, "ab").length > 0);
        assertTrue(PatternMatcher.findPatternMatches2(big, "aaa").length > 0);
    }
}