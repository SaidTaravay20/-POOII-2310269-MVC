package core;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public abstract class Controller {


    protected static final JFrame mainFrame = new JFrame();

    private static final JPanel viewsViewer = new JPanel(new CardLayout());

 
    private static final Map<String,Component> mainFrameComponents = new HashMap<>();


 
    {
        mainFrame.add(viewsViewer);
    }


    public abstract void run();


    public static void addView(String viewName, View view)
    {
        viewsViewer.add((Component)view, viewName);
    }


    public static void loadView(String viewName)
    {
        CardLayout cl = (CardLayout)viewsViewer.getLayout();
        cl.show(viewsViewer, viewName);
    }


    public static void addComponent(String name, Component component)
    {
        mainFrameComponents.put(name, component);
    }

  
    public static void removeComponent(String name)
    {
        mainFrameComponents.remove(name);
    }

   
    public static Component getComponent(String name)
    {
        return mainFrameComponents.get(name);
    }
}
