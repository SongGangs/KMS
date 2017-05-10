/**
 * 
 */
package pers.sg.kms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/Index")
	public ModelAndView index() {
		DynamicIndexViewModel viewModel = new DynamicIndexViewModel();
		viewModel.setDynamicModelslist(dynamicIndexSer.getDynamicIndexViewModel().getDynamicModelslist());

		return new ModelAndView("dynamic/index", "view", viewModel);
	}

}
