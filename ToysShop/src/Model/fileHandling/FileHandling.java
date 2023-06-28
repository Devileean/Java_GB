package Model.fileHandling;

import java.io.*;

import java.util.*;

import Console.View;

public class FileHandling {
    /*
     * Работа с фалами
     */

    //String path = "/Users/devileean/Desktop/projects/Java_GB/ToysShop/src/";  // Место
                                                                                // хранения
                                                                                // файла
                                                                                // на
                                                                                // компьютере
    String path = "/Users/devileean/Desktop/projects/Java_GB/ToysShop/src/";

    String nameFileToy = "DataToy.txt"; // Название файла для хранения списка игрушек розыгрыша.

    String nameFileListToyRaffle = "ListToyRaffle.txt"; // Название файла разыгранных игрушек.

    String nameFileReceivedToys = "ReceivedToys.txt"; // Название файла забранных игрушек.

    public void setDataToy(ArrayList<Map<String, String>> listMap) {
        /*
         * Создание файл и запись данных данных игрушек для розыгрыша
         */

        String dataFile = path + nameFileToy; // Файл, куда записываются данные с игрушками

        ListIterator<Map<String, String>> itr = listMap.listIterator(); // Создание итератора

        try (FileWriter fw = new FileWriter(dataFile, false)) // Запись данных в файл
        {

            while (itr.hasNext()) {
                Map<String, String> list = itr.next();

                fw.append(list.get("ID") + "\n");
                fw.append(list.get("Name") + "\n");
                fw.append(list.get("Quantity") + "\n");
                fw.append(list.get("Possibility") + "\n");

            }
        }

        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<Map<String, String>> getDataToy() {

        /*
         * Чтение файла где хранятся данные по игрушкам для розыгрыша
         */

        String dataFile = path + nameFileToy; // Файл, куда записываются данные с игрушками

        ArrayList<Map<String, String>> listMap = new ArrayList();

        ArrayList<String> listRedData = new ArrayList();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(dataFile));
            String tempData;
            while ((tempData = br.readLine()) != null) {

                listRedData.add(tempData);

            }

            ListIterator<String> itr1 = listRedData.listIterator(); // Создание итератора
            Integer tempIndexNew = 0;
            while (itr1.hasNext()) {
                String c = itr1.next();
                tempIndexNew++;
            }
            ListIterator<String> itr = listRedData.listIterator();
            Integer tempIndex = 0;
            while (tempIndexNew != tempIndex) {

                Map<String, String> listToy = new HashMap<String, String>();
                while (itr.hasNext()) {

                    String b = itr.next();

                    if (tempIndex % 4 == 0) {
                        String a = "ID";
                        listToy.put(a, b);
                    } else if (tempIndex % 4 == 1) {
                        String a = "Name";
                        listToy.put(a, b);
                    } else if (tempIndex % 4 == 2) {
                        String a = "Quantity";
                        listToy.put(a, b);
                    } else if (tempIndex % 4 == 3) {
                        String a = "Possibility";
                        listToy.put(a, b);
                        listMap.add(listToy);
                        tempIndex++;
                        break;
                    }
                    tempIndex++;

                }
            }

            br.close();

        } catch (

        FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listMap;

    }

    public void setListToyRaffle(Queue<String> listRaffledToys) {
        /*
         * Создание файл и запись в файл разыгранных игрушек.
         */

        String dataFile = path + nameFileListToyRaffle; // Файл, куда записываются данные с игрушками.

        try (FileWriter d = new FileWriter(dataFile, false)) // Запись данных в файл
        {

            for (String data : listRaffledToys) {
                d.append(data + "\n");

            }
        }

        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Queue<String> getListToyRaffle() {

        /*
         * Чтение файла, где находятся данные разыгранных игрушек.
         */

        String dataFile = path + nameFileListToyRaffle; // Файл, куда записываются данные с игрушками

        Queue<String> ListToyRaffle = new LinkedList();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(dataFile));
            String tempData;
            while ((tempData = br.readLine()) != null) {

                ListToyRaffle.add(tempData);

            }

            br.close();

        } catch (

        FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ListToyRaffle;

    }

    public void setReceivedToys(String Toy) {
        /*
         * Создание файл и запись в файл разыгранных игрушек.
         */

        String dataFile = path + nameFileReceivedToys; // Файл, куда записываются данные с игрушками.

        try (FileWriter da = new FileWriter(dataFile, true)) // Запись данных в файл
        {

                da.write(Toy + "\n");

        }

        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
