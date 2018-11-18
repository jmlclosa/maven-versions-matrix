package com.jmlclosa.versionsmatrix.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VersionInfo implements Serializable {
    private ArtifactId artifact;
    private Set<DependencyInfo> dependencies;

    public VersionInfo() {
        this.dependencies = new HashSet<>();
    }

    public VersionInfo(ArtifactId artifact) {
        this.artifact = artifact;
        this.dependencies = new HashSet<>();
    }

    public ArtifactId getArtifact() {
        return artifact;
    }

    public void setArtifact(ArtifactId artifact) {
        this.artifact = artifact;
    }

    public void setDependencies(Set<DependencyInfo> dependencies) {
        this.dependencies = dependencies;
    }

    public void addDependency(DependencyInfo dependencyInfo) {
        this.dependencies.add(dependencyInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VersionInfo that = (VersionInfo) o;
        return Objects.equals(artifact, that.artifact)
                && Objects.equals(dependencies, that.dependencies)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifact, dependencies);
    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "artifact=" + artifact +
                ", dependencies=" + dependencies +
                '}';
    }
}
