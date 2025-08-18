package org.acme;

/* import jakarta.inject.Inject;
 * plan to inject a service which will handle PDF parsing
*/
// import jakarta.ws.rs.Produces;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.core.MediaType;

import java.io.Console;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;


@Path("/upload")
public class UploadResource {
    /*
    @Inject
    GreetingService service;
    */
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String uploadFile(@RestForm("file") FileUpload file) {
        System.out.println("Hello!");
        return "Filename is " + file.name();
    }
}
