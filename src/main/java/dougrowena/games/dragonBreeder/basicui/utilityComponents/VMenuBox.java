package dougrowena.games.dragonBreeder.basicui.utilityComponents;

import dougrowena.games.dragonBreeder.basicui.Imgs;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Douglas Warren
 */
public class VMenuBox<T> extends JLabel {

    // constants
    private static final String NONE_SELECTED = "please select";
    public static Font VINTER_HAND_ITC;

    static {

        VINTER_HAND_ITC = ScriptFontSelecter.getScriptFont();

    }

    // fields
    private T selectedItem;
    private ArrayList<T> allItems;
    private JPopupMenu internalMenu;

    // internal popup listener
    class PopupListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {

            // was it a popup trigger or was the component left clicked
            if (e.isPopupTrigger() || e.getButton() == MouseEvent.BUTTON1) {
                internalMenu.show(e.getComponent(),
                        0, getHeight());
            }
        }
    }

    public VMenuBox() {
        super();

        internalMenu = new JPopupMenu();
        this.allItems = new ArrayList<T>();

        addMouseListener(new PopupListener());
        setSelectedItem(null);
        setFont(VINTER_HAND_ITC);

    }

    public VMenuBox(Collection<T> items) {
        this();

        // add all of the items
        for (T item: items) {
            addItem(item);
        }

        // Pick the first to be the default selected item
        if (items.size() > 0) {
            setSelectedItem((T) items.toArray()[0]);
        } else {
            setSelectedItem(null);
        }

    }

    public void addItem(T item) {

        internalMenu.add(new VMenuItem<T>(this, item));
        allItems.add(item);

    }

    public T getSelected() {
        return selectedItem;
    }

    public void setSelectedItem(T selectedItem) {
        this.selectedItem = selectedItem;

        if (selectedItem != null) {
            setText(selectedItem.toString());
        } else {
            setText(NONE_SELECTED);
        }

    }

    public void replaceItems(Collection<T> items) {

        // if the collection is null replace with an empty collection
        if (items == null) {
            replaceItems(new ArrayList<T>());
        }

        // save currently selected.
        T currentItem = getSelected();

        // remove existing items
        int currentItemCount = allItems.size();
        for (int i = 0; i < currentItemCount; i++) {
            // remove the item currently at the top until there are no more
            internalMenu.remove(0);
        }
        allItems.clear();

        // Add the new items
        for (T item: items) {
            addItem(item);
        }

        if (items.contains(currentItem)) {
            // Item selected item is already selected
        } else if (items.size() > 0) {
            // pick the first item to be the selected one
            setSelectedItem((T)items.toArray()[0]);
        } else {
            // There are no items, set to null
            setSelectedItem(null);
        }

    }

}
