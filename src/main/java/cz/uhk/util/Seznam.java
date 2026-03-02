package cz.uhk.util;

/**
 * Rozhrani seznamu prvku
 * @param <E> typ prvku
 */
public interface Seznam<E> {
    void pridej(E prvek);
    void smaz(int pozice);
    E vrat(int pozice);
    int pocet();
}
