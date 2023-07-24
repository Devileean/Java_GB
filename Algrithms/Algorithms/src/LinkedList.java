public class LinkedList<T extends Comparable<T>> {
    private Node root;
    public int getSize() {
        return size;
    }
    private int size;
    public void add(T value) {
        Node newNode = new Node(value, null);
        if (root == null) {
            root = newNode;
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = newNode;
        size++;
    }

    public void print() {
        System.out.print(" ");
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println(" null");
    }

    private void quickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        T pivot = this.getValue((leftMarker + rightMarker) / 2);
        do {
            while (this.getValue(leftMarker).compareTo(pivot) < 0)
                leftMarker++;
            while (this.getValue(rightMarker).compareTo(pivot) > 0)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker)
                    this.swap(leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder)
            quickSort(leftMarker, rightBorder);
        if (leftBorder < rightMarker)
            quickSort(leftBorder, rightMarker);
    }

    public T getValue(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode.value;
    }

    public void swap(int index_1, int index_2) {
        if (index_1 >= size || index_2 >= size || index_1 == index_2 || index_1 < 0 || index_2 < 0)
            return;
        Node node_1 = null;
        Node node_2 = null;
        Node currentNode = root;
        for (int i = 0; node_1 == null || node_2 == null; i++) {
            if (i == index_1)
                node_1 = currentNode;
            else if (i == index_2)
                node_2 = currentNode;
            currentNode = currentNode.next;
        }
        T temp = node_1.value;
        node_1.value = node_2.value;
        node_2.value = temp;
    }

    /*home work
    Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).
     */
    public void reverseList() {
        if (getSize() == 0)
            return;
        Node reversedPart = null;
        Node current = root;
        while (current != null) {
            Node next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
        }
        root = reversedPart;
    }

    private class Node {
        public T value;
        public Node next;

        public Node(T _value, Node _next) {
            this.value = _value;
            this.next = _next;
        }
    }
}