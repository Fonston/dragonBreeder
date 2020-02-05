package dougrowena.games.dragonBreeder.basicui.utilityComponents;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by HP DX2400 Custom on 11/05/2017.
 */
public class VComboBox<E> extends JComboBox<E> {

    class VComboBoxRenderer<E> extends VLabel
            implements ListCellRenderer<E> {

        public VComboBoxRenderer() {

            setOpaque(true);

        }

        public Component getListCellRendererComponent(
                JList<? extends E> list,
                E value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            if (value != null ) {
                setText(value.toString());
            } else {
                setText("");
            }

            setFont(VINTER_HAND_ITC);
            setOpaque(false);

            return this;
        }

    }


    public static Font VINTER_HAND_ITC;

    static {

        VINTER_HAND_ITC = ScriptFontSelecter.getScriptFont();

    }

    public VComboBox(E[] data) {

        super(data);

        initialise();

    }

    public VComboBox(ComboBoxModel<E> model){
        super(model);

        initialise();
    }

    public VComboBox(Vector<E> vector) {
        super(vector);

        initialise();
    }

    public VComboBox() {

        super();

        initialise();
    }

    private void initialise() {

        //setFocusPainted(false);
        setOpaque(false);

        setFont(VINTER_HAND_ITC);
        setRenderer(new VComboBoxRenderer());

    }


}
