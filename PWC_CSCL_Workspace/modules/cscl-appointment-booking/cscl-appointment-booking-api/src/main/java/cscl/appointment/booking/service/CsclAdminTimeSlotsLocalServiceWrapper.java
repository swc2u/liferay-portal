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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CsclAdminTimeSlotsLocalService}.
 *
 * @author @rnab
 * @see CsclAdminTimeSlotsLocalService
 * @generated
 */
public class CsclAdminTimeSlotsLocalServiceWrapper
	implements CsclAdminTimeSlotsLocalService,
			   ServiceWrapper<CsclAdminTimeSlotsLocalService> {

	public CsclAdminTimeSlotsLocalServiceWrapper(
		CsclAdminTimeSlotsLocalService csclAdminTimeSlotsLocalService) {

		_csclAdminTimeSlotsLocalService = csclAdminTimeSlotsLocalService;
	}

	/**
	 * Adds the cscl admin time slots to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAdminTimeSlots the cscl admin time slots
	 * @return the cscl admin time slots that was added
	 */
	@Override
	public cscl.appointment.booking.model.CsclAdminTimeSlots
		addCsclAdminTimeSlots(
			cscl.appointment.booking.model.CsclAdminTimeSlots
				csclAdminTimeSlots) {

		return _csclAdminTimeSlotsLocalService.addCsclAdminTimeSlots(
			csclAdminTimeSlots);
	}

	/**
	 * Creates a new cscl admin time slots with the primary key. Does not add the cscl admin time slots to the database.
	 *
	 * @param id_ the primary key for the new cscl admin time slots
	 * @return the new cscl admin time slots
	 */
	@Override
	public cscl.appointment.booking.model.CsclAdminTimeSlots
		createCsclAdminTimeSlots(long id_) {

		return _csclAdminTimeSlotsLocalService.createCsclAdminTimeSlots(id_);
	}

	/**
	 * Deletes the cscl admin time slots from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAdminTimeSlots the cscl admin time slots
	 * @return the cscl admin time slots that was removed
	 */
	@Override
	public cscl.appointment.booking.model.CsclAdminTimeSlots
		deleteCsclAdminTimeSlots(
			cscl.appointment.booking.model.CsclAdminTimeSlots
				csclAdminTimeSlots) {

		return _csclAdminTimeSlotsLocalService.deleteCsclAdminTimeSlots(
			csclAdminTimeSlots);
	}

	/**
	 * Deletes the cscl admin time slots with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots that was removed
	 * @throws PortalException if a cscl admin time slots with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclAdminTimeSlots
			deleteCsclAdminTimeSlots(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAdminTimeSlotsLocalService.deleteCsclAdminTimeSlots(id_);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAdminTimeSlotsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclAdminTimeSlotsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _csclAdminTimeSlotsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAdminTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _csclAdminTimeSlotsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAdminTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _csclAdminTimeSlotsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _csclAdminTimeSlotsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _csclAdminTimeSlotsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cscl.appointment.booking.model.CsclAdminTimeSlots
		fetchCsclAdminTimeSlots(long id_) {

		return _csclAdminTimeSlotsLocalService.fetchCsclAdminTimeSlots(id_);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclAdminTimeSlotsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl admin time slots with the primary key.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots
	 * @throws PortalException if a cscl admin time slots with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclAdminTimeSlots
			getCsclAdminTimeSlots(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAdminTimeSlotsLocalService.getCsclAdminTimeSlots(id_);
	}

	/**
	 * Returns a range of all the cscl admin time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAdminTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl admin time slotses
	 * @param end the upper bound of the range of cscl admin time slotses (not inclusive)
	 * @return the range of cscl admin time slotses
	 */
	@Override
	public java.util.List<cscl.appointment.booking.model.CsclAdminTimeSlots>
		getCsclAdminTimeSlotses(int start, int end) {

		return _csclAdminTimeSlotsLocalService.getCsclAdminTimeSlotses(
			start, end);
	}

	/**
	 * Returns the number of cscl admin time slotses.
	 *
	 * @return the number of cscl admin time slotses
	 */
	@Override
	public int getCsclAdminTimeSlotsesCount() {
		return _csclAdminTimeSlotsLocalService.getCsclAdminTimeSlotsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclAdminTimeSlotsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclAdminTimeSlotsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAdminTimeSlotsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl admin time slots in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAdminTimeSlots the cscl admin time slots
	 * @return the cscl admin time slots that was updated
	 */
	@Override
	public cscl.appointment.booking.model.CsclAdminTimeSlots
		updateCsclAdminTimeSlots(
			cscl.appointment.booking.model.CsclAdminTimeSlots
				csclAdminTimeSlots) {

		return _csclAdminTimeSlotsLocalService.updateCsclAdminTimeSlots(
			csclAdminTimeSlots);
	}

	@Override
	public CsclAdminTimeSlotsLocalService getWrappedService() {
		return _csclAdminTimeSlotsLocalService;
	}

	@Override
	public void setWrappedService(
		CsclAdminTimeSlotsLocalService csclAdminTimeSlotsLocalService) {

		_csclAdminTimeSlotsLocalService = csclAdminTimeSlotsLocalService;
	}

	private CsclAdminTimeSlotsLocalService _csclAdminTimeSlotsLocalService;

}