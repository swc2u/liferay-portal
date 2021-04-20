/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cscl.appointment.admin.table.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import cscl.appointment.admin.table.model.csclAppointmentAdmin;
import cscl.appointment.admin.table.service.base.csclAppointmentAdminLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;


/**
 * The implementation of the cscl appointment admin local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cscl.appointment.admin.table.service.csclAppointmentAdminLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see csclAppointmentAdminLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=cscl.appointment.admin.table.model.csclAppointmentAdmin",
	service = AopService.class
)
public class csclAppointmentAdminLocalServiceImpl
	extends csclAppointmentAdminLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>cscl.appointment.admin.table.service.csclAppointmentAdminLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil</code>.
	 */
	public List<csclAppointmentAdmin> findAll() throws SystemException {
		  return csclAppointmentAdminPersistence.findAll();
		 }
	
	public List<csclAppointmentAdmin> getByID(long ID)
			   throws SystemException {
			  return csclAppointmentAdminPersistence.findByappointeeId(ID);
			 }
	
	public List<csclAppointmentAdmin> getByappointee(String appointee)
			   throws SystemException {
			  return csclAppointmentAdminPersistence.findByappointee(appointee);
			 }
	public List<csclAppointmentAdmin> getByappointedDate(String appointedDate)
			   throws SystemException {
			  return csclAppointmentAdminPersistence.findByappointedDate(appointedDate);
			 }
	
	public List<csclAppointmentAdmin> findByappointeeAndSlot(
			String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot) throws SystemException {
		
		return csclAppointmentAdminPersistence.findByappointeeAndSlot(appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot, FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot, EighthTimeSlot);
		
		}	
	
	public List<csclAppointmentAdmin> findByAppointeeAndDate(
			String appointee, String appointedDate) throws SystemException {
		return csclAppointmentAdminPersistence.findByAppointeeAndDate(appointee, appointedDate);
	}
	
	
	public List<csclAppointmentAdmin> findByAppointeeIDAndDate(
			long appointeeId, String appointedDate) throws SystemException{
		
		return csclAppointmentAdminPersistence.findByAppointeeIDAndDate(appointeeId, appointedDate);

	}
	
}	
	
