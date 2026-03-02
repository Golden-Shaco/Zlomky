package cz.uhk;

import cz.uhk.zlomky.Zlomek;

public class Main {
    static void main() {
        IO.println("Projekt Zlomky");

        Zlomek a  = new Zlomek(1, 2);
        Zlomek b  = new Zlomek(3, 4);
        IO.println('+' + a.plus(b).toString());
        IO.println('-' + a.minus(b).toString());
        IO.println('*' + a.multiply(b).toString());
        IO.println('/' + a.divide(b).toString());

        Zlomek[] pole = new Zlomek[] {
                new Zlomek(1, 3),
                new Zlomek(1, 2),
                new Zlomek(6, 5),
                new Zlomek(4, 3),
                new Zlomek(7, 8),
                new Zlomek(13, 10)
        };
        Zlomek ap = prumer(pole);
        IO.println("Aritmetický průměr: %s".formatted(ap.toString()));

        int prumerRaunded = ap.intValue();
        IO.println("Zaokrouhlen: %d".formatted(prumerRaunded));
    }

    private static Zlomek prumer(Zlomek[] pole) {
        Zlomek temp = new Zlomek();
        for (Zlomek z : pole) {
            temp = temp.plus(z);
        }
        return temp.divide(new Zlomek(pole.length, 1));
    }
}
