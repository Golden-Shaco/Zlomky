package cz.uhk.merapp.data;

import cz.uhk.util.Seznam;
import cz.uhk.util.impl.SpojovySeznam;

public class Mereni {
    private Seznam<Number> data = new SpojovySeznam<>();

    public void pridat(Number n) {
        data.pridej(n);
    }

    public Number secist() {
        Number soucet = 0;
        for(Number n : data){
            soucet = soucet.doubleValue() + n.doubleValue();
        }
        return soucet;
    }

    public Number prumer() {
        return secist().doubleValue() / data.pocet();
    }

    public Number max() {
        Number max = data.vrat(0);
        for (Number n : data){
            if (n.doubleValue() > max.doubleValue())
                max = n;
        }
        return max;
    }

    public Number min() {
        Number min = data.vrat(0);
        for (Number n : data){
            if (n.doubleValue() < min.doubleValue())
                min = n;
        }
        return min;
    }

    public Number get(int index) {
        return data.vrat(index);
    }

    public int size() {
        return data.pocet();
    }
}
