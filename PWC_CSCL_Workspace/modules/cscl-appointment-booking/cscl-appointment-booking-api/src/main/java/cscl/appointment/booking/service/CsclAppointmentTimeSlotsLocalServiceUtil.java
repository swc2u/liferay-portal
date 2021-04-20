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

package cscl.appointment.booking.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CsclAppointmentTimeSlots. This utility wraps
 * <code>cscl.appointment.booking.service.impl.CsclAppointmentTimeSlotsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author @rnab
 * @see CsclAppointmentTimeSlotsLocalService
 * @generated
 */
public class CsclAppointmentTimeSlotsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cscl.appointment.booking.service.impl.CsclAppointmentTimeSlotsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl appointment time slots to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentTimeSlots the cscl appointment time slots
	 * @return the cscl appointment time slots that was added
	 */
	public static cscl.appointment.booking.model.CsclAppointmentTimeSlots
		addCsclAppointmentTimeSlots(
			cscl.appointment.booking.model.CsclAppointmentTimeSlots
				csclAppointmentTimeSlots) {

		return getService().addCsclAppointmentTimeSlots(
			csclAppointmentTimeSlots);
	}

	/**
	 * Creates a new cscl appointment time slots with the primary key. Does not add the cscl appointment time slots to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment time slots
	 * @return the new cscl appointment time slots
	 */
	public static cscl.appointment.booking.model.CsclAppointmentTimeSlots
		createCsclAppointmentTimeSlots(long id_) {

		return getService().createCsclAppointmentTimeSlots(id_);
	}

	/**
	 * Deletes the cscl appointment time slots from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentTimeSlots the cscl appointment time slots
	 * @return the cscl appointment time slots that was removed
	 */
	public static cscl.appointment.booking.model.CsclAppointmentTimeSlots
		deleteCsclAppointmentTimeSlots(
			cscl.appointment.booking.model.CsclAppointmentTimeSlots
				csclAppointmentTimeSlots) {

		return getService().deleteCsclAppointmentTimeSlots(
			csclAppointmentTimeSlots);
	}

	/**
	 * Deletes the cscl appointment time slots with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment time slots
	 * @return the cscl appointment time slots that was removed
	 * @throws PortalException if a cscl appointment time slots with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclAppointmentTimeSlots
			deleteCsclAppointmentTimeSlots(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCsclAppointmentTimeSlots(id_);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static cscl.appointment.booking.model.CsclAppointmentTimeSlots
		fetchCsclAppointmentTimeSlots(long id_) {

		return getService().fetchCsclAppointmentTimeSlots(id_);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl appointment time slots with the primary key.
	 *
	 * @param id_ the primary key of the cscl appointment time slots
	 * @return the cscl appointment time slots
	 * @throws PortalException if a cscl appointment time slots with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclAppointmentTimeSlots
			getCsclAppointmentTimeSlots(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCsclAppointmentTimeSlots(id_);
	}

	/**
	 * Returns a range of all the cscl appointment time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment time slotses
	 * @param end the upper bound of the range of cscl appointment time slotses (not inclusive)
	 * @return the range of cscl appointment time slotses
	 */
	public static java.util.List
		<cscl.appointment.booking.model.CsclAppointmentTimeSlots>
			getCsclAppointmentTimeSlotses(int start, int end) {

		return getService().getCsclAppointmentTimeSlotses(start, end);
	}

	/**
	 * Returns the number of cscl appointment time slotses.
	 *
	 * @return the number of cscl appointment time slotses
	 */
	public static int getCsclAppointmentTimeSlotsesCount() {
		return getService().getCsclAppointmentTimeSlotsesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl appointment time slots in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentTimeSlots the cscl appointment time slots
	 * @return the cscl appointment time slots that was updated
	 */
	public static cscl.appointment.booking.model.CsclAppointmentTimeSlots
		updateCsclAppointmentTimeSlots(
			cscl.appointment.booking.model.CsclAppointmentTimeSlots
				csclAppointmentTimeSlots) {

		return getService().updateCsclAppointmentTimeSlots(
			csclAppointmentTimeSlots);
	}

	public static CsclAppointmentTimeSlotsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclAppointmentTimeSlotsLocalService,
		 CsclAppointmentTimeSlotsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclAppointmentTimeSlotsLocalService.class);

		ServiceTracker
			<CsclAppointmentTimeSlotsLocalService,
			 CsclAppointmentTimeSlotsLocalService> serviceTracker =
				new ServiceTracker
					<CsclAppointmentTimeSlotsLocalService,
					 CsclAppointmentTimeSlotsLocalService>(
						 bundle.getBundleContext(),
						 CsclAppointmentTimeSlotsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}