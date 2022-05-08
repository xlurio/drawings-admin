package com.calegario.update;

import com.calegario.defaultwins.BoxBtn;
import com.calegario.csvdb.CSVDBManager;
import java.util.List;
import com.calegario.filedbgen.ListOfFilesGen;
import com.calegario.defaultwins.msgbox.MsgBox;
import java.awt.*;
import java.awt.event.*;
import com.calegario.drawingsadmin.Settings;
import com.calegario.defaultwins.threebtnsbox.ThreeBtnsBox;
import javax.swing.*;
import java.util.*;

public class UpdateListener implements ActionListener {
    private ThreeBtnsBox frame;
    private CSVDBManager manager;

    public UpdateListener (ThreeBtnsBox frame, CSVDBManager manager) {
        this.frame = frame;
        this.manager = manager;
    }

    public void actionPerformed (ActionEvent ev) {
        BoxBtn oldBtn = frame.getBtnThree();
        BoxBtn updatingBtn = new BoxBtn(
            "Atualizando...",
            new ActionListener(){
                public void actionPerformed(ActionEvent ev) {

                }
            }
        );
        frame.setBtnThree(updatingBtn);
        List<String> fileEnds = new ArrayList<String>();
        fileEnds.add("pdf"); fileEnds.add("dwg"); fileEnds.add("stp");
        fileEnds.add("step");
        ListOfFilesGen generator =
            new ListOfFilesGen(
                Settings.CSV_PATH,
                fileEnds
            );
        manager.newDB(generator.getListOfFiles());
        JOptionPane.showMessageDialog(
            null,
            "Tabela atualizada!",
            "Sucesso!",
            JOptionPane.INFORMATION_MESSAGE
        );
        updatingBtn.setBtnThree(oldBtn);
    }

}