import zlomky.Zlomek;

public class Main {
    static void main() {
        IO.println("Projekt Zlomky");

        Zlomek a  = new Zlomek(3, 4);
        IO.println("Zlomek: " + a.getCitatel() + " / " + a.getJmenovatel());
        IO.println(a.toString());
    }
}
