package animate;

import graphisch.MyFrame;

public abstract class MyFrameAnimate extends MyFrame implements Runnable{

    private long frameTimeMs = 50;
    private long timeMs;
    private long deltaTimeMs;

    public MyFrameAnimate(String title, int width, int height) {
        super(title, width, height);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        timeMs = 0;
        while(true) {
            deltaTimeMs = (System.currentTimeMillis() - startTime) - timeMs;
            timeMs += deltaTimeMs;
            //timeMs = System.currentTimeMillis() - startTime;
            // Endlosschleife für die Animation
            repaint();
            long waitTime = frameTimeMs - (System.currentTimeMillis() - startTime - timeMs);
            if (waitTime <= 0) continue;
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {}
        }
    }

    public long getFrameTimeMs() {
        return frameTimeMs;
    }

    public void setFrameTimeMs(long frameTimeMs) {
        this.frameTimeMs = frameTimeMs;
    }

    public long getTimeMs() {
        return timeMs;
    }

    public long getDeltaTimeMs() {
        return deltaTimeMs;
    }
}
