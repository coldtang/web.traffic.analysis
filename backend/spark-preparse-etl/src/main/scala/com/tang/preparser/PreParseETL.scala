package com.tang.preparser

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Encoders, SaveMode, SparkSession}

object PreParseETL {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    if (args.isEmpty) {
      conf.setMaster("local")
    }
    val spark = SparkSession.builder()
      .appName("PreParseETL")
      .config(conf)
      .enableHiveSupport()
      .getOrCreate()

    val rawdataInputPath = spark.conf.get("spark.traffic.analysis.rawdata.input",
      "hdfs://master:9999/user/hadoop-coldtang/traffic-analysis/rawlog/20180615")

    val numberPartitions = spark.conf.get("spark.traffic.analysis.rawdata.numberPartitions", "2").toInt

    val preParsedLogRDD: RDD[PreParserLog] = spark.sparkContext.textFile(rawdataInputPath).flatMap(line => {
      Option(WebLogPreParser.parser(line))
    })

    val preParsedLogDS=spark.createDataset(preParsedLogRDD)(Encoders.bean(classOf[PreParserLog]))

    // 保存到hive表中
    preParsedLogDS.coalesce(numberPartitions)
        .write
        .mode(SaveMode.Append)
        .partitionBy("year","month","day")
        .saveAsTable("rawdata.web")

    spark.stop()
  }
}
