// @SOURCE:/srv/pdnet/MomentMachine/conf/routes
// @HASH:12c47e335135875b6ed95ac026175cc1cbd7fa40
// @DATE:Thu Feb 21 11:24:32 CET 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_MomentMachineController_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:7
val controllers_MomentMachineController_index1 = Route("GET", PathPattern(List(StaticPart("/MomentMachine/"))))
                    

// @LINE:11
val controllers_MomentMachineController_webSocket2 = Route("GET", PathPattern(List(StaticPart("/MomentMachine/socket"))))
                    

// @LINE:18
val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart("/dassets/"),DynamicPart("file", """.+"""))))
                    

// @LINE:19
val controllers_Assets_at4 = Route("POST", PathPattern(List(StaticPart("/dassets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.MomentMachineController.index(id:String ?= null, size:String ?= null)"""),("""GET""","""/MomentMachine/""","""controllers.MomentMachineController.index(id:String ?= null, size:String ?= null)"""),("""GET""","""/MomentMachine/socket""","""controllers.MomentMachineController.webSocket"""),("""GET""","""/dassets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""","""/dassets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_MomentMachineController_index0(params) => {
   call(params.fromQuery[String]("id", Some(null)), params.fromQuery[String]("size", Some(null))) { (id, size) =>
        invokeHandler(_root_.controllers.MomentMachineController.index(id, size), HandlerDef(this, "controllers.MomentMachineController", "index", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:7
case controllers_MomentMachineController_index1(params) => {
   call(params.fromQuery[String]("id", Some(null)), params.fromQuery[String]("size", Some(null))) { (id, size) =>
        invokeHandler(_root_.controllers.MomentMachineController.index(id, size), HandlerDef(this, "controllers.MomentMachineController", "index", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:11
case controllers_MomentMachineController_webSocket2(params) => {
   call { 
        invokeHandler(_root_.controllers.MomentMachineController.webSocket, HandlerDef(this, "controllers.MomentMachineController", "webSocket", Nil))
   }
}
                    

// @LINE:18
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    

// @LINE:19
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                