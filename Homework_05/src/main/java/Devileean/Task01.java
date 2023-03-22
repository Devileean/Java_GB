package Devileean;

import java.util.HashMap;
import java.util.Map;

/**
 * 1) Подсчитать количество вхождения каждого слова
 * Пример:
 * Россия идет вперед всей планеты. Планета — это не Россия.
 * toLoverCase().
 */
public class Task01 {
    public static void main(String[] args) {
        String inputString = "Россия идет вперед всей планеты. Планета — это не Россия.".toLowerCase();
        Map<String, Integer> count = countWords(inputString);
        System.out.println(count);

    }

    private static Map<String, Integer> countWords(String inputString) {
        Map<String, Integer> count = new HashMap<>();
        for (String longWord : inputString.split(" ")) {
            String word = longWord.replaceAll("[^А-Яа-яЁё]", "");
            if (word.isEmpty()) continue;
            Integer item = count.get(word);
            if (item == null) item = 0;
            count.put(word, ++item);
        }
        return count;
    }
}