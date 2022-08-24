package com.company;

import com.company.entities.Bot;
import com.company.entities.DataSource;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class GreetingResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/bots")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bot> bots() {
        System.out.println("get bots");

        List<Bot> bots = em.createQuery("from Bot", Bot.class).getResultList();

        return bots;
    }

    @GET
    @Path("/data_sources")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DataSource> dataSources() {
        System.out.println("get dataSources");

        List<DataSource> dataSources = em.createQuery("from DataSource", DataSource.class).getResultList();

        return dataSources;
    }
}
