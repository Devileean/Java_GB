package attestation;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var tree = new BinTree<Integer>();
        for (int i = 0; i < 10; i++) {
            tree.add(new Random().nextInt(15));
        }
        //вывести с раскраской в консоли
        tree.print();
    }
}