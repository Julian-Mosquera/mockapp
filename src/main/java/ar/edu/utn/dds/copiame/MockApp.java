package ar.edu.utn.dds.copiame;

import ar.edu.utn.dds.k3003.facades.dtos.EstadoViandaEnum;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import io.javalin.Javalin;

import java.time.LocalDateTime;

public class MockApp {
    public static void main(String[] args){
        Javalin mockApp = Javalin.create().start(8081);

        mockApp.get("/viandas/{qr}", ctx -> {
            String qr = ctx.pathParam("qr");
            ViandaDTO vianda = new ViandaDTO(qr, LocalDateTime.now(), EstadoViandaEnum.PREPARADA, 1L, 1);
            ctx.json(vianda);
        });

        mockApp.patch("/viandas/{qr}", ctx ->{
            String qr = ctx.pathParam("qr");
            ViandaDTO vianda = new ViandaDTO(qr, LocalDateTime.now(), EstadoViandaEnum.RETIRADA, 1L,1);
            ctx.json(vianda);
                }
                );
        }
}
