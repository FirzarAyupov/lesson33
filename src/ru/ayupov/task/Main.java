package ru.ayupov.task;

import java.util.HashMap;
import java.util.Map;

/*
Вывести максимально встречающийся символ в строке.
Пример:
This is test message
Character: s has occurred maximum times in String: 5
 */
public class Main {
    public static void main(String[] args) {
        printMaxCharCount("This is test message");
    }

    public static Map<Character, Integer> getCharCount(String str) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }
        return map;
    }

    public static void printMaxCharCount(String str) {
        int max = 0;
        char maxCountChar = '*';
        Map<Character, Integer> map = getCharCount(str);
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                maxCountChar = item.getKey();
            }
        }
        System.out.printf("Character: %s has occurred maximum times in String: %d", maxCountChar, max);
    }
}
