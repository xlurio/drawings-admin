package com.calegario.drawingsadmin;

import com.calegario.addpath.AddPathListener;
import com.calegario.csvdb.CSVDBManager;
import com.calegario.rmpath.RmPathListener;
import com.calegario.defaultwins.threebtnsbox.ThreeBtnsBox;
import com.calegario.update.UpdateListener;
import javax.swing.*;
import java.nio.charset.*;

public class App
{
    public static void main( String[] args )
    {
        String[] header = new String[]{
                "file_name", "extension", "path", "last_mod"
        };
        if (!Settings.CSV_PATH.isEmpty() && !Settings.DRAWINGS_DIR.isEmpty()){
            CSVDBManager manager = new CSVDBManager(
                Settings.CSV_PATH,
                header,
                '|'
            );
            ThreeBtnsBox frame = new ThreeBtnsBox(
                "Gerenciador de Desenhos",
                "Selecione uma ação:",
                true,
                "Adicionar caminho",
                "Remover caminho",
                "Atualizar tabela",
                256,
                256
            );
            frame.setBtnOneListener(new AddPathListener(manager));
            frame.setBtnTwoListener(new RmPathListener(manager));
            frame.setBtnThreeListener(new UpdateListener(frame, manager));
            frame.showBox();
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
