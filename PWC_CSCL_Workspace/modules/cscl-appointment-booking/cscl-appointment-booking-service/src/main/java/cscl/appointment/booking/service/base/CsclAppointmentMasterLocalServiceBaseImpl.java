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

package cscl.appointment.booking.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalService;
import cscl.appointment.booking.service.persistence.CsclAppointmentMasterPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cscl appointment master local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link cscl.appointment.booking.service.impl.CsclAppointmentMasterLocalServiceImpl}.
 * </p>
 *
 * @author @rnab
 * @see cscl.appointment.booking.service.impl.CsclAppointmentMasterLocalServiceImpl
 * @generated
 */
public abstract class CsclAppointmentMasterLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CsclAppointmentMasterLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CsclAppointmentMasterLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cscl appointment master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CsclAppointmentMaster addCsclAppointmentMaster(
		CsclAppointmentMaster csclAppointmentMaster) {

		csclAppointmentMaster.setNew(true);

		return csclAppointmentMasterPersistence.update(csclAppointmentMaster);
	}

	/**
	 * Creates a new cscl appointment master with the primary key. Does not add the cscl appointment master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment master
	 * @return the new cscl appointment master
	 */
	@Override
	@Transactional(enabled = false)
	public CsclAppointmentMaster createCsclAppointmentMaster(long id_) {
		return csclAppointmentMasterPersistence.create(id_);
	}

	/**
	 * Deletes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws PortalException if a cscl appointment master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CsclAppointmentMaster deleteCsclAppointmentMaster(long id_)
		throws PortalException {

		return csclAppointmentMasterPersistence.remove(id_);
	}

	/**
	 * Deletes the cscl appointment master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CsclAppointmentMaster deleteCsclAppointmentMaster(
		CsclAppointmentMaster csclAppointmentMaster) {

		return csclAppointmentMasterPersistence.remove(csclAppointmentMaster);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CsclAppointmentMaster.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return csclAppointmentMasterPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return csclAppointmentMasterPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return csclAppointmentMasterPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return csclAppointmentMasterPersistence.countWithDynamicQuery(
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
		DynamicQuery dynamicQuery, Projection projection) {

		return csclAppointmentMasterPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CsclAppointmentMaster fetchCsclAppointmentMaster(long id_) {
		return csclAppointmentMasterPersistence.fetchByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl appointment master with the primary key.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws PortalException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster getCsclAppointmentMaster(long id_)
		throws PortalException {

		return csclAppointmentMasterPersistence.findByPrimaryKey(id_);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			csclAppointmentMasterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CsclAppointmentMaster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id_");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			csclAppointmentMasterLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CsclAppointmentMaster.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id_");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			csclAppointmentMasterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CsclAppointmentMaster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id_");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return csclAppointmentMasterLocalService.deleteCsclAppointmentMaster(
			(CsclAppointmentMaster)persistedModel);
	}

	public BasePersistence<CsclAppointmentMaster> getBasePersistence() {
		return csclAppointmentMasterPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return csclAppointmentMasterPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> getCsclAppointmentMasters(
		int start, int end) {

		return csclAppointmentMasterPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cscl appointment masters.
	 *
	 * @return the number of cscl appointment masters
	 */
	@Override
	public int getCsclAppointmentMastersCount() {
		return csclAppointmentMasterPersistence.countAll();
	}

	/**
	 * Updates the cscl appointment master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CsclAppointmentMaster updateCsclAppointmentMaster(
		CsclAppointmentMaster csclAppointmentMaster) {

		return csclAppointmentMasterPersistence.update(csclAppointmentMaster);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CsclAppointmentMasterLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		csclAppointmentMasterLocalService =
			(CsclAppointmentMasterLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CsclAppointmentMasterLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CsclAppointmentMaster.class;
	}

	protected String getModelClassName() {
		return CsclAppointmentMaster.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				csclAppointmentMasterPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	protected CsclAppointmentMasterLocalService
		csclAppointmentMasterLocalService;

	@Reference
	protected CsclAppointmentMasterPersistence csclAppointmentMasterPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}