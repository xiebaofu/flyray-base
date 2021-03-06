package me.flyray.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.flyray.cms.api.SpecialColumnContentService;
import me.flyray.cms.dao.SpecialColumnContentDao;
import me.flyray.cms.model.SpecialColumnContent;
import me.flyray.common.service.AbstractBaseService;

/** 
* @author: bolei
* @date：2017年10月6日 上午9:42:12
* @description：专栏相关逻辑处理
*/

@Service("specialColumnContentService")
public class SpecialColumnContentServiceImpl extends AbstractBaseService<SpecialColumnContent> implements SpecialColumnContentService {

	@Autowired
	private SpecialColumnContentDao specialColumnContentDao;
	
	@Override
	public SpecialColumnContent queryEntity(SpecialColumnContent param) {
		return specialColumnContentDao.queryObject(param);
	}

}
