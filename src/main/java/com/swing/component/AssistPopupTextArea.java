package com.swing.component;

import com.swing.callback.ActionCallback;
import com.swing.component.inf.IRightMenu;
import com.swing.menu.MenuUtil2;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/***
 * 增加了右键菜单功能
 * @author huangwei
 * @since 2014-02-08
 */
public class AssistPopupTextArea extends PlaceHolderTextArea implements IRightMenu {
    private static final long serialVersionUID = -3651671537628886719L;
	protected JPopupMenu textPopupMenu;
    /**
     * 防止方法custom2执行两遍<br >
     *     是否已经执行过方法custom2()
     */
    private boolean hasCustom = false;

    public AssistPopupTextArea(Map<String, ActionCallback> actionCallbackMap) {
        super(actionCallbackMap);
    }

    public AssistPopupTextArea() {
        super();
    }

    public AssistPopupTextArea(int rows, int columns) {
		super(rows, columns);
	}
	public AssistPopupTextArea(String text) {
        this(text, (Map<String, ActionCallback>) null);
    }

    public AssistPopupTextArea(String text, Map<String, ActionCallback> actionCallbackMap) {
        super(text, actionCallbackMap);
    }

	@Override
	protected void initlize() {
		super.initlize();
        custom2(null);
    }

    @Override
    protected void initlize(Map<String, ActionCallback> actionCallbackMap) {
        super.initlize(actionCallbackMap);
        custom2(actionCallbackMap);
    }

    private void custom2(Map<String, ActionCallback> actionCallbackMap) {
        if (!hasCustom) {
            hasCustom = true;
            textPopupMenu = new JPopupMenu();
            MenuUtil2.addPopupMenuItem(this, textPopupMenu);
            override4Extend(textPopupMenu);
            textPopupMenu = MenuUtil2.setPopupMenu(this, textPopupMenu, actionCallbackMap);
            //added by huangweii @2015-09-30
            setLineWrap(true);//设置文本域自动换行
            setWrapStyleWord(true);
        }
    }

    public JPopupMenu getTextPopupMenu() {
        return textPopupMenu;
	}

    @Override
    public void showMenu() {
        Point point = this.getLocation();
        //see com/swing/menu/MenuUtil2.java 389行
        textPopupMenu.show(this, point.x + 10, point.y);
    }

    /***
	 * 用于子类覆写
	 * @param textPopupMenu
	 */
	protected void override4Extend(JPopupMenu textPopupMenu){}
}
