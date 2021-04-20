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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cscl.appointment.admin.table.exception.NoSuchcsclAppointmentAdminException;
import cscl.appointment.admin.table.model.csclAppointmentAdmin;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl appointment admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see csclAppointmentAdminUtil
 * @generated
 */
@ProviderType
public interface csclAppointmentAdminPersistence
	extends BasePersistence<csclAppointmentAdmin> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link csclAppointmentAdminUtil} to access the cscl appointment admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl appointment admins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl appointment admins
	 */
	public java.util.List<csclAppointmentAdmin> findByUuid(String uuid);

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
	public java.util.List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the first cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the last cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the last cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public csclAppointmentAdmin[] findByUuid_PrevAndNext(
			long ID, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Removes all the cscl appointment admins where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cscl appointment admins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl appointment admins
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the cscl appointment admins where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @return the matching cscl appointment admins
	 */
	public java.util.List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId);

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
	public java.util.List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByappointeeId_First(
			long appointeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByappointeeId_First(
		long appointeeId,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByappointeeId_Last(
			long appointeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByappointeeId_Last(
		long appointeeId,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public csclAppointmentAdmin[] findByappointeeId_PrevAndNext(
			long ID, long appointeeId,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Removes all the cscl appointment admins where appointeeId = &#63; from the database.
	 *
	 * @param appointeeId the appointee ID
	 */
	public void removeByappointeeId(long appointeeId);

	/**
	 * Returns the number of cscl appointment admins where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @return the number of matching cscl appointment admins
	 */
	public int countByappointeeId(long appointeeId);

	/**
	 * Returns all the cscl appointment admins where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl appointment admins
	 */
	public java.util.List<csclAppointmentAdmin> findByappointee(
		String appointee);

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
	public java.util.List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByappointee_First(
			String appointee,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByappointee_First(
		String appointee,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByappointee_Last(
			String appointee,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByappointee_Last(
		String appointee,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public csclAppointmentAdmin[] findByappointee_PrevAndNext(
			long ID, String appointee,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Removes all the cscl appointment admins where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	public void removeByappointee(String appointee);

	/**
	 * Returns the number of cscl appointment admins where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment admins
	 */
	public int countByappointee(String appointee);

	/**
	 * Returns all the cscl appointment admins where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	public java.util.List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate);

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
	public java.util.List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByappointedDate_First(
			String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByappointedDate_First(
		String appointedDate,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByappointedDate_Last(
			String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByappointedDate_Last(
		String appointedDate,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the cscl appointment admins before and after the current cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param ID the primary key of the current cscl appointment admin
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public csclAppointmentAdmin[] findByappointedDate_PrevAndNext(
			long ID, String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Removes all the cscl appointment admins where appointedDate = &#63; from the database.
	 *
	 * @param appointedDate the appointed date
	 */
	public void removeByappointedDate(String appointedDate);

	/**
	 * Returns the number of cscl appointment admins where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	public int countByappointedDate(String appointedDate);

	/**
	 * Returns all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	public java.util.List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate);

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
	public java.util.List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByAppointeeIDAndDate_First(
			long appointeeId, String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByAppointeeIDAndDate_First(
		long appointeeId, String appointedDate,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByAppointeeIDAndDate_Last(
			long appointeeId, String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByAppointeeIDAndDate_Last(
		long appointeeId, String appointedDate,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public csclAppointmentAdmin[] findByAppointeeIDAndDate_PrevAndNext(
			long ID, long appointeeId, String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Removes all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63; from the database.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 */
	public void removeByAppointeeIDAndDate(
		long appointeeId, String appointedDate);

	/**
	 * Returns the number of cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	public int countByAppointeeIDAndDate(
		long appointeeId, String appointedDate);

	/**
	 * Returns all the cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	public java.util.List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate);

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
	public java.util.List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByAppointeeAndDate_First(
			String appointee, String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByAppointeeAndDate_First(
		String appointee, String appointedDate,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin findByAppointeeAndDate_Last(
			String appointee, String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	public csclAppointmentAdmin fetchByAppointeeAndDate_Last(
		String appointee, String appointedDate,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public csclAppointmentAdmin[] findByAppointeeAndDate_PrevAndNext(
			long ID, String appointee, String appointedDate,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Removes all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; from the database.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 */
	public void removeByAppointeeAndDate(
		String appointee, String appointedDate);

	/**
	 * Returns the number of cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	public int countByAppointeeAndDate(String appointee, String appointedDate);

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
	public java.util.List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot);

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
	public java.util.List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

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
	public csclAppointmentAdmin findByappointeeAndSlot_First(
			String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

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
	public csclAppointmentAdmin fetchByappointeeAndSlot_First(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public csclAppointmentAdmin findByappointeeAndSlot_Last(
			String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

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
	public csclAppointmentAdmin fetchByappointeeAndSlot_Last(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public csclAppointmentAdmin[] findByappointeeAndSlot_PrevAndNext(
			long ID, String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			com.liferay.portal.kernel.util.OrderByComparator
				<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException;

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
	public void removeByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot);

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
	public int countByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot);

	/**
	 * Caches the cscl appointment admin in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 */
	public void cacheResult(csclAppointmentAdmin csclAppointmentAdmin);

	/**
	 * Caches the cscl appointment admins in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentAdmins the cscl appointment admins
	 */
	public void cacheResult(
		java.util.List<csclAppointmentAdmin> csclAppointmentAdmins);

	/**
	 * Creates a new cscl appointment admin with the primary key. Does not add the cscl appointment admin to the database.
	 *
	 * @param ID the primary key for the new cscl appointment admin
	 * @return the new cscl appointment admin
	 */
	public csclAppointmentAdmin create(long ID);

	/**
	 * Removes the cscl appointment admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public csclAppointmentAdmin remove(long ID)
		throws NoSuchcsclAppointmentAdminException;

	public csclAppointmentAdmin updateImpl(
		csclAppointmentAdmin csclAppointmentAdmin);

	/**
	 * Returns the cscl appointment admin with the primary key or throws a <code>NoSuchcsclAppointmentAdminException</code> if it could not be found.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	public csclAppointmentAdmin findByPrimaryKey(long ID)
		throws NoSuchcsclAppointmentAdminException;

	/**
	 * Returns the cscl appointment admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin, or <code>null</code> if a cscl appointment admin with the primary key could not be found
	 */
	public csclAppointmentAdmin fetchByPrimaryKey(long ID);

	/**
	 * Returns all the cscl appointment admins.
	 *
	 * @return the cscl appointment admins
	 */
	public java.util.List<csclAppointmentAdmin> findAll();

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
	public java.util.List<csclAppointmentAdmin> findAll(int start, int end);

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
	public java.util.List<csclAppointmentAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator);

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
	public java.util.List<csclAppointmentAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<csclAppointmentAdmin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cscl appointment admins from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl appointment admins.
	 *
	 * @return the number of cscl appointment admins
	 */
	public int countAll();

}