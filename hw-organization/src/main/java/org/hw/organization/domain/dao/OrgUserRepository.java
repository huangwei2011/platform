package org.hw.organization.domain.dao;

import org.hw.organization.domain.entity.OrgUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
public interface OrgUserRepository extends JpaRepository<OrgUser,Long>{
}
