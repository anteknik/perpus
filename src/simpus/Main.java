package simpus;

import java.util.logging.*;
import javax.swing.*;
import usu.widget.util.*;

public class Main
{
    public static void main(final String[] args) {
        WidgetUtilities.invokeLater((Runnable)new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (InstantiationException ex2) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex2);
                }
                catch (IllegalAccessException ex3) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex3);
                }
                catch (UnsupportedLookAndFeelException ex4) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex4);
                }
                finally {
                    final frmUtama utama = new frmUtama();
                    utama.setVisible(true);
                }
            }
        });
    }
}
