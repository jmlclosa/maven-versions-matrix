package com.jmlclosa.versionsmatrix.boundary;

import com.jmlclosa.versionsmatrix.control.VersionsRepository;
import com.jmlclosa.versionsmatrix.entity.VersionInfo;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("versions")
public class VersionsService {

    private VersionsRepository repository;

    @Inject
    public VersionsService(VersionsRepository repository) {
        this.repository = repository;
    }

    @POST
    public Response insert(VersionInfo versionInfo) {
        if (this.repository.insert(versionInfo)) {
            return Response.ok().build();
        }
        return Response.notModified().build();
    }
}
