/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.yijia.bouncer.service;

import cst8218.yijia.bouncer.AbstractFacade;
import cst8218.yijia.bouncer.entity.Bouncer;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Manages RESTful web service endpoints for manipulating entities, 
 * with methods that allows users to access and update entities through 
 * HTTP requests.
 * @author Yijia
 */
@DeclareRoles({"Admin", "RestGroup"})
@Stateless
@Path("cst8218.yijia.bouncer.entity.bouncer")
public class BouncerFacadeREST extends AbstractFacade<Bouncer> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public BouncerFacadeREST() {
        super(Bouncer.class);
    }

    /**
     * Create a bouncer entity if the id is not null.
     * @param bouncer the bouncer entity to create
     * @return returns BAD_REQUEST if id is null; 
     *         returns CREATED for successful creation.
     */
    @RolesAllowed({"Admin", "RestGroup"})
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createBouncer(Bouncer bouncer) {
        if (bouncer.getId() != null) {
            // non-null id, it's a bad request
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Bouncer's ID must be null")
                    .build();
        }

        // set null property values to default values
        if (bouncer.getxPosition() == null) {
            bouncer.setxPosition(0);
        }
        if (bouncer.getyPosition() == null) {
            bouncer.setyPosition(0);
        }
        if (bouncer.getyVelocity() == null) {
            bouncer.setyVelocity(0);
        }
        //create new Bouncer
        super.edit(bouncer);

        // return the created Bouncer with ID
        return Response.status(Response.Status.CREATED)
                .entity(bouncer)
                .build();
    }

    /**
     * Update the bouncer by searching it's id.
     * @param id bouncer's id
     * @param bouncer the new bouncer to update
     * @return returns NOT_FOUND if the searched id is null;
     *         returns BAD_REQUEST if the searched id is not matched;
     *         returns OK if the bouncer is successfully updated.
     */
    @RolesAllowed({"Admin", "RestGroup"})
    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Long id, Bouncer bouncer) {
        // check if the searched id can match a bouncer in the database
        Bouncer existingBouncer = super.find(id);
        //id is null
        if (existingBouncer == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Bouncer" + id + " is not found.")
                    .build();
        } 
        
        //not matched
        if (!bouncer.getId().equals(id)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The input id does not match Bouncer id")
                    .build();
        } 
        //update the bouncer
        existingBouncer.updateBouncer(bouncer);
        super.edit(existingBouncer);
        
        return Response.status(Response.Status.OK).entity(existingBouncer).build();
    }
    
    /**
     * Search the bouncer by id and replaces the specific bouncer if it is found.
     * @param id the old bouncer's id
     * @param bouncer new bouncer to update
     * @return returns NOT_FOUND if the searched is is null
     *         returns BAD_REQUEST if the ids are not matched
     *         returns OK if it is successfully replaced.
     */
    @RolesAllowed({"Admin", "RestGroup"})
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
    public Response replace(@PathParam("id") Long id, Bouncer bouncer) {
        // check if the searched id can match a bouncer in the database
         Bouncer existingBouncer = super.find(id);
         //id is null
         if (existingBouncer == null) {
             return Response.status(Response.Status.NOT_FOUND)
                     .entity("Bouncer " + id + " does not exist.")
                     .build();
         }
         //not matched
         if (!bouncer.getId().equals(id)) {
             return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Requested id does not match the Bouncer id")
                           .build();
         }
        
        /*
         * replace the existing bouncer with the new bouncer's non-null properties,
         * replace it with default value (0) if the new property is null.
         */
        if (bouncer.getxPosition() != null)
            existingBouncer.setxPosition(bouncer.getxPosition());
        else
            existingBouncer.setxPosition(0);
        
        if (bouncer.getyPosition() != null)
            existingBouncer.setyPosition(bouncer.getyPosition());
        else
            existingBouncer.setyPosition(0);
        
        if (bouncer.getyVelocity() != null)
            existingBouncer.setyVelocity(bouncer.getyVelocity());
        else
            existingBouncer.setyVelocity(0);
         //replace the bouncer
         super.edit(existingBouncer);
         
         return Response
                .status(Response.Status.OK)
                .entity(existingBouncer)
                .build();
    }
    
    @RolesAllowed({"Admin", "RestGroup"})
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @RolesAllowed({"Admin", "RestGroup"})
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Bouncer find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @RolesAllowed({"Admin", "RestGroup"})
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Bouncer> findAll() {
        return super.findAll();
    }

    @RolesAllowed({"Admin", "RestGroup"})
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Bouncer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @RolesAllowed({"Admin", "RestGroup"})
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
