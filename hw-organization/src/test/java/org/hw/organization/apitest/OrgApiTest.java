package org.hw.organization.apitest;

import static org.junit.Assert.assertNotNull;

import org.hw.organization.api.OrgApi;
import org.hw.organization.domain.entity.OrgUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={org.hw.organization.config.SpringBeanConfig.class,org.hw.organization.config.JpaConfi.class
		,org.hw.organization.config.OrmConfig.class})
public class OrgApiTest {
	@Autowired
	private OrgApi orgApi;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUser() {
		OrgUser user=new OrgUser();
		user.setUserName("黄伟");
		assertNotNull(orgApi.addUser(user));
	}

}
