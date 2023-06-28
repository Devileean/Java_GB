package Model.ModelMethod;

import java.util.*;

import Console.View;
import Model.fileHandling.FileHandling;

public class MetReceivingToys {

    View m = new View();

    FileHandling fh = new FileHandling();

    
    public void ReceivingToys(Queue<String> listRaffledToys){
        /*
         * Метод получения игрушки
         */

        String receivedToys = listRaffledToys.remove();

        System.out.printf("Полученная игрушка: %s \n",receivedToys);

        fh.setReceivedToys(receivedToys);

        String s = m.getValueStr("Для выхода нажмите Enter");

        
    }
}
