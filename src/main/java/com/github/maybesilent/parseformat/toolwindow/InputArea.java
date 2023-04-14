package com.github.maybesilent.parseformat.toolwindow;

import com.github.maybesilent.parseformat.icon.Icons;
import com.github.maybesilent.parseformat.toolwindow.util.ButtonBorder;
import com.intellij.ui.components.JBTextArea;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class InputArea extends JBTextArea {

    /**
     * input area content
     */
    public InputArea(Runnable onEnter, JScrollPane inputPanel) {
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

        // https://tips4java.wordpress.com/2009/09/27/component-border/
        // add arrow button
        JButton arrowButton = getArrowButton(onEnter);
        ButtonBorder buttonBorder = new ButtonBorder(arrowButton);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(inputPanel.getBorder(), buttonBorder));
        inputPanel.add(arrowButton);
    }

    private JButton getArrowButton(Runnable onClick) {
        JButton arrowButton = new JButton(Icons.enterIcon);
        arrowButton.setBorderPainted(false);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setPreferredSize(new Dimension(Icons.enterIcon.getIconWidth(), Icons.enterIcon.getIconHeight()));
        arrowButton.addActionListener(e -> onClick.run());
        return arrowButton;
    }
}
