
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq(/*7.17*/title)),format.raw/*7.22*/("""</title>
        <!--<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*8.58*/routes/*8.64*/.Assets.at("stylesheets/main.css"))),format.raw/*8.98*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq(/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq(/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*10.74*/("""" type="text/javascript"></script>
        -->
    </head>
    <body>
        """),_display_(Seq(/*14.10*/content)),format.raw/*14.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html) = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Feb 21 11:24:32 CET 2013
                    SOURCE: /srv/pdnet/MomentMachine/app/views/main.scala.html
                    HASH: 339522321d56698a3e1807632e52d015d3c89da6
                    MATRIX: 759->1|861->31|944->84|970->89|1066->155|1080->161|1135->195|1226->256|1240->262|1293->294|1349->319|1364->325|1431->370|1541->449|1570->456
                    LINES: 27->1|30->1|36->7|36->7|37->8|37->8|37->8|38->9|38->9|38->9|39->10|39->10|39->10|43->14|43->14
                    -- GENERATED --
                */
            