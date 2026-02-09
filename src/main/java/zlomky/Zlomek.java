package zlomky;

public class Zlomek {
    private int citatel = 0;
    private int jmenovatel = 1;

    public Zlomek() {}

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
    public String toString() {
        return "Zlomek{" +
                "citatel=" + citatel +
                ", jmenovatel=" + jmenovatel +
                '}';
    }
}
