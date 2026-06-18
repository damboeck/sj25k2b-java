package animate;

public interface Animateable {

    void move(double deltaTimeMs);
    void collision(Fixable a);

}
