package Model.ModelMethod;

public class MetRandom {
    
    public Integer randomMaxMin (Integer minR, Integer maxR){
        /*
         * Метод нахождения случайного числа от min до мах.
         * Min и Max входят в диапазон случайной выборки.
         */

        maxR = maxR+1;

        Double minRD = (double) minR;
        Double maxRD = (double) maxR;

        Integer randomNumber = (int) ((Math.random()*maxRD)-minRD);


        return randomNumber;

    }
}
