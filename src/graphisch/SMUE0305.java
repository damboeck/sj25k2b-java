package graphisch;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class SMUE0305 extends MyFrame {

    private static final int titleBarHeight=31;
    private static final int borderWidth=9;
    private double size=0.5;
    private Color  c=Color.BLUE;

    public SMUE0305() {
        super("SMUE0305",800,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SMUE0305();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        //g.drawRect(borderWidth, titleBarHeight, getWidth()-2*borderWidth, getHeight()-titleBarHeight-borderWidth);

        int innerWidth = getWidth()-2*borderWidth;
        int innerHeight = getHeight()-titleBarHeight-borderWidth;
        int w = (int)(innerWidth*size);
        int h = (int)(innerHeight*size);
        int x1 = (innerWidth-w)/2+borderWidth;
        int y1 = (innerHeight-h)/2+titleBarHeight;
        int x2 = x1+w;
        int y2 = y1+h;
        int xm = innerWidth/2+borderWidth;
        int ym = innerHeight/2+titleBarHeight;
        g.setColor(Color.BLUE);
        g.drawLine(borderWidth, titleBarHeight, x1, y1);
        g.drawLine(borderWidth,getHeight()-borderWidth, x1, y2);
        g.drawLine(x2,y1,getWidth()-borderWidth,titleBarHeight);
        g.drawLine(x2,y2,getWidth()-borderWidth,getHeight()-borderWidth);
        int d = Integer.min(w,h);
        if (w<h)
            g.drawOval(x1,ym-d/2,d,d);
        else
            g.drawOval(xm-d/2,y1,d,d);

        g.setColor(c);
        g.drawRect(x1,y1,w,h);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        size = size+e.getWheelRotation()*0.05;
        if (size>1) size=1;
        if (size<0) size=0;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'r','R': c=Color.RED; break;
            case 'g','G': c=Color.GREEN; break;
            case 'b','B': c=Color.BLUE; break;
            default: return;
        }
        repaint();
    }
}
