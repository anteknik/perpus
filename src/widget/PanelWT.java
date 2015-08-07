package widget;

import javax.swing.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;

public class PanelWT extends JPanel
{
    private static final long serialVersionUID = -1L;
    private BufferedImage gradientImage;
    private Color warnaAtas;
    private Color warnaBawah;
    
    public PanelWT() {
        this.warnaAtas = new Color(130, 0, 130);
        this.warnaBawah = new Color(30, 20, 50);
        this.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
    }
    
    public PanelWT(final LayoutManager layout) {
        super(layout);
        this.warnaAtas = new Color(130, 0, 130);
        this.warnaBawah = new Color(30, 20, 50);
        this.addComponentListener(new GradientCacheManager());
    }
    
    public Color getWarnaAtas() {
        return this.warnaAtas;
    }
    
    public void setWarnaAtas(final Color warnaAtas) {
        this.warnaAtas = warnaAtas;
    }
    
    public Color getWarnaBawah() {
        return this.warnaBawah;
    }
    
    public void setWarnaBawah(final Color warnaBawah) {
        this.warnaBawah = warnaBawah;
    }
    
    protected void paintComponent(final Graphics g) {
        this.createImageCache();
        if (this.gradientImage != null) {
            g.drawImage(this.gradientImage, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
    
    protected void createImageCache() {
        final int width = 2;
        final int height = this.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        if (this.gradientImage == null || width != this.gradientImage.getWidth() || height != this.gradientImage.getHeight()) {
            this.gradientImage = new BufferedImage(width, height, 1);
            final Graphics2D g2 = this.gradientImage.createGraphics();
            GradientPaint painter = new GradientPaint(0.0f, 0.0f, this.warnaBawah, 0.0f, height / 2, this.warnaAtas);
            g2.setPaint(painter);
            Rectangle2D rect = new Rectangle2D.Double(0.0, 0.0, width, height / 2.0);
            g2.fill(rect);
            painter = new GradientPaint(0.0f, height / 2, this.warnaAtas, 0.0f, height, this.warnaBawah);
            g2.setPaint(painter);
            rect = new Rectangle2D.Double(0.0, height / 2.0 - 1.0, width, height);
            g2.fill(rect);
            g2.dispose();
        }
    }
    
    private void disposeImageCache() {
        synchronized (this.gradientImage) {
            this.gradientImage.flush();
            this.gradientImage = null;
        }
    }
    
    private class GradientCacheManager implements ComponentListener
    {
        public void componentResized(final ComponentEvent e) {
        }
        
        public void componentMoved(final ComponentEvent e) {
        }
        
        public void componentShown(final ComponentEvent e) {
        }
        
        public void componentHidden(final ComponentEvent e) {
            PanelWT.this.disposeImageCache();
        }
    }
}
