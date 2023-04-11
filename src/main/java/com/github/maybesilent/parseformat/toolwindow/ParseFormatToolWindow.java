package com.github.maybesilent.parseformat.toolwindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class ParseFormatToolWindow implements ToolWindowFactory {

    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ParseFormatWindow window = new ParseFormatWindow(project);
        toolWindow.getContentManager().addContent(ContentFactory.SERVICE.getInstance()
                .createContent(window.getContent(), "Format", false));
    }
}
