package com.example.jakarta.hello;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/product")
public class ProductResource {
    ProductManager productManager = ProductManager.getInstance();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addProduct(Product product){
        try {
            productManager.addProduct(product);
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(product).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public  Response getProduct(@QueryParam("name") String name){
        Product product;
        product =  productManager.searchProduct(name);
        if(product==null)return  Response.status(Response.Status.BAD_REQUEST).build();
        return Response.status(Response.Status.ACCEPTED).entity(product).build();
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response deleteProduct(Product product){
        productManager.deleteProduct(product);
        return Response.status(Response.Status.ACCEPTED).build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateProduct(@QueryParam("name") String name,@QueryParam("newName") String newName,@QueryParam("price") double price){
        try {
            productManager.updateProduct(name,newName,price);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
