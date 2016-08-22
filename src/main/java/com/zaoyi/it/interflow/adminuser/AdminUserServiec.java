package com.zaoyi.it.interflow.adminuser;

import java.util.List;

import com.zaoyi.it.interflow.common.util.Paging;
import com.zaoyi.it.interflow.pub.bsc.dao.po.AdminUser;
/**
 * adminUser
 * @author linjiang
 *
 */
public interface AdminUserServiec {
	
	Paging<AdminUser> queryPageByName(int firstResult,int maxResults,Object...object);
	
	void sava(AdminUser adminUser);

	void saveAll(List<AdminUser> listAdminUser);
}
