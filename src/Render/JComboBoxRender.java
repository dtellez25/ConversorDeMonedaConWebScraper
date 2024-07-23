package Render;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author LCode
 */
public class JComboBoxRender extends JLabel implements ListCellRenderer {

    Hashtable<Object, ImageIcon> mElementos;
    ImageIcon mImgNull = new ImageIcon(this.getClass().getResource("/Icons/USA.png"));
    Image image = mImgNull.getImage(); // transform it 
    Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    ImageIcon icon = new ImageIcon(newimg); 

    public JComboBoxRender(Hashtable<Object, ImageIcon> aElementos) {
        mElementos = aElementos;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (mElementos.get(value) == null) {
            setIcon(icon);
        } else {
            setIcon(mElementos.get(value));
        }        
        setText(value.toString());
        return this;
    }

}
