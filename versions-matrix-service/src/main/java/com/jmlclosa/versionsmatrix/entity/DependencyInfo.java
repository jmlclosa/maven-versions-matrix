package com.jmlclosa.versionsmatrix.entity;

import java.util.Objects;

public class DependencyInfo {
    private ArtifactId artifactId;

    public ArtifactId getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(ArtifactId artifactId) {
        this.artifactId = artifactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DependencyInfo that = (DependencyInfo) o;
        return Objects.equals(artifactId, that.artifactId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(artifactId);
    }

    @Override
    public String toString() {
        return "DependencyInfo{" +
                "artifactId=" + artifactId +
                '}';
    }
}
