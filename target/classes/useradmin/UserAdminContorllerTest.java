package useradmin;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.zaoyi.it.interflow.common.util.CommonResp;

import util.SpringJunitController;

public class UserAdminContorllerTest extends SpringJunitController {
	/**控制层junit实例
	 * 注意几个静态导包
	 * 尤其注意post的链接地址一定要多加/“/user/queryByName”,不能写出“user/queryByName”
	 * @throws Exception
	 */
	@Test
	public void testqueryALl() throws Exception {
		//发生请求
		String sendHttp = sendHttp("/adminUser/addAdminUser","name","wom","pwd","123");
		CommonResp buildSuccessResp = CommonResp.buildSuccessResp(sendHttp);
		assertEquals(buildSuccessResp.getCode()==0, true);
	}
}
