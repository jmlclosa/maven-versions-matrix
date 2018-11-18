package com.jmlclosa.versionsmatrix.boundary;

import com.jmlclosa.versionsmatrix.control.VersionsRepository;
import com.jmlclosa.versionsmatrix.entity.VersionInfo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("versions")
public class VersionsService {

    private VersionsRepository repository;

    public VersionsService() {
    }

    @Inject
    public VersionsService(VersionsRepository repository) {
        this.repository = repository;
    }

    @POST
    @Consumes("application/json")
    public Response insert(VersionInfo versionInfo) {
        System.out.println(versionInfo);
        if (this.repository.insert(versionInfo)) {
            return Response.ok().build();
        }
        return Response.notModified().build();
    }
}
