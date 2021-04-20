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

package cscl.appointment.booking.service.persistence.impl;

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

import cscl.appointment.booking.exception.NoSuchCsclAppointmentMasterException;
import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.model.impl.CsclAppointmentMasterImpl;
import cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl;
import cscl.appointment.booking.service.persistence.CsclAppointmentMasterPersistence;
import cscl.appointment.booking.service.persistence.impl.constants.CsclAppointmentBookingPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
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
 * The persistence implementation for the cscl appointment master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @generated
 */
@Component(service = CsclAppointmentMasterPersistence.class)
public class CsclAppointmentMasterPersistenceImpl
	extends BasePersistenceImpl<CsclAppointmentMaster>
	implements CsclAppointmentMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclAppointmentMasterUtil</code> to access the cscl appointment master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclAppointmentMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByid_;
	private FinderPath _finderPathWithoutPaginationFindByid_;
	private FinderPath _finderPathCountByid_;

	/**
	 * Returns all the cscl appointment masters where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByid_(long id_) {
		return findByid_(id_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclAppointmentMaster> findByid_(long id_, int start, int end) {
		return findByid_(id_, start, end, null);
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
	@Override
	public List<CsclAppointmentMaster> findByid_(
		long id_, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return findByid_(id_, start, end, orderByComparator, true);
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
	@Override
	public List<CsclAppointmentMaster> findByid_(
		long id_, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByid_;
				finderArgs = new Object[] {id_};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByid_;
			finderArgs = new Object[] {id_, start, end, orderByComparator};
		}

		List<CsclAppointmentMaster> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsclAppointmentMaster csclAppointmentMaster : list) {
					if (id_ != csclAppointmentMaster.getId_()) {
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

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ID__ID__2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id_);

				list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByid__First(
			long id_,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByid__First(
			id_, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id_=");
		sb.append(id_);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByid__First(
		long id_, OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByid_(
			id_, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByid__Last(
			long id_,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByid__Last(
			id_, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id_=");
		sb.append(id_);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByid__Last(
		long id_, OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByid_(id_);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByid_(
			id_, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the cscl appointment masters where id_ = &#63; from the database.
	 *
	 * @param id_ the id_
	 */
	@Override
	public void removeByid_(long id_) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByid_(id_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where id_ = &#63;.
	 *
	 * @param id_ the id_
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByid_(long id_) {
		FinderPath finderPath = _finderPathCountByid_;

		Object[] finderArgs = new Object[] {id_};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_ID__ID__2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id_);

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

	private static final String _FINDER_COLUMN_ID__ID__2 =
		"csclAppointmentMaster.id_ = ?";

	private FinderPath _finderPathWithPaginationFindByapprover;
	private FinderPath _finderPathWithoutPaginationFindByapprover;
	private FinderPath _finderPathCountByapprover;

	/**
	 * Returns all the cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByapprover(long approver) {
		return findByapprover(
			approver, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end) {

		return findByapprover(approver, start, end, null);
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
	@Override
	public List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return findByapprover(approver, start, end, orderByComparator, true);
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
	@Override
	public List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByapprover;
				finderArgs = new Object[] {approver};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByapprover;
			finderArgs = new Object[] {approver, start, end, orderByComparator};
		}

		List<CsclAppointmentMaster> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsclAppointmentMaster csclAppointmentMaster : list) {
					if (approver != csclAppointmentMaster.getApprover()) {
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

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_APPROVER_APPROVER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(approver);

				list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByapprover_First(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByapprover_First(
			approver, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("approver=");
		sb.append(approver);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByapprover_First(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByapprover(
			approver, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByapprover_Last(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByapprover_Last(
			approver, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("approver=");
		sb.append(approver);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByapprover_Last(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByapprover(approver);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByapprover(
			approver, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster[] findByapprover_PrevAndNext(
			long id_, long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByapprover_PrevAndNext(
				session, csclAppointmentMaster, approver, orderByComparator,
				true);

			array[1] = csclAppointmentMaster;

			array[2] = getByapprover_PrevAndNext(
				session, csclAppointmentMaster, approver, orderByComparator,
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

	protected CsclAppointmentMaster getByapprover_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		sb.append(_FINDER_COLUMN_APPROVER_APPROVER_2);

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
			sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(approver);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment masters where approver = &#63; from the database.
	 *
	 * @param approver the approver
	 */
	@Override
	public void removeByapprover(long approver) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByapprover(
					approver, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByapprover(long approver) {
		FinderPath finderPath = _finderPathCountByapprover;

		Object[] finderArgs = new Object[] {approver};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_APPROVER_APPROVER_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(approver);

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

	private static final String _FINDER_COLUMN_APPROVER_APPROVER_2 =
		"csclAppointmentMaster.approver = ?";

	private FinderPath _finderPathWithPaginationFindByappointee;
	private FinderPath _finderPathWithoutPaginationFindByappointee;
	private FinderPath _finderPathCountByappointee;

	/**
	 * Returns all the cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointee(int appointee) {
		return findByappointee(
			appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end) {

		return findByappointee(appointee, start, end, null);
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
	@Override
	public List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return findByappointee(appointee, start, end, orderByComparator, true);
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
	@Override
	public List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

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

		List<CsclAppointmentMaster> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsclAppointmentMaster csclAppointmentMaster : list) {
					if (appointee != csclAppointmentMaster.getAppointee()) {
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

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appointee);

				list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByappointee_First(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByappointee_First(
			appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointee_First(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByappointee(
			appointee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByappointee_Last(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByappointee_Last(
			appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("appointee=");
		sb.append(appointee);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointee_Last(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByappointee(appointee);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByappointee(
			appointee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster[] findByappointee_PrevAndNext(
			long id_, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByappointee_PrevAndNext(
				session, csclAppointmentMaster, appointee, orderByComparator,
				true);

			array[1] = csclAppointmentMaster;

			array[2] = getByappointee_PrevAndNext(
				session, csclAppointmentMaster, appointee, orderByComparator,
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

	protected CsclAppointmentMaster getByappointee_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);

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
			sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(appointee);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment masters where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	@Override
	public void removeByappointee(int appointee) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByappointee(
					appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByappointee(int appointee) {
		FinderPath finderPath = _finderPathCountByappointee;

		Object[] finderArgs = new Object[] {appointee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(appointee);

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
		"csclAppointmentMaster.appointee = ?";

	private FinderPath _finderPathWithPaginationFindByappointeeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByappointeeAndStatus;
	private FinderPath _finderPathCountByappointeeAndStatus;

	/**
	 * Returns all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee) {

		return findByappointeeAndStatus(
			status, appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end) {

		return findByappointeeAndStatus(status, appointee, start, end, null);
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
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return findByappointeeAndStatus(
			status, appointee, start, end, orderByComparator, true);
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
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByappointeeAndStatus;
				finderArgs = new Object[] {status, appointee};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByappointeeAndStatus;
			finderArgs = new Object[] {
				status, appointee, start, end, orderByComparator
			};
		}

		List<CsclAppointmentMaster> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsclAppointmentMaster csclAppointmentMaster : list) {
					if ((status != csclAppointmentMaster.getStatus()) ||
						(appointee != csclAppointmentMaster.getAppointee())) {

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

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2);

			sb.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(appointee);

				list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByappointeeAndStatus_First(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster =
			fetchByappointeeAndStatus_First(
				status, appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", appointee=");
		sb.append(appointee);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointeeAndStatus_First(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByappointeeAndStatus(
			status, appointee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster findByappointeeAndStatus_Last(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster =
			fetchByappointeeAndStatus_Last(
				status, appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", appointee=");
		sb.append(appointee);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointeeAndStatus_Last(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByappointeeAndStatus(status, appointee);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByappointeeAndStatus(
			status, appointee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster[] findByappointeeAndStatus_PrevAndNext(
			long id_, int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByappointeeAndStatus_PrevAndNext(
				session, csclAppointmentMaster, status, appointee,
				orderByComparator, true);

			array[1] = csclAppointmentMaster;

			array[2] = getByappointeeAndStatus_PrevAndNext(
				session, csclAppointmentMaster, status, appointee,
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

	protected CsclAppointmentMaster getByappointeeAndStatus_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		sb.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2);

		sb.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2);

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
			sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		queryPos.add(appointee);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment masters where status = &#63; and appointee = &#63; from the database.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 */
	@Override
	public void removeByappointeeAndStatus(int status, int appointee) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByappointeeAndStatus(
					status, appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByappointeeAndStatus(int status, int appointee) {
		FinderPath finderPath = _finderPathCountByappointeeAndStatus;

		Object[] finderArgs = new Object[] {status, appointee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			sb.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2);

			sb.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(appointee);

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

	private static final String _FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2 =
		"csclAppointmentMaster.status = ? AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2 =
		"csclAppointmentMaster.appointee = ?";

	private FinderPath _finderPathWithPaginationFindByappointeeAndDateAndSlot;
	private FinderPath
		_finderPathWithoutPaginationFindByappointeeAndDateAndSlot;
	private FinderPath _finderPathCountByappointeeAndDateAndSlot;

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
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime) {

		return findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime, int start, int end) {

		return findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime, start, end,
			null);
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
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime, start, end,
			orderByComparator, true);
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
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");
		email = Objects.toString(email, "");
		preferedTime = Objects.toString(preferedTime, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByappointeeAndDateAndSlot;
				finderArgs = new Object[] {
					name, email, appointee, _getTime(preferedDate), preferedTime
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByappointeeAndDateAndSlot;
			finderArgs = new Object[] {
				name, email, appointee, _getTime(preferedDate), preferedTime,
				start, end, orderByComparator
			};
		}

		List<CsclAppointmentMaster> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsclAppointmentMaster csclAppointmentMaster : list) {
					if (!name.equals(csclAppointmentMaster.getName()) ||
						!email.equals(csclAppointmentMaster.getEmail()) ||
						(appointee != csclAppointmentMaster.getAppointee()) ||
						!Objects.equals(
							preferedDate,
							csclAppointmentMaster.getPreferedDate()) ||
						!preferedTime.equals(
							csclAppointmentMaster.getPreferedTime())) {

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
					7 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(7);
			}

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_2);
			}

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_2);
			}

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_APPOINTEE_2);

			boolean bindPreferedDate = false;

			if (preferedDate == null) {
				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_1);
			}
			else {
				bindPreferedDate = true;

				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_2);
			}

			boolean bindPreferedTime = false;

			if (preferedTime.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_3);
			}
			else {
				bindPreferedTime = true;

				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindEmail) {
					queryPos.add(email);
				}

				queryPos.add(appointee);

				if (bindPreferedDate) {
					queryPos.add(new Timestamp(preferedDate.getTime()));
				}

				if (bindPreferedTime) {
					queryPos.add(preferedTime);
				}

				list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	@Override
	public CsclAppointmentMaster findByappointeeAndDateAndSlot_First(
			String name, String email, int appointee, Date preferedDate,
			String preferedTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster =
			fetchByappointeeAndDateAndSlot_First(
				name, email, appointee, preferedDate, preferedTime,
				orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", email=");
		sb.append(email);

		sb.append(", appointee=");
		sb.append(appointee);

		sb.append(", preferedDate=");
		sb.append(preferedDate);

		sb.append(", preferedTime=");
		sb.append(preferedTime);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
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
	@Override
	public CsclAppointmentMaster fetchByappointeeAndDateAndSlot_First(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster findByappointeeAndDateAndSlot_Last(
			String name, String email, int appointee, Date preferedDate,
			String preferedTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster =
			fetchByappointeeAndDateAndSlot_Last(
				name, email, appointee, preferedDate, preferedTime,
				orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append(", email=");
		sb.append(email);

		sb.append(", appointee=");
		sb.append(appointee);

		sb.append(", preferedDate=");
		sb.append(preferedDate);

		sb.append(", preferedTime=");
		sb.append(preferedTime);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
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
	@Override
	public CsclAppointmentMaster fetchByappointeeAndDateAndSlot_Last(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByappointeeAndDateAndSlot(
			name, email, appointee, preferedDate, preferedTime, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster[] findByappointeeAndDateAndSlot_PrevAndNext(
			long id_, String name, String email, int appointee,
			Date preferedDate, String preferedTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		name = Objects.toString(name, "");
		email = Objects.toString(email, "");
		preferedTime = Objects.toString(preferedTime, "");

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByappointeeAndDateAndSlot_PrevAndNext(
				session, csclAppointmentMaster, name, email, appointee,
				preferedDate, preferedTime, orderByComparator, true);

			array[1] = csclAppointmentMaster;

			array[2] = getByappointeeAndDateAndSlot_PrevAndNext(
				session, csclAppointmentMaster, name, email, appointee,
				preferedDate, preferedTime, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsclAppointmentMaster getByappointeeAndDateAndSlot_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		String name, String email, int appointee, Date preferedDate,
		String preferedTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(7);
		}

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_2);
		}

		boolean bindEmail = false;

		if (email.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_3);
		}
		else {
			bindEmail = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_2);
		}

		sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_APPOINTEE_2);

		boolean bindPreferedDate = false;

		if (preferedDate == null) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_1);
		}
		else {
			bindPreferedDate = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_2);
		}

		boolean bindPreferedTime = false;

		if (preferedTime.isEmpty()) {
			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_3);
		}
		else {
			bindPreferedTime = true;

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_2);
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
			sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (bindEmail) {
			queryPos.add(email);
		}

		queryPos.add(appointee);

		if (bindPreferedDate) {
			queryPos.add(new Timestamp(preferedDate.getTime()));
		}

		if (bindPreferedTime) {
			queryPos.add(preferedTime);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public void removeByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime) {

		for (CsclAppointmentMaster csclAppointmentMaster :
				findByappointeeAndDateAndSlot(
					name, email, appointee, preferedDate, preferedTime,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentMaster);
		}
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
	@Override
	public int countByappointeeAndDateAndSlot(
		String name, String email, int appointee, Date preferedDate,
		String preferedTime) {

		name = Objects.toString(name, "");
		email = Objects.toString(email, "");
		preferedTime = Objects.toString(preferedTime, "");

		FinderPath finderPath = _finderPathCountByappointeeAndDateAndSlot;

		Object[] finderArgs = new Object[] {
			name, email, appointee, _getTime(preferedDate), preferedTime
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_2);
			}

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_2);
			}

			sb.append(_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_APPOINTEE_2);

			boolean bindPreferedDate = false;

			if (preferedDate == null) {
				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_1);
			}
			else {
				bindPreferedDate = true;

				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_2);
			}

			boolean bindPreferedTime = false;

			if (preferedTime.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_3);
			}
			else {
				bindPreferedTime = true;

				sb.append(
					_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				if (bindEmail) {
					queryPos.add(email);
				}

				queryPos.add(appointee);

				if (bindPreferedDate) {
					queryPos.add(new Timestamp(preferedDate.getTime()));
				}

				if (bindPreferedTime) {
					queryPos.add(preferedTime);
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

	private static final String _FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_2 =
		"csclAppointmentMaster.name = ? AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_NAME_3 =
		"(csclAppointmentMaster.name IS NULL OR csclAppointmentMaster.name = '') AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_2 =
		"csclAppointmentMaster.email = ? AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_EMAIL_3 =
		"(csclAppointmentMaster.email IS NULL OR csclAppointmentMaster.email = '') AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_APPOINTEE_2 =
			"csclAppointmentMaster.appointee = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_1 =
			"csclAppointmentMaster.preferedDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDDATE_2 =
			"csclAppointmentMaster.preferedDate = ? AND ";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_2 =
			"csclAppointmentMaster.preferedTime = ?";

	private static final String
		_FINDER_COLUMN_APPOINTEEANDDATEANDSLOT_PREFEREDTIME_3 =
			"(csclAppointmentMaster.preferedTime IS NULL OR csclAppointmentMaster.preferedTime = '')";

	private FinderPath _finderPathWithPaginationFindByTimeSlot;
	private FinderPath _finderPathWithoutPaginationFindByTimeSlot;
	private FinderPath _finderPathCountByTimeSlot;

	/**
	 * Returns all the cscl appointment masters where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime) {

		return findByTimeSlot(
			FromTime, ToTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime, int start, int end) {

		return findByTimeSlot(FromTime, ToTime, start, end, null);
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
	@Override
	public List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return findByTimeSlot(
			FromTime, ToTime, start, end, orderByComparator, true);
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
	@Override
	public List<CsclAppointmentMaster> findByTimeSlot(
		String FromTime, String ToTime, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		FromTime = Objects.toString(FromTime, "");
		ToTime = Objects.toString(ToTime, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTimeSlot;
				finderArgs = new Object[] {FromTime, ToTime};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTimeSlot;
			finderArgs = new Object[] {
				FromTime, ToTime, start, end, orderByComparator
			};
		}

		List<CsclAppointmentMaster> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsclAppointmentMaster csclAppointmentMaster : list) {
					if (!FromTime.equals(csclAppointmentMaster.getFromTime()) ||
						!ToTime.equals(csclAppointmentMaster.getToTime())) {

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

			sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			boolean bindFromTime = false;

			if (FromTime.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIMESLOT_FROMTIME_3);
			}
			else {
				bindFromTime = true;

				sb.append(_FINDER_COLUMN_TIMESLOT_FROMTIME_2);
			}

			boolean bindToTime = false;

			if (ToTime.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIMESLOT_TOTIME_3);
			}
			else {
				bindToTime = true;

				sb.append(_FINDER_COLUMN_TIMESLOT_TOTIME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFromTime) {
					queryPos.add(FromTime);
				}

				if (bindToTime) {
					queryPos.add(ToTime);
				}

				list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByTimeSlot_First(
			String FromTime, String ToTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByTimeSlot_First(
			FromTime, ToTime, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FromTime=");
		sb.append(FromTime);

		sb.append(", ToTime=");
		sb.append(ToTime);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByTimeSlot_First(
		String FromTime, String ToTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByTimeSlot(
			FromTime, ToTime, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster findByTimeSlot_Last(
			String FromTime, String ToTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByTimeSlot_Last(
			FromTime, ToTime, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("FromTime=");
		sb.append(FromTime);

		sb.append(", ToTime=");
		sb.append(ToTime);

		sb.append("}");

		throw new NoSuchCsclAppointmentMasterException(sb.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByTimeSlot_Last(
		String FromTime, String ToTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByTimeSlot(FromTime, ToTime);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByTimeSlot(
			FromTime, ToTime, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclAppointmentMaster[] findByTimeSlot_PrevAndNext(
			long id_, String FromTime, String ToTime,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		FromTime = Objects.toString(FromTime, "");
		ToTime = Objects.toString(ToTime, "");

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByTimeSlot_PrevAndNext(
				session, csclAppointmentMaster, FromTime, ToTime,
				orderByComparator, true);

			array[1] = csclAppointmentMaster;

			array[2] = getByTimeSlot_PrevAndNext(
				session, csclAppointmentMaster, FromTime, ToTime,
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

	protected CsclAppointmentMaster getByTimeSlot_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		String FromTime, String ToTime,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
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

		sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		boolean bindFromTime = false;

		if (FromTime.isEmpty()) {
			sb.append(_FINDER_COLUMN_TIMESLOT_FROMTIME_3);
		}
		else {
			bindFromTime = true;

			sb.append(_FINDER_COLUMN_TIMESLOT_FROMTIME_2);
		}

		boolean bindToTime = false;

		if (ToTime.isEmpty()) {
			sb.append(_FINDER_COLUMN_TIMESLOT_TOTIME_3);
		}
		else {
			bindToTime = true;

			sb.append(_FINDER_COLUMN_TIMESLOT_TOTIME_2);
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
			sb.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFromTime) {
			queryPos.add(FromTime);
		}

		if (bindToTime) {
			queryPos.add(ToTime);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment masters where FromTime = &#63; and ToTime = &#63; from the database.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 */
	@Override
	public void removeByTimeSlot(String FromTime, String ToTime) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByTimeSlot(
					FromTime, ToTime, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where FromTime = &#63; and ToTime = &#63;.
	 *
	 * @param FromTime the from time
	 * @param ToTime the to time
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByTimeSlot(String FromTime, String ToTime) {
		FromTime = Objects.toString(FromTime, "");
		ToTime = Objects.toString(ToTime, "");

		FinderPath finderPath = _finderPathCountByTimeSlot;

		Object[] finderArgs = new Object[] {FromTime, ToTime};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			boolean bindFromTime = false;

			if (FromTime.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIMESLOT_FROMTIME_3);
			}
			else {
				bindFromTime = true;

				sb.append(_FINDER_COLUMN_TIMESLOT_FROMTIME_2);
			}

			boolean bindToTime = false;

			if (ToTime.isEmpty()) {
				sb.append(_FINDER_COLUMN_TIMESLOT_TOTIME_3);
			}
			else {
				bindToTime = true;

				sb.append(_FINDER_COLUMN_TIMESLOT_TOTIME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFromTime) {
					queryPos.add(FromTime);
				}

				if (bindToTime) {
					queryPos.add(ToTime);
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

	private static final String _FINDER_COLUMN_TIMESLOT_FROMTIME_2 =
		"csclAppointmentMaster.FromTime = ? AND ";

	private static final String _FINDER_COLUMN_TIMESLOT_FROMTIME_3 =
		"(csclAppointmentMaster.FromTime IS NULL OR csclAppointmentMaster.FromTime = '') AND ";

	private static final String _FINDER_COLUMN_TIMESLOT_TOTIME_2 =
		"csclAppointmentMaster.ToTime = ?";

	private static final String _FINDER_COLUMN_TIMESLOT_TOTIME_3 =
		"(csclAppointmentMaster.ToTime IS NULL OR csclAppointmentMaster.ToTime = '')";

	public CsclAppointmentMasterPersistenceImpl() {
		setModelClass(CsclAppointmentMaster.class);

		setModelImplClass(CsclAppointmentMasterImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cscl appointment master in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 */
	@Override
	public void cacheResult(CsclAppointmentMaster csclAppointmentMaster) {
		entityCache.putResult(
			entityCacheEnabled, CsclAppointmentMasterImpl.class,
			csclAppointmentMaster.getPrimaryKey(), csclAppointmentMaster);

		csclAppointmentMaster.resetOriginalValues();
	}

	/**
	 * Caches the cscl appointment masters in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMasters the cscl appointment masters
	 */
	@Override
	public void cacheResult(
		List<CsclAppointmentMaster> csclAppointmentMasters) {

		for (CsclAppointmentMaster csclAppointmentMaster :
				csclAppointmentMasters) {

			if (entityCache.getResult(
					entityCacheEnabled, CsclAppointmentMasterImpl.class,
					csclAppointmentMaster.getPrimaryKey()) == null) {

				cacheResult(csclAppointmentMaster);
			}
			else {
				csclAppointmentMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl appointment masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclAppointmentMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl appointment master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclAppointmentMaster csclAppointmentMaster) {
		entityCache.removeResult(
			entityCacheEnabled, CsclAppointmentMasterImpl.class,
			csclAppointmentMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclAppointmentMaster> csclAppointmentMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclAppointmentMaster csclAppointmentMaster :
				csclAppointmentMasters) {

			entityCache.removeResult(
				entityCacheEnabled, CsclAppointmentMasterImpl.class,
				csclAppointmentMaster.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CsclAppointmentMasterImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new cscl appointment master with the primary key. Does not add the cscl appointment master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment master
	 * @return the new cscl appointment master
	 */
	@Override
	public CsclAppointmentMaster create(long id_) {
		CsclAppointmentMaster csclAppointmentMaster =
			new CsclAppointmentMasterImpl();

		csclAppointmentMaster.setNew(true);
		csclAppointmentMaster.setPrimaryKey(id_);

		return csclAppointmentMaster;
	}

	/**
	 * Removes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster remove(long id_)
		throws NoSuchCsclAppointmentMasterException {

		return remove((Serializable)id_);
	}

	/**
	 * Removes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster remove(Serializable primaryKey)
		throws NoSuchCsclAppointmentMasterException {

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster csclAppointmentMaster =
				(CsclAppointmentMaster)session.get(
					CsclAppointmentMasterImpl.class, primaryKey);

			if (csclAppointmentMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclAppointmentMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclAppointmentMaster);
		}
		catch (NoSuchCsclAppointmentMasterException noSuchEntityException) {
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
	protected CsclAppointmentMaster removeImpl(
		CsclAppointmentMaster csclAppointmentMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclAppointmentMaster)) {
				csclAppointmentMaster = (CsclAppointmentMaster)session.get(
					CsclAppointmentMasterImpl.class,
					csclAppointmentMaster.getPrimaryKeyObj());
			}

			if (csclAppointmentMaster != null) {
				session.delete(csclAppointmentMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (csclAppointmentMaster != null) {
			clearCache(csclAppointmentMaster);
		}

		return csclAppointmentMaster;
	}

	@Override
	public CsclAppointmentMaster updateImpl(
		CsclAppointmentMaster csclAppointmentMaster) {

		boolean isNew = csclAppointmentMaster.isNew();

		if (!(csclAppointmentMaster instanceof
				CsclAppointmentMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclAppointmentMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csclAppointmentMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclAppointmentMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclAppointmentMaster implementation " +
					csclAppointmentMaster.getClass());
		}

		CsclAppointmentMasterModelImpl csclAppointmentMasterModelImpl =
			(CsclAppointmentMasterModelImpl)csclAppointmentMaster;

		Session session = null;

		try {
			session = openSession();

			if (csclAppointmentMaster.isNew()) {
				session.save(csclAppointmentMaster);

				csclAppointmentMaster.setNew(false);
			}
			else {
				csclAppointmentMaster = (CsclAppointmentMaster)session.merge(
					csclAppointmentMaster);
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
				csclAppointmentMasterModelImpl.getId_()
			};

			finderCache.removeResult(_finderPathCountByid_, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByid_, args);

			args = new Object[] {csclAppointmentMasterModelImpl.getApprover()};

			finderCache.removeResult(_finderPathCountByapprover, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByapprover, args);

			args = new Object[] {csclAppointmentMasterModelImpl.getAppointee()};

			finderCache.removeResult(_finderPathCountByappointee, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointee, args);

			args = new Object[] {
				csclAppointmentMasterModelImpl.getStatus(),
				csclAppointmentMasterModelImpl.getAppointee()
			};

			finderCache.removeResult(
				_finderPathCountByappointeeAndStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointeeAndStatus, args);

			args = new Object[] {
				csclAppointmentMasterModelImpl.getName(),
				csclAppointmentMasterModelImpl.getEmail(),
				csclAppointmentMasterModelImpl.getAppointee(),
				csclAppointmentMasterModelImpl.getPreferedDate(),
				csclAppointmentMasterModelImpl.getPreferedTime()
			};

			finderCache.removeResult(
				_finderPathCountByappointeeAndDateAndSlot, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointeeAndDateAndSlot,
				args);

			args = new Object[] {
				csclAppointmentMasterModelImpl.getFromTime(),
				csclAppointmentMasterModelImpl.getToTime()
			};

			finderCache.removeResult(_finderPathCountByTimeSlot, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTimeSlot, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByid_.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalId_()
				};

				finderCache.removeResult(_finderPathCountByid_, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByid_, args);

				args = new Object[] {csclAppointmentMasterModelImpl.getId_()};

				finderCache.removeResult(_finderPathCountByid_, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByid_, args);
			}

			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByapprover.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalApprover()
				};

				finderCache.removeResult(_finderPathCountByapprover, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByapprover, args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getApprover()
				};

				finderCache.removeResult(_finderPathCountByapprover, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByapprover, args);
			}

			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointee.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointee, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointee, args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointee, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointee, args);
			}

			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointeeAndStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalStatus(),
					csclAppointmentMasterModelImpl.getOriginalAppointee()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndStatus, args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getStatus(),
					csclAppointmentMasterModelImpl.getAppointee()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndStatus, args);
			}

			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointeeAndDateAndSlot.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalName(),
					csclAppointmentMasterModelImpl.getOriginalEmail(),
					csclAppointmentMasterModelImpl.getOriginalAppointee(),
					csclAppointmentMasterModelImpl.getOriginalPreferedDate(),
					csclAppointmentMasterModelImpl.getOriginalPreferedTime()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndDateAndSlot, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndDateAndSlot,
					args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getName(),
					csclAppointmentMasterModelImpl.getEmail(),
					csclAppointmentMasterModelImpl.getAppointee(),
					csclAppointmentMasterModelImpl.getPreferedDate(),
					csclAppointmentMasterModelImpl.getPreferedTime()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndDateAndSlot, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndDateAndSlot,
					args);
			}

			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTimeSlot.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalFromTime(),
					csclAppointmentMasterModelImpl.getOriginalToTime()
				};

				finderCache.removeResult(_finderPathCountByTimeSlot, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTimeSlot, args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getFromTime(),
					csclAppointmentMasterModelImpl.getToTime()
				};

				finderCache.removeResult(_finderPathCountByTimeSlot, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTimeSlot, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclAppointmentMasterImpl.class,
			csclAppointmentMaster.getPrimaryKey(), csclAppointmentMaster,
			false);

		csclAppointmentMaster.resetOriginalValues();

		return csclAppointmentMaster;
	}

	/**
	 * Returns the cscl appointment master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByPrimaryKey(
			primaryKey);

		if (csclAppointmentMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclAppointmentMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclAppointmentMaster;
	}

	/**
	 * Returns the cscl appointment master with the primary key or throws a <code>NoSuchCsclAppointmentMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster findByPrimaryKey(long id_)
		throws NoSuchCsclAppointmentMasterException {

		return findByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns the cscl appointment master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master, or <code>null</code> if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByPrimaryKey(long id_) {
		return fetchByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns all the cscl appointment masters.
	 *
	 * @return the cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclAppointmentMaster> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
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

		List<CsclAppointmentMaster> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLAPPOINTMENTMASTER;

				sql = sql.concat(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Removes all the cscl appointment masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclAppointmentMaster csclAppointmentMaster : findAll()) {
			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters.
	 *
	 * @return the number of cscl appointment masters
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
					_SQL_COUNT_CSCLAPPOINTMENTMASTER);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLAPPOINTMENTMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclAppointmentMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl appointment master persistence.
	 */
	@Activate
	public void activate() {
		CsclAppointmentMasterModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		CsclAppointmentMasterModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByid_ = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByid_",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByid_ = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByid_",
			new String[] {Long.class.getName()},
			CsclAppointmentMasterModelImpl.ID__COLUMN_BITMASK);

		_finderPathCountByid_ = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid_",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByapprover = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapprover",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByapprover = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapprover",
			new String[] {Long.class.getName()},
			CsclAppointmentMasterModelImpl.APPROVER_COLUMN_BITMASK);

		_finderPathCountByapprover = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapprover",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointee",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByappointee",
			new String[] {Integer.class.getName()},
			CsclAppointmentMasterModelImpl.APPOINTEE_COLUMN_BITMASK);

		_finderPathCountByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByappointee",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByappointeeAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointeeAndStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointeeAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByappointeeAndStatus",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			CsclAppointmentMasterModelImpl.STATUS_COLUMN_BITMASK |
			CsclAppointmentMasterModelImpl.APPOINTEE_COLUMN_BITMASK);

		_finderPathCountByappointeeAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByappointeeAndStatus",
			new String[] {Integer.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByappointeeAndDateAndSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByappointeeAndDateAndSlot",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Date.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointeeAndDateAndSlot =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				CsclAppointmentMasterImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByappointeeAndDateAndSlot",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Date.class.getName(),
					String.class.getName()
				},
				CsclAppointmentMasterModelImpl.NAME_COLUMN_BITMASK |
				CsclAppointmentMasterModelImpl.EMAIL_COLUMN_BITMASK |
				CsclAppointmentMasterModelImpl.APPOINTEE_COLUMN_BITMASK |
				CsclAppointmentMasterModelImpl.PREFEREDDATE_COLUMN_BITMASK |
				CsclAppointmentMasterModelImpl.PREFEREDTIME_COLUMN_BITMASK);

		_finderPathCountByappointeeAndDateAndSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByappointeeAndDateAndSlot",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Date.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByTimeSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimeSlot",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTimeSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTimeSlot",
			new String[] {String.class.getName(), String.class.getName()},
			CsclAppointmentMasterModelImpl.FROMTIME_COLUMN_BITMASK |
			CsclAppointmentMasterModelImpl.TOTIME_COLUMN_BITMASK);

		_finderPathCountByTimeSlot = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimeSlot",
			new String[] {String.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclAppointmentMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CsclAppointmentBookingPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.cscl.appointment.booking.model.CsclAppointmentMaster"),
			true);
	}

	@Override
	@Reference(
		target = CsclAppointmentBookingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CsclAppointmentBookingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_CSCLAPPOINTMENTMASTER =
		"SELECT csclAppointmentMaster FROM CsclAppointmentMaster csclAppointmentMaster";

	private static final String _SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE =
		"SELECT csclAppointmentMaster FROM CsclAppointmentMaster csclAppointmentMaster WHERE ";

	private static final String _SQL_COUNT_CSCLAPPOINTMENTMASTER =
		"SELECT COUNT(csclAppointmentMaster) FROM CsclAppointmentMaster csclAppointmentMaster";

	private static final String _SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE =
		"SELECT COUNT(csclAppointmentMaster) FROM CsclAppointmentMaster csclAppointmentMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"csclAppointmentMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclAppointmentMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclAppointmentMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclAppointmentMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"comment"});

	static {
		try {
			Class.forName(
				CsclAppointmentBookingPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}