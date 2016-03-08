package com.learning
//
//import com.esri.realtime.core._
//import com.esri.realtime.core.task.{Flow => CoreFlow, FlowStage => CoreFlowStage, FlowStageKind}
//import org.json4s._
//import org.json4s.native.JsonMethods._
//import org.json4s.native.Serialization
//import org.json4s.native.Serialization._
//
//import scala.collection.mutable.ListBuffer
//
/**
 * Task Type - enum
 */
sealed trait TaskType {
  def name: String
  override def toString = name
}

object TaskType {
  object Rat extends TaskType {
    val name: String = "rat"
  }
  object Bat extends TaskType {
    val name: String = "bat"
  }
  object Sat extends TaskType {
    val name: String = "sat"
  }
  object Sit extends TaskType {
    val name: String = "sit"
  }
  object Rth extends TaskType {
    val name: String = "rth"
  }
  object Unknown extends TaskType {
    val name: String = "unknown"
  }

  /**
   * Helper method to convert from a String to a TaskType
   *
   * @param str the TaskType as a string
   * @return the TaskType
   */
  def fromString(str: String): TaskType = {
    str match {
      case Rat.name => Rat
      case Bat.name => Bat
      case Sit.name => Sit
      case Sat.name => Sat
      case Rth.name => Rth
      case _ => Unknown
    }
  }
}

class Task {

}

object Task {
  def main(args: Array[String]): Unit = {
    val a = TaskType.fromString("rat")

    println(a)

//      println("OK")

  }
}

//
///**
// * Helper Companion Object
// */
//object Task {
//  implicit val formats = Serialization.formats(
//    ShortTypeHints(
//      List(
//        classOf[RatTask],
//        classOf[BatTask],
//        classOf[SitTask]
//      )
//    )
//  )
//  def apply(json: String) = parse(json).extract[Task]
//}
//
///**
// * Simple Trait to represent a Task
// */
//sealed trait Task extends Serializable {
//
//  def name: String
//  def `type`: TaskType
//
//  def validate: Boolean = {
//    //TODO: validate a sit exists
//    //TODO: validate at least one sink exists
//    //TODO: validate pipeline is connected and traversable
//    true
//  }
//
//  def toJson: String = {
//    implicit val formats = Task.formats
//    write(this)
//  }
//
//  def toDef: TaskDefinition
//}
//
//
///**
// * Rat Task
// *
// * @param name the name of the task
// * @param spouts the spout(s) used for this task
// * @param filters the filter(s) used for this task (if any)
// * @param operators the operator(s) used for this task (if any)
// * @param sinks the sinks used for this task
// * @param pipeline the pipeline of this task or DAG
// * @param interval the emit interval in milliseconds, default is 1000
// */
//case class RatTask(name: String,
//                spouts: Array[Spout],
//                filters: Option[Array[Filter]] = None,
//                operators: Option[Array[Operator]] = None,
//                sinks: Array[Sink],
//                pipeline: Array[Flow],
//                interval: Int = 1000) extends Task {
//
//  val `type` = TaskType.Rat
//
//  override def toDef: TaskDefinition = {
//    val p = new ListBuffer[CoreFlow]()
//    this.pipeline.foreach(_.toDef(p))
//
//    val spoutDefs = spouts.map(_.toDef)
//    val filterDefs = filters.map(_.map(_.toDef))
//    val operatorDefs = operators.map(_.map(_.toDef))
//    val sinkDefs = sinks.map(_.toDef)
//    val pipeline = p.toArray
//    val interval = 1000
//
//    new RatTaskDefinition(
//      name,
//      spoutDefs,
//      filterDefs.getOrElse(Array.empty),
//      operatorDefs.getOrElse(Array.empty),
//      sinkDefs,
//      pipeline,
//      interval
//    )
//  }
//}
//
///**
// * Bat Task
// *
// * @param name the name of the task
// * @param spouts the spout(s) used for this task
// * @param filters the filter(s) used for this task (if any)
// * @param operators the operator(s) used for this task (if any)
// * @param sinks the sinks used for this task
// * @param pipeline the pipeline of this task or DAG
// */
//case class BatTask(name: String,
//                   spouts: Array[Spout],
//                   filters: Option[Array[Filter]],
//                   operators: Option[Array[Operator]],
//                   sinks: Array[Sink],
//                   pipeline: Array[Flow]) extends Task {
//
//  val `type` = TaskType.Bat
//
//  override def toDef: TaskDefinition = {
//    val p = new ListBuffer[CoreFlow]()
//    this.pipeline.foreach(_.toDef(p))
//
//    val spoutDefs = spouts.map(_.toDef)
//    val filterDefs = filters.map(_.map(_.toDef))
//    val operatorDefs = operators.map(_.map(_.toDef))
//    val sinkDefs = sinks.map(_.toDef)
//    val pipeline = p.toArray
//
//    new BatTaskDefinition(
//      name,
//      spoutDefs,
//      filterDefs.getOrElse(Array.empty),
//      operatorDefs.getOrElse(Array.empty),
//      sinkDefs,
//      pipeline
//    )
//  }
//}
//
///**
// * Sit Task
// *
// * @param name the name of the task
// * @param spouts the spout(s) used for this task
// * @param sinks the sinks used for this task
// * @param pipeline the pipeline of this task or DAG
// */
//case class SitTask(name: String,
//                   spouts: Array[Spout],
//                   sinks: Array[Sink],
//                   pipeline: Array[Flow]) extends Task {
//
//  val `type` = TaskType.Sit
//
//  override def toDef: TaskDefinition = {
//    val p = new ListBuffer[CoreFlow]()
//    this.pipeline.foreach(_.toDef(p))
//
//    val spoutDefs = spouts.map(_.toDef)
//    val sinkDefs = sinks.map(_.toDef)
//    val pipeline = p.toArray
//
//    new SitTaskDefinition(
//      name,
//      spoutDefs,
//      sinkDefs,
//      pipeline
//    )
//  }
//}
//
///**
// * Transport
// *
// * @param className the class name
// * @param props the properties needed for this transport
// */
//case class Transport(className: String, props: Map[String,String]) extends Serializable {
//  def toDef: TransportDefinition = Class.forName(className + "Definition").getDeclaredConstructors()(0).newInstance(props).asInstanceOf[TransportDefinition]
//}
//
///**
// * Adapter
// *
// * @param className the class name
// * @param props the properties needed for this adapter
// */
//case class Adapter(className: String, props: Map[String,String]) extends Serializable {
//  def toDef: AdapterDefinition = Class.forName(className + "Definition").getDeclaredConstructors()(0).newInstance(props).asInstanceOf[AdapterDefinition]
//}
//
///**
// * Spout
// *
// * @param name the name of the spout
// * @param transport the transport used for this spout
// * @param adapter the adapter used for this spout
// */
//case class Spout(name: String, transport: Transport, adapter: Adapter) extends Serializable {
//  def toDef: SpoutDefinition = new SpoutDefinition(name, transport.toDef, adapter.toDef)
//}
//
///**
// * Sink
// *
// * @param name the name of the sink
// * @param transport the transport used for this simk
// * @param adapter the adapter used for this simk
// */
//case class Sink(name: String, transport: Transport, adapter: Adapter) extends Serializable {
//  def toDef: SinkDefinition = new SinkDefinition(name, transport.toDef, adapter.toDef)
//}
//
///**
// * Filter
// *
// * @param name the name of this filter
// * @param className the class name
// * @param props the properties needed for this filter
// */
//case class Filter(name: String, className: String, props: Map[String,String]) extends Serializable {
//  def toDef: FilterDefinition = Class.forName(className + "Definition").getDeclaredConstructors()(0).newInstance(name, props).asInstanceOf[FilterDefinition]
//}
///**
// * Operator
// *
// * @param name the name of this operator
// * @param className the class name
// * @param props the properties needed for this operator
// */
//case class Operator(name: String, className: String, props: Map[String,String]) extends Serializable {
//  def toDef: OperatorDefinition = Class.forName(className + "Definition").getDeclaredConstructors()(0).newInstance(name, props).asInstanceOf[OperatorDefinition]
//}
//
///**
// * Flow
// *
// * @param from from flow stage
// * @param tos an array of many to's flow stages
// */
//case class Flow(from: FlowStage, tos: Array[FlowStage]) extends Serializable {
//  def toDef(pipeline: ListBuffer[CoreFlow]): CoreFlow = {
//    val flow = new CoreFlow(from.toDef(pipeline), tos.map(_.toDef(pipeline)))
//    pipeline += flow
//    flow
//  }
//}
//
///**
// * Flow Stage
// *
// * @param name the name of the stage
// * @param kind the kind of stage
// */
//case class FlowStage(name: String, kind: String) extends Serializable {
//  def toDef(pipeline: ListBuffer[CoreFlow]): CoreFlowStage = {
//    def searchFrom: CoreFlowStage = {
//      val from = for {
//        flow <- pipeline
//        to <- flow.tos
//        if to.name == name
//      }
//        yield to
//      if (from.isEmpty)
//        null
//      else
//        from.head
//    }
//    val stage = searchFrom
//    if (stage == null)
//      new CoreFlowStage(name, FlowStageKind.withName(kind))
//    else
//      stage
//  }
//}
