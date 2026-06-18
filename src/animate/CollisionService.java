package animate;

import java.util.Vector;

public class CollisionService {

    public static void collision(Vector<Animateable> animateables) {
        for (int i=0;i<animateables.size()-1;i++) {
            for (int j=i+1;j<animateables.size();j++) {
                collision(animateables.get(i),animateables.get(j));
            }
        }
    }

    private static void collision(Animateable a1, Animateable a2) {
        if (a1 instanceof Ball && a2 instanceof Ball) {
            Ball b1 = (Ball) a1;
            Ball b2 = (Ball) a2;
            b1.collision(b2);
        } else throw new RuntimeException("Collision not implemented");
    }

}
