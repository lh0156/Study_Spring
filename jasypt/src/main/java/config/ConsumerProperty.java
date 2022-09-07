/*
****************************************************************************
*
* (c) Copyright aim All rights reserved.
*
* This software is proprietary to and embodies the confidential
* technology of aim Possession, use, or copying of this
* software and media is authorized only pursuant to a valid written
* license from aim systems, Inc.
*
****************************************************************************
*/

package config;

/*
*
*****************************************************************************
* PACKAGE : package kr.co.aim.platform.middleware.legacy.kafka.config;
* NAME : Consumer.java
* Description :
*
*****************************************************************************
*/
public class ConsumerProperty {
	private String beanId;
	private String bootstrapServers;
	private String keyDeserializer;
	private String valueDeserializer;

	private String topic;

	private String groupId;
	private String enableAutoCommit;
	private String fetchMinBytes;
	private String requestTimeout;
	private String autoOffsetReset;
	private String sessionTimeout;
	private String maxPartitionFetchBytes;

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId.trim();
	}

	public String getBootstrapServers() {
		return bootstrapServers;
	}

	public void setBootstrapServers(String bootstrapServers) {
		this.bootstrapServers = bootstrapServers.trim();
	}

	public String getKeyDeserializer() {
		return keyDeserializer;
	}

	public void setKeyDeserializer(String keyDeserializer) {
		this.keyDeserializer = keyDeserializer.trim();
	}

	public String getValueDeserializer() {
		return valueDeserializer;
	}

	public void setValueDeserializer(String valueDeserializer) {
		this.valueDeserializer = valueDeserializer.trim();
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic.trim();
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId.trim();
	}

	public String getEnableAutoCommit() {
		return enableAutoCommit;
	}

	public void setEnableAutoCommit(String enableAutoCommit) {
		this.enableAutoCommit = enableAutoCommit.trim();
	}

	public String getFetchMinBytes() {
		return fetchMinBytes;
	}

	public void setFetchMinBytes(String fetchMinBytes) {
		this.fetchMinBytes = fetchMinBytes.trim();
	}

	public String getRequestTimeout() {
		return requestTimeout;
	}

	public void setRequestTimeout(String requestTimeout) {
		this.requestTimeout = requestTimeout.trim();
	}

	public String getAutoOffsetReset() {
		return autoOffsetReset;
	}

	public void setAutoOffsetReset(String autoOffsetReset) {
		this.autoOffsetReset = autoOffsetReset.trim();
	}

	public String getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(String sessionTimeout) {
		this.sessionTimeout = sessionTimeout.trim();
	}

	public String getMaxPartitionFetchBytes() {
		return maxPartitionFetchBytes;
	}

	public void setMaxPartitionFetchBytes(String maxPartitionFetchBytes) {
		this.maxPartitionFetchBytes = maxPartitionFetchBytes.trim();
	}

}
