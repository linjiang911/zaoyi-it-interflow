package useradmin;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zaoyi.it.interflow.adminuser.AdminUserServiec;
import com.zaoyi.it.interflow.pub.bsc.dao.po.AdminUser;

import util.SpringJunitService;

public class UserAdminServiceTest extends SpringJunitService {
	@Autowired
	private AdminUserServiec adminUserServiec;
	
	/**控制层junit实例
	 * 注意几个静态导包
	 * 尤其注意post的链接地址一定要多加/“/user/queryByName”,不能写出“user/queryByName”
	 * @throws Exception
	 */
	@Test
	public void testSava() throws Exception {
		//发生请求
		AdminUser adminUser = new AdminUser();
		adminUser.setName("林江");
		adminUser.setPassword("123");
		adminUserServiec.sava(adminUser);
		assertEquals(adminUser!=null, true);
		
	}
}
