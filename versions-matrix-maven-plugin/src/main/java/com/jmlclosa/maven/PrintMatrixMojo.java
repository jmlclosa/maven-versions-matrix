package com.jmlclosa.maven;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

import javax.json.Json;
import javax.json.JsonObject;
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
        for (Dependency dependency : dependencies) {
            sendDependencyInfo(dependency);
        }
    }

    private void sendDependencyInfo(Dependency dependency) {
        JsonObject jsonObject = buildJsonFromDependency(dependency);
        System.out.println("Sending " + jsonObject.toString());
    }

    private JsonObject buildJsonFromDependency(Dependency dependency) {
        System.out.println("Transform dependency " + dependency.toString());
        return Json.createObjectBuilder()
                .add("artifact", dependency.getArtifactId())
                .add("group", dependency.getGroupId())
                .add("version", dependency.getVersion())
                .build();
    }
}
