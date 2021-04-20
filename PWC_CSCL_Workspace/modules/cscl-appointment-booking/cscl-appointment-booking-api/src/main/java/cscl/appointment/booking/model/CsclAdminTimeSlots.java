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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CsclAdminTimeSlots service. Represents a row in the &quot;Cscl_Admin_TimeSlots&quot; database table, with each column mapped to a property of this class.
 *
 * @author @rnab
 * @see CsclAdminTimeSlotsModel
 * @generated
 */
@ImplementationClassName(
	"cscl.appointment.booking.model.impl.CsclAdminTimeSlotsImpl"
)
@ProviderType
public interface CsclAdminTimeSlots
	extends CsclAdminTimeSlotsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cscl.appointment.booking.model.impl.CsclAdminTimeSlotsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CsclAdminTimeSlots, Long> ID__ACCESSOR =
		new Accessor<CsclAdminTimeSlots, Long>() {

			@Override
			public Long get(CsclAdminTimeSlots csclAdminTimeSlots) {
				return csclAdminTimeSlots.getId_();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CsclAdminTimeSlots> getTypeClass() {
				return CsclAdminTimeSlots.class;
			}

		};

}