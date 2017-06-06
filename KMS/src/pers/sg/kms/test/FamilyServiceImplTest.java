/**
 * 
 */
package pers.sg.kms.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pers.sg.kms.model.Family;
import pers.sg.kms.services.IFamilyService;

/**
 * @Title:FamilyServiceImplTest
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��6��6������10:07:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FamilyServiceImplTest {

	@Autowired
	private IFamilyService familyServiceImpl;

	/**
	 * Test method for
	 * {@link pers.sg.kms.services.imp.FamilyServiceImp#getFamilyByFamilyID(long)}
	 * .
	 */
	@Test
	public void testGetFamilyByFamilyID() {
		Family family = familyServiceImpl.getFamilyByFamilyID(1);
		System.out.println(family.getFamilyName());
		Assert.assertEquals(family.getFamilyName(), "�Ҹ�֮��");
	}

	/**
	 * Test method for
	 * {@link pers.sg.kms.services.imp.FamilyServiceImp#getFamilyByFamilyName(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetFamilyByFamilyName() {
		Family family = familyServiceImpl.getFamilyByFamilyName("�ҵļ�");
		Assert.assertNotNull(family);
	}

	/**
	 * Test method for
	 * {@link pers.sg.kms.services.imp.FamilyServiceImp#save(pers.sg.kms.model.Family)}
	 * .
	 */
	@Test
	public void testSave() {
		/*
		 * Family family = new Family(); family.setFamilyName("123");
		 * Assert.assertNotNull(familyServiceImpl.save(family));
		 */
	}

}
