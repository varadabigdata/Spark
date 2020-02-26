import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object sparkSample {

  def main(args: Array[String]): Unit = {
     val spark: SparkSession = SparkSession.builder.master("local[*]").getOrCreate();
    println(spark)
    import spark.implicits._
  /*val df=spark.read.option("multiLine", true).option("mode", "PERMISSIVE").json("C:\\Users\\varadaraju.hd\\IdeaProjects\\sample\\src\\main\\resources\\test.json")
  //df.show()
   // val dfDates = data.select(explode(("dates"))).toDF("dates")
    //val dfDates = df.select($"user",explode($"dates"))
    //dfDates.show()
    val d1=df.withColumn("date", explode(col("dates"))).withColumn("content1",explode($"content")).drop($"dates")
    d1.withColumn((explode($"content.foo")),explode($"content.bar")).show()
    /*val dfContent = df.select(explode(df("content"))).toDF("content")
    val dfFooBar = dfContent.select("content.foo", "content.bar")
    dfFooBar.show*/*/

 val df=spark.read.option("multiLine", true).option("mode", "PERMISSIVE").json("C:\\Users\\varadaraju.hd\\IdeaProjects\\sample\\src\\main\\resources\\test1.json")
   // val df1=df.withColumn("id",explode($"lienDetails"))
    //df.select($"bin",explode($"lienDetails.liabilityAmount")).show()
    df.withColumn("liabilityAmount",explode($"lienDetails.liabilityAmount")).withColumn("supplierNumber",explode($"lienDetails.supplierNumber")).drop("lienDetails").show()


}
}
