package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.gui.swing.tabbedPane.TabbedPane;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import lombok.Getter;
import lombok.Setter;


import javax.swing.*;
import java.awt.*;

@Setter
@Getter

public class MainFrame extends JFrame{

    private static MainFrame instance = null;
    private MyMenuBar menu;
    private Toolbar toolbar;
    private ActionManager actionManager;

    private JLabel label;
    private JLabel labela2;
    private MapTree mapTree;

    private JLabel labela3;

    JTabbedPane tp;
    JSplitPane jsp;
    JPanel panel2;
    private MainFrame(){

    }

    private void initialise(){
        actionManager = new ActionManager();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        panel2 = new JPanel(new BorderLayout());

        screenSize.setSize(500, 800);
        Image img = kit.getImage("/images/iko.ico");
        setIconImage(img);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu= new MyMenuBar();
        setJMenuBar(menu);

        toolbar=new Toolbar();
        add(toolbar, BorderLayout.NORTH);

        mapTree = new MapTreeImplementation();
        JTree projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());

        panel2.setPreferredSize(new Dimension(900,700));

        labela2 = new JLabel(" ");

        label = new JLabel(" ");

        labela3 = new JLabel(label.getText() + " " +  labela2.getText(),SwingConstants.LEFT);
        labela3.setVerticalAlignment(JLabel.TOP);
        labela3.setPreferredSize(new Dimension(5,5));

        panel2.add(labela3);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(projectExplorer),
                new JScrollPane(panel2));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(splitPane);
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        splitPane.setDividerLocation(150);
    }



    public Toolbar getToolbar() {
        return toolbar;
    }

    public ActionManager getActionManager(){
        return actionManager;
    }


    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public static MainFrame getInstance(){
        if (instance == null){
            instance  = new MainFrame();
            instance.initialise();

        }
        return instance;
    }
}
