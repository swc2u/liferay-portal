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

package cscl.appointment.admin.table.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.admin.table.model.csclAppointmentAdmin;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl appointment admin service. This utility wraps <code>cscl.appointment.admin.table.service.persistence.impl.csclAppointmentAdminPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see csclAppointmentAdminPersistence
 * @generated
 */
public class csclAppointmentAdminUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(csclAppointmentAdmin csclAppointmentAdmin) {
		getPersistence().clearCache(csclAppointmentAdmin);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, csclAppointmentAdmin> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<csclAppointmentAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<csclAppointmentAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<csclAppointmentAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static csclAppointmentAdmin update(
		csclAppointmentAdmin csclAppointmentAdmin) {

		return getPersistence().update(csclAppointmentAdmin);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static csclAppointmentAdmin update(
		csclAppointmentAdmin csclAppointmentAdmin,
		ServiceContext serviceContext) {

		return getPersistence().update(csclAppointmentAdmin, serviceContext);
	}

	/**
	 * Returns all the cscl appointment admins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cscl appointment admins where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByUuid_First(
			String uuid,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByUuid_First(
		String uuid,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByUuid_Last(
			String uuid,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByUuid_Last(
		String uuid,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin[] findByUuid_PrevAndNext(
			long ID, String uuid,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByUuid_PrevAndNext(
			ID, uuid, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment admins where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cscl appointment admins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl appointment admins
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cscl appointment admins where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @return the matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId) {

		return getPersistence().findByappointeeId(appointeeId);
	}

	/**
	 * Returns a range of all the cscl appointment admins where appointeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointeeId the appointee ID
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end) {

		return getPersistence().findByappointeeId(appointeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointeeId the appointee ID
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findByappointeeId(
			appointeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointeeId the appointee ID
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointeeId(
			appointeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointeeId_First(
			long appointeeId,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointeeId_First(
			appointeeId, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointeeId_First(
		long appointeeId,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointeeId_First(
			appointeeId, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointeeId_Last(
			long appointeeId,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointeeId_Last(
			appointeeId, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointeeId_Last(
		long appointeeId,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointeeId_Last(
			appointeeId, orderByComparator);
	}

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin[] findByappointeeId_PrevAndNext(
			long ID, long appointeeId,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointeeId_PrevAndNext(
			ID, appointeeId, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment admins where appointeeId = &#63; from the database.
	 *
	 * @param appointeeId the appointee ID
	 */
	public static void removeByappointeeId(long appointeeId) {
		getPersistence().removeByappointeeId(appointeeId);
	}

	/**
	 * Returns the number of cscl appointment admins where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @return the number of matching cscl appointment admins
	 */
	public static int countByappointeeId(long appointeeId) {
		return getPersistence().countByappointeeId(appointeeId);
	}

	/**
	 * Returns all the cscl appointment admins where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointee(String appointee) {
		return getPersistence().findByappointee(appointee);
	}

	/**
	 * Returns a range of all the cscl appointment admins where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end) {

		return getPersistence().findByappointee(appointee, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findByappointee(
			appointee, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointee(
			appointee, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointee_First(
			String appointee,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointee_First(
			appointee, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointee_First(
		String appointee,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointee_First(
			appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointee_Last(
			String appointee,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointee_Last(
			appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointee_Last(
		String appointee,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointee_Last(
			appointee, orderByComparator);
	}

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin[] findByappointee_PrevAndNext(
			long ID, String appointee,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointee_PrevAndNext(
			ID, appointee, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment admins where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	public static void removeByappointee(String appointee) {
		getPersistence().removeByappointee(appointee);
	}

	/**
	 * Returns the number of cscl appointment admins where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment admins
	 */
	public static int countByappointee(String appointee) {
		return getPersistence().countByappointee(appointee);
	}

	/**
	 * Returns all the cscl appointment admins where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate) {

		return getPersistence().findByappointedDate(appointedDate);
	}

	/**
	 * Returns a range of all the cscl appointment admins where appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end) {

		return getPersistence().findByappointedDate(appointedDate, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findByappointedDate(
			appointedDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointedDate(
			appointedDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointedDate_First(
			String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointedDate_First(
			appointedDate, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointedDate_First(
		String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointedDate_First(
			appointedDate, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointedDate_Last(
			String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointedDate_Last(
			appointedDate, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointedDate_Last(
		String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointedDate_Last(
			appointedDate, orderByComparator);
	}

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin[] findByappointedDate_PrevAndNext(
			long ID, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointedDate_PrevAndNext(
			ID, appointedDate, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment admins where appointedDate = &#63; from the database.
	 *
	 * @param appointedDate the appointed date
	 */
	public static void removeByappointedDate(String appointedDate) {
		getPersistence().removeByappointedDate(appointedDate);
	}

	/**
	 * Returns the number of cscl appointment admins where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	public static int countByappointedDate(String appointedDate) {
		return getPersistence().countByappointedDate(appointedDate);
	}

	/**
	 * Returns all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate) {

		return getPersistence().findByAppointeeIDAndDate(
			appointeeId, appointedDate);
	}

	/**
	 * Returns a range of all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end) {

		return getPersistence().findByAppointeeIDAndDate(
			appointeeId, appointedDate, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findByAppointeeIDAndDate(
			appointeeId, appointedDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAppointeeIDAndDate(
			appointeeId, appointedDate, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByAppointeeIDAndDate_First(
			long appointeeId, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByAppointeeIDAndDate_First(
			appointeeId, appointedDate, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByAppointeeIDAndDate_First(
		long appointeeId, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByAppointeeIDAndDate_First(
			appointeeId, appointedDate, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByAppointeeIDAndDate_Last(
			long appointeeId, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByAppointeeIDAndDate_Last(
			appointeeId, appointedDate, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByAppointeeIDAndDate_Last(
		long appointeeId, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByAppointeeIDAndDate_Last(
			appointeeId, appointedDate, orderByComparator);
	}

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin[] findByAppointeeIDAndDate_PrevAndNext(
			long ID, long appointeeId, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByAppointeeIDAndDate_PrevAndNext(
			ID, appointeeId, appointedDate, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63; from the database.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 */
	public static void removeByAppointeeIDAndDate(
		long appointeeId, String appointedDate) {

		getPersistence().removeByAppointeeIDAndDate(appointeeId, appointedDate);
	}

	/**
	 * Returns the number of cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	public static int countByAppointeeIDAndDate(
		long appointeeId, String appointedDate) {

		return getPersistence().countByAppointeeIDAndDate(
			appointeeId, appointedDate);
	}

	/**
	 * Returns all the cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate) {

		return getPersistence().findByAppointeeAndDate(
			appointee, appointedDate);
	}

	/**
	 * Returns a range of all the cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end) {

		return getPersistence().findByAppointeeAndDate(
			appointee, appointedDate, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findByAppointeeAndDate(
			appointee, appointedDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAppointeeAndDate(
			appointee, appointedDate, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByAppointeeAndDate_First(
			String appointee, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByAppointeeAndDate_First(
			appointee, appointedDate, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByAppointeeAndDate_First(
		String appointee, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByAppointeeAndDate_First(
			appointee, appointedDate, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByAppointeeAndDate_Last(
			String appointee, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByAppointeeAndDate_Last(
			appointee, appointedDate, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByAppointeeAndDate_Last(
		String appointee, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByAppointeeAndDate_Last(
			appointee, appointedDate, orderByComparator);
	}

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin[] findByAppointeeAndDate_PrevAndNext(
			long ID, String appointee, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByAppointeeAndDate_PrevAndNext(
			ID, appointee, appointedDate, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; from the database.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 */
	public static void removeByAppointeeAndDate(
		String appointee, String appointedDate) {

		getPersistence().removeByAppointeeAndDate(appointee, appointedDate);
	}

	/**
	 * Returns the number of cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	public static int countByAppointeeAndDate(
		String appointee, String appointedDate) {

		return getPersistence().countByAppointeeAndDate(
			appointee, appointedDate);
	}

	/**
	 * Returns all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @return the matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot) {

		return getPersistence().findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot);
	}

	/**
	 * Returns a range of all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end) {

		return getPersistence().findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointeeAndSlot_First(
			String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointeeAndSlot_First(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointeeAndSlot_First(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointeeAndSlot_First(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin findByappointeeAndSlot_Last(
			String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointeeAndSlot_Last(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public static csclAppointmentAdmin fetchByappointeeAndSlot_Last(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().fetchByappointeeAndSlot_Last(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, orderByComparator);
	}

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin[] findByappointeeAndSlot_PrevAndNext(
			long ID, String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByappointeeAndSlot_PrevAndNext(
			ID, appointee, appointedDate, FromTime, SecondTimeSlot,
			ThirdTimeSlot, FourthTimeSlot, FifthTimeSlot, SixthTimeSlot,
			SeventhTimeSlot, EighthTimeSlot, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63; from the database.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 */
	public static void removeByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot) {

		getPersistence().removeByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot);
	}

	/**
	 * Returns the number of cscl appointment admins where appointee = &#63; and appointedDate = &#63; and FromTime = &#63; and SecondTimeSlot = &#63; and ThirdTimeSlot = &#63; and FourthTimeSlot = &#63; and FifthTimeSlot = &#63; and SixthTimeSlot = &#63; and SeventhTimeSlot = &#63; and EighthTimeSlot = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param FromTime the from time
	 * @param SecondTimeSlot the second time slot
	 * @param ThirdTimeSlot the third time slot
	 * @param FourthTimeSlot the fourth time slot
	 * @param FifthTimeSlot the fifth time slot
	 * @param SixthTimeSlot the sixth time slot
	 * @param SeventhTimeSlot the seventh time slot
	 * @param EighthTimeSlot the eighth time slot
	 * @return the number of matching cscl appointment admins
	 */
	public static int countByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot) {

		return getPersistence().countByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot);
	}

	/**
	 * Caches the cscl appointment admin in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 */
	public static void cacheResult(csclAppointmentAdmin csclAppointmentAdmin) {
		getPersistence().cacheResult(csclAppointmentAdmin);
	}

	/**
	 * Caches the cscl appointment admins in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentAdmins the cscl appointment admins
	 */
	public static void cacheResult(
		List<csclAppointmentAdmin> csclAppointmentAdmins) {

		getPersistence().cacheResult(csclAppointmentAdmins);
	}

	/**
	 * Creates a new cscl appointment admin with the primary key. Does not add the cscl appointment admin to the database.
	 *
	 * @param ID the primary key for the new cscl appointment admin
	 * @return the new cscl appointment admin
	 */
	public static csclAppointmentAdmin create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	 * Removes the cscl appointment admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin remove(long ID)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().remove(ID);
	}

	public static csclAppointmentAdmin updateImpl(
		csclAppointmentAdmin csclAppointmentAdmin) {

		return getPersistence().updateImpl(csclAppointmentAdmin);
	}

	/**
	 * Returns the cscl appointment admin with the primary key or throws a <code>NoSuchcsclAppointmentAdminException</code> if it could not be found.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin findByPrimaryKey(long ID)
		throws cscl.appointment.admin.table.exception.
			NoSuchcsclAppointmentAdminException {

		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	 * Returns the cscl appointment admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin, or <code>null</code> if a cscl appointment admin with the primary key could not be found
	 */
	public static csclAppointmentAdmin fetchByPrimaryKey(long ID) {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	 * Returns all the cscl appointment admins.
	 *
	 * @return the cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl appointment admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @return the range of cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findAll(
		int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>csclAppointmentAdminModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment admins
	 * @param end the upper bound of the range of cscl appointment admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl appointment admins
	 */
	public static List<csclAppointmentAdmin> findAll(
		int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cscl appointment admins from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl appointment admins.
	 *
	 * @return the number of cscl appointment admins
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static csclAppointmentAdminPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<csclAppointmentAdminPersistence, csclAppointmentAdminPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			csclAppointmentAdminPersistence.class);

		ServiceTracker
			<csclAppointmentAdminPersistence, csclAppointmentAdminPersistence>
				serviceTracker =
					new ServiceTracker
						<csclAppointmentAdminPersistence,
						 csclAppointmentAdminPersistence>(
							 bundle.getBundleContext(),
							 csclAppointmentAdminPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}