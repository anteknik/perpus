package widget;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class Toolbar extends JToolBar
{
    private static final long serialVersionUID = 1L;
    private BufferedImage gradientImage;
    private BufferedImage ligthImage;
    private Color light;
    private Color dark;
    private Color black;
    private Color warna;
    
    public Toolbar() {
        this.light = new Color(1.0f, 1.0f, 1.0f, 0.5f);
        this.dark = new Color(1.0f, 1.0f, 1.0f, 0.0f);
        this.black = Color.BLACK;
        this.warna = Color.MAGENTA;
        this.setFloatable(false);
        this.setBorder(BorderFactory.createEmptyBorder(3, 3, 4, 3));
    }
    
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        this.setUpGradientImage();
        this.setUpLigthImage();
        if (this.isOpaque()) {
            g.drawImage(this.gradientImage, 0, 0, this.getWidth(), this.getHeight(), null);
            g.drawImage(this.ligthImage, 0, 0, this.getWidth(), this.getHeight() / 2, null);
        }
    }
    
    private void setUpGradientImage() {
        this.gradientImage = new BufferedImage(1, this.getHeight(), 2);
        final GradientPaint paint = new GradientPaint(0.0f, 0.0f, this.warna, 0.0f, this.getHeight(), this.black);
        final Graphics2D g = (Graphics2D)this.gradientImage.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(paint);
        g.fillRect(0, 0, 1, this.getHeight());
        g.dispose();
    }
    
    private void setUpLigthImage() {
        this.ligthImage = new BufferedImage(1, this.getHeight() / 2, 2);
        final GradientPaint paint = new GradientPaint(0.0f, 0.0f, this.light, 0.0f, this.getHeight(), this.dark);
        final Graphics2D g = (Graphics2D)this.ligthImage.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(paint);
        g.fillRect(2, 2, 5, this.getHeight() / 2);
        g.dispose();
    }
}
