package cn.yong.center.practice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: WenLong Li
 * @Date: 2020/05/13 10:33
 * @Description: 常用工具类
 */
public class CommonUtils {
    protected CommonUtils() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * 空字符串
     */
    public static final String EMPTY = "";
    /**
     * 空
     */
    public static final String NULL = "null";
    /**
     * 空格
     */
    public static final String SPACE = " ";

    /**
     * string format 使用的正则表达式
     */
    private static final Pattern PATTERN_FORMAT = Pattern.compile("\\{(\\d+)?\\}");

    /**
     * 修整null值
     *
     * @param str 需要修整的字符串
     * @return 修整后的字符串
     */
    public static String trimNull(String str) {
        return trimNull(str, EMPTY);
    }

    /**
     * 修整null值，并替换成目标字符串
     *
     * @param old  需要修整的字符串
     * @param news 替换成的目标字符串
     * @return 修整后的字符串
     */
    public static String trimNull(String old, String news) {
        return old == null || old.isEmpty() ? news : old;
    }

    /**
     * 将"null"字符串替换成空字符串
     *
     * @param src 需要修整的字符串
     * @return 修整后的字符串
     */
    public static String trim(String src) {
        return src == null ? EMPTY : src.replace(NULL, EMPTY);
    }

    /**
     * 将" "空格字符串替换成空字符串
     *
     * @param src 需要修整的字符串
     * @return 修整后的字符串
     */
    public static String trimEmpty(String src) {
        return src == null ? EMPTY : src.replace(SPACE, EMPTY);
    }

    /**
     * 将 u00a0 空格字符串替换成空字符串
     *
     * @param src 需要修整的字符串
     * @return 修整后的字符串
     */
    public static String trimHTMLEmpty(String src) {
        return src == null ? EMPTY : src.replaceAll("^[\\u00a0　 ]+", EMPTY).replaceAll("[\\u00a0　 ]+$", EMPTY);
    }

    /**
     * 将 [u00a0 ] 空格字符串替换成空字符串
     *
     * @param src 需要修整的字符串
     * @return 修整后的字符串
     */
    public static String trimAllEmpty(String src) {
        return src == null ? EMPTY : src.replaceAll("^[\\u00a0　 ]+", EMPTY).replaceAll("[\\u00a0　 ]+$", EMPTY);
    }

    /**
     * 修整时间格式后的".0"值
     *
     * @param str 需要修整的字符串
     * @return 修整后的字符串
     */
    public static String trimTime(String str) {
        return str != null && str.length() > 2 ? str.substring(0, str.length() - 2) : EMPTY;
    }

    /**
     * string[] ->int[]
     *
     * @param strArr 需要转换的字符串数组
     * @return 转换后的数组
     */
    public static int[] format2IntArray(String[] strArr) {
        int[] ls = new int[strArr == null ? 0 : strArr.length];
        if (strArr != null) {
            for (int i = 0; i < ls.length; i++) {
                ls[i] = Integer.parseInt(strArr[i]);
            }
        }
        return ls;
    }

    /**
     * string[] ->long[]
     *
     * @param strs
     * @return
     */
    public static long[] format2longArray(String[] strs) {
        long[] ls = new long[strs == null ? 0 : strs.length];
        if (strs != null) {
            for (int i = 0; i < ls.length; i++) {
                ls[i] = Long.parseLong(strs[i]);
            }
        }
        return ls;
    }

    /**
     * string[] ->Integer[]
     *
     * @param strs str array
     * @return integer array
     */
    public static Integer[] format2IntegerArray(String[] strs) {
        Integer[] ls = new Integer[strs == null ? 0 : strs.length];
        if (strs != null) {
            for (int i = 0; i < ls.length; i++) {
                ls[i] = Integer.valueOf(strs[i]);
            }
        }
        return ls;
    }

    /**
     * string[] ->Long[]
     *
     * @param strs string array
     * @return long array
     */
    public static Long[] format2LongArray(String[] strs) {
        Long[] ls = new Long[strs == null ? 0 : strs.length];
        if (strs != null) {
            for (int i = 0; i < ls.length; i++) {
                ls[i] = Long.valueOf(strs[i]);
            }
        }
        return ls;
    }

    /**
     * 字符串转换long数组方法,
     *
     * @param str String 转换的字符串
     * @param flg split 截取符号
     * @return long array
     */
    public static long[] format2longArray(String str, String flg) {
        String[] ids1 = str.split(flg, 0);
        long[] ids = new long[ids1.length];
        for (int i = 0; i < ids1.length; i++) {
            ids[i] = Long.parseLong(ids1[i]);
        }
        return ids;
    }

    /**
     * 字符串转int[]
     *
     * @param strs string
     * @param flg  split char
     * @return int array
     */
    public static int[] format2IntArray(String strs, String flg) {
        if (strs.length() <= 0) {
            return new int[0];
        }

        String[] items = strs.split(flg, 0);
        int[] temp = new int[items.length];
        for (int j = 0; j < items.length; j++) {
            temp[j] = Integer.parseInt(items[j]);
        }
        return temp;
    }

    /**
     * 字符串转换Long数组方法,
     *
     * @param str String 转换的字符串
     * @param flg split 截取符号
     * @return long array
     */
    public static Long[] format2LongArray(String str, String flg) {
        if (isEmpty(str, true)) {
            return new Long[0];
        }
        String[] ids1 = str.split(flg, 0);
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < ids1.length; i++) {
            if (!isEmpty(ids1[i], true)) {
                result.add(Long.valueOf(ids1[i]));
            }
        }
        return result.toArray(new Long[result.size()]);
    }

    /**
     * 字符串转Integer[]
     *
     * @param strs string
     * @param flg  split char
     * @return integer array
     */
    public static Integer[] format2IntegerArray(String strs, String flg) {
        if (isEmpty(strs, true)) {
            return new Integer[0];
        }

        String[] items = strs.split(flg, 0);
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < items.length; j++) {
            if (!isEmpty(items[j], true)) {
                result.add(Integer.valueOf(items[j]));
            }
        }
        return result.toArray(new Integer[result.size()]);
    }

    /**
     * 判断是否是double
     *
     * @param value string value
     * @return is double
     */
    public static boolean isDouble(String value) {
        try {
            Double.valueOf(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 验证是否long
     *
     * @param value str
     * @return is long
     */
    public static boolean isLong(String value) {
        try {
            Long.valueOf(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 验证是否 integer
     *
     * @param value str
     * @return is long
     */
    public static boolean isInteger(String value) {
        try {
            Integer.valueOf(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断是否为空值
     *
     * @param str string
     * @return is empty
     */
    public static boolean isEmpty(String str) {
        return isEmpty(str, false);
    }

    /**
     * 判断任意值是否为空值
     *
     * @param str string array
     * @return any empty
     */
    public static boolean isEmpty(String... str) {
        boolean r = true;
        for (String s : str) {
            r &= isEmpty(s, false);
        }
        return r;
    }

    /**
     * 判断是否为空值
     *
     * @param str  string
     * @param trim 是否去除两端空格
     * @return is empty
     */
    public static boolean isEmpty(String str, boolean trim) {
        return str == null || "".equals(trim ? str.trim() : str);
    }

    /**
     * 判断是否为空值
     *
     * @param obj 常用数据类型|String |Object |Collection|Map
     * @return 是否为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        return isEmpty(obj, true);
    }

    /**
     * 判断是否为空值
     *
     * @param obj  object
     * @param trim 是否去除两端空格
     * @return is empty
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj, boolean trim) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        } else if (obj instanceof String) {
            return isEmpty((String) obj, trim);
        } else {
            return isEmpty(obj.toString(), trim);
        }
    }

    /**
     * 判断是否为空值
     *
     * @param str  string arrays
     * @param trim 是否去除两端空格
     * @return any is empty
     */
    public static boolean isEmpty(boolean trim, String... str) {
        boolean r = true;
        if (str != null) {
            r = false;
            for (String s : str) {
                r |= (s == null || "".equals(trim ? s.trim() : s));
            }
        }
        return r;
    }

    /**
     * 判断是否为空值
     *
     * @param str  object array
     * @param trim 是否去除两端空格
     * @return any is empty
     */
    public static boolean isEmpty(boolean trim, Object... str) {
        boolean r = true;
        if (str != null) {
            r = false;
            for (Object o : str) {
                r |= isEmpty(o, trim);
            }
        }
        return r;
    }

    /**
     * reg 取值 判断
     *
     * @param value   需要判断的值
     * @param notNull 是否不允许为空
     * @param trim    是否去除空格
     * @param regex   验证的Regex
     * @return 验证是否通过
     */
    public static boolean matches(String value, boolean notNull, boolean trim, String regex) {
        String str = value == null ? null : (trim ? value.trim() : value);
        return matches(str, notNull, regex);
    }

    /**
     * 正则验证字符串
     *
     * @param value   值
     * @param notNull 不能为空
     * @param regex   regex
     * @return str matches regex
     */
    public static boolean matches(String value, boolean notNull, String regex) {
        if (notNull && isEmpty(value)) {
            return false;
        }
        if (!notNull && isEmpty(value)) {
            return true;
        }

        return matches(value, regex);
    }

    /**
     * 正则表达式
     *
     * @param value 值
     * @param regex 正则表达式
     * @return str matches regex
     */
    public static boolean matches(String value, String regex) {
        if (isEmpty(value)) {
            return false;
        }
        return value.matches(regex);
    }

    /**
     * 采用{index}占位符来格式化字符串
     *
     * @param str    字符串
     * @param params 参数
     * @return FORMAT STR
     */
    public static String format(String str, Object... params) {
        return format(str, null, params);
    }

    /**
     * 采用{index}占位符来格式化字符串
     *
     * @param str      字符串
     * @param addMarks 替换字符串时添加的符号(拼装sql用)
     * @param params   参数
     * @return format str
     */
    public static String format(String str, Character addMarks, Object... params) {
        // 这里用于验证数据有效性
        if (isEmpty(str, true)) {
            return "";
        }
        /*
         * 如果用于生成SQL语句，这里用于在字符串前后加单引号
         */
        if (addMarks != null) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof String) {
                    params[i] = String.valueOf(addMarks) + params[i] + addMarks;
                }
            }
        }
        // 这里的作用是只匹配{}里面是数字的子字符串
        Matcher matcher = PATTERN_FORMAT.matcher(str);
        int index = 0;
        int currentIndex = 0;
        while (matcher.find()) {
            // 获取{}里面的数字作为匹配组的下标取值
            index = matcher.group(1) == null ? currentIndex : Integer.parseInt(matcher.group(1));
            // 这里得考虑数组越界问题，{1000}也能取到值么？？
            if (index < params.length) {
                // 替换，以{}数字为下标，在参数数组中取值
                str = str.replaceFirst("\\{" + (matcher.group(1) == null ? "" : matcher.group(1)) + "}", params[index].toString());
            }
            currentIndex++;
        }
        return str;
    }

    /**
     * 字符串去空格转integer
     *
     * @param value obj
     * @return integer
     */
    public static Integer getInteger(Object value) {
        if (value == null) {
            return null;
        }
        try {
            if (value instanceof Integer) {
                return (Integer) value;
            }
            return Integer.valueOf(String.valueOf(value).trim());
        } catch (Exception e) {
            LOG.error("try convert to integer error:{}", value, e);
        }
        return null;
    }

    /**
     * 字符串去空格转double
     *
     * @param value obj
     * @return double
     */
    public static Double getDouble(Object value) {
        try {
            if (value instanceof Double) {
                return (Double) value;
            }
            return Double.valueOf(String.valueOf(value).trim());
        } catch (Exception e) {
            LOG.error("try convert to double error:{}", value, e);
        }
        return null;
    }

    /**
     * 字符串去空格转long
     *
     * @param value obj
     * @return long
     */
    public static Long getLong(Object value) {
        try {
            if (value instanceof Long) {
                return (Long) value;
            }
            return Long.valueOf(String.valueOf(value).trim());
        } catch (Exception e) {
            LOG.error("try convert to long error:{}", value, e);
        }
        return null;
    }

    /**
     * 将long 转为指定位数的string
     *
     * @param num num
     * @param len string of length for num
     * @return string
     */
    public static String getStringByLong(Long num, int len) {
        return String.format("%0" + len + "d", num);
    }

    /**
     * 拼接指定数量的str
     *
     * @param str str
     * @param len count
     * @return space
     */
    public static String getStringByChar(String str, int len, String sp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(str);
            if (sp != null && i < len - 1) {
                sb.append(sp);
            }
        }
        return sb.toString();
    }

    /**
     * 合并为字符串
     *
     * @param obj 需要合并的对象数组
     * @param c   分割字符串
     * @return 合并后的字符串
     */
    public static String join(Object[] obj, char c) {
        return join(obj, String.valueOf(c));
    }

    /**
     * 合并为字符串
     *
     * @param obj 需要合并的对象数组
     * @param c   分割字符串
     * @return 合并后的字符串
     */
    public static String join(Object[] obj, String c) {
        StringBuilder sb = new StringBuilder();
        if (obj != null && obj.length > 0) {
            for (Object o : obj) {
                sb.append(c).append(o);
            }
            sb.delete(0, c.length());
        }
        return sb.toString();
    }

    /**
     * 合并为字符串
     *
     * @param obj 需要合并的对象数组
     * @param c   分割字符串
     * @return 合并后的字符串
     */
    public static String joinIfNotEmpty(Object[] obj, String c) {
        StringBuilder sb = new StringBuilder();
        if (obj != null && obj.length > 0) {
            for (Object o : obj) {
                if (!isEmpty(o, true)) {
                    sb.append(c).append(o);
                }
            }
            sb.delete(0, c.length());
        }
        return sb.toString();
    }

    /**
     * KMP算法实现
     */
    public static int kmp(String source, String pattern) {
        int[] n = getN(pattern);
        int res = 0;
        int sourceLength = source.length();
        int patternLength = pattern.length();
        for (int i = 0; i <= (sourceLength - patternLength); ) {
            res++;
            // 要比较的字符串
            String str = source.substring(i, i + patternLength);
            LOG.debug(str);
            int count = getNext(pattern, str, n);
            LOG.debug("移动{}步", count);
            if (count == 0) {
                LOG.debug("KMP：匹配成功");
                break;
            }
            i += count;
        }
        LOG.debug("KMP：一共匹配 {} 次数", res);
        return res;
    }

    /**
     * 得到下一次要移动的次数
     *
     * @param pattern 字符串
     * @param str     匹配串
     * @param nArr    位置
     * @return 0, 字符串匹配；
     */
    private static int getNext(String pattern, String str, int[] nArr) {
        int n = pattern.length();
        char[] v1 = str.toCharArray();
        char[] v2 = pattern.toCharArray();
        int x = 0;
        while (n-- != 0) {
            if (v1[x] != v2[x]) {
                if (x == 0) {
                    // 如果第一个不相同，移动1步
                    return 1;
                }
                // x:第一次出现不同的索引的位置，即j
                return x - nArr[x - 1];
            }
            x++;
        }
        return 0;
    }

    private static int[] getN(String pattern) {
        char[] pat = pattern.toCharArray();
        int j = pattern.length() - 1;
        int[] n = new int[j + 1];
        final int i1 = 2;
        for (int i = j; i >= i1; i--) {
            n[i - 1] = getK(i, pat);
        }
        for (int a : n) {
            LOG.debug("{}", a);
        }
        return n;
    }

    private static int getK(int j, char[] pat) {
        int x = j - 2;
        int y = 1;
        while (x >= 0 && compare(pat, 0, x, y, j - 1)) {
            x--;
            y++;
        }
        return x + 1;
    }

    private static boolean compare(char[] pat, int b1, int e1, int b2, int e2) {
        int n = e1 - b1 + 1;
        while (n-- != 0) {
            if (pat[b1] != pat[b2]) {
                return true;
            }
            b1++;
            b2++;
        }
        return false;
    }

    /**
     * object to string
     *
     * @param obj obj
     * @return string
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            return obj.toString();
        }
    }

    /**
     * object to string
     *
     * @param obj obj
     * @return string
     * @deprecated use {@link CommonUtils#toString(Object obj)}
     */
    @Deprecated
    public static String objToString(Object obj) {
        return toString(obj);
    }

    /**
     * 比较字符串
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return 是否相等
     */
    public static boolean equals(final String cs1, final String cs2) {
        if (cs1 == null || cs2 == null) {
            return cs1 == null && cs2 == null;
        }
        if (cs1.length() != cs2.length()) {
            return false;
        }
        return cs1.equals(cs2);
    }

    /**
     * 比较字符串,忽略大小写
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return 是否相等
     */
    public static boolean equalsIgnoreCase(final String cs1, final String cs2) {
        if (cs1 == null || cs2 == null) {
            return cs1 == null && cs2 == null;
        }
        if (cs1.length() != cs2.length()) {
            return false;
        }
        return cs1.equalsIgnoreCase(cs2);
    }

    /**
     * 小于等于<br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param l2 参数2
     * @return c1 <= c2 return true
     */
    public static boolean le(Long l1, Long l2) {
        if (l1 == null || l2 == null) {
            return false;
        }
        return l1.compareTo(l2) <= 0;
    }

    /**
     * 小于等于<br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param i2 参数2
     * @return c1 <= c2 return true
     */
    public static boolean le(Long l1, Integer i2) {
        if (l1 == null || i2 == null) {
            return false;
        }
        return l1.compareTo(Long.valueOf(i2)) <= 0;
    }

    /**
     * 小于等于<br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param i2 参数2
     * @return c1 <= c2 return true
     */
    public static boolean le(Integer i1, Integer i2) {
        if (i1 == null || i2 == null) {
            return false;
        }
        return i1.compareTo(i2) <= 0;
    }

    /**
     * 小于等于<br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param l2 参数2
     * @return c1 <= c2 return true
     */
    public static boolean le(Integer i1, Long l2) {
        if (i1 == null || l2 == null) {
            return false;
        }
        return Long.valueOf(i1).compareTo(l2) <= 0;
    }

    /**
     * 小于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param l2 参数2
     * @return c1 < c2 return true
     */
    public static boolean lt(Long l1, Long l2) {
        if (l1 == null || l2 == null) {
            return false;
        }
        return l1.compareTo(l2) < 0;
    }

    /**
     * 小于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param i2 参数2
     * @return c1 < c2 return true
     */
    public static boolean lt(Integer i1, Integer i2) {
        if (i1 == null || i2 == null) {
            return false;
        }
        return i1.compareTo(i2) < 0;
    }

    /**
     * 小于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param i2 参数2
     * @return c1 < c2 return true
     */
    public static boolean lt(Long l1, Integer i2) {
        if (l1 == null || i2 == null) {
            return false;
        }
        return l1.compareTo(Long.valueOf(i2)) < 0;
    }

    /**
     * 小于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param l2 参数2
     * @return c1 < c2 return true
     */
    public static boolean lt(Integer i1, Long l2) {
        if (i1 == null || l2 == null) {
            return false;
        }
        return Long.valueOf(i1).compareTo(l2) < 0;
    }


    /**
     * 大于等于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param l2 参数2
     * @return c1 >= c2 return true
     */
    public static boolean ge(Long l1, Long l2) {
        if (l1 == null || l2 == null) {
            return false;
        }
        return l1.compareTo(l2) >= 0;
    }

    /**
     * 大于等于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param i2 参数2
     * @return c1 >= c2 return true
     */
    public static boolean ge(Long l1, Integer i2) {
        if (l1 == null || i2 == null) {
            return false;
        }
        return l1.compareTo(Long.valueOf(i2)) >= 0;
    }

    /**
     * 大于等于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param i2 参数2
     * @return c1 >= c2 return true
     */
    public static boolean ge(Integer i1, Integer i2) {
        if (i1 == null || i2 == null) {
            return false;
        }
        return i1.compareTo(i2) >= 0;
    }

    /**
     * 大于等于 <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param l2 参数2
     * @return c1 >= c2 return true
     */
    public static boolean ge(Integer i1, Long l2) {
        if (i1 == null || l2 == null) {
            return false;
        }
        return Long.valueOf(i1).compareTo(l2) >= 0;
    }

    /**
     * 大于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param l2 参数2
     * @return c1 > c2 return true
     */
    public static boolean gt(Long l1, Long l2) {
        if (l1 == null || l2 == null) {
            return false;
        }
        return l1.compareTo(l2) > 0;
    }

    /**
     * 大于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param i2 参数2
     * @return c1 > c2 return true
     */
    public static boolean gt(Integer i1, Integer i2) {
        if (i1 == null || i2 == null) {
            return false;
        }
        return i1.compareTo(i2) > 0;
    }

    /**
     * 大于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param i2 参数2
     * @return c1 > c2 return true
     */
    public static boolean gt(Long l1, Integer i2) {
        if (l1 == null || i2 == null) {
            return false;
        }
        return l1.compareTo(Long.valueOf(i2)) > 0;
    }

    /**
     * 大于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param l2 参数2
     * @return c1 > c2 return true
     */
    public static boolean gt(Integer i1, Long l2) {
        if (i1 == null || l2 == null) {
            return false;
        }
        return Long.valueOf(i1).compareTo(l2) > 0;
    }

    /**
     * 等于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1 参数1
     * @param l2 参数2
     * @return c1 == c2 return true
     */
    public static boolean eq(Integer i1, Long l2) {
        if (i1 == null || l2 == null) {
            return false;
        }
        return Long.valueOf(i1).compareTo(l2) == 0;
    }

    /**
     * 等于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param i1           参数1
     * @param l2           参数2
     * @param eqAtBothNull 当两者为空时 是否为相同
     * @return c1 == c2 return true
     */
    public static boolean eq(Integer i1, Long l2, boolean eqAtBothNull) {
        return eq(Long.valueOf(i1), l2, eqAtBothNull);
    }

    /**
     * 等于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1 参数1
     * @param i2 参数2
     * @return c1 == c2 return true
     */
    public static boolean eq(Long l1, Integer i2) {
        if (l1 == null || i2 == null) {
            return false;
        }
        return l1.compareTo(Long.valueOf(i2)) == 0;
    }

    /**
     * 等于  <br>
     * 比较两个不为空的数据,任意参数为空则为false <br>
     *
     * @param l1           参数1
     * @param i2           参数2
     * @param eqAtBothNull 当两者为空时 是否为相同
     * @return c1 == c2 return true
     */
    public static boolean eq(Long l1, Integer i2, boolean eqAtBothNull) {
        return eq(l1, Long.valueOf(i2), eqAtBothNull);
    }

    /**
     * 判断相等
     *
     * @param v1           v1
     * @param v2           v2
     * @param eqAtBothNull 当两者为空时 是否为相同
     * @return 是否相等
     */
    public static boolean eq(Integer v1, Integer v2, boolean eqAtBothNull) {
        if (v1 == null || v2 == null) {
            return v1 == null && v2 == null && eqAtBothNull;
        }
        return v1.equals(v2);
    }

    /**
     * 判断相等
     *
     * @param v1 v1
     * @param v2 v2
     * @return 是否相等
     */
    public static boolean eq(Integer v1, Integer v2) {
        return eq(v1, v2, false);
    }

    /**
     * 判断相等
     *
     * @param v1           v1
     * @param v2           v2
     * @param eqAtBothNull 当两者为空时 是否为相同
     * @return 是否相等
     */
    public static boolean eq(Long v1, Long v2, boolean eqAtBothNull) {
        if (v1 == null || v2 == null) {
            return v1 == null && v2 == null && eqAtBothNull;
        }
        return v1.equals(v2);
    }

    /**
     * 判断相等
     *
     * @param v1 v1
     * @param v2 v2
     * @return 是否相等
     */
    public static boolean eq(Long v1, Long v2) {
        return eq(v1, v2, false);
    }

    /**
     * 判断指定的兑现是否为空,为空则返回指定的默认值
     *
     * @param obj  对象
     * @param def  默认值
     * @param <T>  泛型
     * @param trim 是否去除首尾空格
     * @return 对象或默认值
     */
    public static <T> T getOrDefault(T obj, T def, boolean trim) {
        if (isEmpty(obj, trim)) {
            return def;
        }
        return obj;
    }

    /**
     * 判断指定的对象去除首尾空格后是否为空,为空则返回指定的默认值
     *
     * @param obj 对象
     * @param def 默认值
     * @param <T> 泛型
     * @return 对象或默认值
     */
    public static <T> T getOrDefault(T obj, T def) {
        return getOrDefault(obj, def, true);
    }

    /**
     * 异常栈转字符串
     *
     * @param throwable 异常
     * @return
     */
    public static String getStackTrace(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        } catch (Exception e) {
            LOG.error("", e);
        }
        return throwable.toString();
    }
}
