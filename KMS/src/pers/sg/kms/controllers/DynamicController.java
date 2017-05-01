/**
 * 
 */
package pers.sg.kms.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pers.sg.kms.model.Commentdetail;
import pers.sg.kms.model.Dynamicinfo;
import pers.sg.kms.model.Publishcomment;
import pers.sg.kms.model.Publishdynamic;
import pers.sg.kms.model.Userinfo;
import pers.sg.kms.services.ICommentDetailServices;
import pers.sg.kms.services.IDynamicInfoServices;
import pers.sg.kms.services.IPublishCommentService;
import pers.sg.kms.services.IPublishDynamicServices;
import pers.sg.kms.services.IUserInfoService;
import pers.sg.kms.services.imp.DynamicIndexServiceImp;
import pers.sg.kms.viewmodel.DynamicIndexViewModel;

/**
 * @Title:DynamicController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ29ÈÕ
 */
@Controller
@RequestMapping("/Dynamic")
public class DynamicController {
	@Autowired
	private DynamicIndexServiceImp dynamicIndexSer;
	@Autowired
	private IPublishDynamicServices publishDynamicServices;
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IDynamicInfoServices dynamicServices;
	@Autowired
	private ICommentDetailServices commentServices;
	@Autowired
	private IPublishCommentService publishCommentService;

	@RequestMapping("/Index")
	public ModelAndView index() {
		DynamicIndexViewModel viewModel = new DynamicIndexViewModel();
		viewModel.setDynamicModelslist(dynamicIndexSer.getDynamicIndexViewModel().getDynamicModelslist());

		return new ModelAndView("dynamic/index", "view", viewModel);
	}

	@RequestMapping(value = "/AddDynamic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String AddDynamic(String username, String message) {
		Publishdynamic p = new Publishdynamic();
		Date nowDate = new Date();
		Userinfo userinfo = userInfoService.getUserinfoByUserName(username);
		p.setUserinfo(userinfo);
		Dynamicinfo dynamic = new Dynamicinfo();
		dynamic.setContent(message);
		dynamic.setPublishTime(nowDate);
		dynamic = dynamicServices.add(dynamic);
		p.setPublishTime(nowDate);
		p.setDynamicinfo(dynamic);
		Publishdynamic publishdynamic = publishDynamicServices.add(p);
		if (publishdynamic.getPublishDynamicId() != 0) {
			return "successful";
		} else {
			return "failed";
		}
	}

	@RequestMapping(value = "/AddComment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String AddComment(String username_me, String username_you, String message, Long dynamicID,
			long publishCommentID) {
		Dynamicinfo dynamicinfo = dynamicServices.getDynamicByDynamicId(dynamicID);
		Date nowDate = new Date();
		Commentdetail c = new Commentdetail();
		c.setCommentDetailTime(nowDate);
		c.setContent(message);

		Userinfo userinfo_me = userInfoService.getUserinfoByUserName(username_me);
		c.setUserinfoByUserRecId(userinfo_me);
		if (username_you.equals("who")) {
			Publishcomment pc = new Publishcomment();
			pc.setDynamicinfo(dynamicinfo);
			pc.setTime(nowDate);
			pc = publishCommentService.add(pc);
			c.setPublishcomment(pc);
			c.setUserinfoByYouUserRecId(publishDynamicServices.getUserinfoByDynamicId(dynamicinfo.getDynamicId()));
		} else {
			c.setPublishcomment(publishCommentService.getPublishcommentByPublishcommentID(publishCommentID));
			c.setUserinfoByYouUserRecId(userInfoService.getUserinfoByUserName(username_you));
		}
		commentServices.add(c);
		if (c.getCommentDetailId() != 0) {
			return "successful";
		} else {
			return "failed";
		}
	}
}
