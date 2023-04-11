package com.github.maybesilent.parseformat.toolwindow;

import com.intellij.ui.components.JBTextArea;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class InputArea extends JBTextArea {

    /**
     * input area content
     */
    public InputArea(Runnable onEnter) {
        super();
        // input tip
        this.getEmptyText().setText("Input json/sql");
        // add key map
        InputMap input = this.getInputMap();
        input.put(KeyStroke.getKeyStroke("shift ENTER"), "insert-break");
        input.put(KeyStroke.getKeyStroke("ENTER"), "parse-format");
        this.getActionMap().put("parse-format", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                onEnter.run();
            }
        });
    }
}
