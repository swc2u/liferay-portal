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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link csclAppointmentAdmin}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see csclAppointmentAdmin
 * @generated
 */
public class csclAppointmentAdminWrapper
	extends BaseModelWrapper<csclAppointmentAdmin>
	implements csclAppointmentAdmin, ModelWrapper<csclAppointmentAdmin> {

	public csclAppointmentAdminWrapper(
		csclAppointmentAdmin csclAppointmentAdmin) {

		super(csclAppointmentAdmin);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ID", getID());
		attributes.put("appointeeId", getAppointeeId());
		attributes.put("appointee", getAppointee());
		attributes.put("appointedDate", getAppointedDate());
		attributes.put("FromTime", getFromTime());
		attributes.put("ToTime", getToTime());
		attributes.put("SecondTimeSlot", getSecondTimeSlot());
		attributes.put("ThirdTimeSlot", getThirdTimeSlot());
		attributes.put("FourthTimeSlot", getFourthTimeSlot());
		attributes.put("FifthTimeSlot", getFifthTimeSlot());
		attributes.put("SixthTimeSlot", getSixthTimeSlot());
		attributes.put("SeventhTimeSlot", getSeventhTimeSlot());
		attributes.put("EighthTimeSlot", getEighthTimeSlot());
		attributes.put("NineTimeSlot", getNineTimeSlot());
		attributes.put("TenTimeSlot", getTenTimeSlot());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ID = (Long)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Long appointeeId = (Long)attributes.get("appointeeId");

		if (appointeeId != null) {
			setAppointeeId(appointeeId);
		}

		String appointee = (String)attributes.get("appointee");

		if (appointee != null) {
			setAppointee(appointee);
		}

		String appointedDate = (String)attributes.get("appointedDate");

		if (appointedDate != null) {
			setAppointedDate(appointedDate);
		}

		String FromTime = (String)attributes.get("FromTime");

		if (FromTime != null) {
			setFromTime(FromTime);
		}

		String ToTime = (String)attributes.get("ToTime");

		if (ToTime != null) {
			setToTime(ToTime);
		}

		String SecondTimeSlot = (String)attributes.get("SecondTimeSlot");

		if (SecondTimeSlot != null) {
			setSecondTimeSlot(SecondTimeSlot);
		}

		String ThirdTimeSlot = (String)attributes.get("ThirdTimeSlot");

		if (ThirdTimeSlot != null) {
			setThirdTimeSlot(ThirdTimeSlot);
		}

		String FourthTimeSlot = (String)attributes.get("FourthTimeSlot");

		if (FourthTimeSlot != null) {
			setFourthTimeSlot(FourthTimeSlot);
		}

		String FifthTimeSlot = (String)attributes.get("FifthTimeSlot");

		if (FifthTimeSlot != null) {
			setFifthTimeSlot(FifthTimeSlot);
		}

		String SixthTimeSlot = (String)attributes.get("SixthTimeSlot");

		if (SixthTimeSlot != null) {
			setSixthTimeSlot(SixthTimeSlot);
		}

		String SeventhTimeSlot = (String)attributes.get("SeventhTimeSlot");

		if (SeventhTimeSlot != null) {
			setSeventhTimeSlot(SeventhTimeSlot);
		}

		String EighthTimeSlot = (String)attributes.get("EighthTimeSlot");

		if (EighthTimeSlot != null) {
			setEighthTimeSlot(EighthTimeSlot);
		}

		String NineTimeSlot = (String)attributes.get("NineTimeSlot");

		if (NineTimeSlot != null) {
			setNineTimeSlot(NineTimeSlot);
		}

		String TenTimeSlot = (String)attributes.get("TenTimeSlot");

		if (TenTimeSlot != null) {
			setTenTimeSlot(TenTimeSlot);
		}
	}

	/**
	 * Returns the appointed date of this cscl appointment admin.
	 *
	 * @return the appointed date of this cscl appointment admin
	 */
	@Override
	public String getAppointedDate() {
		return model.getAppointedDate();
	}

	/**
	 * Returns the appointee of this cscl appointment admin.
	 *
	 * @return the appointee of this cscl appointment admin
	 */
	@Override
	public String getAppointee() {
		return model.getAppointee();
	}

	/**
	 * Returns the appointee ID of this cscl appointment admin.
	 *
	 * @return the appointee ID of this cscl appointment admin
	 */
	@Override
	public long getAppointeeId() {
		return model.getAppointeeId();
	}

	/**
	 * Returns the eighth time slot of this cscl appointment admin.
	 *
	 * @return the eighth time slot of this cscl appointment admin
	 */
	@Override
	public String getEighthTimeSlot() {
		return model.getEighthTimeSlot();
	}

	/**
	 * Returns the fifth time slot of this cscl appointment admin.
	 *
	 * @return the fifth time slot of this cscl appointment admin
	 */
	@Override
	public String getFifthTimeSlot() {
		return model.getFifthTimeSlot();
	}

	/**
	 * Returns the fourth time slot of this cscl appointment admin.
	 *
	 * @return the fourth time slot of this cscl appointment admin
	 */
	@Override
	public String getFourthTimeSlot() {
		return model.getFourthTimeSlot();
	}

	/**
	 * Returns the from time of this cscl appointment admin.
	 *
	 * @return the from time of this cscl appointment admin
	 */
	@Override
	public String getFromTime() {
		return model.getFromTime();
	}

	/**
	 * Returns the ID of this cscl appointment admin.
	 *
	 * @return the ID of this cscl appointment admin
	 */
	@Override
	public long getID() {
		return model.getID();
	}

	/**
	 * Returns the nine time slot of this cscl appointment admin.
	 *
	 * @return the nine time slot of this cscl appointment admin
	 */
	@Override
	public String getNineTimeSlot() {
		return model.getNineTimeSlot();
	}

	/**
	 * Returns the primary key of this cscl appointment admin.
	 *
	 * @return the primary key of this cscl appointment admin
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the second time slot of this cscl appointment admin.
	 *
	 * @return the second time slot of this cscl appointment admin
	 */
	@Override
	public String getSecondTimeSlot() {
		return model.getSecondTimeSlot();
	}

	/**
	 * Returns the seventh time slot of this cscl appointment admin.
	 *
	 * @return the seventh time slot of this cscl appointment admin
	 */
	@Override
	public String getSeventhTimeSlot() {
		return model.getSeventhTimeSlot();
	}

	/**
	 * Returns the sixth time slot of this cscl appointment admin.
	 *
	 * @return the sixth time slot of this cscl appointment admin
	 */
	@Override
	public String getSixthTimeSlot() {
		return model.getSixthTimeSlot();
	}

	/**
	 * Returns the ten time slot of this cscl appointment admin.
	 *
	 * @return the ten time slot of this cscl appointment admin
	 */
	@Override
	public String getTenTimeSlot() {
		return model.getTenTimeSlot();
	}

	/**
	 * Returns the third time slot of this cscl appointment admin.
	 *
	 * @return the third time slot of this cscl appointment admin
	 */
	@Override
	public String getThirdTimeSlot() {
		return model.getThirdTimeSlot();
	}

	/**
	 * Returns the to time of this cscl appointment admin.
	 *
	 * @return the to time of this cscl appointment admin
	 */
	@Override
	public String getToTime() {
		return model.getToTime();
	}

	/**
	 * Returns the uuid of this cscl appointment admin.
	 *
	 * @return the uuid of this cscl appointment admin
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appointed date of this cscl appointment admin.
	 *
	 * @param appointedDate the appointed date of this cscl appointment admin
	 */
	@Override
	public void setAppointedDate(String appointedDate) {
		model.setAppointedDate(appointedDate);
	}

	/**
	 * Sets the appointee of this cscl appointment admin.
	 *
	 * @param appointee the appointee of this cscl appointment admin
	 */
	@Override
	public void setAppointee(String appointee) {
		model.setAppointee(appointee);
	}

	/**
	 * Sets the appointee ID of this cscl appointment admin.
	 *
	 * @param appointeeId the appointee ID of this cscl appointment admin
	 */
	@Override
	public void setAppointeeId(long appointeeId) {
		model.setAppointeeId(appointeeId);
	}

	/**
	 * Sets the eighth time slot of this cscl appointment admin.
	 *
	 * @param EighthTimeSlot the eighth time slot of this cscl appointment admin
	 */
	@Override
	public void setEighthTimeSlot(String EighthTimeSlot) {
		model.setEighthTimeSlot(EighthTimeSlot);
	}

	/**
	 * Sets the fifth time slot of this cscl appointment admin.
	 *
	 * @param FifthTimeSlot the fifth time slot of this cscl appointment admin
	 */
	@Override
	public void setFifthTimeSlot(String FifthTimeSlot) {
		model.setFifthTimeSlot(FifthTimeSlot);
	}

	/**
	 * Sets the fourth time slot of this cscl appointment admin.
	 *
	 * @param FourthTimeSlot the fourth time slot of this cscl appointment admin
	 */
	@Override
	public void setFourthTimeSlot(String FourthTimeSlot) {
		model.setFourthTimeSlot(FourthTimeSlot);
	}

	/**
	 * Sets the from time of this cscl appointment admin.
	 *
	 * @param FromTime the from time of this cscl appointment admin
	 */
	@Override
	public void setFromTime(String FromTime) {
		model.setFromTime(FromTime);
	}

	/**
	 * Sets the ID of this cscl appointment admin.
	 *
	 * @param ID the ID of this cscl appointment admin
	 */
	@Override
	public void setID(long ID) {
		model.setID(ID);
	}

	/**
	 * Sets the nine time slot of this cscl appointment admin.
	 *
	 * @param NineTimeSlot the nine time slot of this cscl appointment admin
	 */
	@Override
	public void setNineTimeSlot(String NineTimeSlot) {
		model.setNineTimeSlot(NineTimeSlot);
	}

	/**
	 * Sets the primary key of this cscl appointment admin.
	 *
	 * @param primaryKey the primary key of this cscl appointment admin
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the second time slot of this cscl appointment admin.
	 *
	 * @param SecondTimeSlot the second time slot of this cscl appointment admin
	 */
	@Override
	public void setSecondTimeSlot(String SecondTimeSlot) {
		model.setSecondTimeSlot(SecondTimeSlot);
	}

	/**
	 * Sets the seventh time slot of this cscl appointment admin.
	 *
	 * @param SeventhTimeSlot the seventh time slot of this cscl appointment admin
	 */
	@Override
	public void setSeventhTimeSlot(String SeventhTimeSlot) {
		model.setSeventhTimeSlot(SeventhTimeSlot);
	}

	/**
	 * Sets the sixth time slot of this cscl appointment admin.
	 *
	 * @param SixthTimeSlot the sixth time slot of this cscl appointment admin
	 */
	@Override
	public void setSixthTimeSlot(String SixthTimeSlot) {
		model.setSixthTimeSlot(SixthTimeSlot);
	}

	/**
	 * Sets the ten time slot of this cscl appointment admin.
	 *
	 * @param TenTimeSlot the ten time slot of this cscl appointment admin
	 */
	@Override
	public void setTenTimeSlot(String TenTimeSlot) {
		model.setTenTimeSlot(TenTimeSlot);
	}

	/**
	 * Sets the third time slot of this cscl appointment admin.
	 *
	 * @param ThirdTimeSlot the third time slot of this cscl appointment admin
	 */
	@Override
	public void setThirdTimeSlot(String ThirdTimeSlot) {
		model.setThirdTimeSlot(ThirdTimeSlot);
	}

	/**
	 * Sets the to time of this cscl appointment admin.
	 *
	 * @param ToTime the to time of this cscl appointment admin
	 */
	@Override
	public void setToTime(String ToTime) {
		model.setToTime(ToTime);
	}

	/**
	 * Sets the uuid of this cscl appointment admin.
	 *
	 * @param uuid the uuid of this cscl appointment admin
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected csclAppointmentAdminWrapper wrap(
		csclAppointmentAdmin csclAppointmentAdmin) {

		return new csclAppointmentAdminWrapper(csclAppointmentAdmin);
	}

}