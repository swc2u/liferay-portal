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

package cscl.appointment.admin.table.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link cscl.appointment.admin.table.service.http.csclAppointmentAdminServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class csclAppointmentAdminSoap implements Serializable {

	public static csclAppointmentAdminSoap toSoapModel(
		csclAppointmentAdmin model) {

		csclAppointmentAdminSoap soapModel = new csclAppointmentAdminSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setID(model.getID());
		soapModel.setAppointeeId(model.getAppointeeId());
		soapModel.setAppointee(model.getAppointee());
		soapModel.setAppointedDate(model.getAppointedDate());
		soapModel.setFromTime(model.getFromTime());
		soapModel.setToTime(model.getToTime());
		soapModel.setSecondTimeSlot(model.getSecondTimeSlot());
		soapModel.setThirdTimeSlot(model.getThirdTimeSlot());
		soapModel.setFourthTimeSlot(model.getFourthTimeSlot());
		soapModel.setFifthTimeSlot(model.getFifthTimeSlot());
		soapModel.setSixthTimeSlot(model.getSixthTimeSlot());
		soapModel.setSeventhTimeSlot(model.getSeventhTimeSlot());
		soapModel.setEighthTimeSlot(model.getEighthTimeSlot());
		soapModel.setNineTimeSlot(model.getNineTimeSlot());
		soapModel.setTenTimeSlot(model.getTenTimeSlot());

		return soapModel;
	}

	public static csclAppointmentAdminSoap[] toSoapModels(
		csclAppointmentAdmin[] models) {

		csclAppointmentAdminSoap[] soapModels =
			new csclAppointmentAdminSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static csclAppointmentAdminSoap[][] toSoapModels(
		csclAppointmentAdmin[][] models) {

		csclAppointmentAdminSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new csclAppointmentAdminSoap[models.length][models[0].length];
		}
		else {
			soapModels = new csclAppointmentAdminSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static csclAppointmentAdminSoap[] toSoapModels(
		List<csclAppointmentAdmin> models) {

		List<csclAppointmentAdminSoap> soapModels =
			new ArrayList<csclAppointmentAdminSoap>(models.size());

		for (csclAppointmentAdmin model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new csclAppointmentAdminSoap[soapModels.size()]);
	}

	public csclAppointmentAdminSoap() {
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long pk) {
		setID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public long getAppointeeId() {
		return _appointeeId;
	}

	public void setAppointeeId(long appointeeId) {
		_appointeeId = appointeeId;
	}

	public String getAppointee() {
		return _appointee;
	}

	public void setAppointee(String appointee) {
		_appointee = appointee;
	}

	public String getAppointedDate() {
		return _appointedDate;
	}

	public void setAppointedDate(String appointedDate) {
		_appointedDate = appointedDate;
	}

	public String getFromTime() {
		return _FromTime;
	}

	public void setFromTime(String FromTime) {
		_FromTime = FromTime;
	}

	public String getToTime() {
		return _ToTime;
	}

	public void setToTime(String ToTime) {
		_ToTime = ToTime;
	}

	public String getSecondTimeSlot() {
		return _SecondTimeSlot;
	}

	public void setSecondTimeSlot(String SecondTimeSlot) {
		_SecondTimeSlot = SecondTimeSlot;
	}

	public String getThirdTimeSlot() {
		return _ThirdTimeSlot;
	}

	public void setThirdTimeSlot(String ThirdTimeSlot) {
		_ThirdTimeSlot = ThirdTimeSlot;
	}

	public String getFourthTimeSlot() {
		return _FourthTimeSlot;
	}

	public void setFourthTimeSlot(String FourthTimeSlot) {
		_FourthTimeSlot = FourthTimeSlot;
	}

	public String getFifthTimeSlot() {
		return _FifthTimeSlot;
	}

	public void setFifthTimeSlot(String FifthTimeSlot) {
		_FifthTimeSlot = FifthTimeSlot;
	}

	public String getSixthTimeSlot() {
		return _SixthTimeSlot;
	}

	public void setSixthTimeSlot(String SixthTimeSlot) {
		_SixthTimeSlot = SixthTimeSlot;
	}

	public String getSeventhTimeSlot() {
		return _SeventhTimeSlot;
	}

	public void setSeventhTimeSlot(String SeventhTimeSlot) {
		_SeventhTimeSlot = SeventhTimeSlot;
	}

	public String getEighthTimeSlot() {
		return _EighthTimeSlot;
	}

	public void setEighthTimeSlot(String EighthTimeSlot) {
		_EighthTimeSlot = EighthTimeSlot;
	}

	public String getNineTimeSlot() {
		return _NineTimeSlot;
	}

	public void setNineTimeSlot(String NineTimeSlot) {
		_NineTimeSlot = NineTimeSlot;
	}

	public String getTenTimeSlot() {
		return _TenTimeSlot;
	}

	public void setTenTimeSlot(String TenTimeSlot) {
		_TenTimeSlot = TenTimeSlot;
	}

	private String _uuid;

	private long _ID;

	private long _appointeeId;
	private String _appointee;
	private String _appointedDate;
	private String _FromTime;
	private String _ToTime;
	private String _SecondTimeSlot;
	private String _ThirdTimeSlot;
	private String _FourthTimeSlot;
	private String _FifthTimeSlot;
	private String _SixthTimeSlot;
	private String _SeventhTimeSlot;
	private String _EighthTimeSlot;
	private String _NineTimeSlot;
	private String _TenTimeSlot;

}