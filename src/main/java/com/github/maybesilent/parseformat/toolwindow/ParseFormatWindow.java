package com.github.maybesilent.parseformat.toolwindow;

import com.github.maybesilent.parseformat.formatter.FormatInfo;
import com.github.maybesilent.parseformat.formatter.Formatter;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ParseFormatWindow {

    private final Project project;
    private JPanel rootPanel;
    private JPanel contentPanel;
    private JScrollPane enterArea;

    private JBTextArea inputArea;
    private FormatArea formatArea;

    public ParseFormatWindow(Project project) {
        this.project = project;
    }

    public JPanel getContent() {
        SimpleToolWindowPanel panel = new SimpleToolWindowPanel(true);
        panel.setContent(rootPanel);
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        contentPanel = new JPanel(new BorderLayout());
        formatArea = new FormatArea(project);
        contentPanel.add(formatArea.getScrollPane(), BorderLayout.CENTER);

        enterArea = new JBScrollPane();
        enterArea.setPreferredSize(new Dimension(-1, 80));
        enterArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 0, JBColor.border()),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        inputArea = new InputArea(() -> {
            String input = inputArea.getText();
            FormatInfo info = Formatter.format(input);
            formatArea.setDocument(info.getFormatContent());
        }, enterArea);
        enterArea.setViewportView(inputArea);
    }
}
