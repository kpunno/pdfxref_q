package org.acme;

/* import jakarta.inject.Inject;
 * plan to inject a service which will handle PDF parsing
*/
// import jakarta.ws.rs.Produces;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;


@Path("/upload")
public class UploadResource {
    @Inject
    UploadService us;
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_HTML)
    public String uploadFile(@RestForm("file") FileUpload file) {
        System.out.println(file);
        String response = null;
        try {
            response = us.handleUpload(file);
        }
        catch (IOException e) {
            System.out.println("File upload failed.");
        }
        return response;
    }
}
