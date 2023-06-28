package Presenter;

import java.util.*;

import Console.View;
import Model.ModelMethod.MetAddToy;
import Model.ModelMethod.MetChangeData;
import Model.ModelMethod.MetDeleteData;
import Model.ModelMethod.MetIdDefinition;
import Model.ModelMethod.MetRaffleToy;
import Model.ModelMethod.MetReceivingToys;
import Model.fileHandling.FileHandling;

public class Presenter {
    View view; // Метод взаимодействия с интерфейсом, консолью ввода.

    View m = new View(); // Описание меню

    MetAddToy addToy = new MetAddToy();

    Map<String, String> newDataToy = new LinkedHashMap<>(); // Данные про игрушек


    FileHandling fh = new FileHandling(); // Работа с файлами

    MetIdDefinition idDef = new MetIdDefinition();
    MetDeleteData del = new MetDeleteData(); // Метод удаления данных по игрушкам

    MetRaffleToy rt = new MetRaffleToy(); // метод розыгрыша игрушек

    Queue <String> listRaffledToys = new LinkedList(); // Список разыгранных игрушек

    MetReceivingToys ret = new MetReceivingToys(); // Метод получения игрушки.

    public Presenter(View v) {

        this.view = v;
    }

    public void buttonClick() {

        ArrayList<Map<String, String>> listToy = fh.getDataToy(); // Список игрушек для розыгрыша
        Queue <String> listRaffledToys = fh.getListToyRaffle(); // Список разыгранных игрушек

        while (true) {
            switch (m.Menu()) {
                case 0:// Вывод списка игрушек в консоль

                    ListIterator<Map<String, String>> itr = listToy.listIterator(); // Создание итератора

                    while (itr.hasNext()) {
                        m.printMap(itr.next());
                    }

                    String s = m.getValueStr("Для продолжения нажмите Enter");

                    break;
                case 1:// Вывод списка игрушек в консоль
                    System.out.print("Список разыгранных игрушек: ");

                    m.printQueue(listRaffledToys);

                    s = m.getValueStr("Для продолжения нажмите Enter");
                                        
                    break;
                case 2:// Добавление наименование новых игрушек для розыгрыша.

                    Integer idToy = idDef.getID(listToy); // Определение ID игрушки
                    System.out.println("ID игрушки :" + idToy);
                    addToy.SetIdToy(idToy);

                    String nameToy = m.getValueStr("Введите наименование игрушки: "); // Ввод наименования игрушки
                    addToy.SetNameToy(nameToy);

                    Integer quantityToy = m.getValueInt("Введите количество игрушек: "); // Ввод количества игрушек
                    addToy.SetQuantityToy(quantityToy);

                    Integer possiToy = m.getValueInt("Введите частоту выпадения игрушки: "); // Ввод количества игрушек
                    addToy.SetPossiToy(possiToy);

                    m.printMap(addToy.getNewToy());

                    String saveData = m.getValueStr(
                            "\nДля сохранения данных введите y + Enter. Для выход без сохранения нажмите Enter.\n");// Подтверждение
                                                                                                                    // сохранения

                    if (saveData.equals("y")) { // Сохранение данных по новой игрушки.

                        listToy.add(addToy.getNewToy());
                    }

                    break;
                case 3:// Изменение данных в существующих игрушкам для розыгрыша.

                    Integer idToyChange = m
                            .getValueInt("Введите ID игрушки, в номенклатуре которой надо сделать изменения: "); 
                            // Id игрушки для изменения 
                                                                                                                 
                           
                    MetChangeData cd = new MetChangeData();                                                                                             //                                                                                                                 // номенклатуры
                    switch (m.MenuChange()) {
                        case 1:// Редактирование наименования
                        
                            cd.changeName(listToy, idToyChange);
                            break;

                        case 2:// Редактирование количества игрушек

                            cd.changeQuantity(listToy, idToyChange);
                            break;

                        case 3:// Редактирование частоты выпадания
                            cd.changePossibility(listToy, idToyChange);
                            break;

                        case 0:// Выход из меню редактирования
                            break;
                    }

                    break;
                case 4:// Удаление данных по игрушкам

                    del.deleteData(listToy);

                    break;
                case 5:// Розыгрыш игрушек

                    rt.raffleToy(listToy,listRaffledToys);

                    break;
                case 6:// Выдача игрушек
                    
                    ret.ReceivingToys(listRaffledToys);
                    
                    break;

                case 7: // Выход из программы
                    fh.setDataToy(listToy);
                    fh.setListToyRaffle(listRaffledToys);

                    return;
            }

        }

    }

}
