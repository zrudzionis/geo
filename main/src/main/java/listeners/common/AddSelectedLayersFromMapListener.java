package listeners.common;

import interfaces.ICommonOperations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSelectedLayersFromMapListener  implements ActionListener {
    
    private ICommonOperations handler;

    public AddSelectedLayersFromMapListener(
            ICommonOperations handler) {
        
        super();
        
        if (handler == null) {
            throw new IllegalArgumentException(
                    "Arguments must not be null!");
        }

        this.handler = handler;
    }

    public void actionPerformed(ActionEvent e) {
        
        handler.addSelectedLayersFromMap();
    }

}