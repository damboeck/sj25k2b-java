package paintProgramm;

import java.awt.*;

public interface Selectable {

    /**
     * Prüft ob der Punkt mc innerhalb dieses Objektes oder
     * auf der Objektline liegt.
     * @param mc Mausposition
     * @return   true, wenn der Punkt mc innerhalb dieses Objektes liegt oder auf der Objektline liegt, sonst false
     */
    boolean select(Point mc);

    /** @return liefert true wenn das Objekt ausgewählt ist, sonst false */
    boolean isSelected();

    /** selektiert oder deselektiert das Objekt */
    void setSelected(boolean selected);

}
