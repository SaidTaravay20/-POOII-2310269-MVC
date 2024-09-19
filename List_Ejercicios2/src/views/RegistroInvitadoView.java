package views;

import javax.swing.*;
import java.awt.*;
import controllers.RegistroInvitadoController;

@SuppressWarnings("serial")
public class RegistroInvitadoView extends JPanel {
    private final RegistroInvitadoController controller;
    private JTextField tf_nombreInvitado;
    private JTextField tf_correoInvitado;
    private JButton btn_registrar;
    private JButton btn_resetear;

    public RegistroInvitadoView(RegistroInvitadoController controller) {
        this.controller = controller;
        make_frame();
    }

    private void make_frame() {
        setLayout(new GridLayout(3, 2));

        // Etiquetas y campos de texto
        add(new JLabel("Nombre del Invitado:"));
        tf_nombreInvitado = new JTextField();
        add(tf_nombreInvitado);

        add(new JLabel("Correo del Invitado:"));
        tf_correoInvitado = new JTextField();
        add(tf_correoInvitado);

        // Botones
        btn_registrar = new JButton("Registrar");
        btn_registrar.addActionListener(e -> controller.registrarInvitado(tf_nombreInvitado.getText(), tf_correoInvitado.getText()));
        add(btn_registrar);

        btn_resetear = new JButton("Resetear");
        btn_resetear.addActionListener(e -> resetFields());
        add(btn_resetear);
    }

    public void resetFields() {
        tf_nombreInvitado.setText("");
        tf_correoInvitado.setText("");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
