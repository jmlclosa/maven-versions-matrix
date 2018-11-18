package com.jmlclosa.versionsmatrix.control;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VersionsRepositoryTest {

    private VersionsRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = new VersionsRepository();
    }
/*
    @Test
    void insert_whenNoExists_TrueReturned() {
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setArtifactId(new ArtifactId("artifact", "group", "1.0"));
        // When
        boolean result = this.repository.insert(versionInfo);
        // Then
        assertTrue(result);
    }


    @Test
    void insert_whenExists_FalseReturned() {
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setArtifactId(new ArtifactId("artifact", "group", "1.0"));

        // When
        boolean result = this.repository.insert(versionInfo);
        boolean result2 = this.repository.insert(versionInfo);
        // Then
        assertTrue(result);
        assertFalse(result2);
    }

    @Test
    void findAll() {
        VersionInfo versionInfo1 = new VersionInfo(new ArtifactId("artifact", "group", "1.0"));
        VersionInfo versionInfo2 = new VersionInfo(new ArtifactId("artifact", "group", "2.0"));
        VersionInfo versionInfo3 = new VersionInfo(new ArtifactId("artifact", "group2", "1.0"));

        // When
        this.repository.insert(versionInfo1);
        this.repository.insert(versionInfo2);
        this.repository.insert(versionInfo3);
        Set<VersionInfo> result = this.repository.findAll();

        // Then
        Set<VersionInfo> expected = Stream.of(versionInfo1, versionInfo2, versionInfo3).collect(Collectors.toSet());
        MatcherAssert.assertThat(result, CoreMatchers.is(expected));
    }

    private static class VersionInfoBuilder {
        private String artifact;
        private String group;
        private String version;
        private Set<DependencyInfo> dependencies;

        public VersionInfoBuilder withArtifact(String artifact) {
            this.artifact = artifact;
            return this;
        }
        public VersionInfoBuilder withGroup() {
            this.group = group;
            return this;
        }
        public VersionInfoBuilder withVersion(String version) {
            this.version = version;
            return this;
        }
        public VersionInfo build() {
            VersionInfo versionInfo = new VersionInfo();
            versionInfo.setArtifactId(new ArtifactId(artifact, group, version));
            versionInfo.setDependencies(dependencies);
            return versionInfo;
        }
    }

    */
}