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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cscl.appointment.booking.exception.NoSuchCsclAdminTimeSlotsException;
import cscl.appointment.booking.model.CsclAdminTimeSlots;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl admin time slots service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclAdminTimeSlotsUtil
 * @generated
 */
@ProviderType
public interface CsclAdminTimeSlotsPersistence
	extends BasePersistence<CsclAdminTimeSlots> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclAdminTimeSlotsUtil} to access the cscl admin time slots persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the cscl admin time slots in the entity cache if it is enabled.
	 *
	 * @param csclAdminTimeSlots the cscl admin time slots
	 */
	public void cacheResult(CsclAdminTimeSlots csclAdminTimeSlots);

	/**
	 * Caches the cscl admin time slotses in the entity cache if it is enabled.
	 *
	 * @param csclAdminTimeSlotses the cscl admin time slotses
	 */
	public void cacheResult(
		java.util.List<CsclAdminTimeSlots> csclAdminTimeSlotses);

	/**
	 * Creates a new cscl admin time slots with the primary key. Does not add the cscl admin time slots to the database.
	 *
	 * @param id_ the primary key for the new cscl admin time slots
	 * @return the new cscl admin time slots
	 */
	public CsclAdminTimeSlots create(long id_);

	/**
	 * Removes the cscl admin time slots with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots that was removed
	 * @throws NoSuchCsclAdminTimeSlotsException if a cscl admin time slots with the primary key could not be found
	 */
	public CsclAdminTimeSlots remove(long id_)
		throws NoSuchCsclAdminTimeSlotsException;

	public CsclAdminTimeSlots updateImpl(CsclAdminTimeSlots csclAdminTimeSlots);

	/**
	 * Returns the cscl admin time slots with the primary key or throws a <code>NoSuchCsclAdminTimeSlotsException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots
	 * @throws NoSuchCsclAdminTimeSlotsException if a cscl admin time slots with the primary key could not be found
	 */
	public CsclAdminTimeSlots findByPrimaryKey(long id_)
		throws NoSuchCsclAdminTimeSlotsException;

	/**
	 * Returns the cscl admin time slots with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl admin time slots
	 * @return the cscl admin time slots, or <code>null</code> if a cscl admin time slots with the primary key could not be found
	 */
	public CsclAdminTimeSlots fetchByPrimaryKey(long id_);

	/**
	 * Returns all the cscl admin time slotses.
	 *
	 * @return the cscl admin time slotses
	 */
	public java.util.List<CsclAdminTimeSlots> findAll();

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
	public java.util.List<CsclAdminTimeSlots> findAll(int start, int end);

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
	public java.util.List<CsclAdminTimeSlots> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CsclAdminTimeSlots>
			orderByComparator);

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
	public java.util.List<CsclAdminTimeSlots> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CsclAdminTimeSlots>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cscl admin time slotses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl admin time slotses.
	 *
	 * @return the number of cscl admin time slotses
	 */
	public int countAll();

}