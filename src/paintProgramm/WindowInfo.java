package paintProgramm;

import java.util.Vector;

/** Liefert mir Informationen über ein AWT-Fenster */
public interface WindowInfo {

    int getWidth();
    int getHeight();
    Vector<Paintable> getElements();


}
