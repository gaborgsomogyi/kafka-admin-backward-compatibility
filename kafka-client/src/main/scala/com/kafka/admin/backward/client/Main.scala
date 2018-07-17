package com.kafka.admin.backward.client

import java.util._

import scala.collection.JavaConverters._

import org.apache.kafka.clients.CommonClientConfigs
import org.apache.kafka.clients.admin.{AdminClient, OffsetSpec}
import org.apache.kafka.common.TopicPartition
import org.apache.log4j.LogManager


object Main {

  @transient lazy val log = LogManager.getLogger(getClass)

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      log.error("Usage: Main [bootstrap]")
      log.error("Example: Main localhost:9092")
      System.exit(1)
    }

    val bootstrapServer = args(0)

    log.info("Creating AdminClient config properties...")
    val adminClientProperties = new Properties
    adminClientProperties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer)
    log.info("OK")

    log.info("Creating AdminClient...")
    val adminClient = AdminClient.create(adminClientProperties)
    log.info("OK")

    log.info("Calling listTopics...")
    val topics = adminClient.listTopics().names().get()
    log.info(s"topics: $topics")

    log.info("Calling describeTopics...")
    val topicsDescription = adminClient.describeTopics(topics).all().get()
    log.info(s"topicsDescription: $topicsDescription")

    log.info("Calling listOffsets...")
    val listOffsetsParams = topicsDescription.asScala.flatMap { case (topic, topicDescription) =>
      topicDescription.partitions().asScala.map { topicPartitionInfo =>
        new TopicPartition(topic, topicPartitionInfo.partition()) -> OffsetSpec.latest()
      }
    }
    val listOffsetsResult = adminClient.listOffsets(listOffsetsParams.asJava).all().get()
    log.info(s"listOffsetsResult: $listOffsetsResult")

    log.info("Closing kafka admin...")
    adminClient.close()
    log.info("OK")
  }
}
