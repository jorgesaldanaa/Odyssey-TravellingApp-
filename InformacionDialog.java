package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InformacionDialog extends JDialog {

    public InformacionDialog(String mensaje, JFrame owner) {
        this.setTitle("Mensaje Emergente");
        this.setModal(true);
        this.setSize(250, 150);
        this.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(mensaje, SwingConstants.CENTER);
        this.add(messageLabel, BorderLayout.CENTER);

        JButton exitButton = new JButton("Ok");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformacionDialog.this.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(exitButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setLocationRelativeTo(owner);

        this.setVisible(true);
    }

}
