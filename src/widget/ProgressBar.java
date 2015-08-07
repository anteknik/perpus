package widget;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;

public class ProgressBar extends JProgressBar
{
    private static final long serialVersionUID = 1L;
    private Timer timer;
    private int percent;
    private Color light;
    private Color dark;
    private Color black;
    private Color warna;
    
    private Timer getTimer() {
        if (this.timer == null) {
            this.timer = new Timer(10, new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    if (ProgressBar.this.getPercent() >= 100) {
                        ProgressBar.this.setPercent(0);
                    }
                    ProgressBar.this.setValue(0);
                    ProgressBar.this.setPercent(ProgressBar.this.getPercent() + 1);
                }
            });
        }
        return this.timer;
    }
    
    private int getPercent() {
        return this.percent;
    }
    
    private void setPercent(final int percent) {
        this.percent = percent;
        this.repaint();
    }
    
    public ProgressBar() {
        this.light = new Color(1.0f, 1.0f, 1.0f, 0.4f);
        this.dark = new Color(1.0f, 1.0f, 1.0f, 0.4f);
        this.black = Color.darkGray;
        this.warna = Color.magenta;
        this.setPercent(0);
        this.setOpaque(false);
        this.setBorderPainted(false);
        super.setIndeterminate(false);
    }
    
    public void setIndeterminate(final boolean newValue) {
        if (newValue) {
            this.setPercent(0);
            this.getTimer().start();
        }
        else {
            if (this.getTimer().isRunning()) {
                this.timer.stop();
            }
            this.setPercent(0);
            this.setValue(0);
            super.setIndeterminate(newValue);
        }
    }
    
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint paint = new GradientPaint(0.0f, 0.0f, this.black, 0.0f, this.getHeight(), this.warna);
        g2.setPaint(paint);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (this.getPercent() > 0) {
            paint = new GradientPaint(0.0f, 0.0f, this.warna, 0.0f, this.getHeight(), this.black);
            g2.setPaint(paint);
            final int space = this.getPercent() * this.getWidth() / 100;
            final int width = this.getWidth() * 10 / 100;
            final Shape s = new Rectangle2D.Double(space, 0.0, width, this.getHeight());
            g2.fill(s);
        }
        if (this.getValue() > 0 && this.getValue() < this.getMaximum()) {
            final int total = this.getMaximum() - this.getMinimum();
            final double rate = this.getWidth() * 1.0 / (total * 1.0);
            final int now = this.getValue() - this.getMinimum();
            paint = new GradientPaint(0.0f, 0.0f, this.warna, 0.0f, this.getHeight(), this.black);
            g2.setPaint(paint);
            final Shape s2 = new Rectangle2D.Double(0.0, 0.0, now * rate, this.getHeight());
            g2.fill(s2);
        }
        paint = new GradientPaint(0.0f, 0.0f, this.light, 0.0f, this.getHeight() * 3 / 4, this.dark);
        g2.setPaint(paint);
        g2.fillRect(3, 3, this.getWidth(), this.getHeight() * 3 / 4);
        g2.setColor(this.black);
        g2.drawRect(3, 3, this.getWidth(), this.getHeight());
        g2.dispose();
    }
}
