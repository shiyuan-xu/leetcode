import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class Question242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = isAnagram2(s, t);
        System.out.println(anagram);

    }

    /**
     * @date 2019-6-5 21:29:32
     * @param s
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            map.put(chars1[i], map.getOrDefault(chars1[i], 0) + 1);
            if (map.containsKey(chars1[i])) {
                map.put(chars1[i], map.get(chars1[i]) + 1);
            } else {
                map.put(chars1[i], 1);
            }
        }
        for (int i = 0; i < chars2.length; i++) {
            if (map.containsKey(chars2[i])) {
                if (map.get(chars2[i]) > 1) {
                    map.put(chars2[i], map.get(chars2[i]) - 1);
                } else {
                    map.remove(chars2[i]);
                }
            } else {
                return false;
            }
        }
        if (map.keySet().size() == 0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * @date 2019-6-5 22:49:19
     * @param s
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)){
                if (map.get(ch) > 1) {
                    map.put(ch, map.get(ch) - 1);
                } else {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

}
