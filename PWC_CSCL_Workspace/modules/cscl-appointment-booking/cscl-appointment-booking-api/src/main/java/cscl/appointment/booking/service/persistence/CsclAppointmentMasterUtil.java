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

package cscl.appointment.booking.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.model.CsclAppointmentMaster;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl appointment master service. This utility wraps <code>cscl.appointment.booking.service.persistence.impl.CsclAppointmentMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclAppointmentMasterPersistence
 * @generated
 */
public class CsclAppointmentMasterUtil {

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
	public static void clearCache(CsclAppointmentMaster csclAppointmentMaster) {
		getPersistence().clearCache(csclAppointmentMaster);
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
	public static Map<Serializable, CsclAppointmentMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclAppointmentMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclAppointmentMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclAppointmentMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclAppointmentMaster update(
		CsclAppointmentMaster csclAppointmentMaster) {

		return getPersistence().update(csclAppointmentMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclAppointmentMaster update(
		CsclAppointmentMaster csclAppointmentMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(csclAppointmentMaster, serviceContext);
	}

	/**
	 * Returns all the cscl appointment masters where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @return the matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByid_(long id_) {
		return getPersistence().findByid_(id_);
	}

	/**
	 * Returns a range of all the cscl appointment masters where id_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param id_ the id_
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByid_(
		long id_, int start, int end) {

		return getPersistence().findByid_(id_, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where id_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param id_ the id_
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByid_(
		long id_, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findByid_(id_, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where id_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param id_ the id_
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByid_(
		long id_, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByid_(
			id_, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByid__First(
			long id_,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByid__First(id_, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByid__First(
		long id_, OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByid__First(id_, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByid__Last(
			long id_,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByid__Last(id_, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByid__Last(
		long id_, OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByid__Last(id_, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment masters where id_ = &#63; from the database.
	 *
	 * @param id_ the id_
	 */
	public static void removeByid_(long id_) {
		getPersistence().removeByid_(id_);
	}

	/**
	 * Returns the number of cscl appointment masters where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @return the number of matching cscl appointment masters
	 */
	public static int countByid_(long id_) {
		return getPersistence().countByid_(id_);
	}

	/**
	 * Returns all the cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByapprover(long approver) {
		return getPersistence().findByapprover(approver);
	}

	/**
	 * Returns a range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end) {

		return getPersistence().findByapprover(approver, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findByapprover(
			approver, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByapprover(
			approver, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByapprover_First(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByapprover_First(
			approver, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByapprover_First(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByapprover_First(
			approver, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByapprover_Last(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByapprover_Last(
			approver, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByapprover_Last(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByapprover_Last(
			approver, orderByComparator);
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster[] findByapprover_PrevAndNext(
			long id_, long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByapprover_PrevAndNext(
			id_, approver, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment masters where approver = &#63; from the database.
	 *
	 * @param approver the approver
	 */
	public static void removeByapprover(long approver) {
		getPersistence().removeByapprover(approver);
	}

	/**
	 * Returns the number of cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the number of matching cscl appointment masters
	 */
	public static int countByapprover(long approver) {
		return getPersistence().countByapprover(approver);
	}

	/**
	 * Returns all the cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointee(int appointee) {
		return getPersistence().findByappointee(appointee);
	}

	/**
	 * Returns a range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end) {

		return getPersistence().findByappointee(appointee, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findByappointee(
			appointee, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointee(
			appointee, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByappointee_First(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointee_First(
			appointee, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByappointee_First(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByappointee_First(
			appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByappointee_Last(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointee_Last(
			appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByappointee_Last(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByappointee_Last(
			appointee, orderByComparator);
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster[] findByappointee_PrevAndNext(
			long id_, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointee_PrevAndNext(
			id_, appointee, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment masters where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	public static void removeByappointee(int appointee) {
		getPersistence().removeByappointee(appointee);
	}

	/**
	 * Returns the number of cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	public static int countByappointee(int appointee) {
		return getPersistence().countByappointee(appointee);
	}

	/**
	 * Returns all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee) {

		return getPersistence().findByappointeeAndStatus(status, appointee);
	}

	/**
	 * Returns a range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end) {

		return getPersistence().findByappointeeAndStatus(
			status, appointee, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findByappointeeAndStatus(
			status, appointee, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointeeAndStatus(
			status, appointee, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByappointeeAndStatus_First(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointeeAndStatus_First(
			status, appointee, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByappointeeAndStatus_First(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByappointeeAndStatus_First(
			status, appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByappointeeAndStatus_Last(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointeeAndStatus_Last(
			status, appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByappointeeAndStatus_Last(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByappointeeAndStatus_Last(
			status, appointee, orderByComparator);
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster[] findByappointeeAndStatus_PrevAndNext(
			long id_, int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointeeAndStatus_PrevAndNext(
			id_, status, appointee, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment masters where status = &#63; and appointee = &#63; from the database.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 */
	public static void removeByappointeeAndStatus(int status, int appointee) {
		getPersistence().removeByappointeeAndStatus(status, appointee);
	}

	/**
	 * Returns the number of cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	public static int countByappointeeAndStatus(int status, int appointee) {
		return getPersistence().countByappointeeAndStatus(status, appointee);
	}

	/**
	 * Returns all the cscl appointment masters where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @return the matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime) {

		return getPersistence().findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime);
	}

	/**
	 * Returns a range of all the cscl appointment masters where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime, int start, int end) {

		return getPersistence().findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByappointeeAndDateAndSlot_First(
			String name, String email, int appointee, Date preferedDate,
			String preferedTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointeeAndDateAndSlot_First(
			name, email, appointee, preferedDate, preferedTime,
			orderByComparator);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByappointeeAndDateAndSlot_First(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByappointeeAndDateAndSlot_First(
			name, email, appointee, preferedDate, preferedTime,
			orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByappointeeAndDateAndSlot_Last(
			String name, String email, int appointee, Date preferedDate,
			String preferedTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointeeAndDateAndSlot_Last(
			name, email, appointee, preferedDate, preferedTime,
			orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByappointeeAndDateAndSlot_Last(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByappointeeAndDateAndSlot_Last(
			name, email, appointee, preferedDate, preferedTime,
			orderByComparator);
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster[]
			findByappointeeAndDateAndSlot_PrevAndNext(
				long id_, String name, String email, int appointee,
				Date preferedDate, String preferedTime,
				OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByappointeeAndDateAndSlot_PrevAndNext(
			id_, name, email, appointee, preferedDate, preferedTime,
			orderByComparator);
	}

	/**
	 * Removes all the cscl appointment masters where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63; from the database.
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 */
	public static void removeByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime) {

		getPersistence().removeByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime);
	}

	/**
	 * Returns the number of cscl appointment masters where name = &#63; and email = &#63; and appointee = &#63; and preferedDate = &#63; and preferedTime = &#63;.
	 *
	 * @param name the name
	 * @param email the email
	 * @param appointee the appointee
	 * @param preferedDate the prefered date
	 * @param preferedTime the prefered time
	 * @return the number of matching cscl appointment masters
	 */
	public static int countByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime) {

		return getPersistence().countByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime);
	}

	/**
	 * Returns all the cscl appointment masters where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @return the matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime) {

		return getPersistence().findByTimeSlot(FromTime, ToTime);
	}

	/**
	 * Returns a range of all the cscl appointment masters where FromTime = &#63; and ToTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime, int start, int end) {

		return getPersistence().findByTimeSlot(FromTime, ToTime, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where FromTime = &#63; and ToTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findByTimeSlot(
			FromTime, ToTime, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where FromTime = &#63; and ToTime = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTimeSlot(
			FromTime, ToTime, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByTimeSlot_First(
			String FromTime, String ToTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByTimeSlot_First(
			FromTime, ToTime, orderByComparator);
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByTimeSlot_First(
		String FromTime, String ToTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByTimeSlot_First(
			FromTime, ToTime, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster findByTimeSlot_Last(
			String FromTime, String ToTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByTimeSlot_Last(
			FromTime, ToTime, orderByComparator);
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public static CsclAppointmentMaster fetchByTimeSlot_Last(
		String FromTime, String ToTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().fetchByTimeSlot_Last(
			FromTime, ToTime, orderByComparator);
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster[] findByTimeSlot_PrevAndNext(
			long id_, String FromTime, String ToTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByTimeSlot_PrevAndNext(
			id_, FromTime, ToTime, orderByComparator);
	}

	/**
	 * Removes all the cscl appointment masters where FromTime = &#63; and ToTime = &#63; from the database.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 */
	public static void removeByTimeSlot(String FromTime, String ToTime) {
		getPersistence().removeByTimeSlot(FromTime, ToTime);
	}

	/**
	 * Returns the number of cscl appointment masters where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @return the number of matching cscl appointment masters
	 */
	public static int countByTimeSlot(String FromTime, String ToTime) {
		return getPersistence().countByTimeSlot(FromTime, ToTime);
	}

	/**
	 * Caches the cscl appointment master in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 */
	public static void cacheResult(
		CsclAppointmentMaster csclAppointmentMaster) {

		getPersistence().cacheResult(csclAppointmentMaster);
	}

	/**
	 * Caches the cscl appointment masters in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMasters the cscl appointment masters
	 */
	public static void cacheResult(
		List<CsclAppointmentMaster> csclAppointmentMasters) {

		getPersistence().cacheResult(csclAppointmentMasters);
	}

	/**
	 * Creates a new cscl appointment master with the primary key. Does not add the cscl appointment master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment master
	 * @return the new cscl appointment master
	 */
	public static CsclAppointmentMaster create(long id_) {
		return getPersistence().create(id_);
	}

	/**
	 * Removes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster remove(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().remove(id_);
	}

	public static CsclAppointmentMaster updateImpl(
		CsclAppointmentMaster csclAppointmentMaster) {

		return getPersistence().updateImpl(csclAppointmentMaster);
	}

	/**
	 * Returns the cscl appointment master with the primary key or throws a <code>NoSuchCsclAppointmentMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster findByPrimaryKey(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAppointmentMasterException {

		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl appointment master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master, or <code>null</code> if a cscl appointment master with the primary key could not be found
	 */
	public static CsclAppointmentMaster fetchByPrimaryKey(long id_) {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	 * Returns all the cscl appointment masters.
	 *
	 * @return the cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl appointment masters
	 */
	public static List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cscl appointment masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl appointment masters.
	 *
	 * @return the number of cscl appointment masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclAppointmentMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclAppointmentMasterPersistence, CsclAppointmentMasterPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclAppointmentMasterPersistence.class);

		ServiceTracker
			<CsclAppointmentMasterPersistence, CsclAppointmentMasterPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclAppointmentMasterPersistence,
						 CsclAppointmentMasterPersistence>(
							 bundle.getBundleContext(),
							 CsclAppointmentMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}