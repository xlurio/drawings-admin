package com.calegario.drawingsadmin;

import com.calegario.addpath.AddPathListener;
import com.calegario.csvdb.CSVDBManager;
import com.calegario.rmpath.RmPathListener;
import com.calegario.defaultwins.threebtnsbox.ThreeBtnsBox;
import com.calegario.update.UpdateListener;
import javax.swing.*;

public class App
{
    public static void main( String[] args )
    {
        String[] header = new String[]{
                "file_name", "extension", "path", "last_mod"
        };
        if (!Settings.CSV_PATH.isEmpty() && !Settings.DRAWINGS_DIR.isEmpty()){
            CSVDBManager manager = new CSVDBManager(Settings.CSV_PATH, header);
            ThreeBtnsBox frame = new ThreeBtnsBox(
                "Gerenciador de Desenhos",
                "Selecione uma ação:",
                "Adicionar caminho",
                "Remover caminho",
                "Atualizar tabela"
            );
            frame.setBtnOneListener(new AddPathListener(manager));
            frame.setBtnOneListener(new RmPathListener(manager));
            frame.setBtnOneListener(new UpdateListener(frame, manager));
        }
        if (Settings.CSV_PATH.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "CSV_PATH não configurado",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
        if (Settings.DRAWINGS_DIR.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "DRAWINGS_DIR não configurado",
                "ERRO",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
