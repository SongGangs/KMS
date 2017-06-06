/**
 * 
 */
package pers.sg.kms.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.sg.kms.model.Commentdetail;
import pers.sg.kms.model.Publishcomment;
import pers.sg.kms.model.Publishdynamic;
import pers.sg.kms.services.ICommentDetailService;
import pers.sg.kms.services.IPublishCommentService;
import pers.sg.kms.services.IPublishDynamicService;
import pers.sg.kms.services.IZambiaService;
import pers.sg.kms.viewmodel.DynamicIndexViewModel;
import pers.sg.kms.viewmodel.SingleDynamicModel;

/**
 * @Title:DynamicIndexServiceImp
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年3月29日
 */
@Service
public class DynamicIndexServiceImp {
	@Autowired
	private ICommentDetailService CommentServiceImp;
	@Autowired
	private IPublishCommentService publishCommentService;
	@Autowired
	private IZambiaService ZambiaServiceImp;
	@Autowired
	private IPublishDynamicService publishDynamicServices;

	public DynamicIndexViewModel getDynamicIndexViewModel() {
		DynamicIndexViewModel model = new DynamicIndexViewModel();
		List<Publishdynamic> publishdynamics = publishDynamicServices.getAllPublishdynamics();
		List<SingleDynamicModel> Slist = new ArrayList<SingleDynamicModel>();
		for (int i = 0; i < publishdynamics.size(); i++) {
			SingleDynamicModel sing = new SingleDynamicModel();
			long dynamicID = publishdynamics.get(i).getDynamicinfo().getDynamicId();
			sing.setDynamicinfo(publishdynamics.get(i).getDynamicinfo());
			List<Publishcomment> pcList = publishCommentService.getAllPublishcommentByDynamicInfoID(dynamicID);

			Map<Commentdetail, List<Commentdetail>> map = new HashMap<Commentdetail, List<Commentdetail>>();
			for (Publishcomment publishcomment : pcList) {
				List<Commentdetail> commentdetails = new ArrayList<Commentdetail>();// 副评论列表
				// 随着每个主评论初始化
				List<Commentdetail> cdlist = CommentServiceImp
						.getCommentsByPublishCommentId(publishcomment.getPublishCommentId());
				for (int j = 0; j < cdlist.size(); j++) {
					if (j == 0) {

					} else {
						commentdetails.add(cdlist.get(j));
					}
				}
				map.put(cdlist.get(0), commentdetails);

			}
			sing.setCommentmapMap(map);
			sing.setZambialist(ZambiaServiceImp.getZambiasByDynamicId(dynamicID));
			sing.setUserinfo(publishdynamics.get(i).getUserinfo());
			Slist.add(sing);
		}
		model.setDynamicModelslist(Slist);
		return model;
	}
}
