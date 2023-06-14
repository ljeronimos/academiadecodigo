package org.academiadecodigo.sharpshoorts.Objetos;

public interface Destroyable {
    void hit(int damage);
    boolean isDestroyed();
    String getMessage();
}
