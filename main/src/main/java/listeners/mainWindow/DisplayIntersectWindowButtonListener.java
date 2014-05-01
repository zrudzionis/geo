package listeners.mainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import windows.FeatureTableWindow;
import windows.intersect.IntersectWindow;

public class DisplayIntersectWindowButtonListener implements ActionListener {

    private IntersectWindow intersectWindow;

    public DisplayIntersectWindowButtonListener(
            IntersectWindow intersectWindow) {

        super();

        if (intersectWindow == null) {
            throw new IllegalArgumentException(
                    "Constructor argument must not be null!");
        }

        this.intersectWindow = intersectWindow;
    }

    public void actionPerformed(ActionEvent e) {

        try {
            
            if (intersectWindow.isVisible()) {
                intersectWindow.setVisible(false);
            } else {
                intersectWindow.setVisible(true);
            }

        } catch (Exception e1) {

            e1.printStackTrace();

        }
    }
}