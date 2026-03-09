package cz.uhk.util.impl;

import cz.uhk.util.Seznam;

import java.util.Iterator;

public class SpojovySeznam<E> implements Seznam<E> {
    private PrvekSeznamu<E> prvni, posledni;

    @Override
    public void pridej(E hodnota) {
        var temp = new PrvekSeznamu<E>(hodnota);
        if (prvni == null) {
            prvni = posledni = temp;
        } else {
            posledni.dalsi = temp;
            posledni = temp;
        }
    }

    @Override
    public void pridej(E hodnota, int pozice) {
        if (pozice > pocet() - 1 || pozice < 0) {
            return;
        }
        var temp = new PrvekSeznamu<E>(hodnota);
        if (prvni == null) {
            prvni = posledni = temp;
            return;
        }
        if (pozice == 0) {
            temp.dalsi = prvni;
            prvni = temp;
        } else if (pozice == pocet() - 1) {
            posledni.dalsi = temp;
            posledni = temp;
        } else {
            temp.dalsi = vratPrvek(pozice);
            vratPrvek(pozice - 1).dalsi = temp;
        }
    }

    @Override
    public void smaz(int pozice) {
        if (pozice < 1) {
            prvni = prvni.dalsi;
        } else {
            var temp = vratPrvek(pozice - 1);
            temp.dalsi = temp.dalsi.dalsi;
        }
    }

    @Override
    public E vrat(int pozice) {
        var prvek = vratPrvek(pozice);
        return (prvek != null) ? prvek.hodnota : null;
    }

    private PrvekSeznamu<E> vratPrvek(int pozice) {
        var temp = prvni;
        for (int i = 0; i < pozice && temp != null; i++, temp = temp.dalsi) {}
        return temp;
    }

    @Override
    public int pocet() {
        var temp = prvni;
        int pocet = 0;
        while(temp != null) {
            temp = temp.dalsi;
            pocet++;
        }
        return pocet;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            PrvekSeznamu<E> current = prvni;
            @Override
            public boolean hasNext() {
                return current.dalsi != null;
            }

            @Override
            public E next() {
                current = current.dalsi;
                return current.hodnota;
            }
        };
    }
}

class PrvekSeznamu<E> {
    E hodnota;
    PrvekSeznamu<E> dalsi;

    public PrvekSeznamu (E hodnota) {
        this.hodnota = hodnota;
    }
}
