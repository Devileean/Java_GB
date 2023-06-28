package Model.ModelMethod;

import java.util.*;

import Console.View;

public class MetRaffleToy {

    View m = new View();

    MetRandom random = new MetRandom();

    public void raffleToy(ArrayList<Map<String, String>> listToy, Queue <String> listRaffledToys) {
        /*
         * Метод розыгрыша игрушек из существующего списка
         */
        String toy = "";

        Map<Integer, String> rendToy = new LinkedHashMap<>();

        ListIterator<Map<String, String>> newItr2 = listToy.listIterator(); // Создание итератора

        Boolean tempNoToyList = true;

        while (newItr2.hasNext()) {
            Map<String, String> temMap = newItr2.next();
            
            Integer tempQuantity = Integer.parseInt(temMap.get("Quantity"));
            if (tempQuantity > 0) {
                tempNoToyList = false;
            }

        }

        if (tempNoToyList){
           System.out.println("Общее количество игрушек, участвующих в розыгрыше, равно нулю!!!!");
           String s = m.getValueStr("Для продолжения нажмите Enter");
           return;
        }

        Integer index = 0;
        while (true) { // Розыгрыш игрушки 

            ListIterator<Map<String, String>> newItr = listToy.listIterator(); // Создание итератора

            Integer randomNumber = random.randomMaxMin(0, 99); // Определение минимального числа

            Integer randomNumberDelta = 100 - randomNumber;


            Boolean tempBoolData = false;


            String b;

            while (newItr.hasNext()) { // Нахождение 
                Map<String, String> temMap = newItr.next();
                Integer tempNum = Integer.parseInt(temMap.get("Possibility"));
                Integer tempQuantity = Integer.parseInt(temMap.get("Quantity"));
                if (tempNum >= randomNumberDelta && tempQuantity > 0) {
                    tempBoolData = true;


                    b = temMap.get("ID");

                    rendToy.put(index, b);

                    index++;
                }

            }

            if (tempBoolData) { // Останов цикла поиска при нахождение хотя бы одной игрушки
                break;
            }
        }

        Integer prize = random.randomMaxMin(1, index - 1);

        String toyID = rendToy.get(prize);

        ListIterator<Map<String, String>> newItr1 = listToy.listIterator(); // Создание итератора

        while (newItr1.hasNext()) {
            Map<String, String> temMap = newItr1.next();

            if (temMap.get("ID").equals(toyID)) {
                toy = temMap.get("Name");
                Integer c =  (Integer.parseInt(temMap.get("Quantity")) - 1 );
                temMap.put("Quantity", c.toString());
            }
        }

        System.out.printf("В розыгрыше выпала игрушка %s.\n",toy);
        
        String s = m.getValueStr("Для продолжения нажмите Enter");

        listRaffledToys.add(toy);        

    }
}
