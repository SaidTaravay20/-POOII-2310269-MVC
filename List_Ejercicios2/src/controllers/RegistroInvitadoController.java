package controllers;

import models.Invitado;
import models.InvitadoIO;
import views.RegistroInvitadoView;

public class RegistroInvitadoController {
    private final RegistroInvitadoView view;
    private final InvitadoIO invitadoIO;

    public RegistroInvitadoController() {
        invitadoIO = new InvitadoIO();
        view = new RegistroInvitadoView(this);
    }

    public void registrarInvitado(String nombre, String correo) {
        if (nombre.isEmpty() || correo.isEmpty()) {
            view.mostrarMensaje("Por favor, complete todos los campos.");
        } else {
            Invitado invitado = new Invitado(nombre, correo);
            try {
                invitadoIO.guardarInvitado(invitado);
                view.mostrarMensaje("Invitado registrado correctamente.");
                view.resetFields();
            } catch (Exception e) {
                view.mostrarMensaje("Error al registrar invitado: " + e.getMessage());
            }
        }
    }

    public RegistroInvitadoView getView() {
        return view;
    }
}
