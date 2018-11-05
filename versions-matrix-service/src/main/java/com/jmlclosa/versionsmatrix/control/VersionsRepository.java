package com.jmlclosa.versionsmatrix.control;

import com.jmlclosa.versionsmatrix.entity.VersionInfo;

import java.util.HashSet;
import java.util.Set;

public class VersionsRepository {
    private Set<VersionInfo> versions;

    public VersionsRepository() {
        this.versions = new HashSet<>();
    }

    public boolean insert(VersionInfo versionInfo) {
        return this.versions.add(versionInfo);
    }

    public Set<VersionInfo> findAll() {
        return this.versions;
    }
}
