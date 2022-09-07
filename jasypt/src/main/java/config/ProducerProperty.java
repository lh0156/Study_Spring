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
* NAME : Producer.java
* Description :
*
*****************************************************************************
*/
public class ProducerProperty {
	private String beanId;
	private String bootstrapServers;
	private String keySerializer;
	private String valueSerializer;

	private String topic;

	private String bufferMemory;
	private String ack;
	private String batchSize;
	private String linger;
	private String compressionType;
	private String retres;
	private String partitionerClass;
	private String timeout;

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

	public Object getKeySerializer() {
		return keySerializer;
	}

	public void setKeySerializer(String keySerializer) {
		this.keySerializer = keySerializer.trim();
	}

	public Object getValueSerializer() {
		return valueSerializer;
	}

	public void setValueSerializer(String valueSerializer) {
		this.valueSerializer = valueSerializer.trim();
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic.trim();
	}

	public String getBufferMemory() {
		return bufferMemory;
	}

	public void setBufferMemory(String bufferMemory) {
		this.bufferMemory = bufferMemory.trim();
	}

	public String getAck() {
		return ack;
	}

	public void setAck(String ack) {
		this.ack = ack.trim();
	}

	public String getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(String batchSize) {
		this.batchSize = batchSize.trim();
	}

	public String getLinger() {
		return linger;
	}

	public void setLinger(String linger) {
		this.linger = linger.trim();
	}

	public String getCompressionType() {
		return compressionType;
	}

	public void setCompressionType(String compressionType) {
		this.compressionType = compressionType.trim();
	}

	public String getRetres() {
		return retres;
	}

	public void setRetres(String retres) {
		this.retres = retres.trim();
	}

	public String getPartitionerClass() {
		return partitionerClass;
	}

	public void setPartitionerClass(String partitionerClass) {
		this.partitionerClass = partitionerClass.trim();
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout.trim();
	}
}
