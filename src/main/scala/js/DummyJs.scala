package js

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

/**
  * Created by zakaria on 6/26/2017.
  */
@JSExportTopLevel("DummyJs")
class DummyJs(val dummyValue: String) {

  @JSExport
   def getTheDummyValue(): String = dummyValue
}
