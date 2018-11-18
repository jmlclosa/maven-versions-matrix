package com.jmlclosa.maven;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Goal: print
 */
@Mojo(name = "print")
public class PrintMatrixMojo extends AbstractMojo {

    /**
     * The Maven Project.
     */
    @Component
    protected MavenProject project;

    public void execute() throws MojoExecutionException {
        System.out.println(String.format("Hello %s", project.getArtifactId()));
        List<Dependency> dependencies = project.getDependencies();
        System.out.println(dependencies.size());
        JsonArrayBuilder jsonDependencies = Json.createArrayBuilder();
        for (Dependency dependency : dependencies) {
            jsonDependencies.add(buildJsonFromDependency(dependency));
        }
        sendDependencyInfo(buildVersionInfoJson(this.project, jsonDependencies.build()));
    }

    private void sendDependencyInfo(JsonObject versionInfo) {
        System.out.println("Sending " + versionInfo.toString());
        Response response = ClientBuilder.newBuilder().build()
                .target("http://localhost:8080/versions-matrix-service/resources/")
                .path("versions")
                .request().post(Entity.entity(versionInfo.toString(), MediaType.APPLICATION_JSON));
        System.out.println("Response: " + response.getStatus());
    }

    private JsonObject buildJsonFromDependency(Dependency dependency) {
        return Json.createObjectBuilder()
                .add("artifact", Json.createObjectBuilder()
                        .add("artifactId", dependency.getArtifactId())
                        .add("groupId", dependency.getGroupId())
                        .add("version", dependency.getVersion())
                        .build()
                )
                .build();
    }

    private JsonObject buildVersionInfoJson(MavenProject project, JsonArray dependencies) {
        return Json.createObjectBuilder()
                .add("artifact", buildArtifactIdFromMavenProject(project))
                .add("dependencies", dependencies)
                .build();
    }

    private JsonObject buildArtifactIdFromMavenProject(MavenProject project) {
        return Json.createObjectBuilder()
                .add("artifactId", project.getArtifactId())
                .add("groupId", project.getGroupId())
                .add("version", project.getVersion())
                .build();
    }
}
