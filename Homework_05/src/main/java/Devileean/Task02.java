package Devileean;

import java.util.HashMap;
import java.util.Map;

/**
 * 2) Подсчитать количество искомого слова, через map (наполнением значение,
 * где искомое слово будет являться ключом), вносить все слова не нужно
 */
public class Task02 {
    public static void main(String[] args) {
        String inputString = "Россия идет вперед всей планеты. Планета — это не Россия.".toLowerCase();
        String searchWord = "Россия".toLowerCase();
        Integer count = searchWord(inputString, searchWord);
        System.out.println(searchWord + ": " + count);

    }

    private static Integer searchWord(String inputString, String searchWord) {
        Map<String, Integer> count = new HashMap<>();
        for (String longWord : inputString.split(" ")) {
            String word = longWord.replaceAll("[^А-Яа-яЁё]", "");
            if (word.equals(searchWord)) {
                Integer item = count.get(word);
                if (item == null) item = 0;
                count.put(word, ++item);
            }
        }
        return count.get(searchWord);
    }
}