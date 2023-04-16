package com.github.maybesilent.parseformat.toolwindow.util;


import com.intellij.util.ui.JBUI;

import javax.swing.JComponent;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;

/**
 * https://tips4java.wordpress.com/2009/09/27/component-border/
 * put button input panel border
 */
public class ButtonBorder implements Border {

    private final JComponent button;

    private static final int gap = 5;
    private final Insets borderInsets = JBUI.emptyInsets();

    public ButtonBorder(JComponent button) {
        button.setAlignmentX(1.0f);
        button.setAlignmentY(0.5f);
        button.setSize(button.getPreferredSize());
        button.setCursor(Cursor.getDefaultCursor());
        this.button = button;
        this.borderInsets.right = button.getPreferredSize().width + gap;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        float x2 = (width  - button.getWidth())  * button.getAlignmentX() + x;
        float y2 = (height - button.getHeight()) * button.getAlignmentY() + y;
        button.setLocation((int)x2, (int)y2);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return borderInsets;
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
