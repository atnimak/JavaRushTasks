package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Maxim on 11.10.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;

    public HTMLDocument getDocument() {
        return document;
    }

    private  File currentFile;

    public Controller(View view) {
        this.view = view;
    }



    public static void main(String... args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }

    public void init(){ createNewDocument();}

    public void resetDocument(){
        if (document!=null){
            document.removeUndoableEditListener(view.getUndoListener());
            document=(HTMLDocument) new HTMLEditorKit().createDefaultDocument();
            document.addUndoableEditListener(view.getUndoListener());
            view.update();
        }
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader, document, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }

    }

    public  String getPlainText(){
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer,document,0,document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();

    }

     public void exit(){
        System.exit(0);
     }

    public void createNewDocument() {
         view.selectHtmlTab();
         resetDocument();
         view.setTitle("HTML Editior");
         view.resetUndo();
         currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        fileChooser.setDialogTitle("Open File");
        int option = fileChooser.showOpenDialog(view);
        if (option==JFileChooser.APPROVE_OPTION){
            currentFile=fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try(FileReader fileReader = new FileReader(currentFile)){
                new HTMLEditorKit().read(fileReader,document,document.getLength());

            }
            catch (IOException e){ExceptionHandler.log(e);}
            catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile==null){
            saveDocumentAs();
        }
        else {
            try(FileWriter fileWriter = new FileWriter(currentFile)){
                new HTMLEditorKit().write(fileWriter,document,0,document.getLength());

            } catch (IOException e){
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        fileChooser.setDialogTitle("Save File");
        int option = fileChooser.showSaveDialog(view);
        if (option==JFileChooser.APPROVE_OPTION){
            currentFile=fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try(FileWriter fileWriter = new FileWriter(currentFile)){
                new HTMLEditorKit().write(fileWriter,document,0,document.getLength());

            }
            catch (IOException e){ExceptionHandler.log(e);}
            catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }


    }
}
