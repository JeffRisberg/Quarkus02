package com.company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }


    @GET
    @Path("/charities")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Charity> charities() {
        System.out.println("get charities");

        List<Charity> charities = em.createQuery("from Charity", Charity.class).getResultList();

        return charities;
    }

    @GET
    @Path("/charities/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Charity> charities(@PathParam("id") int id) {
        System.out.println("get charities " + id);

        List<Charity> charities = em.createQuery("from Charity where id="+id, Charity.class).getResultList();

        return charities;
    }

    @GET
    @Path("/donors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Donor> donors() {
        System.out.println("get donors");

        List<Donor> donors = em.createQuery("from Donor", Donor.class).getResultList();

        return donors;
    }
}
