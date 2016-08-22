package com.zaoyi.test.util.adminuser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zaoyi.it.interflow.adminuser.AdminUserServiec;
import com.zaoyi.it.interflow.common.util.CommonResp;
import com.zaoyi.it.interflow.common.util.Paging;
import com.zaoyi.it.interflow.pub.bsc.dao.po.AdminUser;
import com.zaoyi.test.util.SpringJunitService;

public class UserAdminServiceTest extends SpringJunitService {
	@Autowired
	private AdminUserServiec adminUserServiec;
	
	@Test
	public void testSava() throws Exception {
		AdminUser adminUser = new AdminUser();
		adminUser.setName("林江");
		adminUser.setPassword("123");
		adminUserServiec.sava(adminUser);
		assertEquals(adminUser!=null, true);
	}
	@Test
	public void testQueryPageByName() {
		Paging<AdminUser> queryPageByName = adminUserServiec.queryPageByName(1, 6, "s");
		CommonResp bs = CommonResp.buildSuccessResp(queryPageByName);
		assertEquals(bs.getCode()==0,true);
	}

	@Test
	public void testSaveAll() {
		List<AdminUser> arrayList = new ArrayList<AdminUser>();
		for(int i=0;i<100000;i++){
			AdminUser adminUser = new AdminUser();
			adminUser.setName("ssdd"+i);
			adminUser.setPassword("123");
			arrayList.add(adminUser);
		}
		adminUserServiec.saveAll(arrayList);
		assertEquals(arrayList.size()>0,true);
	}
}
