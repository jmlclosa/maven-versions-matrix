package com.jmlclosa.versionsmatrix.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VersionInfo implements Serializable {
    private ArtifactId artifactId;
    private Set<DependencyInfo> dependencies;

    public VersionInfo() {
        this.dependencies = new HashSet<>();
    }

    public VersionInfo(ArtifactId artifactId) {
        this.artifactId = artifactId;
        this.dependencies = new HashSet<>();
    }

    public ArtifactId getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(ArtifactId artifactId) {
        this.artifactId = artifactId;
    }

    public Set<DependencyInfo> getDependencies() {
        return dependencies;
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
        return Objects.equals(artifactId, that.artifactId) &&
                Objects.equals(dependencies, that.dependencies);
    }

    @Override
    public int hashCode() {

        return Objects.hash(artifactId, dependencies);
    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "artifactId=" + artifactId +
                ", dependencies=" + dependencies +
                '}';
    }
}
