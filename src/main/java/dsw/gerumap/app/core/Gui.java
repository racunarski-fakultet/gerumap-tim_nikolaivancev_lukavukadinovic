package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.commands.CommandManager;

public interface Gui {

    void start();


    void disableUndoAction();
    void disableRedoAction();

    void enableUndoAction();
    void enableRedoAction();

    
    
}
