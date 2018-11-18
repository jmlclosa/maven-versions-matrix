package com.jmlclosa.versionsmatrix.entity;

import java.util.Objects;

public class DependencyInfo {
    private ArtifactId artifact;

    public ArtifactId getArtifact() {
        return artifact;
    }

    public void setArtifact(ArtifactId artifact) {
        this.artifact = artifact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DependencyInfo that = (DependencyInfo) o;
        return Objects.equals(artifact, that.artifact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifact);
    }

    @Override
    public String toString() {
        return "DependencyInfo{" +
                "artifact=" + artifact +
                '}';
    }
}
