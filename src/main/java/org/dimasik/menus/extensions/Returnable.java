package org.dimasik.menus.extensions;

import org.dimasik.menus.implementation.IMenu;

public interface Returnable extends IMenu {
    boolean isForceClose();
    void setForceClose(boolean forceClose);
    IMenu getBack();
    void setBack(IMenu menu);
}
