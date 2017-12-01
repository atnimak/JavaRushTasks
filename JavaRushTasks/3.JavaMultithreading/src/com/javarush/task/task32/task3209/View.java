package com.javarush.task.task32.task3209;


import com.javarush.task.task32.task3209.listeners.UndoListener;
import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 * Created by Maxim on 11.10.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

   public View(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        if (event.equals("Новый")){
            controller.createNewDocument();

        }
        else if (event.equals("Открыть")){
            controller.openDocument();
        }
        else if (event.equals("Сохранить")){
            controller.saveDocument();
        }
        else if (event.equals("Сохранить как...")){
            controller.saveDocumentAs();
        }
        else if (event.equals("Выход")){
            controller.exit();
        }
        else if (event.equals("О программе")){
            showAbout();
        }

    }

    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }


    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        setVisible(true);


    }

    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,menuBar);
        MenuHelper.initEditMenu(this,menuBar);
        MenuHelper.initStyleMenu(this,menuBar);
        MenuHelper.initAlignMenu(this,menuBar);
        MenuHelper.initColorMenu(this,menuBar);
        MenuHelper.initFontMenu(this,menuBar);
        MenuHelper.initHelpMenu(this,menuBar);
        this.getContentPane().add(menuBar,BorderLayout.NORTH);
    }

   public void  initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML" ,jScrollPane);
        JScrollPane jScrollPane1Two = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст",jScrollPane1Two);
        tabbedPane.setPreferredSize(new Dimension(1500,800));
       TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
       tabbedPane.addChangeListener(tabbedPaneChangeListener);
       getContentPane().add(tabbedPane,BorderLayout.CENTER);

   }

   public void initGui(){
        initMenuBar();
        initEditor();
        pack();
   }

    public void exit(){
        controller.exit();
    }

    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex()==0){
            controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex()==1){
            plainTextPane.setText(controller.getPlainText());
        }
        this.resetUndo();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    /*void undo() — отменяет последнее действие. Реализуй его используя undoManager.
Метод не должен кидать исключений, логируй их.
11.5.2. void redo() — возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.*/

    public void undo(){
        try{
            undoManager.undo();
        }catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }

    }

    public void redo(){
        try{
            undoManager.redo();
        }catch (CannotRedoException e){
            ExceptionHandler.log(e);
        }

    }

    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        this.resetUndo();
    }

    public void update(){
       htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout(){
        JOptionPane.showMessageDialog(this.getContentPane(),"Our soft makes you unhappy!","HTMLEditor",JOptionPane.INFORMATION_MESSAGE);
    }

}
