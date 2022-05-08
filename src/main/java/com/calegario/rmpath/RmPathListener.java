package com.calegario.rmpath;

import com.calegario.csvdb.CSVDBManager;
import java.util.List;
import com.calegario.filedbgen.ListOfFilesGen;
import com.calegario.defaultwins.inputbox.InputBox;
import com.calegario.drawingsadmin.Settings;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class RmPathListener implements ActionListener {
    private CSVDBManager manager;

    public RmPathListener (CSVDBManager manager) {
        this.manager = manager;
    }

    public void actionPerformed (ActionEvent ev) {
        final InputBox frame = new InputBox(
            "Remover caminho",
            "Informe o caminho a remover"
        );
        frame.setBtnListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    String pathToRemove = frame.getUserInput().toString();
                    if (!pathToRemove.isEmpty()) {
                        manager.removeRow(pathToRemove, "path");
                        JOptionPane.showMessageDialog(
                            null,
                            "'" + pathToRemove + "' removido!",
                            "Sucesso!",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(
                        null,
                        "'" + Settings.CSV_PATH + "' não encontrado",
                        "ERRO",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (IOException ex){
                    JOptionPane.showMessageDialog(
                        null,
                        "'" + Settings.CSV_PATH + "' não encontrado",
                        "ERRO",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });
    }

}
