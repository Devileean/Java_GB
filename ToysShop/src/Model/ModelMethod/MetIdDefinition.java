package Model.ModelMethod;

import java.util.*;

public class MetIdDefinition {

    public Integer getID (ArrayList<Map<String, String>> listToy){
        /*
         * Автоматическое присваивание ID
         */

        Integer indexID = 0;

        ListIterator<Map<String, String>> itr = listToy.listIterator(); // Создание итератора 

        while (itr.hasNext()) {
            indexID=Integer.parseInt(itr.next().get("ID")); // Нахождение ID в ArrayList
        }
        
        indexID ++;

        return indexID;

    }
    
}
