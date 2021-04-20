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

package cscl.appointment.admin.table.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link csclAppointmentAdminLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see csclAppointmentAdminLocalService
 * @generated
 */
public class csclAppointmentAdminLocalServiceWrapper
	implements csclAppointmentAdminLocalService,
			   ServiceWrapper<csclAppointmentAdminLocalService> {

	public csclAppointmentAdminLocalServiceWrapper(
		csclAppointmentAdminLocalService csclAppointmentAdminLocalService) {

		_csclAppointmentAdminLocalService = csclAppointmentAdminLocalService;
	}

	/**
	 * Adds the cscl appointment admin to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was added
	 */
	@Override
	public cscl.appointment.admin.table.model.csclAppointmentAdmin
		addcsclAppointmentAdmin(
			cscl.appointment.admin.table.model.csclAppointmentAdmin
				csclAppointmentAdmin) {

		return _csclAppointmentAdminLocalService.addcsclAppointmentAdmin(
			csclAppointmentAdmin);
	}

	/**
	 * Creates a new cscl appointment admin with the primary key. Does not add the cscl appointment admin to the database.
	 *
	 * @param ID the primary key for the new cscl appointment admin
	 * @return the new cscl appointment admin
	 */
	@Override
	public cscl.appointment.admin.table.model.csclAppointmentAdmin
		createcsclAppointmentAdmin(long ID) {

		return _csclAppointmentAdminLocalService.createcsclAppointmentAdmin(ID);
	}

	/**
	 * Deletes the cscl appointment admin from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 */
	@Override
	public cscl.appointment.admin.table.model.csclAppointmentAdmin
		deletecsclAppointmentAdmin(
			cscl.appointment.admin.table.model.csclAppointmentAdmin
				csclAppointmentAdmin) {

		return _csclAppointmentAdminLocalService.deletecsclAppointmentAdmin(
			csclAppointmentAdmin);
	}

	/**
	 * Deletes the cscl appointment admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 * @throws PortalException if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public cscl.appointment.admin.table.model.csclAppointmentAdmin
			deletecsclAppointmentAdmin(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentAdminLocalService.deletecsclAppointmentAdmin(ID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentAdminLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclAppointmentAdminLocalService.dynamicQuery();
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

		return _csclAppointmentAdminLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
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

		return _csclAppointmentAdminLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
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

		return _csclAppointmentAdminLocalService.dynamicQuery(
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

		return _csclAppointmentAdminLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _csclAppointmentAdminLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cscl.appointment.admin.table.model.csclAppointmentAdmin
		fetchcsclAppointmentAdmin(long ID) {

		return _csclAppointmentAdminLocalService.fetchcsclAppointmentAdmin(ID);
	}

	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin> findAll()
			throws com.liferay.portal.kernel.exception.SystemException {

		return _csclAppointmentAdminLocalService.findAll();
	}

	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				findByAppointeeAndDate(String appointee, String appointedDate)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _csclAppointmentAdminLocalService.findByAppointeeAndDate(
			appointee, appointedDate);
	}

	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				findByappointeeAndSlot(
					String appointee, String appointedDate, String FromTime,
					String SecondTimeSlot, String ThirdTimeSlot,
					String FourthTimeSlot, String FifthTimeSlot,
					String SixthTimeSlot, String SeventhTimeSlot,
					String EighthTimeSlot)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _csclAppointmentAdminLocalService.findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot);
	}

	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				findByAppointeeIDAndDate(long appointeeId, String appointedDate)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _csclAppointmentAdminLocalService.findByAppointeeIDAndDate(
			appointeeId, appointedDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclAppointmentAdminLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				getByappointedDate(String appointedDate)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _csclAppointmentAdminLocalService.getByappointedDate(
			appointedDate);
	}

	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				getByappointee(String appointee)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _csclAppointmentAdminLocalService.getByappointee(appointee);
	}

	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin> getByID(
				long ID)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _csclAppointmentAdminLocalService.getByID(ID);
	}

	/**
	 * Returns the cscl appointment admin with the primary key.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin
	 * @throws PortalException if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public cscl.appointment.admin.table.model.csclAppointmentAdmin
			getcsclAppointmentAdmin(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentAdminLocalService.getcsclAppointmentAdmin(ID);
	}

	/**
	 * Returns a range of all the cscl appointment admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of cscl appointment admins
	 */
	@Override
	public java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
			getcsclAppointmentAdmins(int start, int end) {

		return _csclAppointmentAdminLocalService.getcsclAppointmentAdmins(
			start, end);
	}

	/**
	 * Returns the number of cscl appointment admins.
	 *
	 * @return the number of cscl appointment admins
	 */
	@Override
	public int getcsclAppointmentAdminsCount() {
		return _csclAppointmentAdminLocalService.
			getcsclAppointmentAdminsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclAppointmentAdminLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclAppointmentAdminLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentAdminLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the cscl appointment admin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was updated
	 */
	@Override
	public cscl.appointment.admin.table.model.csclAppointmentAdmin
		updatecsclAppointmentAdmin(
			cscl.appointment.admin.table.model.csclAppointmentAdmin
				csclAppointmentAdmin) {

		return _csclAppointmentAdminLocalService.updatecsclAppointmentAdmin(
			csclAppointmentAdmin);
	}

	@Override
	public csclAppointmentAdminLocalService getWrappedService() {
		return _csclAppointmentAdminLocalService;
	}

	@Override
	public void setWrappedService(
		csclAppointmentAdminLocalService csclAppointmentAdminLocalService) {

		_csclAppointmentAdminLocalService = csclAppointmentAdminLocalService;
	}

	private csclAppointmentAdminLocalService _csclAppointmentAdminLocalService;

}