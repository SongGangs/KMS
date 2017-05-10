/**
 * 
 */
package pers.sg.kms.ajaxcontrollers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

/**
 * @Title:DynamicAjaxController
 * @Description:动态的发表及评论区
 * @Personal
 * @author : SGang
 * @date : 2017年5月10日
 */
@Controller
@RequestMapping("/Dynamic")
public class DynamicAjaxController {

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

	/**
	 * 发表新的动态
	 * 
	 * @param username
	 * @param message
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/AddDynamic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> AddDynamic(String username, String message) {
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

		Map<String, Object> map = new HashMap<String, Object>();
		if (publishdynamic.getPublishDynamicId() != 0) {
			map.put("msg", "success");
		} else {
			map.put("msg", "error");
		}
		return map;
	}

	/**
	 * 发表评论
	 * 
	 * @param username_me
	 * @param username_you
	 * @param message
	 * @param dynamicID
	 * @param publishCommentID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/AddComment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> AddComment(String username_me, String username_you, String message, Long dynamicID,
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

		Map<String, Object> map = new HashMap<String, Object>();
		if (c.getCommentDetailId() != 0) {
			map.put("msg", "success");
		} else {
			map.put("msg", "error");
		}
		return map;
	}
}
