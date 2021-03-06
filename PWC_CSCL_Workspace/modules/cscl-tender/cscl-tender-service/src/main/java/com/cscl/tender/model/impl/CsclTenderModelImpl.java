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

package com.cscl.tender.model.impl;

import com.cscl.tender.model.CsclTender;
import com.cscl.tender.model.CsclTenderModel;
import com.cscl.tender.model.CsclTenderSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the CsclTender service. Represents a row in the &quot;cscl_tender&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CsclTenderModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CsclTenderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CsclTenderModelImpl
	extends BaseModelImpl<CsclTender> implements CsclTenderModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cscl tender model instance should use the <code>CsclTender</code> interface instead.
	 */
	public static final String TABLE_NAME = "cscl_tender";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"tenderId", Types.BIGINT},
		{"createdById", Types.BIGINT}, {"updatedById", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"title", Types.VARCHAR},
		{"description", Types.CLOB}, {"tenderCategoryId", Types.BIGINT},
		{"publishDate", Types.TIMESTAMP}, {"lastApplyDate", Types.TIMESTAMP},
		{"tenderOpeningDate", Types.TIMESTAMP}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tenderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdById", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("updatedById", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("tenderCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastApplyDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("tenderOpeningDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table cscl_tender (uuid_ VARCHAR(75) null,tenderId LONG not null primary key,createdById LONG,updatedById LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title STRING null,description TEXT null,tenderCategoryId LONG,publishDate DATE null,lastApplyDate DATE null,tenderOpeningDate DATE null,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table cscl_tender";

	public static final String ORDER_BY_JPQL =
		" ORDER BY csclTender.publishDate DESC, csclTender.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY cscl_tender.publishDate DESC, cscl_tender.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long STATUS_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long PUBLISHDATE_COLUMN_BITMASK = 4L;

	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CsclTender toModel(CsclTenderSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CsclTender model = new CsclTenderImpl();

		model.setUuid(soapModel.getUuid());
		model.setTenderId(soapModel.getTenderId());
		model.setCreatedById(soapModel.getCreatedById());
		model.setUpdatedById(soapModel.getUpdatedById());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setTenderCategoryId(soapModel.getTenderCategoryId());
		model.setPublishDate(soapModel.getPublishDate());
		model.setLastApplyDate(soapModel.getLastApplyDate());
		model.setTenderOpeningDate(soapModel.getTenderOpeningDate());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CsclTender> toModels(CsclTenderSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CsclTender> models = new ArrayList<CsclTender>(soapModels.length);

		for (CsclTenderSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CsclTenderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tenderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTenderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tenderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CsclTender.class;
	}

	@Override
	public String getModelClassName() {
		return CsclTender.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CsclTender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CsclTender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclTender, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CsclTender)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CsclTender, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CsclTender, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CsclTender)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CsclTender, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CsclTender, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CsclTender>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CsclTender.class.getClassLoader(), CsclTender.class,
			ModelWrapper.class);

		try {
			Constructor<CsclTender> constructor =
				(Constructor<CsclTender>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CsclTender, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CsclTender, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CsclTender, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CsclTender, Object>>();
		Map<String, BiConsumer<CsclTender, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CsclTender, ?>>();

		attributeGetterFunctions.put("uuid", CsclTender::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<CsclTender, String>)CsclTender::setUuid);
		attributeGetterFunctions.put("tenderId", CsclTender::getTenderId);
		attributeSetterBiConsumers.put(
			"tenderId", (BiConsumer<CsclTender, Long>)CsclTender::setTenderId);
		attributeGetterFunctions.put("createdById", CsclTender::getCreatedById);
		attributeSetterBiConsumers.put(
			"createdById",
			(BiConsumer<CsclTender, Long>)CsclTender::setCreatedById);
		attributeGetterFunctions.put("updatedById", CsclTender::getUpdatedById);
		attributeSetterBiConsumers.put(
			"updatedById",
			(BiConsumer<CsclTender, Long>)CsclTender::setUpdatedById);
		attributeGetterFunctions.put("userName", CsclTender::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CsclTender, String>)CsclTender::setUserName);
		attributeGetterFunctions.put("createDate", CsclTender::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CsclTender, Date>)CsclTender::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CsclTender::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CsclTender, Date>)CsclTender::setModifiedDate);
		attributeGetterFunctions.put("title", CsclTender::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<CsclTender, String>)CsclTender::setTitle);
		attributeGetterFunctions.put("description", CsclTender::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<CsclTender, String>)CsclTender::setDescription);
		attributeGetterFunctions.put(
			"tenderCategoryId", CsclTender::getTenderCategoryId);
		attributeSetterBiConsumers.put(
			"tenderCategoryId",
			(BiConsumer<CsclTender, Long>)CsclTender::setTenderCategoryId);
		attributeGetterFunctions.put("publishDate", CsclTender::getPublishDate);
		attributeSetterBiConsumers.put(
			"publishDate",
			(BiConsumer<CsclTender, Date>)CsclTender::setPublishDate);
		attributeGetterFunctions.put(
			"lastApplyDate", CsclTender::getLastApplyDate);
		attributeSetterBiConsumers.put(
			"lastApplyDate",
			(BiConsumer<CsclTender, Date>)CsclTender::setLastApplyDate);
		attributeGetterFunctions.put(
			"tenderOpeningDate", CsclTender::getTenderOpeningDate);
		attributeSetterBiConsumers.put(
			"tenderOpeningDate",
			(BiConsumer<CsclTender, Date>)CsclTender::setTenderOpeningDate);
		attributeGetterFunctions.put("status", CsclTender::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<CsclTender, Integer>)CsclTender::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTenderId() {
		return _tenderId;
	}

	@Override
	public void setTenderId(long tenderId) {
		_tenderId = tenderId;
	}

	@JSON
	@Override
	public long getCreatedById() {
		return _createdById;
	}

	@Override
	public void setCreatedById(long createdById) {
		_createdById = createdById;
	}

	@JSON
	@Override
	public long getUpdatedById() {
		return _updatedById;
	}

	@Override
	public void setUpdatedById(long updatedById) {
		_updatedById = updatedById;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getTitle(), languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(
				LocalizationUtil.updateLocalization(
					getTitle(), "Title", title, languageId, defaultLanguageId));
		}
		else {
			setTitle(
				LocalizationUtil.removeLocalization(
					getTitle(), "Title", languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(
		Map<Locale, String> titleMap, Locale defaultLocale) {

		if (titleMap == null) {
			return;
		}

		setTitle(
			LocalizationUtil.updateLocalization(
				titleMap, getTitle(), "Title",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public long getTenderCategoryId() {
		return _tenderCategoryId;
	}

	@Override
	public void setTenderCategoryId(long tenderCategoryId) {
		_tenderCategoryId = tenderCategoryId;
	}

	@JSON
	@Override
	public Date getPublishDate() {
		return _publishDate;
	}

	@Override
	public void setPublishDate(Date publishDate) {
		_columnBitmask = -1L;

		_publishDate = publishDate;
	}

	@JSON
	@Override
	public Date getLastApplyDate() {
		return _lastApplyDate;
	}

	@Override
	public void setLastApplyDate(Date lastApplyDate) {
		_lastApplyDate = lastApplyDate;
	}

	@JSON
	@Override
	public Date getTenderOpeningDate() {
		return _tenderOpeningDate;
	}

	@Override
	public void setTenderOpeningDate(Date tenderOpeningDate) {
		_tenderOpeningDate = tenderOpeningDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CsclTender.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			CsclTender.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CsclTender toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CsclTender>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CsclTenderImpl csclTenderImpl = new CsclTenderImpl();

		csclTenderImpl.setUuid(getUuid());
		csclTenderImpl.setTenderId(getTenderId());
		csclTenderImpl.setCreatedById(getCreatedById());
		csclTenderImpl.setUpdatedById(getUpdatedById());
		csclTenderImpl.setUserName(getUserName());
		csclTenderImpl.setCreateDate(getCreateDate());
		csclTenderImpl.setModifiedDate(getModifiedDate());
		csclTenderImpl.setTitle(getTitle());
		csclTenderImpl.setDescription(getDescription());
		csclTenderImpl.setTenderCategoryId(getTenderCategoryId());
		csclTenderImpl.setPublishDate(getPublishDate());
		csclTenderImpl.setLastApplyDate(getLastApplyDate());
		csclTenderImpl.setTenderOpeningDate(getTenderOpeningDate());
		csclTenderImpl.setStatus(getStatus());

		csclTenderImpl.resetOriginalValues();

		return csclTenderImpl;
	}

	@Override
	public int compareTo(CsclTender csclTender) {
		int value = 0;

		value = DateUtil.compareTo(
			getPublishDate(), csclTender.getPublishDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), csclTender.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclTender)) {
			return false;
		}

		CsclTender csclTender = (CsclTender)obj;

		long primaryKey = csclTender.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CsclTenderModelImpl csclTenderModelImpl = this;

		csclTenderModelImpl._originalUuid = csclTenderModelImpl._uuid;

		csclTenderModelImpl._setModifiedDate = false;

		csclTenderModelImpl._originalStatus = csclTenderModelImpl._status;

		csclTenderModelImpl._setOriginalStatus = false;

		csclTenderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CsclTender> toCacheModel() {
		CsclTenderCacheModel csclTenderCacheModel = new CsclTenderCacheModel();

		csclTenderCacheModel.uuid = getUuid();

		String uuid = csclTenderCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			csclTenderCacheModel.uuid = null;
		}

		csclTenderCacheModel.tenderId = getTenderId();

		csclTenderCacheModel.createdById = getCreatedById();

		csclTenderCacheModel.updatedById = getUpdatedById();

		csclTenderCacheModel.userName = getUserName();

		String userName = csclTenderCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			csclTenderCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			csclTenderCacheModel.createDate = createDate.getTime();
		}
		else {
			csclTenderCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			csclTenderCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			csclTenderCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		csclTenderCacheModel.title = getTitle();

		String title = csclTenderCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			csclTenderCacheModel.title = null;
		}

		csclTenderCacheModel.description = getDescription();

		String description = csclTenderCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			csclTenderCacheModel.description = null;
		}

		csclTenderCacheModel.tenderCategoryId = getTenderCategoryId();

		Date publishDate = getPublishDate();

		if (publishDate != null) {
			csclTenderCacheModel.publishDate = publishDate.getTime();
		}
		else {
			csclTenderCacheModel.publishDate = Long.MIN_VALUE;
		}

		Date lastApplyDate = getLastApplyDate();

		if (lastApplyDate != null) {
			csclTenderCacheModel.lastApplyDate = lastApplyDate.getTime();
		}
		else {
			csclTenderCacheModel.lastApplyDate = Long.MIN_VALUE;
		}

		Date tenderOpeningDate = getTenderOpeningDate();

		if (tenderOpeningDate != null) {
			csclTenderCacheModel.tenderOpeningDate =
				tenderOpeningDate.getTime();
		}
		else {
			csclTenderCacheModel.tenderOpeningDate = Long.MIN_VALUE;
		}

		csclTenderCacheModel.status = getStatus();

		return csclTenderCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CsclTender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CsclTender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclTender, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CsclTender)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CsclTender, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CsclTender, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclTender, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CsclTender)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CsclTender>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _tenderId;
	private long _createdById;
	private long _updatedById;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private long _tenderCategoryId;
	private Date _publishDate;
	private Date _lastApplyDate;
	private Date _tenderOpeningDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private CsclTender _escapedModel;

}