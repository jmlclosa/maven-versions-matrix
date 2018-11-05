package com.jmlclosa.versionsmatrix.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArtifactId implements Serializable {
    private String artifactId;
    private String groupId;
    private String version;

    public ArtifactId() {
        // Default JPA constructor
    }

    public ArtifactId(String artifactId, String groupId, String version) {
        this.artifactId = artifactId;
        this.groupId = groupId;
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtifactId that = (ArtifactId) o;
        return Objects.equals(artifactId, that.artifactId) &&
                Objects.equals(groupId, that.groupId) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactId, groupId, version);
    }

    @Override
    public String toString() {
        return "ArtifactId{" +
                "artifactId='" + artifactId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
