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

package cscl.appointment.booking.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cscl.appointment.booking.model.CsclAppointmentTimeSlots;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CsclAppointmentTimeSlots in entity cache.
 *
 * @author @rnab
 * @generated
 */
public class CsclAppointmentTimeSlotsCacheModel
	implements CacheModel<CsclAppointmentTimeSlots>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclAppointmentTimeSlotsCacheModel)) {
			return false;
		}

		CsclAppointmentTimeSlotsCacheModel csclAppointmentTimeSlotsCacheModel =
			(CsclAppointmentTimeSlotsCacheModel)obj;

		if (id_ == csclAppointmentTimeSlotsCacheModel.id_) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id_=");
		sb.append(id_);
		sb.append(", Timeslot=");
		sb.append(Timeslot);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclAppointmentTimeSlots toEntityModel() {
		CsclAppointmentTimeSlotsImpl csclAppointmentTimeSlotsImpl =
			new CsclAppointmentTimeSlotsImpl();

		csclAppointmentTimeSlotsImpl.setId_(id_);

		if (Timeslot == null) {
			csclAppointmentTimeSlotsImpl.setTimeslot("");
		}
		else {
			csclAppointmentTimeSlotsImpl.setTimeslot(Timeslot);
		}

		csclAppointmentTimeSlotsImpl.resetOriginalValues();

		return csclAppointmentTimeSlotsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();
		Timeslot = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id_);

		if (Timeslot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Timeslot);
		}
	}

	public long id_;
	public String Timeslot;

}