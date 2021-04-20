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

package cscl.appointment.booking.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author @rnab
 * @generated
 */
public class CsclAppointmentTimeSlotsSoap implements Serializable {

	public static CsclAppointmentTimeSlotsSoap toSoapModel(
		CsclAppointmentTimeSlots model) {

		CsclAppointmentTimeSlotsSoap soapModel =
			new CsclAppointmentTimeSlotsSoap();

		soapModel.setId_(model.getId_());
		soapModel.setTimeslot(model.getTimeslot());

		return soapModel;
	}

	public static CsclAppointmentTimeSlotsSoap[] toSoapModels(
		CsclAppointmentTimeSlots[] models) {

		CsclAppointmentTimeSlotsSoap[] soapModels =
			new CsclAppointmentTimeSlotsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclAppointmentTimeSlotsSoap[][] toSoapModels(
		CsclAppointmentTimeSlots[][] models) {

		CsclAppointmentTimeSlotsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclAppointmentTimeSlotsSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new CsclAppointmentTimeSlotsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclAppointmentTimeSlotsSoap[] toSoapModels(
		List<CsclAppointmentTimeSlots> models) {

		List<CsclAppointmentTimeSlotsSoap> soapModels =
			new ArrayList<CsclAppointmentTimeSlotsSoap>(models.size());

		for (CsclAppointmentTimeSlots model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CsclAppointmentTimeSlotsSoap[soapModels.size()]);
	}

	public CsclAppointmentTimeSlotsSoap() {
	}

	public long getPrimaryKey() {
		return _id_;
	}

	public void setPrimaryKey(long pk) {
		setId_(pk);
	}

	public long getId_() {
		return _id_;
	}

	public void setId_(long id_) {
		_id_ = id_;
	}

	public String getTimeslot() {
		return _Timeslot;
	}

	public void setTimeslot(String Timeslot) {
		_Timeslot = Timeslot;
	}

	private long _id_;
	private String _Timeslot;

}