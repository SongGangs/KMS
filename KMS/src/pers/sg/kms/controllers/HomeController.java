/**
 * 
 */
package pers.sg.kms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title:HomeController
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��3��25��
 */
@Controller
@RequestMapping("/Home")
public class HomeController {

	@RequestMapping("/Index")
	public String index() {
		return "home/index";
	}
}
