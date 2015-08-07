package widget;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class InternalFrame extends JPanel
{
    private static final long serialVersionUID = -1L;
    private BufferedImage gradientImage;
    private Color warnaAtas;
    private Color warnaBawah;
    
    public InternalFrame() {
        this.warnaAtas = new Color(90, 0, 90);
        this.warnaBawah = new Color(90, 0, 90);
        this.setBorder(BorderFactory.createLineBorder(new Color(125, 35, 135)));
    }
    
    public InternalFrame(final LayoutManager layout) {
        super(layout);
        this.warnaAtas = new Color(90, 0, 90);
        this.warnaBawah = new Color(90, 0, 90);
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
            this.createImageCache();
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
    
    private void setUpGradient() {
        this.gradientImage = new BufferedImage(1, this.getHeight(), 2);
        final Graphics2D g2 = (Graphics2D)this.gradientImage.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final GradientPaint paint = new GradientPaint(0.0f, 0.0f, this.warnaAtas, 0.0f, this.getHeight(), this.warnaBawah);
        g2.setPaint(paint);
        g2.fillRect(0, 0, 1, this.getHeight());
        g2.dispose();
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
            InternalFrame.this.disposeImageCache();
        }
    }
}
