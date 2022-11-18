package dsw.gerumap.app.gui.swing.factory;


import dsw.gerumap.app.gui.swing.mapRepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.mapRepository.implementation.MindMap;


public class MindMapFactory extends NodeFactory {
    @Override
    public MapNode createNode(String name,MapNode parent) {
        return new MindMap(name, parent);
    }
}
