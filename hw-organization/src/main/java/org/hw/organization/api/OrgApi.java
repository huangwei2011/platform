package org.hw.organization.api;

import org.hw.organization.domain.entity.OrgUser;
import org.hw.organization.domain.service.OrgApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgApi {
	@Autowired
	private OrgApiService orgApiService;
	public OrgUser addUser(OrgUser orgUser)
	{
		return orgApiService.addOrgUser(orgUser);
	}

}
