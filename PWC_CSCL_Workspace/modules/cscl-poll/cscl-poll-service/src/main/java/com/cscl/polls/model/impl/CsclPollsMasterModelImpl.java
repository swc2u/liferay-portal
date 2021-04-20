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

package com.cscl.polls.model.impl;

import com.cscl.polls.model.CsclPollsMaster;
import com.cscl.polls.model.CsclPollsMasterModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the CsclPollsMaster service. Represents a row in the &quot;cscl_polls_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CsclPollsMasterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CsclPollsMasterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsMasterImpl
 * @generated
 */
@ProviderType
public class CsclPollsMasterModelImpl
	extends BaseModelImpl<CsclPollsMaster> implements CsclPollsMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cscl polls master model instance should use the <code>CsclPollsMaster</code> interface instead.
	 */
	public static final String TABLE_NAME = "cscl_polls_master";

	public static final Object[][] TABLE_COLUMNS = {
		{"entryId", Types.BIGINT}, {"voteId", Types.BIGINT},
		{"questionId", Types.BIGINT}, {"choiceId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"email", Types.VARCHAR},
		{"mobile", Types.VARCHAR}, {"birthDate", Types.TIMESTAMP},
		{"sex", Types.VARCHAR}, {"locality", Types.INTEGER},
		{"createdDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("entryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("voteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("questionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("choiceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("sex", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("locality", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table cscl_polls_master (entryId LONG not null primary key,voteId LONG,questionId LONG,choiceId LONG,name VARCHAR(75) null,email VARCHAR(75) null,mobile VARCHAR(10) null,birthDate DATE null,sex VARCHAR(75) null,locality INTEGER,createdDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table cscl_polls_master";

	public static final String ORDER_BY_JPQL =
		" ORDER BY csclPollsMaster.entryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY cscl_polls_master.entryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long BIRTHDATE_COLUMN_BITMASK = 1L;

	public static final long LOCALITY_COLUMN_BITMASK = 2L;

	public static final long QUESTIONID_COLUMN_BITMASK = 4L;

	public static final long SEX_COLUMN_BITMASK = 8L;

	public static final long ENTRYID_COLUMN_BITMASK = 16L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public CsclPollsMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _entryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CsclPollsMaster.class;
	}

	@Override
	public String getModelClassName() {
		return CsclPollsMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CsclPollsMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CsclPollsMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclPollsMaster, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CsclPollsMaster)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CsclPollsMaster, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CsclPollsMaster, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CsclPollsMaster)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CsclPollsMaster, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CsclPollsMaster, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CsclPollsMaster>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CsclPollsMaster.class.getClassLoader(), CsclPollsMaster.class,
			ModelWrapper.class);

		try {
			Constructor<CsclPollsMaster> constructor =
				(Constructor<CsclPollsMaster>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CsclPollsMaster, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CsclPollsMaster, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CsclPollsMaster, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CsclPollsMaster, Object>>();
		Map<String, BiConsumer<CsclPollsMaster, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CsclPollsMaster, ?>>();

		attributeGetterFunctions.put("entryId", CsclPollsMaster::getEntryId);
		attributeSetterBiConsumers.put(
			"entryId",
			(BiConsumer<CsclPollsMaster, Long>)CsclPollsMaster::setEntryId);
		attributeGetterFunctions.put("voteId", CsclPollsMaster::getVoteId);
		attributeSetterBiConsumers.put(
			"voteId",
			(BiConsumer<CsclPollsMaster, Long>)CsclPollsMaster::setVoteId);
		attributeGetterFunctions.put(
			"questionId", CsclPollsMaster::getQuestionId);
		attributeSetterBiConsumers.put(
			"questionId",
			(BiConsumer<CsclPollsMaster, Long>)CsclPollsMaster::setQuestionId);
		attributeGetterFunctions.put("choiceId", CsclPollsMaster::getChoiceId);
		attributeSetterBiConsumers.put(
			"choiceId",
			(BiConsumer<CsclPollsMaster, Long>)CsclPollsMaster::setChoiceId);
		attributeGetterFunctions.put("name", CsclPollsMaster::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CsclPollsMaster, String>)CsclPollsMaster::setName);
		attributeGetterFunctions.put("email", CsclPollsMaster::getEmail);
		attributeSetterBiConsumers.put(
			"email",
			(BiConsumer<CsclPollsMaster, String>)CsclPollsMaster::setEmail);
		attributeGetterFunctions.put("mobile", CsclPollsMaster::getMobile);
		attributeSetterBiConsumers.put(
			"mobile",
			(BiConsumer<CsclPollsMaster, String>)CsclPollsMaster::setMobile);
		attributeGetterFunctions.put(
			"birthDate", CsclPollsMaster::getBirthDate);
		attributeSetterBiConsumers.put(
			"birthDate",
			(BiConsumer<CsclPollsMaster, Date>)CsclPollsMaster::setBirthDate);
		attributeGetterFunctions.put("sex", CsclPollsMaster::getSex);
		attributeSetterBiConsumers.put(
			"sex",
			(BiConsumer<CsclPollsMaster, String>)CsclPollsMaster::setSex);
		attributeGetterFunctions.put("locality", CsclPollsMaster::getLocality);
		attributeSetterBiConsumers.put(
			"locality",
			(BiConsumer<CsclPollsMaster, Integer>)CsclPollsMaster::setLocality);
		attributeGetterFunctions.put(
			"createdDate", CsclPollsMaster::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<CsclPollsMaster, Date>)CsclPollsMaster::setCreatedDate);
		attributeGetterFunctions.put(
			"modifiedDate", CsclPollsMaster::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CsclPollsMaster, Date>)
				CsclPollsMaster::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getEntryId() {
		return _entryId;
	}

	@Override
	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	@Override
	public long getVoteId() {
		return _voteId;
	}

	@Override
	public void setVoteId(long voteId) {
		_voteId = voteId;
	}

	@Override
	public long getQuestionId() {
		return _questionId;
	}

	@Override
	public void setQuestionId(long questionId) {
		_columnBitmask |= QUESTIONID_COLUMN_BITMASK;

		if (!_setOriginalQuestionId) {
			_setOriginalQuestionId = true;

			_originalQuestionId = _questionId;
		}

		_questionId = questionId;
	}

	public long getOriginalQuestionId() {
		return _originalQuestionId;
	}

	@Override
	public long getChoiceId() {
		return _choiceId;
	}

	@Override
	public void setChoiceId(long choiceId) {
		_choiceId = choiceId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getMobile() {
		if (_mobile == null) {
			return "";
		}
		else {
			return _mobile;
		}
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	@Override
	public Date getBirthDate() {
		return _birthDate;
	}

	@Override
	public void setBirthDate(Date birthDate) {
		_columnBitmask |= BIRTHDATE_COLUMN_BITMASK;

		if (_originalBirthDate == null) {
			_originalBirthDate = _birthDate;
		}

		_birthDate = birthDate;
	}

	public Date getOriginalBirthDate() {
		return _originalBirthDate;
	}

	@Override
	public String getSex() {
		if (_sex == null) {
			return "";
		}
		else {
			return _sex;
		}
	}

	@Override
	public void setSex(String sex) {
		_columnBitmask |= SEX_COLUMN_BITMASK;

		if (_originalSex == null) {
			_originalSex = _sex;
		}

		_sex = sex;
	}

	public String getOriginalSex() {
		return GetterUtil.getString(_originalSex);
	}

	@Override
	public int getLocality() {
		return _locality;
	}

	@Override
	public void setLocality(int locality) {
		_columnBitmask |= LOCALITY_COLUMN_BITMASK;

		if (!_setOriginalLocality) {
			_setOriginalLocality = true;

			_originalLocality = _locality;
		}

		_locality = locality;
	}

	public int getOriginalLocality() {
		return _originalLocality;
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CsclPollsMaster.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CsclPollsMaster toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CsclPollsMaster>
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
		CsclPollsMasterImpl csclPollsMasterImpl = new CsclPollsMasterImpl();

		csclPollsMasterImpl.setEntryId(getEntryId());
		csclPollsMasterImpl.setVoteId(getVoteId());
		csclPollsMasterImpl.setQuestionId(getQuestionId());
		csclPollsMasterImpl.setChoiceId(getChoiceId());
		csclPollsMasterImpl.setName(getName());
		csclPollsMasterImpl.setEmail(getEmail());
		csclPollsMasterImpl.setMobile(getMobile());
		csclPollsMasterImpl.setBirthDate(getBirthDate());
		csclPollsMasterImpl.setSex(getSex());
		csclPollsMasterImpl.setLocality(getLocality());
		csclPollsMasterImpl.setCreatedDate(getCreatedDate());
		csclPollsMasterImpl.setModifiedDate(getModifiedDate());

		csclPollsMasterImpl.resetOriginalValues();

		return csclPollsMasterImpl;
	}

	@Override
	public int compareTo(CsclPollsMaster csclPollsMaster) {
		long primaryKey = csclPollsMaster.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclPollsMaster)) {
			return false;
		}

		CsclPollsMaster csclPollsMaster = (CsclPollsMaster)obj;

		long primaryKey = csclPollsMaster.getPrimaryKey();

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
		CsclPollsMasterModelImpl csclPollsMasterModelImpl = this;

		csclPollsMasterModelImpl._originalQuestionId =
			csclPollsMasterModelImpl._questionId;

		csclPollsMasterModelImpl._setOriginalQuestionId = false;

		csclPollsMasterModelImpl._originalBirthDate =
			csclPollsMasterModelImpl._birthDate;

		csclPollsMasterModelImpl._originalSex = csclPollsMasterModelImpl._sex;

		csclPollsMasterModelImpl._originalLocality =
			csclPollsMasterModelImpl._locality;

		csclPollsMasterModelImpl._setOriginalLocality = false;

		csclPollsMasterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CsclPollsMaster> toCacheModel() {
		CsclPollsMasterCacheModel csclPollsMasterCacheModel =
			new CsclPollsMasterCacheModel();

		csclPollsMasterCacheModel.entryId = getEntryId();

		csclPollsMasterCacheModel.voteId = getVoteId();

		csclPollsMasterCacheModel.questionId = getQuestionId();

		csclPollsMasterCacheModel.choiceId = getChoiceId();

		csclPollsMasterCacheModel.name = getName();

		String name = csclPollsMasterCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			csclPollsMasterCacheModel.name = null;
		}

		csclPollsMasterCacheModel.email = getEmail();

		String email = csclPollsMasterCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			csclPollsMasterCacheModel.email = null;
		}

		csclPollsMasterCacheModel.mobile = getMobile();

		String mobile = csclPollsMasterCacheModel.mobile;

		if ((mobile != null) && (mobile.length() == 0)) {
			csclPollsMasterCacheModel.mobile = null;
		}

		Date birthDate = getBirthDate();

		if (birthDate != null) {
			csclPollsMasterCacheModel.birthDate = birthDate.getTime();
		}
		else {
			csclPollsMasterCacheModel.birthDate = Long.MIN_VALUE;
		}

		csclPollsMasterCacheModel.sex = getSex();

		String sex = csclPollsMasterCacheModel.sex;

		if ((sex != null) && (sex.length() == 0)) {
			csclPollsMasterCacheModel.sex = null;
		}

		csclPollsMasterCacheModel.locality = getLocality();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			csclPollsMasterCacheModel.createdDate = createdDate.getTime();
		}
		else {
			csclPollsMasterCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			csclPollsMasterCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			csclPollsMasterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return csclPollsMasterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CsclPollsMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CsclPollsMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclPollsMaster, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CsclPollsMaster)this));
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
		Map<String, Function<CsclPollsMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CsclPollsMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclPollsMaster, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CsclPollsMaster)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CsclPollsMaster>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _entryId;
	private long _voteId;
	private long _questionId;
	private long _originalQuestionId;
	private boolean _setOriginalQuestionId;
	private long _choiceId;
	private String _name;
	private String _email;
	private String _mobile;
	private Date _birthDate;
	private Date _originalBirthDate;
	private String _sex;
	private String _originalSex;
	private int _locality;
	private int _originalLocality;
	private boolean _setOriginalLocality;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private CsclPollsMaster _escapedModel;

}