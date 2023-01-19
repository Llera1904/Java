/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browser;

import java.awt.*;
import javax.swing.*;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

/**
 *
 * @author Macario
 */
public class Browser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                JFrame frame = new JFrame("Web Browser in Java");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.getContentPane().add(getBrowserPanel(), BorderLayout.CENTER);
                frame.setSize(800, 600);
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    
        NativeInterface.runEventPump();
        // don't forget to properly close native components
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() 
        {
            @Override
            public void run() 
            {
                NativeInterface.close();
            }
        }));
    }

    public static JPanel getBrowserPanel() 
    {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        webBrowser.setBarsVisible(false);
        webBrowser.navigate("https://www.youtube.com/watch?v=m_m2oYJkx1A");
        return webBrowserPanel;
    }

}