package Devileean;

public class Task004 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Validate:" + isValidSudoku(board));
    }

    /**
     * @param board двумерный массив судоку
     * @return true если в судоку нет ошибок
     */
    private static boolean isValidSudoku(char[][] board) {
        boolean result = true;
        for (char[] chars : board) {
            if (!rowCorrect(chars)) {
                result = false;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (!columnCorrect(board, i)) {
                result = false;
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (!blockCorrect(board, i, j)) {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * @param chars массив символов ряда
     * @return истина если в ряду нет повторений
     */
    private static boolean rowCorrect(char[] chars) {
        String allstring = "";
        boolean result = true;
        for (char ch : chars) {
            if (stringContains(ch, allstring)) {
                result = false;
            }
            allstring += ch;
        }
        return result;
    }

    /**
     * @param board        вся доска судоку
     * @param columnNumber номер проверяемой колонки
     * @return истина если в колонке нет повторений
     */
    public static boolean columnCorrect(char[][] board, int columnNumber) {
        String allstring = "";
        boolean result = true;
        char ch;
        for (int i = 0; i < board[0].length; i++) {
            ch = board[i][columnNumber];
            if (stringContains(ch, allstring)) {
                result = false;
            }
            allstring += ch;
        }
        return result;
    }

    /**
     * @param board    вся доска судоку
     * @param startRow индекс первой строки блока
     * @param StartCol индекс первой колонки блока
     * @return истина если в блоке нет повторений
     */
    public static boolean blockCorrect(char[][] board, int startRow, int StartCol) {
        String allstring = "";
        boolean result = true;
        char ch;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ch = board[startRow + i][StartCol + j];
                if (stringContains(ch, allstring)) {
                    result = false;
                }
                allstring += ch;
            }
        }
        return result;
    }

    /**
     * @param ch     искомый символ
     * @param string строка в которой ищем
     * @return входит ли символ в данную строку
     */
    public static boolean stringContains(char ch, String string) {
        boolean result = false;
        if (ch != '.') {
            result = string.contains(Character.toString(ch));
        }
        return result;
    }
}
