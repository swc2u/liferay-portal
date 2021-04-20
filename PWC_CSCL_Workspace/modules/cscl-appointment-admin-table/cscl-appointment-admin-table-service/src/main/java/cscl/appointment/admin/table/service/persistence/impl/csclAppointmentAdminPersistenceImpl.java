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

package cscl.appointment.admin.table.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import cscl.appointment.admin.table.exception.NoSuchcsclAppointmentAdminException;
import cscl.appointment.admin.table.model.csclAppointmentAdmin;
import cscl.appointment.admin.table.model.impl.csclAppointmentAdminImpl;
import cscl.appointment.admin.table.model.impl.csclAppointmentAdminModelImpl;
import cscl.appointment.admin.table.service.persistence.csclAppointmentAdminPersistence;
import cscl.appointment.admin.table.service.persistence.impl.constants.csclAppointmentAdminPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl appointment admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = csclAppointmentAdminPersistence.class)
public class csclAppointmentAdminPersistenceImpl
	extends BasePersistenceImpl<csclAppointmentAdmin>
	implements csclAppointmentAdminPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>csclAppointmentAdminUtil</code> to access the cscl appointment admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		csclAppointmentAdminImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the cscl appointment admins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (csclAppointmentAdmin csclAppointmentAdmin : list) {
					if (!uuid.equals(csclAppointmentAdmin.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByUuid_First(
			String uuid,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByUuid_First(
			uuid, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByUuid_First(
		String uuid,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		List<csclAppointmentAdmin> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByUuid_Last(
			String uuid,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByUuid_Last(
			uuid, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByUuid_Last(
		String uuid,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<csclAppointmentAdmin> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin[] findByUuid_PrevAndNext(
			long ID, String uuid,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		uuid = Objects.toString(uuid, "");

		csclAppointmentAdmin csclAppointmentAdmin = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin[] array = new csclAppointmentAdminImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, csclAppointmentAdmin, uuid, orderByComparator, true);

			array[1] = csclAppointmentAdmin;

			array[2] = getByUuid_PrevAndNext(
				session, csclAppointmentAdmin, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected csclAppointmentAdmin getByUuid_PrevAndNext(
		Session session, csclAppointmentAdmin csclAppointmentAdmin, String uuid,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentAdmin)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<csclAppointmentAdmin> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment admins where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (csclAppointmentAdmin csclAppointmentAdmin :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentAdmin);
		}
	}

	/**
	 * Returns the number of cscl appointment admins where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl appointment admins
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"csclAppointmentAdmin.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(csclAppointmentAdmin.uuid IS NULL OR csclAppointmentAdmin.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByappointeeId;
	private FinderPath _finderPathWithoutPaginationFindByappointeeId;
	private FinderPath _finderPathCountByappointeeId;

	/**
	 * Returns all the cscl appointment admins where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @return the matching cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> findByappointeeId(long appointeeId) {
		return findByappointeeId(
			appointeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end) {

		return findByappointeeId(appointeeId, start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findByappointeeId(
			appointeeId, start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findByappointeeId(
		long appointeeId, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByappointeeId;
				finderArgs = new Object[] {appointeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByappointeeId;
			finderArgs = new Object[] {
				appointeeId, start, end, orderByComparator
			};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (csclAppointmentAdmin csclAppointmentAdmin : list) {
					if (appointeeId != csclAppointmentAdmin.getAppointeeId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEEID_APPOINTEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appointeeId);

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByappointeeId_First(
			long appointeeId,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByappointeeId_First(
			appointeeId, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointeeId=");
		sb.append(appointeeId);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByappointeeId_First(
		long appointeeId,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		List<csclAppointmentAdmin> list = findByappointeeId(
			appointeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByappointeeId_Last(
			long appointeeId,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByappointeeId_Last(
			appointeeId, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointeeId=");
		sb.append(appointeeId);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByappointeeId_Last(
		long appointeeId,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		int count = countByappointeeId(appointeeId);

		if (count == 0) {
			return null;
		}

		List<csclAppointmentAdmin> list = findByappointeeId(
			appointeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin[] findByappointeeId_PrevAndNext(
			long ID, long appointeeId,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin[] array = new csclAppointmentAdminImpl[3];

			array[0] = getByappointeeId_PrevAndNext(
				session, csclAppointmentAdmin, appointeeId, orderByComparator,
				true);

			array[1] = csclAppointmentAdmin;

			array[2] = getByappointeeId_PrevAndNext(
				session, csclAppointmentAdmin, appointeeId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected csclAppointmentAdmin getByappointeeId_PrevAndNext(
		Session session, csclAppointmentAdmin csclAppointmentAdmin,
		long appointeeId,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

		sb.append(_FINDER_COLUMN_APPOINTEEID_APPOINTEEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(appointeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentAdmin)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<csclAppointmentAdmin> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment admins where appointeeId = &#63; from the database.
	 *
	 * @param appointeeId the appointee ID
	 */
	@Override
	public void removeByappointeeId(long appointeeId) {
		for (csclAppointmentAdmin csclAppointmentAdmin :
				findByappointeeId(
					appointeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentAdmin);
		}
	}

	/**
	 * Returns the number of cscl appointment admins where appointeeId = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @return the number of matching cscl appointment admins
	 */
	@Override
	public int countByappointeeId(long appointeeId) {
		FinderPath finderPath = _finderPathCountByappointeeId;

		Object[] finderArgs = new Object[] {appointeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEEID_APPOINTEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appointeeId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPOINTEEID_APPOINTEEID_2 =
		"csclAppointmentAdmin.appointeeId = ?";

	private FinderPath _finderPathWithPaginationFindByappointee;
	private FinderPath _finderPathWithoutPaginationFindByappointee;
	private FinderPath _finderPathCountByappointee;

	/**
	 * Returns all the cscl appointment admins where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> findByappointee(String appointee) {
		return findByappointee(
			appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end) {

		return findByappointee(appointee, start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findByappointee(appointee, start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findByappointee(
		String appointee, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		appointee = Objects.toString(appointee, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByappointee;
				finderArgs = new Object[] {appointee};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByappointee;
			finderArgs = new Object[] {
				appointee, start, end, orderByComparator
			};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (csclAppointmentAdmin csclAppointmentAdmin : list) {
					if (!appointee.equals(
							csclAppointmentAdmin.getAppointee())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointee = false;

			if (appointee.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_3);
			}
			else {
				bindAppointee = true;

				sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointee) {
					queryPos.add(appointee);
				}

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByappointee_First(
			String appointee,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByappointee_First(
			appointee, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByappointee_First(
		String appointee,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		List<csclAppointmentAdmin> list = findByappointee(
			appointee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByappointee_Last(
			String appointee,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByappointee_Last(
			appointee, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByappointee_Last(
		String appointee,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		int count = countByappointee(appointee);

		if (count == 0) {
			return null;
		}

		List<csclAppointmentAdmin> list = findByappointee(
			appointee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin[] findByappointee_PrevAndNext(
			long ID, String appointee,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		appointee = Objects.toString(appointee, "");

		csclAppointmentAdmin csclAppointmentAdmin = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin[] array = new csclAppointmentAdminImpl[3];

			array[0] = getByappointee_PrevAndNext(
				session, csclAppointmentAdmin, appointee, orderByComparator,
				true);

			array[1] = csclAppointmentAdmin;

			array[2] = getByappointee_PrevAndNext(
				session, csclAppointmentAdmin, appointee, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected csclAppointmentAdmin getByappointee_PrevAndNext(
		Session session, csclAppointmentAdmin csclAppointmentAdmin,
		String appointee,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

		boolean bindAppointee = false;

		if (appointee.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_3);
		}
		else {
			bindAppointee = true;

			sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAppointee) {
			queryPos.add(appointee);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentAdmin)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<csclAppointmentAdmin> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment admins where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	@Override
	public void removeByappointee(String appointee) {
		for (csclAppointmentAdmin csclAppointmentAdmin :
				findByappointee(
					appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentAdmin);
		}
	}

	/**
	 * Returns the number of cscl appointment admins where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment admins
	 */
	@Override
	public int countByappointee(String appointee) {
		appointee = Objects.toString(appointee, "");

		FinderPath finderPath = _finderPathCountByappointee;

		Object[] finderArgs = new Object[] {appointee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointee = false;

			if (appointee.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_3);
			}
			else {
				bindAppointee = true;

				sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointee) {
					queryPos.add(appointee);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPOINTEE_APPOINTEE_2 =
		"csclAppointmentAdmin.appointee = ?";

	private static final String _FINDER_COLUMN_APPOINTEE_APPOINTEE_3 =
		"(csclAppointmentAdmin.appointee IS NULL OR csclAppointmentAdmin.appointee = '')";

	private FinderPath _finderPathWithPaginationFindByappointedDate;
	private FinderPath _finderPathWithoutPaginationFindByappointedDate;
	private FinderPath _finderPathCountByappointedDate;

	/**
	 * Returns all the cscl appointment admins where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate) {

		return findByappointedDate(
			appointedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end) {

		return findByappointedDate(appointedDate, start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findByappointedDate(
			appointedDate, start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findByappointedDate(
		String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		appointedDate = Objects.toString(appointedDate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByappointedDate;
				finderArgs = new Object[] {appointedDate};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByappointedDate;
			finderArgs = new Object[] {
				appointedDate, start, end, orderByComparator
			};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (csclAppointmentAdmin csclAppointmentAdmin : list) {
					if (!appointedDate.equals(
							csclAppointmentAdmin.getAppointedDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByappointedDate_First(
			String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByappointedDate_First(
			appointedDate, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointedDate=");
		sb.append(appointedDate);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByappointedDate_First(
		String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		List<csclAppointmentAdmin> list = findByappointedDate(
			appointedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin findByappointedDate_Last(
			String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByappointedDate_Last(
			appointedDate, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointedDate=");
		sb.append(appointedDate);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByappointedDate_Last(
		String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		int count = countByappointedDate(appointedDate);

		if (count == 0) {
			return null;
		}

		List<csclAppointmentAdmin> list = findByappointedDate(
			appointedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin[] findByappointedDate_PrevAndNext(
			long ID, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		appointedDate = Objects.toString(appointedDate, "");

		csclAppointmentAdmin csclAppointmentAdmin = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin[] array = new csclAppointmentAdminImpl[3];

			array[0] = getByappointedDate_PrevAndNext(
				session, csclAppointmentAdmin, appointedDate, orderByComparator,
				true);

			array[1] = csclAppointmentAdmin;

			array[2] = getByappointedDate_PrevAndNext(
				session, csclAppointmentAdmin, appointedDate, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected csclAppointmentAdmin getByappointedDate_PrevAndNext(
		Session session, csclAppointmentAdmin csclAppointmentAdmin,
		String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

		boolean bindAppointedDate = false;

		if (appointedDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_3);
		}
		else {
			bindAppointedDate = true;

			sb.append(_FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAppointedDate) {
			queryPos.add(appointedDate);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentAdmin)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<csclAppointmentAdmin> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment admins where appointedDate = &#63; from the database.
	 *
	 * @param appointedDate the appointed date
	 */
	@Override
	public void removeByappointedDate(String appointedDate) {
		for (csclAppointmentAdmin csclAppointmentAdmin :
				findByappointedDate(
					appointedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclAppointmentAdmin);
		}
	}

	/**
	 * Returns the number of cscl appointment admins where appointedDate = &#63;.
	 *
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	@Override
	public int countByappointedDate(String appointedDate) {
		appointedDate = Objects.toString(appointedDate, "");

		FinderPath finderPath = _finderPathCountByappointedDate;

		Object[] finderArgs = new Object[] {appointedDate};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_2 =
		"csclAppointmentAdmin.appointedDate = ?";

	private static final String _FINDER_COLUMN_APPOINTEDDATE_APPOINTEDDATE_3 =
		"(csclAppointmentAdmin.appointedDate IS NULL OR csclAppointmentAdmin.appointedDate = '')";

	private FinderPath _finderPathWithPaginationFindByAppointeeIDAndDate;
	private FinderPath _finderPathWithoutPaginationFindByAppointeeIDAndDate;
	private FinderPath _finderPathCountByAppointeeIDAndDate;

	/**
	 * Returns all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate) {

		return findByAppointeeIDAndDate(
			appointeeId, appointedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end) {

		return findByAppointeeIDAndDate(
			appointeeId, appointedDate, start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findByAppointeeIDAndDate(
			appointeeId, appointedDate, start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findByAppointeeIDAndDate(
		long appointeeId, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		appointedDate = Objects.toString(appointedDate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByAppointeeIDAndDate;
				finderArgs = new Object[] {appointeeId, appointedDate};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAppointeeIDAndDate;
			finderArgs = new Object[] {
				appointeeId, appointedDate, start, end, orderByComparator
			};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (csclAppointmentAdmin csclAppointmentAdmin : list) {
					if ((appointeeId !=
							csclAppointmentAdmin.getAppointeeId()) ||
						!appointedDate.equals(
							csclAppointmentAdmin.getAppointedDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEEID_2);

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appointeeId);

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public csclAppointmentAdmin findByAppointeeIDAndDate_First(
			long appointeeId, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin =
			fetchByAppointeeIDAndDate_First(
				appointeeId, appointedDate, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointeeId=");
		sb.append(appointeeId);

		sb.append(", appointedDate=");
		sb.append(appointedDate);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByAppointeeIDAndDate_First(
		long appointeeId, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		List<csclAppointmentAdmin> list = findByAppointeeIDAndDate(
			appointeeId, appointedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin findByAppointeeIDAndDate_Last(
			long appointeeId, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin =
			fetchByAppointeeIDAndDate_Last(
				appointeeId, appointedDate, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointeeId=");
		sb.append(appointeeId);

		sb.append(", appointedDate=");
		sb.append(appointedDate);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByAppointeeIDAndDate_Last(
		long appointeeId, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		int count = countByAppointeeIDAndDate(appointeeId, appointedDate);

		if (count == 0) {
			return null;
		}

		List<csclAppointmentAdmin> list = findByAppointeeIDAndDate(
			appointeeId, appointedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin[] findByAppointeeIDAndDate_PrevAndNext(
			long ID, long appointeeId, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		appointedDate = Objects.toString(appointedDate, "");

		csclAppointmentAdmin csclAppointmentAdmin = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin[] array = new csclAppointmentAdminImpl[3];

			array[0] = getByAppointeeIDAndDate_PrevAndNext(
				session, csclAppointmentAdmin, appointeeId, appointedDate,
				orderByComparator, true);

			array[1] = csclAppointmentAdmin;

			array[2] = getByAppointeeIDAndDate_PrevAndNext(
				session, csclAppointmentAdmin, appointeeId, appointedDate,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected csclAppointmentAdmin getByAppointeeIDAndDate_PrevAndNext(
		Session session, csclAppointmentAdmin csclAppointmentAdmin,
		long appointeeId, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

		sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEEID_2);

		boolean bindAppointedDate = false;

		if (appointedDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_3);
		}
		else {
			bindAppointedDate = true;

			sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(appointeeId);

		if (bindAppointedDate) {
			queryPos.add(appointedDate);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentAdmin)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<csclAppointmentAdmin> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment admins where appointeeId = &#63; and appointedDate = &#63; from the database.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 */
	@Override
	public void removeByAppointeeIDAndDate(
		long appointeeId, String appointedDate) {

		for (csclAppointmentAdmin csclAppointmentAdmin :
				findByAppointeeIDAndDate(
					appointeeId, appointedDate, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentAdmin);
		}
	}

	/**
	 * Returns the number of cscl appointment admins where appointeeId = &#63; and appointedDate = &#63;.
	 *
	 * @param appointeeId the appointee ID
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	@Override
	public int countByAppointeeIDAndDate(
		long appointeeId, String appointedDate) {

		appointedDate = Objects.toString(appointedDate, "");

		FinderPath finderPath = _finderPathCountByAppointeeIDAndDate;

		Object[] finderArgs = new Object[] {appointeeId, appointedDate};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEEID_2);

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appointeeId);

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEEID_2 =
			"csclAppointmentAdmin.appointeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_2 =
			"csclAppointmentAdmin.appointedDate = ?";

	private static final String
		_FINDER_COLUMN_APPOINTEEIDANDDATE_APPOINTEDDATE_3 =
			"(csclAppointmentAdmin.appointedDate IS NULL OR csclAppointmentAdmin.appointedDate = '')";

	private FinderPath _finderPathWithPaginationFindByAppointeeAndDate;
	private FinderPath _finderPathWithoutPaginationFindByAppointeeAndDate;
	private FinderPath _finderPathCountByAppointeeAndDate;

	/**
	 * Returns all the cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @return the matching cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate) {

		return findByAppointeeAndDate(
			appointee, appointedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end) {

		return findByAppointeeAndDate(
			appointee, appointedDate, start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findByAppointeeAndDate(
			appointee, appointedDate, start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findByAppointeeAndDate(
		String appointee, String appointedDate, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		appointee = Objects.toString(appointee, "");
		appointedDate = Objects.toString(appointedDate, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAppointeeAndDate;
				finderArgs = new Object[] {appointee, appointedDate};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAppointeeAndDate;
			finderArgs = new Object[] {
				appointee, appointedDate, start, end, orderByComparator
			};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (csclAppointmentAdmin csclAppointmentAdmin : list) {
					if (!appointee.equals(
							csclAppointmentAdmin.getAppointee()) ||
						!appointedDate.equals(
							csclAppointmentAdmin.getAppointedDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointee = false;

			if (appointee.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_3);
			}
			else {
				bindAppointee = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_2);
			}

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointee) {
					queryPos.add(appointee);
				}

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public csclAppointmentAdmin findByAppointeeAndDate_First(
			String appointee, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin =
			fetchByAppointeeAndDate_First(
				appointee, appointedDate, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append(", appointedDate=");
		sb.append(appointedDate);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByAppointeeAndDate_First(
		String appointee, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		List<csclAppointmentAdmin> list = findByAppointeeAndDate(
			appointee, appointedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin findByAppointeeAndDate_Last(
			String appointee, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin =
			fetchByAppointeeAndDate_Last(
				appointee, appointedDate, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append(", appointedDate=");
		sb.append(appointedDate);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment admin in the ordered set where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment admin, or <code>null</code> if a matching cscl appointment admin could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByAppointeeAndDate_Last(
		String appointee, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		int count = countByAppointeeAndDate(appointee, appointedDate);

		if (count == 0) {
			return null;
		}

		List<csclAppointmentAdmin> list = findByAppointeeAndDate(
			appointee, appointedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin[] findByAppointeeAndDate_PrevAndNext(
			long ID, String appointee, String appointedDate,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		appointee = Objects.toString(appointee, "");
		appointedDate = Objects.toString(appointedDate, "");

		csclAppointmentAdmin csclAppointmentAdmin = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin[] array = new csclAppointmentAdminImpl[3];

			array[0] = getByAppointeeAndDate_PrevAndNext(
				session, csclAppointmentAdmin, appointee, appointedDate,
				orderByComparator, true);

			array[1] = csclAppointmentAdmin;

			array[2] = getByAppointeeAndDate_PrevAndNext(
				session, csclAppointmentAdmin, appointee, appointedDate,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected csclAppointmentAdmin getByAppointeeAndDate_PrevAndNext(
		Session session, csclAppointmentAdmin csclAppointmentAdmin,
		String appointee, String appointedDate,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

		boolean bindAppointee = false;

		if (appointee.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_3);
		}
		else {
			bindAppointee = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_2);
		}

		boolean bindAppointedDate = false;

		if (appointedDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_3);
		}
		else {
			bindAppointedDate = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAppointee) {
			queryPos.add(appointee);
		}

		if (bindAppointedDate) {
			queryPos.add(appointedDate);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentAdmin)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<csclAppointmentAdmin> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment admins where appointee = &#63; and appointedDate = &#63; from the database.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 */
	@Override
	public void removeByAppointeeAndDate(
		String appointee, String appointedDate) {

		for (csclAppointmentAdmin csclAppointmentAdmin :
				findByAppointeeAndDate(
					appointee, appointedDate, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentAdmin);
		}
	}

	/**
	 * Returns the number of cscl appointment admins where appointee = &#63; and appointedDate = &#63;.
	 *
	 * @param appointee the appointee
	 * @param appointedDate the appointed date
	 * @return the number of matching cscl appointment admins
	 */
	@Override
	public int countByAppointeeAndDate(String appointee, String appointedDate) {
		appointee = Objects.toString(appointee, "");
		appointedDate = Objects.toString(appointedDate, "");

		FinderPath finderPath = _finderPathCountByAppointeeAndDate;

		Object[] finderArgs = new Object[] {appointee, appointedDate};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointee = false;

			if (appointee.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_3);
			}
			else {
				bindAppointee = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_2);
			}

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointee) {
					queryPos.add(appointee);
				}

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_2 =
		"csclAppointmentAdmin.appointee = ? AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEE_3 =
		"(csclAppointmentAdmin.appointee IS NULL OR csclAppointmentAdmin.appointee = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_2 =
			"csclAppointmentAdmin.appointedDate = ?";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDDATE_APPOINTEDDATE_3 =
			"(csclAppointmentAdmin.appointedDate IS NULL OR csclAppointmentAdmin.appointedDate = '')";

	private FinderPath _finderPathWithPaginationFindByappointeeAndSlot;
	private FinderPath _finderPathWithoutPaginationFindByappointeeAndSlot;
	private FinderPath _finderPathCountByappointeeAndSlot;

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
	@Override
	public List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot) {

		return findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end) {

		return findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot, int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		appointee = Objects.toString(appointee, "");
		appointedDate = Objects.toString(appointedDate, "");
		FromTime = Objects.toString(FromTime, "");
		SecondTimeSlot = Objects.toString(SecondTimeSlot, "");
		ThirdTimeSlot = Objects.toString(ThirdTimeSlot, "");
		FourthTimeSlot = Objects.toString(FourthTimeSlot, "");
		FifthTimeSlot = Objects.toString(FifthTimeSlot, "");
		SixthTimeSlot = Objects.toString(SixthTimeSlot, "");
		SeventhTimeSlot = Objects.toString(SeventhTimeSlot, "");
		EighthTimeSlot = Objects.toString(EighthTimeSlot, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByappointeeAndSlot;
				finderArgs = new Object[] {
					appointee, appointedDate, FromTime, SecondTimeSlot,
					ThirdTimeSlot, FourthTimeSlot, FifthTimeSlot, SixthTimeSlot,
					SeventhTimeSlot, EighthTimeSlot
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByappointeeAndSlot;
			finderArgs = new Object[] {
				appointee, appointedDate, FromTime, SecondTimeSlot,
				ThirdTimeSlot, FourthTimeSlot, FifthTimeSlot, SixthTimeSlot,
				SeventhTimeSlot, EighthTimeSlot, start, end, orderByComparator
			};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (csclAppointmentAdmin csclAppointmentAdmin : list) {
					if (!appointee.equals(
							csclAppointmentAdmin.getAppointee()) ||
						!appointedDate.equals(
							csclAppointmentAdmin.getAppointedDate()) ||
						!FromTime.equals(csclAppointmentAdmin.getFromTime()) ||
						!SecondTimeSlot.equals(
							csclAppointmentAdmin.getSecondTimeSlot()) ||
						!ThirdTimeSlot.equals(
							csclAppointmentAdmin.getThirdTimeSlot()) ||
						!FourthTimeSlot.equals(
							csclAppointmentAdmin.getFourthTimeSlot()) ||
						!FifthTimeSlot.equals(
							csclAppointmentAdmin.getFifthTimeSlot()) ||
						!SixthTimeSlot.equals(
							csclAppointmentAdmin.getSixthTimeSlot()) ||
						!SeventhTimeSlot.equals(
							csclAppointmentAdmin.getSeventhTimeSlot()) ||
						!EighthTimeSlot.equals(
							csclAppointmentAdmin.getEighthTimeSlot())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					12 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(12);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointee = false;

			if (appointee.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_3);
			}
			else {
				bindAppointee = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_2);
			}

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_2);
			}

			boolean bindFromTime = false;

			if (FromTime.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_3);
			}
			else {
				bindFromTime = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_2);
			}

			boolean bindSecondTimeSlot = false;

			if (SecondTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_3);
			}
			else {
				bindSecondTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_2);
			}

			boolean bindThirdTimeSlot = false;

			if (ThirdTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_3);
			}
			else {
				bindThirdTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_2);
			}

			boolean bindFourthTimeSlot = false;

			if (FourthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_3);
			}
			else {
				bindFourthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_2);
			}

			boolean bindFifthTimeSlot = false;

			if (FifthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_3);
			}
			else {
				bindFifthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_2);
			}

			boolean bindSixthTimeSlot = false;

			if (SixthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_3);
			}
			else {
				bindSixthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_2);
			}

			boolean bindSeventhTimeSlot = false;

			if (SeventhTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_3);
			}
			else {
				bindSeventhTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_2);
			}

			boolean bindEighthTimeSlot = false;

			if (EighthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_3);
			}
			else {
				bindEighthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointee) {
					queryPos.add(appointee);
				}

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				if (bindFromTime) {
					queryPos.add(FromTime);
				}

				if (bindSecondTimeSlot) {
					queryPos.add(SecondTimeSlot);
				}

				if (bindThirdTimeSlot) {
					queryPos.add(ThirdTimeSlot);
				}

				if (bindFourthTimeSlot) {
					queryPos.add(FourthTimeSlot);
				}

				if (bindFifthTimeSlot) {
					queryPos.add(FifthTimeSlot);
				}

				if (bindSixthTimeSlot) {
					queryPos.add(SixthTimeSlot);
				}

				if (bindSeventhTimeSlot) {
					queryPos.add(SeventhTimeSlot);
				}

				if (bindEighthTimeSlot) {
					queryPos.add(EighthTimeSlot);
				}

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public csclAppointmentAdmin findByappointeeAndSlot_First(
			String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin =
			fetchByappointeeAndSlot_First(
				appointee, appointedDate, FromTime, SecondTimeSlot,
				ThirdTimeSlot, FourthTimeSlot, FifthTimeSlot, SixthTimeSlot,
				SeventhTimeSlot, EighthTimeSlot, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(22);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append(", appointedDate=");
		sb.append(appointedDate);

		sb.append(", FromTime=");
		sb.append(FromTime);

		sb.append(", SecondTimeSlot=");
		sb.append(SecondTimeSlot);

		sb.append(", ThirdTimeSlot=");
		sb.append(ThirdTimeSlot);

		sb.append(", FourthTimeSlot=");
		sb.append(FourthTimeSlot);

		sb.append(", FifthTimeSlot=");
		sb.append(FifthTimeSlot);

		sb.append(", SixthTimeSlot=");
		sb.append(SixthTimeSlot);

		sb.append(", SeventhTimeSlot=");
		sb.append(SeventhTimeSlot);

		sb.append(", EighthTimeSlot=");
		sb.append(EighthTimeSlot);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
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
	@Override
	public csclAppointmentAdmin fetchByappointeeAndSlot_First(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		List<csclAppointmentAdmin> list = findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin findByappointeeAndSlot_Last(
			String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin =
			fetchByappointeeAndSlot_Last(
				appointee, appointedDate, FromTime, SecondTimeSlot,
				ThirdTimeSlot, FourthTimeSlot, FifthTimeSlot, SixthTimeSlot,
				SeventhTimeSlot, EighthTimeSlot, orderByComparator);

		if (csclAppointmentAdmin != null) {
			return csclAppointmentAdmin;
		}

		StringBundler sb = new StringBundler(22);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append(", appointedDate=");
		sb.append(appointedDate);

		sb.append(", FromTime=");
		sb.append(FromTime);

		sb.append(", SecondTimeSlot=");
		sb.append(SecondTimeSlot);

		sb.append(", ThirdTimeSlot=");
		sb.append(ThirdTimeSlot);

		sb.append(", FourthTimeSlot=");
		sb.append(FourthTimeSlot);

		sb.append(", FifthTimeSlot=");
		sb.append(FifthTimeSlot);

		sb.append(", SixthTimeSlot=");
		sb.append(SixthTimeSlot);

		sb.append(", SeventhTimeSlot=");
		sb.append(SeventhTimeSlot);

		sb.append(", EighthTimeSlot=");
		sb.append(EighthTimeSlot);

		sb.append("}");

		throw new NoSuchcsclAppointmentAdminException(sb.toString());
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
	@Override
	public csclAppointmentAdmin fetchByappointeeAndSlot_Last(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		int count = countByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot);

		if (count == 0) {
			return null;
		}

		List<csclAppointmentAdmin> list = findByappointeeAndSlot(
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public csclAppointmentAdmin[] findByappointeeAndSlot_PrevAndNext(
			long ID, String appointee, String appointedDate, String FromTime,
			String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
			String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
			String EighthTimeSlot,
			OrderByComparator<csclAppointmentAdmin> orderByComparator)
		throws NoSuchcsclAppointmentAdminException {

		appointee = Objects.toString(appointee, "");
		appointedDate = Objects.toString(appointedDate, "");
		FromTime = Objects.toString(FromTime, "");
		SecondTimeSlot = Objects.toString(SecondTimeSlot, "");
		ThirdTimeSlot = Objects.toString(ThirdTimeSlot, "");
		FourthTimeSlot = Objects.toString(FourthTimeSlot, "");
		FifthTimeSlot = Objects.toString(FifthTimeSlot, "");
		SixthTimeSlot = Objects.toString(SixthTimeSlot, "");
		SeventhTimeSlot = Objects.toString(SeventhTimeSlot, "");
		EighthTimeSlot = Objects.toString(EighthTimeSlot, "");

		csclAppointmentAdmin csclAppointmentAdmin = findByPrimaryKey(ID);

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin[] array = new csclAppointmentAdminImpl[3];

			array[0] = getByappointeeAndSlot_PrevAndNext(
				session, csclAppointmentAdmin, appointee, appointedDate,
				FromTime, SecondTimeSlot, ThirdTimeSlot, FourthTimeSlot,
				FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot, EighthTimeSlot,
				orderByComparator, true);

			array[1] = csclAppointmentAdmin;

			array[2] = getByappointeeAndSlot_PrevAndNext(
				session, csclAppointmentAdmin, appointee, appointedDate,
				FromTime, SecondTimeSlot, ThirdTimeSlot, FourthTimeSlot,
				FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot, EighthTimeSlot,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected csclAppointmentAdmin getByappointeeAndSlot_PrevAndNext(
		Session session, csclAppointmentAdmin csclAppointmentAdmin,
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				13 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
						(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(12);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE);

		boolean bindAppointee = false;

		if (appointee.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_3);
		}
		else {
			bindAppointee = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_2);
		}

		boolean bindAppointedDate = false;

		if (appointedDate.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_3);
		}
		else {
			bindAppointedDate = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_2);
		}

		boolean bindFromTime = false;

		if (FromTime.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_3);
		}
		else {
			bindFromTime = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_2);
		}

		boolean bindSecondTimeSlot = false;

		if (SecondTimeSlot.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_3);
		}
		else {
			bindSecondTimeSlot = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_2);
		}

		boolean bindThirdTimeSlot = false;

		if (ThirdTimeSlot.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_3);
		}
		else {
			bindThirdTimeSlot = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_2);
		}

		boolean bindFourthTimeSlot = false;

		if (FourthTimeSlot.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_3);
		}
		else {
			bindFourthTimeSlot = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_2);
		}

		boolean bindFifthTimeSlot = false;

		if (FifthTimeSlot.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_3);
		}
		else {
			bindFifthTimeSlot = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_2);
		}

		boolean bindSixthTimeSlot = false;

		if (SixthTimeSlot.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_3);
		}
		else {
			bindSixthTimeSlot = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_2);
		}

		boolean bindSeventhTimeSlot = false;

		if (SeventhTimeSlot.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_3);
		}
		else {
			bindSeventhTimeSlot = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_2);
		}

		boolean bindEighthTimeSlot = false;

		if (EighthTimeSlot.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_3);
		}
		else {
			bindEighthTimeSlot = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindAppointee) {
			queryPos.add(appointee);
		}

		if (bindAppointedDate) {
			queryPos.add(appointedDate);
		}

		if (bindFromTime) {
			queryPos.add(FromTime);
		}

		if (bindSecondTimeSlot) {
			queryPos.add(SecondTimeSlot);
		}

		if (bindThirdTimeSlot) {
			queryPos.add(ThirdTimeSlot);
		}

		if (bindFourthTimeSlot) {
			queryPos.add(FourthTimeSlot);
		}

		if (bindFifthTimeSlot) {
			queryPos.add(FifthTimeSlot);
		}

		if (bindSixthTimeSlot) {
			queryPos.add(SixthTimeSlot);
		}

		if (bindSeventhTimeSlot) {
			queryPos.add(SeventhTimeSlot);
		}

		if (bindEighthTimeSlot) {
			queryPos.add(EighthTimeSlot);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentAdmin)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<csclAppointmentAdmin> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public void removeByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot) {

		for (csclAppointmentAdmin csclAppointmentAdmin :
				findByappointeeAndSlot(
					appointee, appointedDate, FromTime, SecondTimeSlot,
					ThirdTimeSlot, FourthTimeSlot, FifthTimeSlot, SixthTimeSlot,
					SeventhTimeSlot, EighthTimeSlot, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentAdmin);
		}
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
	@Override
	public int countByappointeeAndSlot(
		String appointee, String appointedDate, String FromTime,
		String SecondTimeSlot, String ThirdTimeSlot, String FourthTimeSlot,
		String FifthTimeSlot, String SixthTimeSlot, String SeventhTimeSlot,
		String EighthTimeSlot) {

		appointee = Objects.toString(appointee, "");
		appointedDate = Objects.toString(appointedDate, "");
		FromTime = Objects.toString(FromTime, "");
		SecondTimeSlot = Objects.toString(SecondTimeSlot, "");
		ThirdTimeSlot = Objects.toString(ThirdTimeSlot, "");
		FourthTimeSlot = Objects.toString(FourthTimeSlot, "");
		FifthTimeSlot = Objects.toString(FifthTimeSlot, "");
		SixthTimeSlot = Objects.toString(SixthTimeSlot, "");
		SeventhTimeSlot = Objects.toString(SeventhTimeSlot, "");
		EighthTimeSlot = Objects.toString(EighthTimeSlot, "");

		FinderPath finderPath = _finderPathCountByappointeeAndSlot;

		Object[] finderArgs = new Object[] {
			appointee, appointedDate, FromTime, SecondTimeSlot, ThirdTimeSlot,
			FourthTimeSlot, FifthTimeSlot, SixthTimeSlot, SeventhTimeSlot,
			EighthTimeSlot
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(11);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE);

			boolean bindAppointee = false;

			if (appointee.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_3);
			}
			else {
				bindAppointee = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_2);
			}

			boolean bindAppointedDate = false;

			if (appointedDate.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_3);
			}
			else {
				bindAppointedDate = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_2);
			}

			boolean bindFromTime = false;

			if (FromTime.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_3);
			}
			else {
				bindFromTime = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_2);
			}

			boolean bindSecondTimeSlot = false;

			if (SecondTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_3);
			}
			else {
				bindSecondTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_2);
			}

			boolean bindThirdTimeSlot = false;

			if (ThirdTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_3);
			}
			else {
				bindThirdTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_2);
			}

			boolean bindFourthTimeSlot = false;

			if (FourthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_3);
			}
			else {
				bindFourthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_2);
			}

			boolean bindFifthTimeSlot = false;

			if (FifthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_3);
			}
			else {
				bindFifthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_2);
			}

			boolean bindSixthTimeSlot = false;

			if (SixthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_3);
			}
			else {
				bindSixthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_2);
			}

			boolean bindSeventhTimeSlot = false;

			if (SeventhTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_3);
			}
			else {
				bindSeventhTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_2);
			}

			boolean bindEighthTimeSlot = false;

			if (EighthTimeSlot.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_3);
			}
			else {
				bindEighthTimeSlot = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppointee) {
					queryPos.add(appointee);
				}

				if (bindAppointedDate) {
					queryPos.add(appointedDate);
				}

				if (bindFromTime) {
					queryPos.add(FromTime);
				}

				if (bindSecondTimeSlot) {
					queryPos.add(SecondTimeSlot);
				}

				if (bindThirdTimeSlot) {
					queryPos.add(ThirdTimeSlot);
				}

				if (bindFourthTimeSlot) {
					queryPos.add(FourthTimeSlot);
				}

				if (bindFifthTimeSlot) {
					queryPos.add(FifthTimeSlot);
				}

				if (bindSixthTimeSlot) {
					queryPos.add(SixthTimeSlot);
				}

				if (bindSeventhTimeSlot) {
					queryPos.add(SeventhTimeSlot);
				}

				if (bindEighthTimeSlot) {
					queryPos.add(EighthTimeSlot);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_2 =
		"csclAppointmentAdmin.appointee = ? AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEE_3 =
		"(csclAppointmentAdmin.appointee IS NULL OR csclAppointmentAdmin.appointee = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_2 =
			"csclAppointmentAdmin.appointedDate = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_APPOINTEDDATE_3 =
			"(csclAppointmentAdmin.appointedDate IS NULL OR csclAppointmentAdmin.appointedDate = '') AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_2 =
		"csclAppointmentAdmin.FromTime = ? AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDSLOT_FROMTIME_3 =
		"(csclAppointmentAdmin.FromTime IS NULL OR csclAppointmentAdmin.FromTime = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_2 =
			"csclAppointmentAdmin.SecondTimeSlot = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_SECONDTIMESLOT_3 =
			"(csclAppointmentAdmin.SecondTimeSlot IS NULL OR csclAppointmentAdmin.SecondTimeSlot = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_2 =
			"csclAppointmentAdmin.ThirdTimeSlot = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_THIRDTIMESLOT_3 =
			"(csclAppointmentAdmin.ThirdTimeSlot IS NULL OR csclAppointmentAdmin.ThirdTimeSlot = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_2 =
			"csclAppointmentAdmin.FourthTimeSlot = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_FOURTHTIMESLOT_3 =
			"(csclAppointmentAdmin.FourthTimeSlot IS NULL OR csclAppointmentAdmin.FourthTimeSlot = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_2 =
			"csclAppointmentAdmin.FifthTimeSlot = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_FIFTHTIMESLOT_3 =
			"(csclAppointmentAdmin.FifthTimeSlot IS NULL OR csclAppointmentAdmin.FifthTimeSlot = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_2 =
			"csclAppointmentAdmin.SixthTimeSlot = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_SIXTHTIMESLOT_3 =
			"(csclAppointmentAdmin.SixthTimeSlot IS NULL OR csclAppointmentAdmin.SixthTimeSlot = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_2 =
			"csclAppointmentAdmin.SeventhTimeSlot = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_SEVENTHTIMESLOT_3 =
			"(csclAppointmentAdmin.SeventhTimeSlot IS NULL OR csclAppointmentAdmin.SeventhTimeSlot = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_2 =
			"csclAppointmentAdmin.EighthTimeSlot = ?";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDSLOT_EIGHTHTIMESLOT_3 =
			"(csclAppointmentAdmin.EighthTimeSlot IS NULL OR csclAppointmentAdmin.EighthTimeSlot = '')";

	public csclAppointmentAdminPersistenceImpl() {
		setModelClass(csclAppointmentAdmin.class);

		setModelImplClass(csclAppointmentAdminImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cscl appointment admin in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentAdmin the cscl appointment admin
	 */
	@Override
	public void cacheResult(csclAppointmentAdmin csclAppointmentAdmin) {
		entityCache.putResult(
			entityCacheEnabled, csclAppointmentAdminImpl.class,
			csclAppointmentAdmin.getPrimaryKey(), csclAppointmentAdmin);

		csclAppointmentAdmin.resetOriginalValues();
	}

	/**
	 * Caches the cscl appointment admins in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentAdmins the cscl appointment admins
	 */
	@Override
	public void cacheResult(List<csclAppointmentAdmin> csclAppointmentAdmins) {
		for (csclAppointmentAdmin csclAppointmentAdmin :
				csclAppointmentAdmins) {

			if (entityCache.getResult(
					entityCacheEnabled, csclAppointmentAdminImpl.class,
					csclAppointmentAdmin.getPrimaryKey()) == null) {

				cacheResult(csclAppointmentAdmin);
			}
			else {
				csclAppointmentAdmin.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl appointment admins.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(csclAppointmentAdminImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl appointment admin.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(csclAppointmentAdmin csclAppointmentAdmin) {
		entityCache.removeResult(
			entityCacheEnabled, csclAppointmentAdminImpl.class,
			csclAppointmentAdmin.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<csclAppointmentAdmin> csclAppointmentAdmins) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (csclAppointmentAdmin csclAppointmentAdmin :
				csclAppointmentAdmins) {

			entityCache.removeResult(
				entityCacheEnabled, csclAppointmentAdminImpl.class,
				csclAppointmentAdmin.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, csclAppointmentAdminImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new cscl appointment admin with the primary key. Does not add the cscl appointment admin to the database.
	 *
	 * @param ID the primary key for the new cscl appointment admin
	 * @return the new cscl appointment admin
	 */
	@Override
	public csclAppointmentAdmin create(long ID) {
		csclAppointmentAdmin csclAppointmentAdmin =
			new csclAppointmentAdminImpl();

		csclAppointmentAdmin.setNew(true);
		csclAppointmentAdmin.setPrimaryKey(ID);

		String uuid = PortalUUIDUtil.generate();

		csclAppointmentAdmin.setUuid(uuid);

		return csclAppointmentAdmin;
	}

	/**
	 * Removes the cscl appointment admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public csclAppointmentAdmin remove(long ID)
		throws NoSuchcsclAppointmentAdminException {

		return remove((Serializable)ID);
	}

	/**
	 * Removes the cscl appointment admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl appointment admin
	 * @return the cscl appointment admin that was removed
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public csclAppointmentAdmin remove(Serializable primaryKey)
		throws NoSuchcsclAppointmentAdminException {

		Session session = null;

		try {
			session = openSession();

			csclAppointmentAdmin csclAppointmentAdmin =
				(csclAppointmentAdmin)session.get(
					csclAppointmentAdminImpl.class, primaryKey);

			if (csclAppointmentAdmin == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcsclAppointmentAdminException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclAppointmentAdmin);
		}
		catch (NoSuchcsclAppointmentAdminException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected csclAppointmentAdmin removeImpl(
		csclAppointmentAdmin csclAppointmentAdmin) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclAppointmentAdmin)) {
				csclAppointmentAdmin = (csclAppointmentAdmin)session.get(
					csclAppointmentAdminImpl.class,
					csclAppointmentAdmin.getPrimaryKeyObj());
			}

			if (csclAppointmentAdmin != null) {
				session.delete(csclAppointmentAdmin);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (csclAppointmentAdmin != null) {
			clearCache(csclAppointmentAdmin);
		}

		return csclAppointmentAdmin;
	}

	@Override
	public csclAppointmentAdmin updateImpl(
		csclAppointmentAdmin csclAppointmentAdmin) {

		boolean isNew = csclAppointmentAdmin.isNew();

		if (!(csclAppointmentAdmin instanceof csclAppointmentAdminModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclAppointmentAdmin.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csclAppointmentAdmin);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclAppointmentAdmin proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom csclAppointmentAdmin implementation " +
					csclAppointmentAdmin.getClass());
		}

		csclAppointmentAdminModelImpl csclAppointmentAdminModelImpl =
			(csclAppointmentAdminModelImpl)csclAppointmentAdmin;

		if (Validator.isNull(csclAppointmentAdmin.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			csclAppointmentAdmin.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (csclAppointmentAdmin.isNew()) {
				session.save(csclAppointmentAdmin);

				csclAppointmentAdmin.setNew(false);
			}
			else {
				csclAppointmentAdmin = (csclAppointmentAdmin)session.merge(
					csclAppointmentAdmin);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				csclAppointmentAdminModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				csclAppointmentAdminModelImpl.getAppointeeId()
			};

			finderCache.removeResult(_finderPathCountByappointeeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointeeId, args);

			args = new Object[] {csclAppointmentAdminModelImpl.getAppointee()};

			finderCache.removeResult(_finderPathCountByappointee, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointee, args);

			args = new Object[] {
				csclAppointmentAdminModelImpl.getAppointedDate()
			};

			finderCache.removeResult(_finderPathCountByappointedDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointedDate, args);

			args = new Object[] {
				csclAppointmentAdminModelImpl.getAppointeeId(),
				csclAppointmentAdminModelImpl.getAppointedDate()
			};

			finderCache.removeResult(
				_finderPathCountByAppointeeIDAndDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAppointeeIDAndDate, args);

			args = new Object[] {
				csclAppointmentAdminModelImpl.getAppointee(),
				csclAppointmentAdminModelImpl.getAppointedDate()
			};

			finderCache.removeResult(_finderPathCountByAppointeeAndDate, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAppointeeAndDate, args);

			args = new Object[] {
				csclAppointmentAdminModelImpl.getAppointee(),
				csclAppointmentAdminModelImpl.getAppointedDate(),
				csclAppointmentAdminModelImpl.getFromTime(),
				csclAppointmentAdminModelImpl.getSecondTimeSlot(),
				csclAppointmentAdminModelImpl.getThirdTimeSlot(),
				csclAppointmentAdminModelImpl.getFourthTimeSlot(),
				csclAppointmentAdminModelImpl.getFifthTimeSlot(),
				csclAppointmentAdminModelImpl.getSixthTimeSlot(),
				csclAppointmentAdminModelImpl.getSeventhTimeSlot(),
				csclAppointmentAdminModelImpl.getEighthTimeSlot()
			};

			finderCache.removeResult(_finderPathCountByappointeeAndSlot, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointeeAndSlot, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclAppointmentAdminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclAppointmentAdminModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {csclAppointmentAdminModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((csclAppointmentAdminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointeeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentAdminModelImpl.getOriginalAppointeeId()
				};

				finderCache.removeResult(_finderPathCountByappointeeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeId, args);

				args = new Object[] {
					csclAppointmentAdminModelImpl.getAppointeeId()
				};

				finderCache.removeResult(_finderPathCountByappointeeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeId, args);
			}

			if ((csclAppointmentAdminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointee.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentAdminModelImpl.getOriginalAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointee, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointee, args);

				args = new Object[] {
					csclAppointmentAdminModelImpl.getAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointee, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointee, args);
			}

			if ((csclAppointmentAdminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointedDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentAdminModelImpl.getOriginalAppointedDate()
				};

				finderCache.removeResult(_finderPathCountByappointedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointedDate, args);

				args = new Object[] {
					csclAppointmentAdminModelImpl.getAppointedDate()
				};

				finderCache.removeResult(_finderPathCountByappointedDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointedDate, args);
			}

			if ((csclAppointmentAdminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAppointeeIDAndDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentAdminModelImpl.getOriginalAppointeeId(),
					csclAppointmentAdminModelImpl.getOriginalAppointedDate()
				};

				finderCache.removeResult(
					_finderPathCountByAppointeeIDAndDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAppointeeIDAndDate, args);

				args = new Object[] {
					csclAppointmentAdminModelImpl.getAppointeeId(),
					csclAppointmentAdminModelImpl.getAppointedDate()
				};

				finderCache.removeResult(
					_finderPathCountByAppointeeIDAndDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAppointeeIDAndDate, args);
			}

			if ((csclAppointmentAdminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAppointeeAndDate.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentAdminModelImpl.getOriginalAppointee(),
					csclAppointmentAdminModelImpl.getOriginalAppointedDate()
				};

				finderCache.removeResult(
					_finderPathCountByAppointeeAndDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAppointeeAndDate, args);

				args = new Object[] {
					csclAppointmentAdminModelImpl.getAppointee(),
					csclAppointmentAdminModelImpl.getAppointedDate()
				};

				finderCache.removeResult(
					_finderPathCountByAppointeeAndDate, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAppointeeAndDate, args);
			}

			if ((csclAppointmentAdminModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointeeAndSlot.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentAdminModelImpl.getOriginalAppointee(),
					csclAppointmentAdminModelImpl.getOriginalAppointedDate(),
					csclAppointmentAdminModelImpl.getOriginalFromTime(),
					csclAppointmentAdminModelImpl.getOriginalSecondTimeSlot(),
					csclAppointmentAdminModelImpl.getOriginalThirdTimeSlot(),
					csclAppointmentAdminModelImpl.getOriginalFourthTimeSlot(),
					csclAppointmentAdminModelImpl.getOriginalFifthTimeSlot(),
					csclAppointmentAdminModelImpl.getOriginalSixthTimeSlot(),
					csclAppointmentAdminModelImpl.getOriginalSeventhTimeSlot(),
					csclAppointmentAdminModelImpl.getOriginalEighthTimeSlot()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndSlot, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndSlot, args);

				args = new Object[] {
					csclAppointmentAdminModelImpl.getAppointee(),
					csclAppointmentAdminModelImpl.getAppointedDate(),
					csclAppointmentAdminModelImpl.getFromTime(),
					csclAppointmentAdminModelImpl.getSecondTimeSlot(),
					csclAppointmentAdminModelImpl.getThirdTimeSlot(),
					csclAppointmentAdminModelImpl.getFourthTimeSlot(),
					csclAppointmentAdminModelImpl.getFifthTimeSlot(),
					csclAppointmentAdminModelImpl.getSixthTimeSlot(),
					csclAppointmentAdminModelImpl.getSeventhTimeSlot(),
					csclAppointmentAdminModelImpl.getEighthTimeSlot()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndSlot, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndSlot, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, csclAppointmentAdminImpl.class,
			csclAppointmentAdmin.getPrimaryKey(), csclAppointmentAdmin, false);

		csclAppointmentAdmin.resetOriginalValues();

		return csclAppointmentAdmin;
	}

	/**
	 * Returns the cscl appointment admin with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl appointment admin
	 * @return the cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public csclAppointmentAdmin findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcsclAppointmentAdminException {

		csclAppointmentAdmin csclAppointmentAdmin = fetchByPrimaryKey(
			primaryKey);

		if (csclAppointmentAdmin == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcsclAppointmentAdminException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclAppointmentAdmin;
	}

	/**
	 * Returns the cscl appointment admin with the primary key or throws a <code>NoSuchcsclAppointmentAdminException</code> if it could not be found.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin
	 * @throws NoSuchcsclAppointmentAdminException if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public csclAppointmentAdmin findByPrimaryKey(long ID)
		throws NoSuchcsclAppointmentAdminException {

		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the cscl appointment admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the cscl appointment admin
	 * @return the cscl appointment admin, or <code>null</code> if a cscl appointment admin with the primary key could not be found
	 */
	@Override
	public csclAppointmentAdmin fetchByPrimaryKey(long ID) {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the cscl appointment admins.
	 *
	 * @return the cscl appointment admins
	 */
	@Override
	public List<csclAppointmentAdmin> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<csclAppointmentAdmin> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<csclAppointmentAdmin> findAll(
		int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<csclAppointmentAdmin> findAll(
		int start, int end,
		OrderByComparator<csclAppointmentAdmin> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<csclAppointmentAdmin> list = null;

		if (useFinderCache) {
			list = (List<csclAppointmentAdmin>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CSCLAPPOINTMENTADMIN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLAPPOINTMENTADMIN;

				sql = sql.concat(csclAppointmentAdminModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<csclAppointmentAdmin>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cscl appointment admins from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (csclAppointmentAdmin csclAppointmentAdmin : findAll()) {
			remove(csclAppointmentAdmin);
		}
	}

	/**
	 * Returns the number of cscl appointment admins.
	 *
	 * @return the number of cscl appointment admins
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CSCLAPPOINTMENTADMIN);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLAPPOINTMENTADMIN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return csclAppointmentAdminModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl appointment admin persistence.
	 */
	@Activate
	public void activate() {
		csclAppointmentAdminModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		csclAppointmentAdminModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			csclAppointmentAdminModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByappointeeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointeeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointeeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByappointeeId",
			new String[] {Long.class.getName()},
			csclAppointmentAdminModelImpl.APPOINTEEID_COLUMN_BITMASK);

		_finderPathCountByappointeeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByappointeeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointee",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByappointee",
			new String[] {String.class.getName()},
			csclAppointmentAdminModelImpl.APPOINTEE_COLUMN_BITMASK);

		_finderPathCountByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByappointee",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByappointedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointedDate",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByappointedDate",
			new String[] {String.class.getName()},
			csclAppointmentAdminModelImpl.APPOINTEDDATE_COLUMN_BITMASK);

		_finderPathCountByappointedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByappointedDate",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByAppointeeIDAndDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppointeeIDAndDate",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAppointeeIDAndDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAppointeeIDAndDate",
			new String[] {Long.class.getName(), String.class.getName()},
			csclAppointmentAdminModelImpl.APPOINTEEID_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.APPOINTEDDATE_COLUMN_BITMASK);

		_finderPathCountByAppointeeIDAndDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppointeeIDAndDate",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByAppointeeAndDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppointeeAndDate",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAppointeeAndDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppointeeAndDate",
			new String[] {String.class.getName(), String.class.getName()},
			csclAppointmentAdminModelImpl.APPOINTEE_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.APPOINTEDDATE_COLUMN_BITMASK);

		_finderPathCountByAppointeeAndDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppointeeAndDate",
			new String[] {String.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByappointeeAndSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointeeAndSlot",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointeeAndSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			csclAppointmentAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByappointeeAndSlot",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			csclAppointmentAdminModelImpl.APPOINTEE_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.APPOINTEDDATE_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.FROMTIME_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.SECONDTIMESLOT_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.THIRDTIMESLOT_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.FOURTHTIMESLOT_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.FIFTHTIMESLOT_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.SIXTHTIMESLOT_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.SEVENTHTIMESLOT_COLUMN_BITMASK |
			csclAppointmentAdminModelImpl.EIGHTHTIMESLOT_COLUMN_BITMASK);

		_finderPathCountByappointeeAndSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByappointeeAndSlot",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(csclAppointmentAdminImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = csclAppointmentAdminPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.cscl.appointment.admin.table.model.csclAppointmentAdmin"),
			true);
	}

	@Override
	@Reference(
		target = csclAppointmentAdminPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = csclAppointmentAdminPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CSCLAPPOINTMENTADMIN =
		"SELECT csclAppointmentAdmin FROM csclAppointmentAdmin csclAppointmentAdmin";

	private static final String _SQL_SELECT_CSCLAPPOINTMENTADMIN_WHERE =
		"SELECT csclAppointmentAdmin FROM csclAppointmentAdmin csclAppointmentAdmin WHERE ";

	private static final String _SQL_COUNT_CSCLAPPOINTMENTADMIN =
		"SELECT COUNT(csclAppointmentAdmin) FROM csclAppointmentAdmin csclAppointmentAdmin";

	private static final String _SQL_COUNT_CSCLAPPOINTMENTADMIN_WHERE =
		"SELECT COUNT(csclAppointmentAdmin) FROM csclAppointmentAdmin csclAppointmentAdmin WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"csclAppointmentAdmin.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No csclAppointmentAdmin exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No csclAppointmentAdmin exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		csclAppointmentAdminPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(
				csclAppointmentAdminPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}