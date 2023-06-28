package Model.ModelMethod;

import java.util.*;

import Console.View;

public class MetDeleteData {

    View m = new View();

    public void deleteData(ArrayList<Map<String, String>> listToy) {
        /*
         * Метод удаления данных из списка
         */

        Integer idToyChange = m
                .getValueInt("Введите ID игрушки, в номенклатуре которой надо сделать изменения: ");
        // Id игрушки для изменения
        ListIterator<Map<String, String>> newItr = listToy.listIterator(); // Создание итератора
        Boolean tempBoolData = true;
        while (newItr.hasNext()) {
            Map<String, String> temMap = newItr.next();
            if (temMap.get("ID").equals(idToyChange.toString())) {
                tempBoolData = false;
                m.printMap(temMap);
                String saveData = m.getValueStr(
                        "\nДля удаления данных по игрушке введите y + Enter. Для выход без удаления нажмите Enter.\n");// Подтверждение
                                                                                                                // сохранения
                if (saveData.equals("y")) {
                    
                    listToy.remove(temMap);
                    
                }
                break;
            }

        }

        if (tempBoolData) { // Вывод сообщения в консоль при отсутствие ID
            System.out.printf("Игрушки c ID %d не существует.\n", idToyChange);
            String nextP = m.getValueStr("Для продолжения нажмите Enter");
        }

    }

}
