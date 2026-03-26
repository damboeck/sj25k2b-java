package paintProgramm;

import java.awt.*;

/**
 * Realisierung der Symbolleiste
 */
public class Symbolleiste implements Paintable {

    private int windowWith;
    private int windowHeight;
    private POSITION position;
    private Color lineColor = Color.black;
    private int thickness   = 3;

    public Symbolleiste(int windowWidth, int windowHeight, POSITION position ) {
        this.windowWith = windowWidth;
        this.windowHeight = windowHeight;
        this.position = position;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY);
        switch (position) {
            case LEFT: default :
                g.fillRect(0, 0, 40, windowHeight);
                break;
        }
    }
}
