package fungsi;

import javax.swing.text.*;
import javax.swing.*;

public class batasInput
{
    int length;
    PlainDocument filter;
    
    public batasInput(final int length) {
        this.length = length;
    }
    
    public PlainDocument getFilter(final JTextField inputan) {
        return this.filter = new PlainDocument() {
            public void insertString(final int offs, final String str, final AttributeSet a) throws BadLocationException {
                final StringBuffer buf = new StringBuffer();
                int c = 0;
                final char[] upp = str.toCharArray();
                for (int i = 0; i < upp.length; ++i) {
                    upp[i] = Character.toUpperCase(upp[i]);
                    final boolean isOnlyAngka = Character.isDigit(upp[i]);
                    final boolean isOnlyLetter = Character.isLetter(upp[i]);
                    final boolean isOnlySpasi = Character.isSpaceChar(upp[i]);
                    if (isOnlyLetter) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (isOnlyAngka) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (isOnlySpasi) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (!isOnlyLetter) {
                        upp[c] = upp[i];
                        ++c;
                    }
                }
                buf.append(upp, 0, c);
                final int x = inputan.getText().length();
                if (x < batasInput.this.length) {
                    super.insertString(offs, new String(buf).replaceAll("'", "").replaceAll("\\\\", ""), a);
                }
            }
        };
    }
    
    public PlainDocument getFilter(final JTextArea inputan) {
        return this.filter = new PlainDocument() {
            public void insertString(final int offs, final String str, final AttributeSet a) throws BadLocationException {
                final StringBuffer buf = new StringBuffer();
                int c = 0;
                final char[] upp = str.toCharArray();
                for (int i = 0; i < upp.length; ++i) {
                    upp[i] = Character.toUpperCase(upp[i]);
                    final boolean isOnlyAngka = Character.isDigit(upp[i]);
                    final boolean isOnlyLetter = Character.isLetter(upp[i]);
                    final boolean isOnlySpasi = Character.isSpaceChar(upp[i]);
                    if (isOnlyLetter) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (isOnlyAngka) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (isOnlySpasi) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (!isOnlyLetter) {
                        upp[c] = upp[i];
                        ++c;
                    }
                }
                buf.append(upp, 0, c);
                final int x = inputan.getText().length();
                if (x < batasInput.this.length) {
                    super.insertString(offs, new String(buf).replaceAll("'", "").replaceAll("\\\\", ""), a);
                }
            }
        };
    }
    
    public PlainDocument getOnlyAngka(final JTextField inputan) {
        return this.filter = new PlainDocument() {
            public void insertString(final int offs, final String str, final AttributeSet a) throws BadLocationException {
                final StringBuffer buf = new StringBuffer();
                int c = 0;
                final char[] upp = str.toCharArray();
                for (int i = 0; i < upp.length; ++i) {
                    upp[i] = Character.toUpperCase(upp[i]);
                    final boolean isOnlyAngka = Character.isDigit(upp[i]);
                    if (isOnlyAngka) {
                        upp[c] = upp[i];
                        ++c;
                    }
                }
                buf.append(upp, 0, c);
                final int x = inputan.getText().length();
                if (x < batasInput.this.length) {
                    super.insertString(offs, new String(buf), a);
                }
            }
        };
    }
    
    public PlainDocument getKata(final JTextField inputan) {
        return this.filter = new PlainDocument() {
            public void insertString(final int offs, final String str, final AttributeSet a) throws BadLocationException {
                final StringBuffer buf = new StringBuffer();
                int c = 0;
                final char[] upp = str.toCharArray();
                for (int i = 0; i < upp.length; ++i) {
                    final boolean isOnlyAngka = Character.isDigit(upp[i]);
                    final boolean isOnlyLetter = Character.isLetter(upp[i]);
                    final boolean isOnlySpasi = Character.isSpaceChar(upp[i]);
                    if (isOnlyLetter) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (isOnlyAngka) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (isOnlySpasi) {
                        upp[c] = upp[i];
                        ++c;
                    }
                    else if (!isOnlyLetter) {
                        upp[c] = upp[i];
                        ++c;
                    }
                }
                buf.append(upp, 0, c);
                final int x = inputan.getText().length();
                if (x < batasInput.this.length) {
                    super.insertString(offs, new String(buf).replaceAll("'", "").replaceAll("\\\\", ""), a);
                }
            }
        };
    }
}
