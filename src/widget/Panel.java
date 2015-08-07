package widget;

import javax.swing.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;

public class Panel extends JPanel
{
    private static final long serialVersionUID = -1L;
    private BufferedImage gradientImage;
    private Color black;
    private Color warna;
    
    public Panel() {
        this.black = Color.black;
        this.warna = new Color(74, 54, 105);
    }
    
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (this.isOpaque()) {
            final Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            this.setUpGradient();
            g2.drawImage(this.gradientImage, 0, 0, this.getWidth(), this.getHeight(), null);
            final int width = this.getWidth();
            final int height = this.getHeight() * 5 / 100;
            final Color light = new Color(1.0f, 1.0f, 1.0f, 0.5f);
            final Color dark = new Color(1.0f, 1.0f, 1.0f, 0.0f);
            GradientPaint paint = new GradientPaint(0.0f, 0.0f, light, 0.0f, height, dark);
            GeneralPath path = new GeneralPath();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, height);
            path.curveTo(0.0f, height, width / 2, height / 2, width, height);
            path.lineTo(width, 0.0f);
            path.closePath();
            g2.setPaint(paint);
            g2.fill(path);
            paint = new GradientPaint(0.0f, this.getHeight(), light, 0.0f, this.getHeight() - height, dark);
            path = new GeneralPath();
            path.moveTo(0.0f, this.getHeight());
            path.lineTo(0.0f, this.getHeight() - height);
            path.curveTo(0.0f, this.getHeight() - height, width / 2, this.getHeight() - height / 2, width, this.getHeight() - height);
            path.lineTo(width, this.getHeight());
            path.closePath();
            g2.setPaint(paint);
            g2.fill(path);
            g2.dispose();
        }
    }
    
    private void setUpGradient() {
        this.gradientImage = new BufferedImage(1, this.getHeight(), 2);
        final Graphics2D g2 = (Graphics2D)this.gradientImage.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final GradientPaint paint = new GradientPaint(0.0f, 0.0f, this.black, 0.0f, this.getHeight(), this.warna);
        g2.setPaint(paint);
        g2.fillRect(0, 0, 1, this.getHeight());
        g2.dispose();
    }
}
