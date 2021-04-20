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

import cscl.appointment.booking.model.CsclAdminTimeSlots;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl admin time slots service. This utility wraps <code>cscl.appointment.booking.service.persistence.impl.CsclAdminTimeSlotsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclAdminTimeSlotsPersistence
 * @generated
 */
public class CsclAdminTimeSlotsUtil {

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
	public static void clearCache(CsclAdminTimeSlots csclAdminTimeSlots) {
		getPersistence().clearCache(csclAdminTimeSlots);
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
	public static Map<Serializable, CsclAdminTimeSlots> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclAdminTimeSlots> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclAdminTimeSlots> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclAdminTimeSlots> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclAdminTimeSlots> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclAdminTimeSlots update(
		CsclAdminTimeSlots csclAdminTimeSlots) {

		return getPersistence().update(csclAdminTimeSlots);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclAdminTimeSlots update(
		CsclAdminTimeSlots csclAdminTimeSlots, ServiceContext serviceContext) {

		return getPersistence().update(csclAdminTimeSlots, serviceContext);
	}

	/**
	 * Caches the cscl admin time slots in the entity cache if it is enabled.
	 *
	 * @param csclAdminTimeSlots the cscl admin time slots
	 */
	public static void cacheResult(CsclAdminTimeSlots csclAdminTimeSlots) {
		getPersistence().cacheResult(csclAdminTimeSlots);
	}

	/**
	 * Caches the cscl admin time slotses in the entity cache if it is enabled.
	 *
	 * @param csclAdminTimeSlotses the cscl admin time slotses
	 */
	public static void cacheResult(
		List<CsclAdminTimeSlots> csclAdminTimeSlotses) {

		getPersistence().cacheResult(csclAdminTimeSlotses);
	}

	/**
	 * Creates a new cscl admin time slots with the primary key. Does not add the cscl admin time slots to the database.
	 *
	 * @param id_ the primary key for the new cscl admin time slots
	 * @return the new cscl admin time slots
	 */
	public static CsclAdminTimeSlots create(long id_) {
		return getPersistence().create(id_);
	}

	/**
	 * Removes the cscl admin time slots with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots that was removed
	 * @throws NoSuchCsclAdminTimeSlotsException if a cscl admin time slots with the primary key could not be found
	 */
	public static CsclAdminTimeSlots remove(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAdminTimeSlotsException {

		return getPersistence().remove(id_);
	}

	public static CsclAdminTimeSlots updateImpl(
		CsclAdminTimeSlots csclAdminTimeSlots) {

		return getPersistence().updateImpl(csclAdminTimeSlots);
	}

	/**
	 * Returns the cscl admin time slots with the primary key or throws a <code>NoSuchCsclAdminTimeSlotsException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots
	 * @throws NoSuchCsclAdminTimeSlotsException if a cscl admin time slots with the primary key could not be found
	 */
	public static CsclAdminTimeSlots findByPrimaryKey(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclAdminTimeSlotsException {

		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl admin time slots with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots, or <code>null</code> if a cscl admin time slots with the primary key could not be found
	 */
	public static CsclAdminTimeSlots fetchByPrimaryKey(long id_) {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	 * Returns all the cscl admin time slotses.
	 *
	 * @return the cscl admin time slotses
	 */
	public static List<CsclAdminTimeSlots> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl admin time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAdminTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl admin time slotses
	 * @param end the upper bound of the range of cscl admin time slotses (not inclusive)
	 * @return the range of cscl admin time slotses
	 */
	public static List<CsclAdminTimeSlots> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl admin time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAdminTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl admin time slotses
	 * @param end the upper bound of the range of cscl admin time slotses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl admin time slotses
	 */
	public static List<CsclAdminTimeSlots> findAll(
		int start, int end,
		OrderByComparator<CsclAdminTimeSlots> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl admin time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAdminTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl admin time slotses
	 * @param end the upper bound of the range of cscl admin time slotses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl admin time slotses
	 */
	public static List<CsclAdminTimeSlots> findAll(
		int start, int end,
		OrderByComparator<CsclAdminTimeSlots> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cscl admin time slotses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl admin time slotses.
	 *
	 * @return the number of cscl admin time slotses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclAdminTimeSlotsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclAdminTimeSlotsPersistence, CsclAdminTimeSlotsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclAdminTimeSlotsPersistence.class);

		ServiceTracker
			<CsclAdminTimeSlotsPersistence, CsclAdminTimeSlotsPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclAdminTimeSlotsPersistence,
						 CsclAdminTimeSlotsPersistence>(
							 bundle.getBundleContext(),
							 CsclAdminTimeSlotsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}