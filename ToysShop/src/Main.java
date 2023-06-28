import Presenter.Presenter;
import Console.View;


public class Main {
    public static void main(String[] args) {
        Presenter p = new Presenter(new View());
        p.buttonClick(); // Старт программы;
    }
}