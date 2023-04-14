package com.github.maybesilent.parseformat.toolwindow;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.project.Project;

import java.awt.Component;

public class FormatArea {

    private final Document document;
    private final Component editorComponent;

    public FormatArea(Project project) {
        document = EditorFactory.getInstance().createDocument("");
        // Create read-only editor
        Editor textEditor = EditorFactory.getInstance().createViewer(document, project);
        // Create new scroll pane and add editor to it
        editorComponent = textEditor.getComponent();
    }

    public void setDocument(String text) {
        ApplicationManager.getApplication().runWriteAction(() -> document.setText(text));
    }

    public Component getScrollPane() {
        return editorComponent;
    }
}
