package Model.ModelMethod;

import java.util.*;

import Console.View;




public class MetChangeData {

    View m = new View();
    String saveData;
    String nextP;
    

    public void changeName (ArrayList<Map<String, String>> listToy, Integer idToyChange){
        /*
         * Метод изменения наименования по ID игрушки.
         */

        ListIterator<Map<String, String>> newItr = listToy.listIterator(); // Создание итератора
        
        Boolean trmpBoolData = true;

        while (newItr.hasNext()) {
            Map <String,String> temMap = newItr.next();
            if (temMap.get("ID").equals(idToyChange.toString())) {
                trmpBoolData =false;
                m.printMap(temMap);
                String b = m.getValueStr("Введите новое наименование игрушки: ");
                String a = "Name";
                saveData = m.getValueStr(
                        "\nДля сохранения данных введите y + Enter. Для выход без сохранения нажмите Enter.\n");// Подтверждение
                                                                                                                // сохранения
                if (saveData.equals("y")) {
                    temMap.put(a, b);
                    m.printMap(temMap);
                }
            }

        }

        if (trmpBoolData){ // Вывод сообщения в консоль при отсутствие ID
            System.out.printf("Игрушки c ID %d не существует.\n",idToyChange);
            nextP = m.getValueStr("Для продолжения нажмите Enter"); 
            }
    }

    public void changeQuantity (ArrayList<Map<String, String>> listToy, Integer idToyChange){
        /*
         * Метод изменения количества игрушек по ID игрушки.
         */

        ListIterator<Map<String, String>> newItr = listToy.listIterator(); // Создание итератора
        
        Boolean trmpBoolData = true;

        while (newItr.hasNext()) {
            Map <String,String> temMap = newItr.next();
            if (temMap.get("ID").equals(idToyChange.toString())) {
                trmpBoolData =false;
                m.printMap(temMap);
                Integer b = m.getValueInt("Введите новое количество игрушек: ");
                String a = "Quantity";
                saveData = m.getValueStr(
                        "\nДля сохранения данных введите y + Enter. Для выход без сохранения нажмите Enter.\n");// Подтверждение
                                                                                                                // сохранения
                if (saveData.equals("y")) {
                    temMap.put(a, b.toString());
                    m.printMap(temMap);
                }
            }

        }

        if (trmpBoolData){ // Вывод сообщения в консоль при отсутствие ID
            System.out.printf("Игрушки c ID %d не существует.\n",idToyChange);
            nextP = m.getValueStr("Для продолжения нажмите Enter"); 
            }
    }
    
    public void changePossibility(ArrayList<Map<String, String>> listToy, Integer idToyChange){
        /*
         * Метод изменения вероятности выпадения  по ID игрушки.
         */

        ListIterator<Map<String, String>> newItr = listToy.listIterator(); // Создание итератора
        
        Boolean trmpBoolData = true;

        while (newItr.hasNext()) {
            Map <String,String> temMap = newItr.next();
            if (temMap.get("ID").equals(idToyChange.toString())) {
                trmpBoolData =false;
                m.printMap(temMap);
                Integer b = m.getValueInt("Введите новую вероятность выпадения игрушек: ");
                String a = "Possibility";
                saveData = m.getValueStr(
                        "\nДля сохранения данных введите y + Enter. Для выход без сохранения нажмите Enter.\n");// Подтверждение
                                                                                                                // сохранения
                if (saveData.equals("y")) {
                    temMap.put(a, b.toString());
                    m.printMap(temMap);
                }
            }

        }

        if (trmpBoolData){ // Вывод сообщения в консоль при отсутствие ID
            System.out.printf("Игрушки c ID %d не существует.\n",idToyChange);
            nextP = m.getValueStr("Для продолжения нажмите Enter"); 
            }
    }
}
