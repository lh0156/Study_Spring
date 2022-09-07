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

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
*
*****************************************************************************
* PACKAGE : package kr.co.aim.platform.middleware.legacy.kafka;
* NAME : PropertiesListForKafka
* Description :
*
*****************************************************************************
*/

@Component
@ConfigurationProperties(prefix = "framework.middle.kafka")
public class PropertiesListForKafka {

	private Map<String, ProducerProperty> producers;
	private Map<String, ConsumerProperty> consumers;

	public Map<String, ProducerProperty> getProducers() {
		return producers;
	}

	public void setProducers(Map<String, ProducerProperty> producers) {
		this.producers = producers;
	}

	public Map<String, ConsumerProperty> getConsumers() {
		return consumers;
	}

	public void setConsumers(Map<String, ConsumerProperty> consumers) {
		this.consumers = consumers;
	}

}
