/**
 * 
 */
package pers.sg.kms.component;

/**
 * @Title:ISaveFile
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017��5��23��
 */
public interface IBase64Image {
	public boolean GenerateImage(String filePath, String content, String imgType);

	public String GetImageStr(String imgFilePath);
}
