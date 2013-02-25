// @SOURCE:/srv/pdnet/MomentMachine/conf/routes
// @HASH:12c47e335135875b6ed95ac026175cc1cbd7fa40
// @DATE:Thu Feb 21 11:24:32 CET 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:19
// @LINE:18
// @LINE:11
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
// @LINE:7
// @LINE:6
class ReverseMomentMachineController {
    


 
// @LINE:7
// @LINE:6
def index(id:String = null, size:String = null) = {
   (id, size) match {
// @LINE:6
case (id, size) if true => Call("GET", "/" + queryString(List(if(id == null) None else Some(implicitly[QueryStringBindable[String]].unbind("id", id)), if(size == null) None else Some(implicitly[QueryStringBindable[String]].unbind("size", size)))))
                                                                
// @LINE:7
case (id, size) if true => Call("GET", "/MomentMachine/" + queryString(List(if(id == null) None else Some(implicitly[QueryStringBindable[String]].unbind("id", id)), if(size == null) None else Some(implicitly[QueryStringBindable[String]].unbind("size", size)))))
                                                                    
   }
}
                                                        
 
// @LINE:11
def webSocket() = {
   Call("GET", "/MomentMachine/socket")
}
                                                        

                      
    
}
                            

// @LINE:19
// @LINE:18
class ReverseAssets {
    


 
// @LINE:19
// @LINE:18
def at(file:String) = {
   (file) match {
// @LINE:18
case (file) if true => Call("GET", "/dassets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                                
// @LINE:19
case (file) if true => Call("POST", "/dassets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                                    
   }
}
                                                        

                      
    
}
                            
}
                    


// @LINE:19
// @LINE:18
// @LINE:11
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:11
// @LINE:7
// @LINE:6
class ReverseMomentMachineController {
    


 
// @LINE:7
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.MomentMachineController.index",
   """
      function(id, size) {
      if (true) {
      return _wA({method:"GET", url:"/" + _qS([(id == """ +  implicitly[JavascriptLitteral[String]].to(null) + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)), (size == """ +  implicitly[JavascriptLitteral[String]].to(null) + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("size", size))])})
      }
      if (true) {
      return _wA({method:"GET", url:"/MomentMachine/" + _qS([(id == """ +  implicitly[JavascriptLitteral[String]].to(null) + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)), (size == """ +  implicitly[JavascriptLitteral[String]].to(null) + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("size", size))])})
      }
      }
   """
)
                                                        
 
// @LINE:11
def webSocket = JavascriptReverseRoute(
   "controllers.MomentMachineController.webSocket",
   """
      function() {
      return _wA({method:"GET", url:"/MomentMachine/socket"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:19
// @LINE:18
class ReverseAssets {
    


 
// @LINE:19
// @LINE:18
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      if (true) {
      return _wA({method:"GET", url:"/dassets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      if (true) {
      return _wA({method:"POST", url:"/dassets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:19
// @LINE:18
// @LINE:11
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:11
// @LINE:7
// @LINE:6
class ReverseMomentMachineController {
    


 
// @LINE:6
def index(id:String, size:String) = new play.api.mvc.HandlerRef(
   controllers.MomentMachineController.index(id, size), HandlerDef(this, "controllers.MomentMachineController", "index", Seq(classOf[String], classOf[String]))
)
                              
 
// @LINE:11
def webSocket() = new play.api.mvc.HandlerRef(
   controllers.MomentMachineController.webSocket(), HandlerDef(this, "controllers.MomentMachineController", "webSocket", Seq())
)
                              

                      
    
}
                            

// @LINE:19
// @LINE:18
class ReverseAssets {
    


 
// @LINE:18
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                