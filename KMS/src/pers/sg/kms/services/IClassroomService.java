/**
 * 
 */
package pers.sg.kms.services;

import java.util.List;

import pers.sg.kms.model.Classroom;

/**
 * @Title:IClassroom
 * @Description:
 * @Personal
 * @author : SGang
 * @date : 2017Äê3ÔÂ14ÈÕ
 */
public interface IClassroomService {
	public List<Classroom> getAllClassroom();

	public Classroom delectClassroomByClassID(int ClassID);

	public Classroom insertClassroomByClassID(int ClassID);

	public Classroom updateClassroomByClassID(int ClassID);
}
