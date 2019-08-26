import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    /**
     * 唯一摩尔斯密码词
     * 目前还是通过暴力解法，双重循环，
     * 利用HashMap来产生字符与国际摩尔斯密码的映射，
     * 利用集合Set的元素唯一性给翻译结果去重。
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        //字母们对应的国际摩尔斯密码
        String[] abcList={".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--",
                "-..-","-.--","--.."};

        //利用HashMap，将字符与国际摩尔斯密码对应上
        HashMap<Character,String> charToStringMap=new HashMap<>();
        int index=0;
        for (char i = 'a'; i <= 'z'; i++) {
            charToStringMap.put(i,abcList[index++]);
        }

        //利用Set存放不同的翻译结果
        Set<String> set=new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuffer str=new StringBuffer();
            for (int j = 0; j < words[i].length(); j++) {
                str.append(charToStringMap.get(words[i].charAt(j)));
            }
            set.add(str.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};

        Solution804 solution=new Solution804();
        System.out.println(solution.uniqueMorseRepresentations(words));


    }
}
