import java.util.*;

/**
 * @Description 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */
public class Question387 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    /**
     * @date 2019-6-4 07:33:05
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Set<Character> uniq = new HashSet<>();
        Set<Character> ununiq = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!uniq.contains(s.charAt(i)) && !ununiq.contains(s.charAt(i))) {
                uniq.add(s.charAt(i));
            } else if (uniq.contains(s.charAt(i)) && !ununiq.contains(s.charAt(i))) {
                uniq.remove(s.charAt(i));
                ununiq.add(s.charAt(i));
            }
        }
        if (uniq.size() > 0) {
            for (int i = 0; i < s.length(); i++) {
                if (uniq.contains(s.charAt(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

}
