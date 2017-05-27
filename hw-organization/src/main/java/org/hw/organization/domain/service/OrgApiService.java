package org.hw.organization.domain.service;

import org.hw.organization.domain.dao.OrgUserRepository;
import org.hw.organization.domain.entity.OrgUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrgApiService {
	@Autowired
	private OrgUserRepository orgUserRepository;
	@Transactional
	public OrgUser addOrgUser(OrgUser orgUser)
	{
		return orgUserRepository.saveAndFlush(orgUser);
	}

}
