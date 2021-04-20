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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CsclAppointmentTimeSlots}.
 * </p>
 *
 * @author @rnab
 * @see CsclAppointmentTimeSlots
 * @generated
 */
public class CsclAppointmentTimeSlotsWrapper
	extends BaseModelWrapper<CsclAppointmentTimeSlots>
	implements CsclAppointmentTimeSlots,
			   ModelWrapper<CsclAppointmentTimeSlots> {

	public CsclAppointmentTimeSlotsWrapper(
		CsclAppointmentTimeSlots csclAppointmentTimeSlots) {

		super(csclAppointmentTimeSlots);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("Timeslot", getTimeslot());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_ = (Long)attributes.get("id_");

		if (id_ != null) {
			setId_(id_);
		}

		String Timeslot = (String)attributes.get("Timeslot");

		if (Timeslot != null) {
			setTimeslot(Timeslot);
		}
	}

	/**
	 * Returns the id_ of this cscl appointment time slots.
	 *
	 * @return the id_ of this cscl appointment time slots
	 */
	@Override
	public long getId_() {
		return model.getId_();
	}

	/**
	 * Returns the primary key of this cscl appointment time slots.
	 *
	 * @return the primary key of this cscl appointment time slots
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the timeslot of this cscl appointment time slots.
	 *
	 * @return the timeslot of this cscl appointment time slots
	 */
	@Override
	public String getTimeslot() {
		return model.getTimeslot();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the id_ of this cscl appointment time slots.
	 *
	 * @param id_ the id_ of this cscl appointment time slots
	 */
	@Override
	public void setId_(long id_) {
		model.setId_(id_);
	}

	/**
	 * Sets the primary key of this cscl appointment time slots.
	 *
	 * @param primaryKey the primary key of this cscl appointment time slots
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the timeslot of this cscl appointment time slots.
	 *
	 * @param Timeslot the timeslot of this cscl appointment time slots
	 */
	@Override
	public void setTimeslot(String Timeslot) {
		model.setTimeslot(Timeslot);
	}

	@Override
	protected CsclAppointmentTimeSlotsWrapper wrap(
		CsclAppointmentTimeSlots csclAppointmentTimeSlots) {

		return new CsclAppointmentTimeSlotsWrapper(csclAppointmentTimeSlots);
	}

}