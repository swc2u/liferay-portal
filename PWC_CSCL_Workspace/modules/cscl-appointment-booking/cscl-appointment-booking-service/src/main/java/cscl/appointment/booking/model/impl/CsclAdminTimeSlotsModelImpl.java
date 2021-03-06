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

package cscl.appointment.booking.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import cscl.appointment.booking.model.CsclAdminTimeSlots;
import cscl.appointment.booking.model.CsclAdminTimeSlotsModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CsclAdminTimeSlots service. Represents a row in the &quot;Cscl_Admin_TimeSlots&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CsclAdminTimeSlotsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CsclAdminTimeSlotsImpl}.
 * </p>
 *
 * @author @rnab
 * @see CsclAdminTimeSlotsImpl
 * @generated
 */
public class CsclAdminTimeSlotsModelImpl
	extends BaseModelImpl<CsclAdminTimeSlots>
	implements CsclAdminTimeSlotsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cscl admin time slots model instance should use the <code>CsclAdminTimeSlots</code> interface instead.
	 */
	public static final String TABLE_NAME = "Cscl_Admin_TimeSlots";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"Timeslot", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("Timeslot", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Cscl_Admin_TimeSlots (id_ LONG not null primary key,Timeslot VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Cscl_Admin_TimeSlots";

	public static final String ORDER_BY_JPQL =
		" ORDER BY csclAdminTimeSlots.id_ ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Cscl_Admin_TimeSlots.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public CsclAdminTimeSlotsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id_;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CsclAdminTimeSlots.class;
	}

	@Override
	public String getModelClassName() {
		return CsclAdminTimeSlots.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CsclAdminTimeSlots, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CsclAdminTimeSlots, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclAdminTimeSlots, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CsclAdminTimeSlots)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CsclAdminTimeSlots, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CsclAdminTimeSlots, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CsclAdminTimeSlots)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CsclAdminTimeSlots, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CsclAdminTimeSlots, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CsclAdminTimeSlots>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CsclAdminTimeSlots.class.getClassLoader(), CsclAdminTimeSlots.class,
			ModelWrapper.class);

		try {
			Constructor<CsclAdminTimeSlots> constructor =
				(Constructor<CsclAdminTimeSlots>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CsclAdminTimeSlots, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CsclAdminTimeSlots, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CsclAdminTimeSlots, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CsclAdminTimeSlots, Object>>();
		Map<String, BiConsumer<CsclAdminTimeSlots, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CsclAdminTimeSlots, ?>>();

		attributeGetterFunctions.put("id_", CsclAdminTimeSlots::getId_);
		attributeSetterBiConsumers.put(
			"id_",
			(BiConsumer<CsclAdminTimeSlots, Long>)CsclAdminTimeSlots::setId_);
		attributeGetterFunctions.put(
			"Timeslot", CsclAdminTimeSlots::getTimeslot);
		attributeSetterBiConsumers.put(
			"Timeslot",
			(BiConsumer<CsclAdminTimeSlots, String>)
				CsclAdminTimeSlots::setTimeslot);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId_() {
		return _id_;
	}

	@Override
	public void setId_(long id_) {
		_id_ = id_;
	}

	@Override
	public String getTimeslot() {
		if (_Timeslot == null) {
			return "";
		}
		else {
			return _Timeslot;
		}
	}

	@Override
	public void setTimeslot(String Timeslot) {
		_Timeslot = Timeslot;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CsclAdminTimeSlots.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CsclAdminTimeSlots toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CsclAdminTimeSlots>
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
		CsclAdminTimeSlotsImpl csclAdminTimeSlotsImpl =
			new CsclAdminTimeSlotsImpl();

		csclAdminTimeSlotsImpl.setId_(getId_());
		csclAdminTimeSlotsImpl.setTimeslot(getTimeslot());

		csclAdminTimeSlotsImpl.resetOriginalValues();

		return csclAdminTimeSlotsImpl;
	}

	@Override
	public int compareTo(CsclAdminTimeSlots csclAdminTimeSlots) {
		long primaryKey = csclAdminTimeSlots.getPrimaryKey();

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

		if (!(obj instanceof CsclAdminTimeSlots)) {
			return false;
		}

		CsclAdminTimeSlots csclAdminTimeSlots = (CsclAdminTimeSlots)obj;

		long primaryKey = csclAdminTimeSlots.getPrimaryKey();

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
	}

	@Override
	public CacheModel<CsclAdminTimeSlots> toCacheModel() {
		CsclAdminTimeSlotsCacheModel csclAdminTimeSlotsCacheModel =
			new CsclAdminTimeSlotsCacheModel();

		csclAdminTimeSlotsCacheModel.id_ = getId_();

		csclAdminTimeSlotsCacheModel.Timeslot = getTimeslot();

		String Timeslot = csclAdminTimeSlotsCacheModel.Timeslot;

		if ((Timeslot != null) && (Timeslot.length() == 0)) {
			csclAdminTimeSlotsCacheModel.Timeslot = null;
		}

		return csclAdminTimeSlotsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CsclAdminTimeSlots, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CsclAdminTimeSlots, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclAdminTimeSlots, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CsclAdminTimeSlots)this));
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
		Map<String, Function<CsclAdminTimeSlots, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CsclAdminTimeSlots, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclAdminTimeSlots, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CsclAdminTimeSlots)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CsclAdminTimeSlots>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _id_;
	private String _Timeslot;
	private CsclAdminTimeSlots _escapedModel;

}