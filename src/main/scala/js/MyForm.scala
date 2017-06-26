package js

import scala.scalajs.js.{JSApp}
import org.scalajs.dom
import dom.document
import org.scalajs.dom.raw.{DOMParser, XMLHttpRequest}
import org.scalajs.dom.Event


/**
  * Created by zakaria on 6/23/2017.
  */
object MyForm extends JSApp {
  override def main(): Unit = {

    val button = document.createElement("button")
    button.textContent = "Click button"
    button.addEventListener("click", { (e0: dom.Event) =>
      println("clicked")
    }, false)
    document.body.appendChild(button)


    val header = document.createElement("h2")
    header.textContent = "Blog Posts Titles"

    document.body.appendChild(header)

    val req = new XMLHttpRequest()
    req.open("GET", "http://www.g-widgets.com/feed/")
    req.setRequestHeader("Access-Control-Allow-Origin", "*")


  val blogPostsListElement = document.createElement("ul")
    req.onload = {(e: Event) =>
      if (req.status == 200) {
        val parser = new DOMParser();
        val doc = parser.parseFromString(req.responseText, "application/xml")
        val titleList = doc.getElementsByTagName("title")


        for(i <- 0 to titleList.length){
          val listElement = document.createElement("li")
          if(titleList.item(i) != null){
            listElement.textContent = titleList.item(i).textContent
            blogPostsListElement.appendChild(listElement)
          }

        }

      }
    }
    req.send();

    document.body.appendChild(blogPostsListElement)

    val req2 = new XMLHttpRequest()
    req2.open("GET", "http://geoip.nekudo.com/api/188.166.120.19")
    req2.setRequestHeader("Access-Control-Allow-Origin", "*")


    req2.onload = {
      (e: Event) =>
        if (req2.status == 200) {
          val geoLocalization = JSON.parse(req2.responseText).asInstanceOf[GeoLocalization];
          println(geoLocalization.city)
          println(geoLocalization.ip)

        }
    }

    req2.send()


  }

}
