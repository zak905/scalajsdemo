package js

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
/**
  * Created by zakaria on 6/26/2017.
  */
@js.native
@JSGlobal
object JSON extends js.Object{

  def parse(data: String): js.Object = js.native
  def stringify(anobject :js.Object): String = js.native

}
