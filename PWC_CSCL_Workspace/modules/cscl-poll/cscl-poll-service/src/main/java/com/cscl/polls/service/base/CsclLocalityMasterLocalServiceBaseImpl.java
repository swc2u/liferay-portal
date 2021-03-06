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

package com.cscl.polls.service.base;

import com.cscl.polls.model.CsclLocalityMaster;
import com.cscl.polls.service.CsclLocalityMasterLocalService;
import com.cscl.polls.service.persistence.CsclLocalityMasterPersistence;

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
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the cscl locality master local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.cscl.polls.service.impl.CsclLocalityMasterLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.cscl.polls.service.impl.CsclLocalityMasterLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class CsclLocalityMasterLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CsclLocalityMasterLocalService, AopService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CsclLocalityMasterLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.cscl.polls.service.CsclLocalityMasterLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cscl locality master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 * @return the cscl locality master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CsclLocalityMaster addCsclLocalityMaster(
		CsclLocalityMaster csclLocalityMaster) {

		csclLocalityMaster.setNew(true);

		return csclLocalityMasterPersistence.update(csclLocalityMaster);
	}

	/**
	 * Creates a new cscl locality master with the primary key. Does not add the cscl locality master to the database.
	 *
	 * @param localityId the primary key for the new cscl locality master
	 * @return the new cscl locality master
	 */
	@Override
	@Transactional(enabled = false)
	public CsclLocalityMaster createCsclLocalityMaster(long localityId) {
		return csclLocalityMasterPersistence.create(localityId);
	}

	/**
	 * Deletes the cscl locality master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master that was removed
	 * @throws PortalException if a cscl locality master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CsclLocalityMaster deleteCsclLocalityMaster(long localityId)
		throws PortalException {

		return csclLocalityMasterPersistence.remove(localityId);
	}

	/**
	 * Deletes the cscl locality master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 * @return the cscl locality master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CsclLocalityMaster deleteCsclLocalityMaster(
		CsclLocalityMaster csclLocalityMaster) {

		return csclLocalityMasterPersistence.remove(csclLocalityMaster);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CsclLocalityMaster.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return csclLocalityMasterPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return csclLocalityMasterPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return csclLocalityMasterPersistence.findWithDynamicQuery(
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
		return csclLocalityMasterPersistence.countWithDynamicQuery(
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

		return csclLocalityMasterPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CsclLocalityMaster fetchCsclLocalityMaster(long localityId) {
		return csclLocalityMasterPersistence.fetchByPrimaryKey(localityId);
	}

	/**
	 * Returns the cscl locality master with the primary key.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master
	 * @throws PortalException if a cscl locality master with the primary key could not be found
	 */
	@Override
	public CsclLocalityMaster getCsclLocalityMaster(long localityId)
		throws PortalException {

		return csclLocalityMasterPersistence.findByPrimaryKey(localityId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			csclLocalityMasterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CsclLocalityMaster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("localityId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			csclLocalityMasterLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(CsclLocalityMaster.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("localityId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			csclLocalityMasterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CsclLocalityMaster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("localityId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return csclLocalityMasterLocalService.deleteCsclLocalityMaster(
			(CsclLocalityMaster)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return csclLocalityMasterPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cscl locality masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @return the range of cscl locality masters
	 */
	@Override
	public List<CsclLocalityMaster> getCsclLocalityMasters(int start, int end) {
		return csclLocalityMasterPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cscl locality masters.
	 *
	 * @return the number of cscl locality masters
	 */
	@Override
	public int getCsclLocalityMastersCount() {
		return csclLocalityMasterPersistence.countAll();
	}

	/**
	 * Updates the cscl locality master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 * @return the cscl locality master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CsclLocalityMaster updateCsclLocalityMaster(
		CsclLocalityMaster csclLocalityMaster) {

		return csclLocalityMasterPersistence.update(csclLocalityMaster);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CsclLocalityMasterLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		csclLocalityMasterLocalService =
			(CsclLocalityMasterLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CsclLocalityMasterLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CsclLocalityMaster.class;
	}

	protected String getModelClassName() {
		return CsclLocalityMaster.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				csclLocalityMasterPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	protected CsclLocalityMasterLocalService csclLocalityMasterLocalService;

	@Reference
	protected CsclLocalityMasterPersistence csclLocalityMasterPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}