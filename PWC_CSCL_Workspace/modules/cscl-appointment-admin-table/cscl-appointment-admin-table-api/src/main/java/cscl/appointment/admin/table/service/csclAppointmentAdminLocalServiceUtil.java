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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for csclAppointmentAdmin. This utility wraps
 * <code>cscl.appointment.admin.table.service.impl.csclAppointmentAdminLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see csclAppointmentAdminLocalService
 * @generated
 */
public class csclAppointmentAdminLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cscl.appointment.admin.table.service.impl.csclAppointmentAdminLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl appointment admin to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was added
	 */
	public static cscl.appointment.admin.table.model.csclAppointmentAdmin
		addcsclAppointmentAdmin(
			cscl.appointment.admin.table.model.csclAppointmentAdmin
				csclAppointmentAdmin) {

		return getService().addcsclAppointmentAdmin(csclAppointmentAdmin);
	}

	/**
	 * Creates a new cscl appointment admin with the primary key. Does not add the cscl appointment admin to the database.
	 *
	 * @param ID the primary key for the new cscl appointment admin
	 * @return the new cscl appointment admin
	 */
	public static cscl.appointment.admin.table.model.csclAppointmentAdmin
		createcsclAppointmentAdmin(long ID) {

		return getService().createcsclAppointmentAdmin(ID);
	}

	/**
	 * Deletes the cscl appointment admin from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 */
	public static cscl.appointment.admin.table.model.csclAppointmentAdmin
		deletecsclAppointmentAdmin(
			cscl.appointment.admin.table.model.csclAppointmentAdmin
				csclAppointmentAdmin) {

		return getService().deletecsclAppointmentAdmin(csclAppointmentAdmin);
	}

	/**
	 * Deletes the cscl appointment admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 * @throws PortalException if a cscl appointment admin with the primary key could not be found
	 */
	public static cscl.appointment.admin.table.model.csclAppointmentAdmin
			deletecsclAppointmentAdmin(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletecsclAppointmentAdmin(ID);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl</code>.
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

	public static cscl.appointment.admin.table.model.csclAppointmentAdmin
		fetchcsclAppointmentAdmin(long ID) {

		return getService().fetchcsclAppointmentAdmin(ID);
	}

	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin> findAll()
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findAll();
	}

	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				findByAppointeeAndDate(String appointee, String appointedDate)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByAppointeeAndDate(appointee, appointedDate);
	}

	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				findByappointeeAndSlot(
					String appointee, String appointedDate, String FromTime,
					String SecondTimeSlot, String ThirdTimeSlot,
					String FourthTimeSlot, String FifthTimeSlot,
					String SixthTimeSlot, String SeventhTimeSlot,
					String EighthTimeSlot)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot);
	}

	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				findByAppointeeIDAndDate(long appointeeId, String appointedDate)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByAppointeeIDAndDate(
			appointeeId, appointedDate);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				getByappointedDate(String appointedDate)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByappointedDate(appointedDate);
	}

	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
				getByappointee(String appointee)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByappointee(appointee);
	}

	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin> getByID(
				long ID)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByID(ID);
	}

	/**
	 * Returns the cscl appointment admin with the primary key.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin
	 * @throws PortalException if a cscl appointment admin with the primary key could not be found
	 */
	public static cscl.appointment.admin.table.model.csclAppointmentAdmin
			getcsclAppointmentAdmin(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getcsclAppointmentAdmin(ID);
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
	public static java.util.List
		<cscl.appointment.admin.table.model.csclAppointmentAdmin>
			getcsclAppointmentAdmins(int start, int end) {

		return getService().getcsclAppointmentAdmins(start, end);
	}

	/**
	 * Returns the number of cscl appointment admins.
	 *
	 * @return the number of cscl appointment admins
	 */
	public static int getcsclAppointmentAdminsCount() {
		return getService().getcsclAppointmentAdminsCount();
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
	 * Updates the cscl appointment admin in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 * @return the cscl appointment admin that was updated
	 */
	public static cscl.appointment.admin.table.model.csclAppointmentAdmin
		updatecsclAppointmentAdmin(
			cscl.appointment.admin.table.model.csclAppointmentAdmin
				csclAppointmentAdmin) {

		return getService().updatecsclAppointmentAdmin(csclAppointmentAdmin);
	}

	public static csclAppointmentAdminLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<csclAppointmentAdminLocalService, csclAppointmentAdminLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			csclAppointmentAdminLocalService.class);

		ServiceTracker
			<csclAppointmentAdminLocalService, csclAppointmentAdminLocalService>
				serviceTracker =
					new ServiceTracker
						<csclAppointmentAdminLocalService,
						 csclAppointmentAdminLocalService>(
							 bundle.getBundleContext(),
							 csclAppointmentAdminLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}