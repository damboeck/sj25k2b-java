package paintProgramm.tools;

import paintProgramm.POSITION;
import paintProgramm.Paintable;
import paintProgramm.WindowInfo;

import java.awt.*;
import java.util.Vector;

/**
 * Realisierung der Symbolleiste
 */
public class Toolbar implements Paintable {

    private WindowInfo windowInfo;
    private POSITION position;
    int toolSize = 40;
    private Vector<Tool> tools = new Vector<Tool>();

    private Color lineColor = Color.black;
    private int thickness   = 3;


    public Toolbar(POSITION position, WindowInfo windowInfo) {
        this.position = position;
        this.windowInfo = windowInfo;
        tools.add(new Tool(TOOLENUM.SELECT,this));
        tools.add(new Tool(TOOLENUM.LINE,this));
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.GRAY);
        switch (position) {
            case LEFT: default :
                g.fillRect(0, 0, toolSize, windowInfo.getHeight());
                for (int i = 0; i < tools.size(); i++) {
                    Tool tool = tools.get(i);
                    tool.paint(g,0,i*toolSize);
                }
                break;
        }
    }

    /** Wird aufgerufen wenn die linke Maustaste gedrückt wurde
     * @param p Position des Mauscursors
     * @return  liefert true wenn in die Buttonleiste gedrückt wurde
     */
    public boolean leftMousePressed(Point p) {
        switch (position) {
            case LEFT: default :
                if (p.x<=toolSize && p.x>=0) {
                    int i = p.y/toolSize;
                    if (i<tools.size()) {
                        Tool tool = tools.get(i);
                        double tx = ((double)p.x)/toolSize*100.;
                        double ty = ((double)(p.y-i*toolSize))/toolSize*100.;
                        tool.leftMousePressed(tx,ty);
                    }

                    return true;
                }
        }
        return false;
    }

    public void deSelectAll() {
        for (int i = 0; i < tools.size(); i++) {
            Tool tool     = tools.get(i);
            tool.selected = false;
        }
    }

}
