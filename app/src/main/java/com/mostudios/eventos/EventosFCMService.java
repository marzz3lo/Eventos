package com.mostudios.eventos;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static com.mostudios.eventos.EventosAplicacion.mostrarDialogo;

/**
 * Created by marzzelo on 16/2/2017.
 */

public class EventosFCMService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            String evento="";
            evento ="Evento: "+remoteMessage.getData().get("Evento")+ "\n";
            evento = evento + "Día: "+ remoteMessage.getData().get("Dia")+ "\n";
            evento = evento +"Ciudad: "+
                    remoteMessage.getData().get("Ciudad")+"\n";
            evento = evento +"Comentario: "
                    +remoteMessage.getData().get("Comentario");
            mostrarDialogo(getApplicationContext(), evento);
        } else {
            if (remoteMessage.getNotification() != null) {
                mostrarDialogo(getApplicationContext(),
                        remoteMessage.getNotification().getBody());
            }
        }    }
}
