package paintProgramm.tools;

import java.awt.*;

/** Elemente der Toolbar */
public class Tool {

    private TOOLENUM type;
    private Toolbar toolbar;
    boolean selected;

    public Tool(TOOLENUM type, Toolbar toolbar) {
        this.type = type;
        this.toolbar = toolbar;
        selected = false;
    }

    public void paint(Graphics2D g, int x, int y) {
        int s = toolbar.toolSize;
        if (selected) g.setColor(Color.white);
        else          g.setColor(Color.lightGray);
        g.fillRect(x+2,y+2,s-4,s-4);
        g.setColor(Color.black);
        Stroke oldStroke = g.getStroke();
        switch (type) {
            case LINE:
                g.setStroke(new BasicStroke(3));
                g.drawLine(x+5,y+5,x+s-5,y+s-5);
        }
        g.setStroke(oldStroke);
    }

    /**
     * Verarbeitet einen Klick in das Tool
     * @param x MouseCursor im Tool von 0..100
     * @param y MouseCursor im Tool von 0..100
     */
    public void leftMousePressed(double x, double y) {
        switch(type) {
            case LINE: case SELECT: case RECTANGLE: case OVAL: case FREEHAND:
                toolbar.deSelectAll();
                this.selected = true;
                break;
        }
    }

}
