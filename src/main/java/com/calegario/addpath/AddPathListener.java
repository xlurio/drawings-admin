package com.calegario.addpath;

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

public class AddPathListener implements ActionListener {
    private CSVDBManager manager;

    public AddPathListener (CSVDBManager manager) {
        this.manager = manager;
    }

    public void actionPerformed (ActionEvent ev) {
        final InputBox frame = new InputBox(
            "Adicionar caminho",
            "Informe o caminho a adicionar"
        );
        frame.setBtnListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    String pathToAdd = frame.getUserInput().toString();
                    if (!pathToAdd.isEmpty()) {
                        String[] row = ListOfFilesGen.getInfoFromPath(pathToAdd);
                        manager.addRow(row);
                        JOptionPane.showMessageDialog(
                            null,
                            "'" + pathToAdd + "' adicionado!",
                            "Sucesso!",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } catch (IOException ex) {
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
