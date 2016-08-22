package com.zaoyi.it.interflow.adminuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaoyi.it.interflow.adminuser.AdminUserServiec;
import com.zaoyi.it.interflow.common.util.ExtraSpringHibernateTemplate;
import com.zaoyi.it.interflow.common.util.Paging;
import com.zaoyi.it.interflow.pub.bsc.dao.po.AdminUser;

@Service
public class AdminUserServiecImpl implements AdminUserServiec {
	
	@Autowired
	private ExtraSpringHibernateTemplate extraSpringHibernateTemplate;
	@Override
	public Paging<AdminUser> queryPageByName(int firstResult,int maxResults,Object...object) {
		String hql="From AdminUser where name like ?";
		String object1="%s%";
		return extraSpringHibernateTemplate.findPageByHQL(hql, firstResult, maxResults, object1);
	}

	@Override
	public void sava(AdminUser poc) {
		extraSpringHibernateTemplate.saveByPoc(poc);
	}

	@Override
	public void saveAll(List<AdminUser> listAdminUser) {
		extraSpringHibernateTemplate.saveAll(listAdminUser);
	}
	
}
