package com.mostudios.eventos;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static com.mostudios.eventos.EventosAplicacion.guardarIdRegistro;

/**
 * Created by marzzelo on 18/2/2017.
 */

public class EventosFCMInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        String idPush;
        idPush = FirebaseInstanceId.getInstance().getToken();
        guardarIdRegistro(getApplicationContext(), idPush);
    }
}
