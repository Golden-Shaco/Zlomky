package cz.uhk.merapp.data;

import java.util.List;
import java.util.ArrayList;

public class Mereni {
    private List<Number> data = new ArrayList<Number>();

    public void pridat(Number n) {
        data.add(n);
    }

    public Number secist() {
        Number soucet = 0;
        for(Number n : data){
            soucet = soucet.doubleValue() + n.doubleValue();
        }
        return soucet;
    }

    public Number prumer() {
        return secist().doubleValue() / data.size();
    }

    public Number max() {
        Number max = data.getFirst();
        for (Number n : data){
            if (n.doubleValue() > max.doubleValue())
                max = n;
        }
        return max;
    }

    public Number min() {
        Number min = data.getFirst();
        for (Number n : data){
            if (n.doubleValue() < min.doubleValue())
                min = n;
        }
        return min;
    }

    public Number get(int index) {
        return data.get(index);
    }

    public int size() {
        return data.size();
    }
}
