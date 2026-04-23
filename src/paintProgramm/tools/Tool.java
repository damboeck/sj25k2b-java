package paintProgramm.tools;

import paintProgramm.Selectable;
import paintProgramm.elements.Line;
import paintProgramm.elements.Rectangle;

import java.awt.*;
import java.util.Vector;

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
        int r = s/6;
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(3));
        switch (type) {
            case SELECT:
                g.translate(x+s-r,y+s-r);
                g.rotate(-5*Math.PI/4);
                g.drawLine(0,0,0,s/2);
                g.fillPolygon(new int[]{0,r*2/3,-r*2/3}, new int[]{(s-2*r)*14/10,s/2,s/2}, 3);
                g.rotate(5*Math.PI/4);
                g.translate(-(x+s-r),-(y+s-r));
                break;
            case LINE:
                g.drawLine(x+r,y+r,x+s-r,y+s-r);
                break;
            case RECTANGLE:
                g.drawRect(x+r,y+r,s-2*r,s-2*r);
                break;
            case OVAL:
                g.drawOval(x+r,y+2*r,s-2*r,s-4*r);
                break;
            case FREEHAND:
                int n=10;
                int[] xp=new int[n];
                int[] yp=new int[n];
                for (int i=0;i<n;i++) {
                    xp[i] = x+r+i*(s-2*r)/(n-1);
                    yp[i] = y+s/2-(int)((s-2*r)/2*Math.sin(i/(n-1d)*Math.PI*2));
                }
                g.drawPolyline(xp,yp,n);
                break;


        }
        g.setStroke(oldStroke);
    }

    /**
     * Verarbeitet einen Klick in das Tool
     * @param x MouseCursor im Tool von 0..100
     * @param y MouseCursor im Tool von 0..100
     */
    public void leftMousePressedToolbar(double x, double y) {
        switch(type) {
            case LINE: case SELECT: case RECTANGLE: case OVAL: case FREEHAND:
                toolbar.deSelectAll();
                this.selected = true;
                break;
        }
    }

    /**
     * verarbeitet einen Klick in die Zeichenebenen mit dem Tool
     * @param mc MouseCursor
     */
    public void leftMousePressedZeichenebene(Point mc) {
        switch(type) {
            case LINE:
                toolbar.actualZweipunkt = new Line(mc,Color.red,3);
                break;
            case RECTANGLE:
                toolbar.actualZweipunkt = new Rectangle(mc,Color.red,Color.blue,3);
                break;
            case SELECT:
                Vector<Selectable> selectables = toolbar.windowInfo.getSelectableElements();
                Selectable s = null;
                for (Selectable selectable : selectables) {
                    selectable.setSelected(false);
                    if (selectable.select(mc)) s = selectable;
                }
                if (s!=null) s.setSelected(true);
                break;
        }
    }

    /**
     * verarbeitet einen Klick in die Zeichenebenen mit dem Tool
     * @param mc MouseCursor
     */
    public void leftMouseReleased(Point mc) {
        switch(type) {
            case LINE,RECTANGLE,OVAL:
                if (toolbar.actualZweipunkt!=null) {
                    toolbar.actualZweipunkt.setP2(mc);
                    toolbar.windowInfo.getElements().add(toolbar.actualZweipunkt);
                    toolbar.actualZweipunkt = null;
                }
                break;
            case FREEHAND:
                break;
        }
    }

    /**
     * verarbeitet eine Bewegung der Maus in die Zeichenebenen mit dem Tool
     * @param mc MouseCursor
     */
    public void mouseMoved(Point mc) {
        switch(type)  {
            case LINE,RECTANGLE,OVAL:
                if (toolbar.actualZweipunkt!=null) {
                    toolbar.actualZweipunkt.setP2(mc);
                }
                break;
            case FREEHAND:

                break;
        }
    }

}
