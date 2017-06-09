/**
 * 
 */
package pers.sg.kms.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pers.sg.kms.component.IBase64Image;

/**
 * @Title:Base64ImageTest
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017年6月9日下午12:22:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Base64ImageTest {

	@Autowired
	private IBase64Image base64ImageImpl;

	private String imgfilePath = "D:\\qqqq\\logo.jpg";
	private String filePath = "D:\\qqqq\\1.jpg";
	private String m_result = "";

	/**
	 * Test method for
	 * {@link pers.sg.kms.component.Base64ImageImpl#GenerateImage(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testGenerateImage() {

	}

	/**
	 * Test method for
	 * {@link pers.sg.kms.component.Base64ImageImpl#GetImageStr(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetImageStr() {

		String result = base64ImageImpl.GetImageStr(imgfilePath);
		try {
			FileWriter fileWriter = new FileWriter("D:\\qqqq\\1.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(result);
			bufferedWriter.close();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = base64ImageImpl.GenerateImage(filePath, result, "jpeg");
		Assert.assertTrue(flag);

	}

	@Test
	public void testCompare() {
		try {
			FileReader fileReader = new FileReader("D:\\qqqq\\1.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readResult1 = "";
			String lineTxt1 = null;
			while ((lineTxt1 = bufferedReader.readLine()) != null) {
				readResult1 += lineTxt1;
			}
			bufferedReader.close();
			fileReader = new FileReader("D:\\qqqq\\2.txt");
			bufferedReader = new BufferedReader(fileReader);
			String readResult2 = "";
			String lineTxt2 = null;
			while ((lineTxt2 = bufferedReader.readLine()) != null) {
				readResult2 += lineTxt2;
			}
			bufferedReader.close();
			String result = readResult2.replace(readResult1, "");
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
