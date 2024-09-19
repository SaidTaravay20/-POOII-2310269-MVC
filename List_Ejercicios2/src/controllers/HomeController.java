package controllers;

import core.Controller;
import static core.Controller.addView;
import views.EventListView;
import views.HomeView;
import views.NewEventView;
import views.RegistroInvitadoView;
import views.RemoveEventView;

public class HomeController extends Controller {
    private final EventListController eventListController = new EventListController();
    private final NewEventController newEventController = new NewEventController(eventListController);
    private final RemoveEventController removeEventController = new RemoveEventController();
    private final RegistroInvitadoController registroInvitadoController = new RegistroInvitadoController();

    @Override
    public void run() {
        // Inicializa otros controladores
        eventListController.run();
        newEventController.run();
        removeEventController.run();

        // Inicializa la vista principal (HomeView)
        HomeView homeView = new HomeView(this, mainFrame);
        addView("HomeView", homeView);

        // Añade las diferentes pestañas
        homeView.getTabbedPane().addTab("Nuevo Evento", newEventController.getView());
        homeView.getTabbedPane().addTab("Eventos", eventListController.getView());
        homeView.getTabbedPane().addTab("Eliminar Evento", removeEventController.getView());
        homeView.getTabbedPane().addTab("Registrar Invitado", registroInvitadoController.getView());

        // Muestra la ventana principal
        mainFrame.setVisible(true);
    }

    // Métodos para obtener las vistas de cada controlador (si es necesario)
    public EventListView getEventListView() {
        return eventListController.getView();
    }

    public NewEventView getNewEventView() {
        return newEventController.getView();
    }

    public RemoveEventView getRemoveEventView() {
        return removeEventController.getView();
    }

    public RegistroInvitadoView getRegistroInvitadoView() {
        return registroInvitadoController.getView();
    }
}
