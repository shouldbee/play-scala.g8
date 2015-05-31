import sbt._

import play.PlayRunHook

object RunSubProcess {
  def apply(command: String): PlayRunHook = {

    object RunSubProcessHook extends PlayRunHook {

      var process: Option[Process] = None

      override def beforeStarted(): Unit = {
        process = Some(Process(command).run)
      }

      override def afterStopped(): Unit = {
        process.map(p => p.destroy())
        process = None
      }
    }

    RunSubProcessHook
  }
}
