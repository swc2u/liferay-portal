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

package cscl.appointment.admin.table.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cscl.appointment.admin.table.model.csclAppointmentAdmin;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing csclAppointmentAdmin in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class csclAppointmentAdminCacheModel
	implements CacheModel<csclAppointmentAdmin>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof csclAppointmentAdminCacheModel)) {
			return false;
		}

		csclAppointmentAdminCacheModel csclAppointmentAdminCacheModel =
			(csclAppointmentAdminCacheModel)obj;

		if (ID == csclAppointmentAdminCacheModel.ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ID=");
		sb.append(ID);
		sb.append(", appointeeId=");
		sb.append(appointeeId);
		sb.append(", appointee=");
		sb.append(appointee);
		sb.append(", appointedDate=");
		sb.append(appointedDate);
		sb.append(", FromTime=");
		sb.append(FromTime);
		sb.append(", ToTime=");
		sb.append(ToTime);
		sb.append(", SecondTimeSlot=");
		sb.append(SecondTimeSlot);
		sb.append(", ThirdTimeSlot=");
		sb.append(ThirdTimeSlot);
		sb.append(", FourthTimeSlot=");
		sb.append(FourthTimeSlot);
		sb.append(", FifthTimeSlot=");
		sb.append(FifthTimeSlot);
		sb.append(", SixthTimeSlot=");
		sb.append(SixthTimeSlot);
		sb.append(", SeventhTimeSlot=");
		sb.append(SeventhTimeSlot);
		sb.append(", EighthTimeSlot=");
		sb.append(EighthTimeSlot);
		sb.append(", NineTimeSlot=");
		sb.append(NineTimeSlot);
		sb.append(", TenTimeSlot=");
		sb.append(TenTimeSlot);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public csclAppointmentAdmin toEntityModel() {
		csclAppointmentAdminImpl csclAppointmentAdminImpl =
			new csclAppointmentAdminImpl();

		if (uuid == null) {
			csclAppointmentAdminImpl.setUuid("");
		}
		else {
			csclAppointmentAdminImpl.setUuid(uuid);
		}

		csclAppointmentAdminImpl.setID(ID);
		csclAppointmentAdminImpl.setAppointeeId(appointeeId);

		if (appointee == null) {
			csclAppointmentAdminImpl.setAppointee("");
		}
		else {
			csclAppointmentAdminImpl.setAppointee(appointee);
		}

		if (appointedDate == null) {
			csclAppointmentAdminImpl.setAppointedDate("");
		}
		else {
			csclAppointmentAdminImpl.setAppointedDate(appointedDate);
		}

		if (FromTime == null) {
			csclAppointmentAdminImpl.setFromTime("");
		}
		else {
			csclAppointmentAdminImpl.setFromTime(FromTime);
		}

		if (ToTime == null) {
			csclAppointmentAdminImpl.setToTime("");
		}
		else {
			csclAppointmentAdminImpl.setToTime(ToTime);
		}

		if (SecondTimeSlot == null) {
			csclAppointmentAdminImpl.setSecondTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setSecondTimeSlot(SecondTimeSlot);
		}

		if (ThirdTimeSlot == null) {
			csclAppointmentAdminImpl.setThirdTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setThirdTimeSlot(ThirdTimeSlot);
		}

		if (FourthTimeSlot == null) {
			csclAppointmentAdminImpl.setFourthTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setFourthTimeSlot(FourthTimeSlot);
		}

		if (FifthTimeSlot == null) {
			csclAppointmentAdminImpl.setFifthTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setFifthTimeSlot(FifthTimeSlot);
		}

		if (SixthTimeSlot == null) {
			csclAppointmentAdminImpl.setSixthTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setSixthTimeSlot(SixthTimeSlot);
		}

		if (SeventhTimeSlot == null) {
			csclAppointmentAdminImpl.setSeventhTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setSeventhTimeSlot(SeventhTimeSlot);
		}

		if (EighthTimeSlot == null) {
			csclAppointmentAdminImpl.setEighthTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setEighthTimeSlot(EighthTimeSlot);
		}

		if (NineTimeSlot == null) {
			csclAppointmentAdminImpl.setNineTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setNineTimeSlot(NineTimeSlot);
		}

		if (TenTimeSlot == null) {
			csclAppointmentAdminImpl.setTenTimeSlot("");
		}
		else {
			csclAppointmentAdminImpl.setTenTimeSlot(TenTimeSlot);
		}

		csclAppointmentAdminImpl.resetOriginalValues();

		return csclAppointmentAdminImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ID = objectInput.readLong();

		appointeeId = objectInput.readLong();
		appointee = objectInput.readUTF();
		appointedDate = objectInput.readUTF();
		FromTime = objectInput.readUTF();
		ToTime = objectInput.readUTF();
		SecondTimeSlot = objectInput.readUTF();
		ThirdTimeSlot = objectInput.readUTF();
		FourthTimeSlot = objectInput.readUTF();
		FifthTimeSlot = objectInput.readUTF();
		SixthTimeSlot = objectInput.readUTF();
		SeventhTimeSlot = objectInput.readUTF();
		EighthTimeSlot = objectInput.readUTF();
		NineTimeSlot = objectInput.readUTF();
		TenTimeSlot = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ID);

		objectOutput.writeLong(appointeeId);

		if (appointee == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appointee);
		}

		if (appointedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appointedDate);
		}

		if (FromTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FromTime);
		}

		if (ToTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ToTime);
		}

		if (SecondTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SecondTimeSlot);
		}

		if (ThirdTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ThirdTimeSlot);
		}

		if (FourthTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FourthTimeSlot);
		}

		if (FifthTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FifthTimeSlot);
		}

		if (SixthTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SixthTimeSlot);
		}

		if (SeventhTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SeventhTimeSlot);
		}

		if (EighthTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(EighthTimeSlot);
		}

		if (NineTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NineTimeSlot);
		}

		if (TenTimeSlot == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TenTimeSlot);
		}
	}

	public String uuid;

	public long ID;

	public long appointeeId;
	public String appointee;
	public String appointedDate;
	public String FromTime;
	public String ToTime;
	public String SecondTimeSlot;
	public String ThirdTimeSlot;
	public String FourthTimeSlot;
	public String FifthTimeSlot;
	public String SixthTimeSlot;
	public String SeventhTimeSlot;
	public String EighthTimeSlot;
	public String NineTimeSlot;
	public String TenTimeSlot;

}