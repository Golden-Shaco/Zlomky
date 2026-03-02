package cz.uhk.zlomky;

public class Zlomek extends Number {
    private int citatel = 0;
    private int jmenovatel = 1;

    public Zlomek() {
    }

    public Zlomek(int citatel, int jmenovatel) {
        if (jmenovatel == 0) {

        }
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }

    public int getCitatel() {
        return citatel;
    }

    public void setCitatel(int citatel) {
        this.citatel = citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    public void setJmenovatel(int jmenovatel) {
        this.jmenovatel = jmenovatel;
    }

    @Override
    public int intValue() {
        return Math.round(citatel / (float)jmenovatel);
    }

    @Override
    public long longValue() {
        return Math.round(citatel / (float)jmenovatel);
    }

    @Override
    public float floatValue() {
        return citatel / (float)jmenovatel;
    }

    @Override
    public double doubleValue() {
        return citatel / (double)jmenovatel;
    }

    @Override
    public String toString() {
        return "Zlomek{" + citatel + " / " + jmenovatel + '}';
    }

    /**
     * Zjednodušší zlomek na jeho základní zvar
     *
     * @param z Zlomek
     * @return zlomek v základním tvaru
     */
    public Zlomek zkratit(Zlomek z) {
        int nsd = nsd(z.citatel, z.jmenovatel);
        return new Zlomek(z.citatel / nsd, z.jmenovatel / nsd);
    }

    /**
     * Vrátí nejmenšího společného dělitele
     *
     * @param a int
     * @param b int
     * @return int
     */
    private int nsd(int a, int b) {
        int vetsi;
        int mensi;
        int vysledek;
        if (a > b) {
            vetsi = a;
            mensi = b;
        } else {
            vetsi = b;
            mensi = a;
        }
        if (mensi == 0) {
            return 1;
        }
        do {
            vysledek = vetsi % mensi;
            vetsi = mensi;
            mensi = vysledek;
        } while (vysledek != 0);
        return vetsi;
    }

    /**
     * Metoda pro sčítání dvou zlomků
     *
     * @param a Zlomek
     * @return nový zlomek, který je součtem obou zlomků
     */
    public Zlomek plus(Zlomek a) {
        int tempCitatel = a.citatel * jmenovatel + citatel * a.jmenovatel;
        int tempJmenovatel = a.jmenovatel * jmenovatel;
        return zkratit(new Zlomek(tempCitatel, tempJmenovatel));
    }

    public Zlomek minus(Zlomek a) {
        int tempCitatel = citatel * a.jmenovatel - a.citatel * jmenovatel;
        int tempJmenovatel = a.jmenovatel * jmenovatel;
        return zkratit(new Zlomek(tempCitatel, tempJmenovatel));
    }

    public Zlomek multiply(Zlomek a) {
        return zkratit(new Zlomek(citatel * a.citatel, jmenovatel * a.jmenovatel));
    }

    public Zlomek divide(Zlomek a) {
        return zkratit(new Zlomek(citatel * a.jmenovatel, jmenovatel * a.citatel));
    }
}
