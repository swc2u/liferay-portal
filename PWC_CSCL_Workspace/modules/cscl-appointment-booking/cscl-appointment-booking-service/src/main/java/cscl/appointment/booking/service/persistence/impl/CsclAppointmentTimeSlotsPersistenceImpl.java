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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.exception.NoSuchCsclAppointmentTimeSlotsException;
import cscl.appointment.booking.model.CsclAppointmentTimeSlots;
import cscl.appointment.booking.model.impl.CsclAppointmentTimeSlotsImpl;
import cscl.appointment.booking.model.impl.CsclAppointmentTimeSlotsModelImpl;
import cscl.appointment.booking.service.persistence.CsclAppointmentTimeSlotsPersistence;
import cscl.appointment.booking.service.persistence.impl.constants.CsclAppointmentBookingPersistenceConstants;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl appointment time slots service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @generated
 */
@Component(service = CsclAppointmentTimeSlotsPersistence.class)
public class CsclAppointmentTimeSlotsPersistenceImpl
	extends BasePersistenceImpl<CsclAppointmentTimeSlots>
	implements CsclAppointmentTimeSlotsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclAppointmentTimeSlotsUtil</code> to access the cscl appointment time slots persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclAppointmentTimeSlotsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CsclAppointmentTimeSlotsPersistenceImpl() {
		setModelClass(CsclAppointmentTimeSlots.class);

		setModelImplClass(CsclAppointmentTimeSlotsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl appointment time slots in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentTimeSlots the cscl appointment time slots
	 */
	@Override
	public void cacheResult(CsclAppointmentTimeSlots csclAppointmentTimeSlots) {
		entityCache.putResult(
			entityCacheEnabled, CsclAppointmentTimeSlotsImpl.class,
			csclAppointmentTimeSlots.getPrimaryKey(), csclAppointmentTimeSlots);

		csclAppointmentTimeSlots.resetOriginalValues();
	}

	/**
	 * Caches the cscl appointment time slotses in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentTimeSlotses the cscl appointment time slotses
	 */
	@Override
	public void cacheResult(
		List<CsclAppointmentTimeSlots> csclAppointmentTimeSlotses) {

		for (CsclAppointmentTimeSlots csclAppointmentTimeSlots :
				csclAppointmentTimeSlotses) {

			if (entityCache.getResult(
					entityCacheEnabled, CsclAppointmentTimeSlotsImpl.class,
					csclAppointmentTimeSlots.getPrimaryKey()) == null) {

				cacheResult(csclAppointmentTimeSlots);
			}
			else {
				csclAppointmentTimeSlots.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl appointment time slotses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclAppointmentTimeSlotsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl appointment time slots.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclAppointmentTimeSlots csclAppointmentTimeSlots) {
		entityCache.removeResult(
			entityCacheEnabled, CsclAppointmentTimeSlotsImpl.class,
			csclAppointmentTimeSlots.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CsclAppointmentTimeSlots> csclAppointmentTimeSlotses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclAppointmentTimeSlots csclAppointmentTimeSlots :
				csclAppointmentTimeSlotses) {

			entityCache.removeResult(
				entityCacheEnabled, CsclAppointmentTimeSlotsImpl.class,
				csclAppointmentTimeSlots.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CsclAppointmentTimeSlotsImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new cscl appointment time slots with the primary key. Does not add the cscl appointment time slots to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment time slots
	 * @return the new cscl appointment time slots
	 */
	@Override
	public CsclAppointmentTimeSlots create(long id_) {
		CsclAppointmentTimeSlots csclAppointmentTimeSlots =
			new CsclAppointmentTimeSlotsImpl();

		csclAppointmentTimeSlots.setNew(true);
		csclAppointmentTimeSlots.setPrimaryKey(id_);

		return csclAppointmentTimeSlots;
	}

	/**
	 * Removes the cscl appointment time slots with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment time slots
	 * @return the cscl appointment time slots that was removed
	 * @throws NoSuchCsclAppointmentTimeSlotsException if a cscl appointment time slots with the primary key could not be found
	 */
	@Override
	public CsclAppointmentTimeSlots remove(long id_)
		throws NoSuchCsclAppointmentTimeSlotsException {

		return remove((Serializable)id_);
	}

	/**
	 * Removes the cscl appointment time slots with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl appointment time slots
	 * @return the cscl appointment time slots that was removed
	 * @throws NoSuchCsclAppointmentTimeSlotsException if a cscl appointment time slots with the primary key could not be found
	 */
	@Override
	public CsclAppointmentTimeSlots remove(Serializable primaryKey)
		throws NoSuchCsclAppointmentTimeSlotsException {

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentTimeSlots csclAppointmentTimeSlots =
				(CsclAppointmentTimeSlots)session.get(
					CsclAppointmentTimeSlotsImpl.class, primaryKey);

			if (csclAppointmentTimeSlots == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclAppointmentTimeSlotsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclAppointmentTimeSlots);
		}
		catch (NoSuchCsclAppointmentTimeSlotsException noSuchEntityException) {
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
	protected CsclAppointmentTimeSlots removeImpl(
		CsclAppointmentTimeSlots csclAppointmentTimeSlots) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclAppointmentTimeSlots)) {
				csclAppointmentTimeSlots =
					(CsclAppointmentTimeSlots)session.get(
						CsclAppointmentTimeSlotsImpl.class,
						csclAppointmentTimeSlots.getPrimaryKeyObj());
			}

			if (csclAppointmentTimeSlots != null) {
				session.delete(csclAppointmentTimeSlots);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (csclAppointmentTimeSlots != null) {
			clearCache(csclAppointmentTimeSlots);
		}

		return csclAppointmentTimeSlots;
	}

	@Override
	public CsclAppointmentTimeSlots updateImpl(
		CsclAppointmentTimeSlots csclAppointmentTimeSlots) {

		boolean isNew = csclAppointmentTimeSlots.isNew();

		Session session = null;

		try {
			session = openSession();

			if (csclAppointmentTimeSlots.isNew()) {
				session.save(csclAppointmentTimeSlots);

				csclAppointmentTimeSlots.setNew(false);
			}
			else {
				csclAppointmentTimeSlots =
					(CsclAppointmentTimeSlots)session.merge(
						csclAppointmentTimeSlots);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, CsclAppointmentTimeSlotsImpl.class,
			csclAppointmentTimeSlots.getPrimaryKey(), csclAppointmentTimeSlots,
			false);

		csclAppointmentTimeSlots.resetOriginalValues();

		return csclAppointmentTimeSlots;
	}

	/**
	 * Returns the cscl appointment time slots with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl appointment time slots
	 * @return the cscl appointment time slots
	 * @throws NoSuchCsclAppointmentTimeSlotsException if a cscl appointment time slots with the primary key could not be found
	 */
	@Override
	public CsclAppointmentTimeSlots findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclAppointmentTimeSlotsException {

		CsclAppointmentTimeSlots csclAppointmentTimeSlots = fetchByPrimaryKey(
			primaryKey);

		if (csclAppointmentTimeSlots == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclAppointmentTimeSlotsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclAppointmentTimeSlots;
	}

	/**
	 * Returns the cscl appointment time slots with the primary key or throws a <code>NoSuchCsclAppointmentTimeSlotsException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment time slots
	 * @return the cscl appointment time slots
	 * @throws NoSuchCsclAppointmentTimeSlotsException if a cscl appointment time slots with the primary key could not be found
	 */
	@Override
	public CsclAppointmentTimeSlots findByPrimaryKey(long id_)
		throws NoSuchCsclAppointmentTimeSlotsException {

		return findByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns the cscl appointment time slots with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment time slots
	 * @return the cscl appointment time slots, or <code>null</code> if a cscl appointment time slots with the primary key could not be found
	 */
	@Override
	public CsclAppointmentTimeSlots fetchByPrimaryKey(long id_) {
		return fetchByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns all the cscl appointment time slotses.
	 *
	 * @return the cscl appointment time slotses
	 */
	@Override
	public List<CsclAppointmentTimeSlots> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl appointment time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment time slotses
	 * @param end the upper bound of the range of cscl appointment time slotses (not inclusive)
	 * @return the range of cscl appointment time slotses
	 */
	@Override
	public List<CsclAppointmentTimeSlots> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl appointment time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment time slotses
	 * @param end the upper bound of the range of cscl appointment time slotses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl appointment time slotses
	 */
	@Override
	public List<CsclAppointmentTimeSlots> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentTimeSlots> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cscl appointment time slotses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsclAppointmentTimeSlotsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment time slotses
	 * @param end the upper bound of the range of cscl appointment time slotses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl appointment time slotses
	 */
	@Override
	public List<CsclAppointmentTimeSlots> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentTimeSlots> orderByComparator,
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

		List<CsclAppointmentTimeSlots> list = null;

		if (useFinderCache) {
			list = (List<CsclAppointmentTimeSlots>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CSCLAPPOINTMENTTIMESLOTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLAPPOINTMENTTIMESLOTS;

				sql = sql.concat(
					CsclAppointmentTimeSlotsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CsclAppointmentTimeSlots>)QueryUtil.list(
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
	 * Removes all the cscl appointment time slotses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclAppointmentTimeSlots csclAppointmentTimeSlots : findAll()) {
			remove(csclAppointmentTimeSlots);
		}
	}

	/**
	 * Returns the number of cscl appointment time slotses.
	 *
	 * @return the number of cscl appointment time slotses
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
					_SQL_COUNT_CSCLAPPOINTMENTTIMESLOTS);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLAPPOINTMENTTIMESLOTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclAppointmentTimeSlotsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl appointment time slots persistence.
	 */
	@Activate
	public void activate() {
		CsclAppointmentTimeSlotsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		CsclAppointmentTimeSlotsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentTimeSlotsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentTimeSlotsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclAppointmentTimeSlotsImpl.class.getName());
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
				"value.object.column.bitmask.enabled.cscl.appointment.booking.model.CsclAppointmentTimeSlots"),
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

	private static final String _SQL_SELECT_CSCLAPPOINTMENTTIMESLOTS =
		"SELECT csclAppointmentTimeSlots FROM CsclAppointmentTimeSlots csclAppointmentTimeSlots";

	private static final String _SQL_COUNT_CSCLAPPOINTMENTTIMESLOTS =
		"SELECT COUNT(csclAppointmentTimeSlots) FROM CsclAppointmentTimeSlots csclAppointmentTimeSlots";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"csclAppointmentTimeSlots.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclAppointmentTimeSlots exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclAppointmentTimeSlotsPersistenceImpl.class);

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