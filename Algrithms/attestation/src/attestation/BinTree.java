package attestation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinTree<T extends Comparable<T>> {
    private Node root;

    /**
     * Добавление ноды
     * @param value число
     */
    public void add(T value) {
        if (root == null) {
            root = new Node();
            root.value = value;
            root.color = Color.black;
            return;
        }
        addNode(root, value);
    }

    /**
     * Добавление ноды с определением правая или левая и перебалансировкой
     * @param node нода
     * @param value значение
     * @return true или false
     */
    private boolean addNode(Node node, T value) {
        if (node.value == value)
            return false;
        if (node.value.compareTo(value) > 0) {
            if (node.left != null) {
                boolean result = addNode(node.left, value);
                node.left = rebalanced(node.left);
                return result;
            } else {
                node.left = new Node();
                node.left.value = value;
                return true;
            }
        } else {
            if (node.right != null) {
                boolean result = addNode(node.right, value);
                node.right = rebalanced(node.right);
                return result;
            } else {
                node.right = new Node();
                node.right.value = value;
                return true;
            }
        }
    }

    /**
     * Перебалансировка нод
     * @param node нода
     * @return Node result
     */
    private Node rebalanced(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.red
                    && (result.left == null || result.left.color == Color.black)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.red
                    && result.left.left != null && result.left.left.color == Color.red) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.red
                    && result.right != null && result.right.color == Color.red) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    /**
     * Переворот цвета
     * @param node нода
     */
    private void colorSwap(Node node) {
        node.right.color = Color.black;
        node.left.color = Color.black;
        node.color = Color.red;
    }

    /**
     * Перестановка ноды с право на лево
     * @param node нода
     * @return левая часть
     */
    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.red;
        return left;
    }
    /**
     * Перестановка ноды с лево на право
     * @param node нода
     * @return правая часть
     */
    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.red;
        return right;
    }

    private class Node {
        private T value;
        private Color color;
        private Node left;
        private Node right;

        Node() {
            color = Color.red;
        }
    }

    enum Color {red, black}

    /**
     * Печать древа с раскраской в консоль
     */
    public void print() {

        int maxDepth = maxDepth() + 3;
        int nodeCount = nodeCount(root);
        int width = 50;//maxDepth * 4 + 2;
        int height = nodeCount * 5;
        List<List<PrintNode>> list = new ArrayList<>();
        for (int i = 0; i < height; i++) /*Создание ячеек массива*/ {
            ArrayList<PrintNode> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(new PrintNode());
            }
            list.add(row);
        }

        list.get(height / 2).set(0, new PrintNode(root));
        list.get(height / 2).get(0).depth = 0;

        for (int j = 0; j < width; j++)  /*Принцип заполнения*/ {
            for (int i = 0; i < height; i++) {
                PrintNode currentNode = list.get(i).get(j);
                if (currentNode.node != null) {
                    currentNode.str = currentNode.node.value.toString();
                    currentNode.color = currentNode.node.color.toString();
                    if (currentNode.node.left != null) {
                        int in = i + (maxDepth / (int) Math.pow(2, currentNode.depth));
                        int jn = j + 3;
                        printLines(list, i, j, in, jn);
                        list.get(in).get(jn).node = currentNode.node.left;
                        list.get(in).get(jn).depth = list.get(i).get(j).depth + 1;

                    }
                    if (currentNode.node.right != null) {
                        int in = i - (maxDepth / (int) Math.pow(2, currentNode.depth));
                        int jn = j + 3;
                        printLines(list, i, j, in, jn);
                        list.get(in).get(jn).node = currentNode.node.right;
                        list.get(in).get(jn).depth = list.get(i).get(j).depth + 1;
                    }
                }
            }
        }
        for (int i = 0; i < height; i++) /*Чистка пустых строк*/ {
            boolean flag = true;
            for (int j = 0; j < width; j++) {
                if (!Objects.equals(list.get(i).get(j).str, " ")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.remove(i);
                i--;
                height--;
            }
        }

        for (var row : list) {
            for (var item : row) {
                if(item.color.equals("red")){
                    System.out.print(attestation.Color.RED + item.str + " " + attestation.Color.RESET);
                }
                else if(item.color.equals("black")){
                    System.out.print(attestation.Color.BLACK + item.str + " " + attestation.Color.RESET);
                }else
                    System.out.print(item.str + " ");
            }
            System.out.println();
        }
    }

    /**
     * Формирование строки
     * @param list список нод
     * @param i позиция
     * @param j позиция
     * @param i2 позиция
     * @param j2 позиция
     */
    private void printLines(List<List<PrintNode>> list, int i, int j, int i2, int j2) {
        if (i2 > i) // Идём вниз
        {
            while (i < i2) {
                i++;
                list.get(i).get(j).str = "|";
            }
            list.get(i).get(j).str = "\\";
        } else {
            while (i > i2) {
                i--;
                list.get(i).get(j).str = "|";
            }
            list.get(i).get(j).str = "/";
        }
        while (j < j2) {
            j++;
            list.get(i).get(j).str = "-";
        }
    }

    /**
     * Максмальная глубина
     * @return Math.max(left, right);
     */
    public int maxDepth() {
        return maxDepth2(0, root);
    }

    /**
     *  2 проверка максимальной глубины
     * @param depth глубина
     * @param node нода
     * @return Math.max(left, right);
     */
    private int maxDepth2(int depth, Node node) {
        depth++;
        int left = depth;
        int right = depth;
        if (node.left != null)
            left = maxDepth2(depth, node.left);
        if (node.right != null)
            right = maxDepth2(depth, node.right);
        return Math.max(left, right);
    }

    /**
     * Количество нод
     *
     * @param node нода
     * @return количество
     */
    private int nodeCount(Node node) {
        if (node != null) {
            return 1 + nodeCount(node.left) + nodeCount(node.right);
        }
        return 0;
    }

    private class PrintNode {
        Node node;
        String str;
        String color;
        int depth;

        public PrintNode() {
            node = null;
            str = " ";
            color = " ";
            depth = 0;
        }

        /**
         * формирование ноды
         * @param node нода
         */
        public PrintNode(Node node) {
            depth = 0;
            this.node = node;
            this.str = node.value.toString();
            this.color = node.color.toString();
        }
    }
}
