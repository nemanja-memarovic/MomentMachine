
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
object momentMachine extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,String,play.api.templates.Html] {

    /**/
    def apply/*2.2*/(displayId: String, wsAddress: String, size: String):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*2.54*/("""

"""),_display_(Seq(/*4.2*/main("Moment Machine")/*4.24*/ {_display_(Seq(format.raw/*4.26*/("""

		"""),_display_(Seq(/*6.4*/if(size == "small")/*6.23*/{_display_(Seq(format.raw/*6.24*/("""
			<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*7.49*/routes/*7.55*/.Assets.at("stylesheets/mainSmall.css"))),format.raw/*7.94*/("""">
		""")))})),format.raw/*8.4*/("""
		"""),_display_(Seq(/*9.4*/if(size == "big")/*9.21*/{_display_(Seq(format.raw/*9.22*/("""
			<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*10.49*/routes/*10.55*/.Assets.at("stylesheets/mainBig.css"))),format.raw/*10.92*/("""">
		""")))})),format.raw/*11.4*/("""
		"""),_display_(Seq(/*12.4*/if(size == "fullscreen")/*12.28*/{_display_(Seq(format.raw/*12.29*/("""
			<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*13.49*/routes/*13.55*/.Assets.at("stylesheets/mainFullscreen.css"))),format.raw/*13.99*/("""">
		""")))})),format.raw/*14.4*/("""
		"""),_display_(Seq(/*15.4*/if(size == "portrait")/*15.26*/{_display_(Seq(format.raw/*15.27*/("""
			<link rel="stylesheet" media="screen" href=""""),_display_(Seq(/*16.49*/routes/*16.55*/.Assets.at("stylesheets/mainPortrait.css"))),format.raw/*16.97*/("""">
		""")))})),format.raw/*17.4*/("""
		"""),_display_(Seq(/*18.4*/if(displayId=="5")/*18.22*/ {_display_(Seq(format.raw/*18.24*/("""
		<style>
			body """),format.raw("""{"""),format.raw/*20.10*/("""
				background: url('"""),_display_(Seq(/*21.23*/routes/*21.29*/.Assets.at("stylesheets/zavesa1.png"))),format.raw/*21.66*/("""');
				"""),format.raw("""}"""),format.raw/*22.6*/("""
		</style>
		""")))})),format.raw/*24.4*/("""
		<script type="text/javascript" src=""""),_display_(Seq(/*25.40*/routes/*25.46*/.Assets.at("javascripts/jquery-1.8.0.min.js"))),format.raw/*25.91*/(""""></script>
		<script type="text/javascript" src=""""),_display_(Seq(/*26.40*/routes/*26.46*/.Assets.at("javascripts/jquery.timeago.js"))),format.raw/*26.89*/(""""></script>
		<script type="text/javascript" src=""""),_display_(Seq(/*27.40*/routes/*27.46*/.Assets.at("javascripts/channel.js"))),format.raw/*27.82*/(""""></script>
	
	<div id="cameraLayer">
		<div id="imgIdDiv" style="display:none;">
			<img src="" id="imgId" height="500" width="375"></img>
		</div>
		
		<div id="photoCapture" style="display:inline-block;" onclick="changeFilter()">
			<canvas id="canvasID"></canvas>
		</div>
		<div id="cameraFeed" style="display:none;">
			<video autoplay="autoplay" id="localVideo"></video>
			<!--  <video autoplay="autoplay" id="remoteVideo"></video> -->
			<!-- <input id="start_btn" type="image" value="Take Snapshot" class="unselected" onClick="take_snapshot()" src=""""),_display_(Seq(/*40.117*/routes/*40.123*/.Assets.at("buttons/Take_picture.png"))),format.raw/*40.161*/(""""> -->
		</div>	
			<!-- <embed src=""""),_display_(Seq(/*42.22*/routes/*42.28*/.Assets.at("javascripts/shutter.mp3"))),format.raw/*42.65*/("""" autostart=false width=1 height=1 
			enablejavascript="true" id="soundObj"/> -->
			<audio src=""""),_display_(Seq(/*44.17*/routes/*44.23*/.Assets.at("javascripts/shutter.mp3"))),format.raw/*44.60*/("""" id="audioID"></audio>
	</div>
	<div id="filtersButton" onclick="changeFilter()" ondragend="changeFilter()" style="position: absolute;
            left: 10px; top: 660px;">
			<img src=""""),_display_(Seq(/*48.15*/routes/*48.21*/.Assets.at("buttons/element-16.png"))),format.raw/*48.57*/("""" id="chageFilter"></img>
	</div>
	<div id="photoButtonDiv">
		
		<div id="captureButton" onclick="if (!touch) take_snapshot();" ondragend="if (!touch) take_snapshot()" style="display: block;">
			<img src=""""),_display_(Seq(/*53.15*/routes/*53.21*/.Assets.at("buttons/click.png"))),format.raw/*53.52*/("""" id="shutterImg"></img>
		</div>
		
		<!--  <div id="handDiv" onclick="if (!touch) take_snapshot()" ondragend="if (!touch) take_snapshot()" style="display: block;">
			<img src=""""),_display_(Seq(/*57.15*/routes/*57.21*/.Assets.at("buttons/hand1.png"))),format.raw/*57.52*/("""" id="handImg"></img>
		</div>
		-->
		<div id="timerTillShot" value="" onclick="if (!touch) take_snapshot();" ondragend="if (!touch) take_snapshot()">Click
		</div>
		
		<div id="fbButton" onclick="saveTheImage(2)" ondragend="saveTheImage(2)" style="display: none;">
			<img src=""""),_display_(Seq(/*64.15*/routes/*64.21*/.Assets.at("buttons/facebook_logo.png"))),format.raw/*64.60*/("""" id="fbImg"></img>
		</div>
		
		<div id="yesButton" onclick="saveTheImage(1)" ondragend="saveTheImage(1)" style="display: none;">
			<img src=""""),_display_(Seq(/*68.15*/routes/*68.21*/.Assets.at("buttons/element-17.png"))),format.raw/*68.57*/("""" id="yesImg"></img>
		</div>
		
		<div id="noButton" onclick="clearAndRefresh()" ondragend="clearAndRefresh()" style="display: none;">
			<img src=""""),_display_(Seq(/*72.15*/routes/*72.21*/.Assets.at("buttons/element-18.png"))),format.raw/*72.57*/("""" id="noImg"></img>
		</div>
		
		<div id="countdownTimer" style="display: none;"></div>
	</div>
	
	<script type="text/javascript">

	//var date1 = new Date();
	//alert('Year: '+date1.getFullYear()+', month: '+date1.getMonth()+', day: '+date1.getDate()+', hour: '+date1.getHours()+', minute: '+date1.getMinutes());

	var touch = false;
	//------------	
	//---- WS ----
	//------------
	var WS = WebSocket;
	var wsUri = """"),_display_(Seq(/*88.16*/wsAddress)),format.raw/*88.25*/("""";
	var iHeight = 240;
	var iWidth = 320;
	//var imgArray = new Array();
	//var locArray = new Array();
	var momentArray = new Array();
	
	websocket = new WS(wsUri); 
	var peerConn = null;
	console.log("display id: "+"""),_display_(Seq(/*97.30*/displayId)),format.raw/*97.39*/("""+" ,size: "+""""),_display_(Seq(/*97.53*/size)),format.raw/*97.57*/("""");
	
	websocket.onopen = function(evt) """),format.raw("""{"""),format.raw/*99.36*/(""" 
		console.log("CONNECTED"); 
		var hi = JSON.stringify
		("""),format.raw("""{"""),format.raw/*102.5*/("""
			"kind":"appReady",
			"displayID": """),_display_(Seq(/*104.18*/displayId)),format.raw/*104.27*/(""",
			"size": """"),_display_(Seq(/*105.14*/size)),format.raw/*105.18*/(""""
		"""),format.raw("""}"""),format.raw/*106.4*/(""");
		websocket.send(hi);
	"""),format.raw("""}"""),format.raw/*108.3*/("""; //websocket.onopen

	websocket.onclose = function(evt) """),format.raw("""{"""),format.raw/*110.37*/(""" 
		console.log("DISCONNECTED");
		var bye = JSON.stringify
		("""),format.raw("""{"""),format.raw/*113.5*/("""
			"kind":"appClose",
			"displayID": """),_display_(Seq(/*115.18*/displayId)),format.raw/*115.27*/(""",
			"size": """"),_display_(Seq(/*116.14*/size)),format.raw/*116.18*/(""""
		"""),format.raw("""}"""),format.raw/*117.4*/(""");
		websocket.send(bye);
	"""),format.raw("""}"""),format.raw/*119.3*/("""; //websocket.onclose

	websocket.onmessage = function(evt) """),format.raw("""{"""),format.raw/*121.39*/("""
		var response = jQuery.parseJSON(evt.data);
		
		if(response.kind == "request")"""),format.raw("""{"""),format.raw/*124.34*/("""
			//TODO - do something here when a message from the app server arrives
		"""),format.raw("""}"""),format.raw/*126.4*/("""//if
		
		//Hello World message sent from the app server
		if(response.kind == "imageList")"""),format.raw("""{"""),format.raw/*129.36*/("""
			//$('#helloWorldBox').text(response.urls);
			for (i=0; i<response.urls.length;i++) """),format.raw("""{"""),format.raw/*131.43*/("""
				//imgArray[i] = response.urls[i].fileName;
				//locArray[i] = response.urls[i].location;
				
				var obj = """),format.raw("""{"""),format.raw/*135.16*/("""
				        fileName: response.urls[i].fileName,
				        location: response.urls[i].location,
				        likes: response.urls[i].likes,
				        //shares: response.urls[i].shares
				    """),format.raw("""}"""),format.raw/*140.10*/(""";
				
				momentArray[i]=obj;
				
				//var timeInfo=imgArray[i].split("-");
				var timeInfo=momentArray[i].fileName.split("-");
				//alert("Just the elements "+timeInfo[1]+", "+ timeInfo[2]+", "+ timeInfo[3]+", "+ timeInfo[4]+", "+ timeInfo[5]);
				var month = parseInt(timeInfo[2]);
				var hour = parseInt(timeInfo[4]);
				var minute = parseInt(timeInfo[5]);
				//alert("Just the elements "+timeInfo[1]+", "+ month+", "+ timeInfo[3]+", "+ hour+", "+ minute);
				//alert(new Date(timeInfo[1], month, timeInfo[3], hour, minute));
				//alert(new Date(timeInfo[1], timeInfo[2]-1, timeInfo[3], timeInfo[4]-1, timeInfo[5]+1));
				var timeAgo = jQuery.timeago(new Date(timeInfo[1], month, timeInfo[3], hour, minute));
				//$('#photoContainer').prepend('<div class="photoItem"><div class="img"><img src="http://pdnet.inf.unisi.ch/photobooth/images/'+imgArray[i]+'" height="'+iHeight+'" width="'+iWidth+'"></img><div class="timeAgo">Moment captured at '+locArray[i]+' '+timeAgo+'</div></div></div>');
				$('#photoContainer').prepend('<div class="photoItem"><div class="img"><img src="http://pdnet.inf.unisi.ch/dphotobooth/images/'+momentArray[i].fileName+'" height="'+iHeight+'" width="'+iWidth+'"></img><div class="timeAgo">'+momentArray[i].location+' - '+timeAgo+'</div></div></div>');
				
			"""),format.raw("""}"""),format.raw/*157.5*/("""
		"""),format.raw("""}"""),format.raw/*158.4*/("""//if
		
		//PhotoBooth message sent from the app server
		if(response.kind == "newImage")"""),format.raw("""{"""),format.raw/*161.35*/("""
			//$('#helloWorldBox').text(response.urls);
			var temp=response.fileName;
				var timeInfo=temp.split("-");
				var month = parseInt(timeInfo[2]);
				var hour = parseInt(timeInfo[4]);
				var minute = parseInt(timeInfo[5]);
				//alert(new Date(timeInfo[1], timeInfo[2]-1, timeInfo[3], timeInfo[4]-1, timeInfo[5]));
				var timeAgo = jQuery.timeago(new Date(timeInfo[1], month, timeInfo[3], hour, minute));
				//alert(timeAgo);
				
				var obj = """),format.raw("""{"""),format.raw/*172.16*/("""
				        fileName: response.fileName,
				        location: response.location,
				        likes: response.likes,
				        //shares: response.shares
				    """),format.raw("""}"""),format.raw/*177.10*/(""";
				
				//imgArray.unshift(response.fileName);
				//locArray.unshift(response.location);
				momentArray.unshift(obj);
			$('#photoContainer').prepend('<div class="photoItem"><div class="img"><img src="http://pdnet.inf.unisi.ch/dphotobooth/images/'+response.fileName+'" height="'+iHeight+'" width="'+iWidth+'"></img><div class="timeAgo">'+response.location+' - '+timeAgo+'</div></div></div>');
		"""),format.raw("""}"""),format.raw/*183.4*/("""//if
		
		//TODO - add other messages as needed
			
	"""),format.raw("""}"""),format.raw/*187.3*/("""; //websocket.onmessage

	websocket.onerror = function(evt) """),format.raw("""{"""),format.raw/*189.37*/(""" 
		console.log(evt.data); 
	"""),format.raw("""}"""),format.raw/*191.3*/("""; //websocket.onerror
	
	//---- WS

	var takeActionTimer = false;
	var counterInterval = false;
	var count = 29;
	
	window.URL = window.URL || window.webkitURL;
	navigator.getUserMedia  = navigator.getUserMedia || navigator.webkitGetUserMedia ||
	                          navigator.mozGetUserMedia || navigator.msGetUserMedia;
	
	var localVideo = document.getElementById('localVideo');
	//localVideo.addEventListener('click', changeFilter, false);
	var remoteVideo = document.getElementById('remoteVideo');
	var audio = document.getElementById('audioID');//document.getElementById('soundObj');
	var canvas = document.getElementById('canvasID');
	var ctx = canvas.getContext('2d');
	var img = document.getElementById('imgId');
	var localMediaStream = null;
	var dataURL;
	var snapshots = [];
	
	var idx = 0;
	/* var filters = ['grayscale', 'sepia', 'blur', 'brightness', 'contrast', 'hue-rotate',
          'hue-rotate2', 'hue-rotate3', 'saturate', 'invert', '']; */
    //var filters = ['color', 'sepia', 'grey', 'invert', 'tint', 'brighten', 'strips', 'noise'];
          var filters = ['color', 'sepia', 'grey', 'invert', 'tint', 'brighten', 'noise'];
          
	var counterScroll=0;
	var step=290;
	var maxHeight = 260*momentArray.length;
	
	// Not showing vendor prefixes or code that works cross-browser.
	navigator.getUserMedia("""),format.raw("""{"""),format.raw/*225.26*/("""video: true"""),format.raw("""}"""),format.raw/*225.38*/(""", function(stream) """),format.raw("""{"""),format.raw/*225.58*/("""
	  
	  navigator.sayswho= (function()"""),format.raw("""{"""),format.raw/*227.35*/("""
		    var N= navigator.appName, ua= navigator.userAgent, tem;
		    var M= ua.match(/(opera|chrome|safari|firefox|msie)\/?\s*(\.?\d+(\.\d+)*)/i);
		    if(M && (tem= ua.match(/version\/([\.\d]+)/i))!= null) M[2]= tem[1];
		    M= M? [M[1], M[2]]: [N, navigator.appVersion, '-?'];

		    return M;
		"""),format.raw("""}"""),format.raw/*234.4*/(""")();
	  //alert('navigator.sayswho='+navigator.sayswho[0]);
	  if (navigator.sayswho[0]=='Opera') """),format.raw("""{"""),format.raw/*236.40*/("""
		  localVideo.src = stream;
	  """),format.raw("""}"""),format.raw/*238.5*/(""" else """),format.raw("""{"""),format.raw/*238.12*/("""
		  localVideo.src = window.URL.createObjectURL(stream);
	  """),format.raw("""}"""),format.raw/*240.5*/("""
	  localMediaStream = stream;
	"""),format.raw("""}"""),format.raw/*242.3*/(""", onFailSoHard);	
	//canvas.width=localVideo.videoWidth;
	//canvas.height=localVideo.videoHeight;
	
	var cw = 500;
	
	var ch = 375;
	canvas.width = cw;
	canvas.height = ch;
	
	var filter = filters[idx++ % filters.length];

	$(localVideo).on("play", function()"""),format.raw("""{"""),format.raw/*254.38*/("""
		//alert('In play');
		draw(localVideo,ctx,cw,ch,filter);
	"""),format.raw("""}"""),format.raw/*257.3*/(""");
	
	var onFailSoHard = function(e) """),format.raw("""{"""),format.raw/*259.34*/("""
	    //console.log('Reeeejected!', e);
		alert('Reeeejected!'+ e);
	 """),format.raw("""}"""),format.raw/*262.4*/(""";
	 
	function changeImage(index) """),format.raw("""{"""),format.raw/*264.31*/("""           
	   //$("#start_btn").attr('src', "assets/buttons/"+index+".png");
	   //if (index==0)  $("#photoButton").attr('value', 'Smile:-)');
	   //else 
		  //$("#captureButton").attr('value', index);
		$("#timerTillShot").text(index);
	"""),format.raw("""}"""),format.raw/*270.3*/("""
			
	function take_snapshot() """),format.raw("""{"""),format.raw/*272.28*/("""
		touch = true;
		//$('#handDiv').attr('style','display: none');
		$('#timerTillShot').attr('style','display: block');
		setTimeout('changeImage(5)', 1000);
		setTimeout('changeImage(4)', 2000);
		setTimeout('changeImage(3)', 3000);
		setTimeout('changeImage(2)', 4000);
		setTimeout('changeImage(1)', 5000);
		setTimeout('changeImage(":-)")', 6000); 
		setTimeout('changeImage("")', 6500);
		//setTimeout('webcam.snap()', 6500);
		setTimeout('snapshot()', 6500); 
	"""),format.raw("""}"""),format.raw/*285.3*/("""
	
	function snapshot() """),format.raw("""{"""),format.raw/*287.23*/("""
		if (localMediaStream) """),format.raw("""{"""),format.raw/*288.26*/("""
			//alert('canvas.width= '+canvas.width+', canvas.height= '+canvas.height);
			//ctx.scale(0.5,0.5);
			//alert(effect);
			img.height= ch;
			img.width= cw;
			//filter = "grey";
			//var idata1 = ctx.getImageData(0,0,640,480);

			//dataURL = canvas.toDataURL('image/jpeg');
			//var  = filterdata(idata1,filter);
			//ctx.putImageData(newdata,0,0);
					
			//dataURL = canvas.toDataURL('image/jpeg');
		    //img.src = dataURL;

		    dataURL = canvas.toDataURL('image/jpeg');
		    img.src = dataURL;
		    //document.getElementById('photoCapture').classList.add(effect);
		    audio.play();
		    $('#countdownTimer').text('30');
			$('#countdownTimer').attr('style','display: inline-block');
		    /* $('#yesButton').attr('style','display: inline-block; -webkit-animation-name: greenPulse;');
		    $('#noButton').attr('style','display: inline-block'); */
		    $('#fbButton').attr('style', 'display: inline-block;');
		    $('#yesButton').attr('style', 'display: inline-block;');
		    $('#noButton').attr('style', 'display: inline-block;');
			$('#captureButton').attr('style','display: none');
			$('#filtersButton').attr('style','display: none');
			$('#photoCapture').attr('style','display: border');
			counterInterval = setInterval('counter()', 1000);
			//$('#cameraFeed').attr('style','display: none');
			$('#imgIdDiv').attr('style','display: inline=block');
			$('#photoCapture').attr('style','display: none');
			//if (takeActionTimer!= false) clearTimeout(takeActionTimer);
			takeActionTimer = setTimeout('refresh(0)', 31000);
			var imageJSON = JSON.stringify
			("""),format.raw("""{"""),format.raw/*325.6*/("""
				"kind":"imagetaken",
				"displayID": """),_display_(Seq(/*327.19*/displayId)),format.raw/*327.28*/("""
			"""),format.raw("""}"""),format.raw/*328.5*/(""");
			websocket.send(imageJSON);
		    //setTimeout('changeImage("Take_picture")', 1500);
		    //setTimeout('changeImage("Capture the moment!")', 1500);
		    //document.getElementById("start_btn").setAttribute("class", "unselected");
		  """),format.raw("""}"""),format.raw/*333.6*/("""
	"""),format.raw("""}"""),format.raw/*334.3*/("""
	
	/* function changeFilter(e) """),format.raw("""{"""),format.raw/*336.31*/("""
		var el = e.target;
		el.className = '';
		effect = filters[idx++ % filters.length]; // loop through filters.
		if (effect) """),format.raw("""{"""),format.raw/*340.16*/("""
 			el.classList.add(effect);
		"""),format.raw("""}"""),format.raw/*342.4*/("""
	"""),format.raw("""}"""),format.raw/*343.3*/(""" */
	
	function changeFilter() """),format.raw("""{"""),format.raw/*345.27*/("""
		
		filter = filters[idx++ % filters.length]; // loop through filters.
		clearTimeout(filterTimeout);
		filterTimeout = setTimeout(draw,20,localVideo,ctx,cw,ch,filter);
		//alert(filter);
		var imageJSON = JSON.stringify
		("""),format.raw("""{"""),format.raw/*352.5*/("""
			"kind":"changefilter",
			"displayID": """),_display_(Seq(/*354.18*/displayId)),format.raw/*354.27*/("""
		"""),format.raw("""}"""),format.raw/*355.4*/(""");
		websocket.send(imageJSON);
		
	"""),format.raw("""}"""),format.raw/*358.3*/("""
	  
		function saveTheImage(type) """),format.raw("""{"""),format.raw/*360.32*/("""
			touch = false;
			refresh(1);
			clearTimeout(takeActionTimer);
			clearInterval(counterInterval);
			count = 29;
			$("#photoContainer").animate("""),format.raw("""{"""),format.raw/*366.34*/(""" scrollTop: 0 """),format.raw("""}"""),format.raw/*366.49*/(""", "slow");
			var date = new Date();
			var month = date.getMonth();
			var day = date.getDate();
			var hours = date.getHours();
			var minutes = date.getMinutes();
			var seconds = date.getSeconds();
			
			/* if (month<10) month = '0'+month;
			if (day<10) day = '0'+day;
			if (hours<10) hours = '0'+hours;
			if (minutes<10) minutes = '0'+minutes; */
			
			month = ("0" + month).slice(-2);
			day = ("0" + day).slice(-2);
			hours = ("0" + hours).slice(-2);
			minutes = ("0" + minutes).slice(-2);
			seconds = ("0" + seconds).slice(-2);
			if (type == 1) """),format.raw("""{"""),format.raw/*384.20*/("""
		    	var imageJSON = JSON.stringify
				("""),format.raw("""{"""),format.raw/*386.7*/("""
					"kind":"saveimage",
					"displayID": """),_display_(Seq(/*388.20*/displayId)),format.raw/*388.29*/(""",
					"image": dataURL,
					"year": date.getFullYear(),
					"month": month,
					"day": day,
					"hour": hours,
					"minute": minutes,
					"seconds": seconds
				"""),format.raw("""}"""),format.raw/*396.6*/(""");
			"""),format.raw("""}"""),format.raw/*397.5*/("""
			
			if (type == 2) """),format.raw("""{"""),format.raw/*399.20*/("""
		    	var imageJSON = JSON.stringify
				("""),format.raw("""{"""),format.raw/*401.7*/("""
					"kind":"savefacebook",
					"displayID": """),_display_(Seq(/*403.20*/displayId)),format.raw/*403.29*/(""",
					"image": dataURL,
					"year": date.getFullYear(),
					"month": month,
					"day": day,
					"hour": hours,
					"minute": minutes,
					"seconds": seconds
				"""),format.raw("""}"""),format.raw/*411.6*/(""");
			"""),format.raw("""}"""),format.raw/*412.5*/("""
			
			websocket.send(imageJSON);
			snapshots.unshift(canvas);
			//touchDetected = true;
			counterScroll=0;
		"""),format.raw("""}"""),format.raw/*418.4*/("""
		
		function refresh(type) """),format.raw("""{"""),format.raw/*420.27*/("""
			touch = false;
			//document.getElementById('photoCapture').classList.remove();
			//changeImage("Capture the moment!");
			//$('#handDiv').attr('style','display: block');
			//$('#filtersButton').attr('style','display: border; position: relative; right: 220px; top: 50px;');
			$('#filtersButton').attr('style','display: border; position: absolute; left: 10px; top: 660px;');
			$('#fbButton').attr('style', 'display: none;');
			$('#yesButton').attr('style', 'display: none;');
			$('#noButton').attr('style', 'display: none;');
			/* $('#yesButton').attr('style','display: none; -webkit-animation-name: greenPulse;');
			$('#noButton').attr('style','display: none'); */
			$('#captureButton').attr('style','display: border');
			$('#imgIdDiv').attr('style','display: none');
			$('#photoCapture').attr('style','display: border');
			$('#countdownTimer').attr('style','display: none');
			$("#timerTillShot").text("Click");
			if (type == 0) """),format.raw("""{"""),format.raw/*437.20*/("""
				var imageJSON = JSON.stringify
				("""),format.raw("""{"""),format.raw/*439.7*/("""
					"kind":"runoutoftime",
					"displayID": """),_display_(Seq(/*441.20*/displayId)),format.raw/*441.29*/("""
				"""),format.raw("""}"""),format.raw/*442.6*/(""");
				websocket.send(imageJSON);
			"""),format.raw("""}"""),format.raw/*444.5*/("""
		"""),format.raw("""}"""),format.raw/*445.4*/("""
		
		function clearAndRefresh() """),format.raw("""{"""),format.raw/*447.31*/("""
			refresh(1); 
			clearTimeout(takeActionTimer); 
			clearInterval(counterInterval);
			count = 29;
			var imageJSON = JSON.stringify
			("""),format.raw("""{"""),format.raw/*453.6*/("""
				"kind":"imagediscarded",
				"displayID": """),_display_(Seq(/*455.19*/displayId)),format.raw/*455.28*/("""
			"""),format.raw("""}"""),format.raw/*456.5*/(""");
			websocket.send(imageJSON);
		"""),format.raw("""}"""),format.raw/*458.4*/("""
		
		function counter()
		"""),format.raw("""{"""),format.raw/*461.4*/("""
			//alert('IN');
		  if (count < 0)
		  """),format.raw("""{"""),format.raw/*464.6*/("""
		     clearInterval(counterInterval);
		     count = 29;
		     $('#countdownTimer').attr('style','display: none');
		     $('#countdownTimer').text("");
		     //counter ended, do something here
		  """),format.raw("""}"""),format.raw/*470.6*/(""" else """),format.raw("""{"""),format.raw/*470.13*/("""
			  $('#countdownTimer').text(count);
			  count=count-1;
		  """),format.raw("""}"""),format.raw/*473.6*/("""

		  //Do code for showing the number of seconds here

		"""),format.raw("""}"""),format.raw/*477.4*/("""
		
		//video.addEventListener('click', snapshot, false);
		
		function goToByScroll(divContext)"""),format.raw("""{"""),format.raw/*481.37*/("""
			//alert('step '+step+', counterScroll '+counterScroll);
			maxHeight = 270*(momentArray.length);
		     if (divContext=='down' && counterScroll<maxHeight) """),format.raw("""{"""),format.raw/*484.60*/("""
			     	counterScroll +=step;
			 	$("#photoContainer").animate("""),format.raw("""{"""),format.raw/*486.36*/(""" scrollTop: counterScroll+"px" """),format.raw("""}"""),format.raw/*486.68*/(""", "slow");
			 	 var imageJSON = JSON.stringify
					("""),format.raw("""{"""),format.raw/*488.8*/("""
						"kind":"scrolldown",
						"displayID": """),_display_(Seq(/*490.21*/displayId)),format.raw/*490.30*/("""
					"""),format.raw("""}"""),format.raw/*491.7*/(""");
					websocket.send(imageJSON);
		     """),format.raw("""}"""),format.raw/*493.9*/(""" else if (divContext=='up' && counterScroll>0) """),format.raw("""{"""),format.raw/*493.57*/("""
		    	 counterScroll -=step;
				 $("#photoContainer").animate("""),format.raw("""{"""),format.raw/*495.36*/(""" scrollTop: counterScroll+"px" """),format.raw("""}"""),format.raw/*495.68*/(""", "slow");
				 var imageJSON = JSON.stringify
					("""),format.raw("""{"""),format.raw/*497.8*/("""
						"kind":"scrollup",
						"displayID": """),_display_(Seq(/*499.21*/displayId)),format.raw/*499.30*/("""
					"""),format.raw("""}"""),format.raw/*500.7*/(""");
					websocket.send(imageJSON);
			 """),format.raw("""}"""),format.raw/*502.6*/("""
		"""),format.raw("""}"""),format.raw/*503.4*/("""
		
//video filters
		var newdata;
		function filterdata(idata,type) """),format.raw("""{"""),format.raw/*507.36*/("""
		var data = idata.data;
		switch(type)"""),format.raw("""{"""),format.raw/*509.16*/("""
			case "grey":
				//alert('in grey');
				for(var i = 0; i < data.length; i+=4) """),format.raw("""{"""),format.raw/*512.44*/("""
					var r = data[i];
					var g = data[i+1];
					var b = data[i+2];
					var brightness = parseInt((r + g + b) / 3);
					data[i] = brightness;
					data[i+1] = brightness;
					data[i+2] = brightness;
				"""),format.raw("""}"""),format.raw/*520.6*/("""

				idata.data = data;
				//ctx.putImageData(idata,0,0);
				//ctx.drawImage(localVideo,0,0);
				return idata;
			  break;
			  
			case "color":
				var p1 = 0.99;
				var p2 = 0.99;
				var p3 = 0.99;
				var er = 0; // extra red
				var eg = 0; // extra green
				var eb = 0; // extra blue
				/* for(var i = 0; i < data.length; i+=4) """),format.raw("""{"""),format.raw/*535.47*/("""
					data[i] = 0;
				"""),format.raw("""}"""),format.raw/*537.6*/(""" */
				for (var i = 0, n = data.length; i < n; i += 4) """),format.raw("""{"""),format.raw/*538.54*/("""
					data[i]   = data[i]*p1+er; // red
					data[i+1] = data[i+1]*p2+eg; // green
					data[i+2] = data[i+2]*p3+eb; // blue
				"""),format.raw("""}"""),format.raw/*542.6*/("""

				idata.data = data;
				return idata;
			  break;
			  
			case "brighten": 
				// Get the picel data from the 
				var adj = 50;
				for (var i = 0; i < data.length; i += 4 ) """),format.raw("""{"""),format.raw/*551.48*/("""		
					data[i] += adj;		
					data[i+1] += adj;
					data[i+2] += adj;
				"""),format.raw("""}"""),format.raw/*555.6*/("""
				// Draw the data on the visible canvas
				idata.data = data;
				return idata;
			break;
			
			case "sepia":
				// set of sepia colors
				var r = [0, 0, 0, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 11, 11, 12, 12, 12, 12, 13, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 17, 18, 19, 19, 20, 21, 22, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 39, 40, 41, 42, 44, 45, 47, 48, 49, 52, 54, 55, 57, 59, 60, 62, 65, 67, 69, 70, 72, 74, 77, 79, 81, 83, 86, 88, 90, 92, 94, 97, 99, 101, 103, 107, 109, 111, 112, 116, 118, 120, 124, 126, 127, 129, 133, 135, 136, 140, 142, 143, 145, 149, 150, 152, 155, 157, 159, 162, 163, 165, 167, 170, 171, 173, 176, 177, 178, 180, 183, 184, 185, 188, 189, 190, 192, 194, 195, 196, 198, 200, 201, 202, 203, 204, 206, 207, 208, 209, 211, 212, 213, 214, 215, 216, 218, 219, 219, 220, 221, 222, 223, 224, 225, 226, 227, 227, 228, 229, 229, 230, 231, 232, 232, 233, 234, 234, 235, 236, 236, 237, 238, 238, 239, 239, 240, 241, 241, 242, 242, 243, 244, 244, 245, 245, 245, 246, 247, 247, 248, 248, 249, 249, 249, 250, 251, 251, 252, 252, 252, 253, 254, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255],
				    g = [0, 0, 1, 2, 2, 3, 5, 5, 6, 7, 8, 8, 10, 11, 11, 12, 13, 15, 15, 16, 17, 18, 18, 19, 21, 22, 22, 23, 24, 26, 26, 27, 28, 29, 31, 31, 32, 33, 34, 35, 35, 37, 38, 39, 40, 41, 43, 44, 44, 45, 46, 47, 48, 50, 51, 52, 53, 54, 56, 57, 58, 59, 60, 61, 63, 64, 65, 66, 67, 68, 69, 71, 72, 73, 74, 75, 76, 77, 79, 80, 81, 83, 84, 85, 86, 88, 89, 90, 92, 93, 94, 95, 96, 97, 100, 101, 102, 103, 105, 106, 107, 108, 109, 111, 113, 114, 115, 117, 118, 119, 120, 122, 123, 124, 126, 127, 128, 129, 131, 132, 133, 135, 136, 137, 138, 140, 141, 142, 144, 145, 146, 148, 149, 150, 151, 153, 154, 155, 157, 158, 159, 160, 162, 163, 164, 166, 167, 168, 169, 171, 172, 173, 174, 175, 176, 177, 178, 179, 181, 182, 183, 184, 186, 186, 187, 188, 189, 190, 192, 193, 194, 195, 195, 196, 197, 199, 200, 201, 202, 202, 203, 204, 205, 206, 207, 208, 208, 209, 210, 211, 212, 213, 214, 214, 215, 216, 217, 218, 219, 219, 220, 221, 222, 223, 223, 224, 225, 226, 226, 227, 228, 228, 229, 230, 231, 232, 232, 232, 233, 234, 235, 235, 236, 236, 237, 238, 238, 239, 239, 240, 240, 241, 242, 242, 242, 243, 244, 245, 245, 246, 246, 247, 247, 248, 249, 249, 249, 250, 251, 251, 252, 252, 252, 253, 254, 255],
				    b = [53, 53, 53, 54, 54, 54, 55, 55, 55, 56, 57, 57, 57, 58, 58, 58, 59, 59, 59, 60, 61, 61, 61, 62, 62, 63, 63, 63, 64, 65, 65, 65, 66, 66, 67, 67, 67, 68, 69, 69, 69, 70, 70, 71, 71, 72, 73, 73, 73, 74, 74, 75, 75, 76, 77, 77, 78, 78, 79, 79, 80, 81, 81, 82, 82, 83, 83, 84, 85, 85, 86, 86, 87, 87, 88, 89, 89, 90, 90, 91, 91, 93, 93, 94, 94, 95, 95, 96, 97, 98, 98, 99, 99, 100, 101, 102, 102, 103, 104, 105, 105, 106, 106, 107, 108, 109, 109, 110, 111, 111, 112, 113, 114, 114, 115, 116, 117, 117, 118, 119, 119, 121, 121, 122, 122, 123, 124, 125, 126, 126, 127, 128, 129, 129, 130, 131, 132, 132, 133, 134, 134, 135, 136, 137, 137, 138, 139, 140, 140, 141, 142, 142, 143, 144, 145, 145, 146, 146, 148, 148, 149, 149, 150, 151, 152, 152, 153, 153, 154, 155, 156, 156, 157, 157, 158, 159, 160, 160, 161, 161, 162, 162, 163, 164, 164, 165, 165, 166, 166, 167, 168, 168, 169, 169, 170, 170, 171, 172, 172, 173, 173, 174, 174, 175, 176, 176, 177, 177, 177, 178, 178, 179, 180, 180, 181, 181, 181, 182, 182, 183, 184, 184, 184, 185, 185, 186, 186, 186, 187, 188, 188, 188, 189, 189, 189, 190, 190, 191, 191, 192, 192, 193, 193, 193, 194, 194, 194, 195, 196, 196, 196, 197, 197, 197, 198, 199];
				// noise value
				
				var noise = 20;
				
				for (var i=0; i < data.length; i+=4) """),format.raw("""{"""),format.raw/*570.43*/("""

			        // change image colors
			        data[i] = r[data[i]];
			        data[i+1] = g[data[i+1]];
			        data[i+2] = b[data[i+2]];
			        // apply noise

			        if (noise > 0) """),format.raw("""{"""),format.raw/*578.28*/("""
			            var noise = Math.round(noise - Math.random() * noise);
			            for(var j=0; j<3; j++)"""),format.raw("""{"""),format.raw/*580.39*/("""
			                var iPN = noise + data[i+j];
			                data[i+j] = (iPN > 255) ? 255 : iPN;
			            """),format.raw("""}"""),format.raw/*583.17*/("""
			        """),format.raw("""}"""),format.raw/*584.13*/("""
			    """),format.raw("""}"""),format.raw/*585.9*/("""
				idata.data = data;
				return idata;
			break;
			
			case "invert":
				for(var i = 0; i < data.length; i += 4) """),format.raw("""{"""),format.raw/*591.46*/("""
			          // red
			          data[i] = 255 - data[i];
			          // green
			          data[i + 1] = 255 - data[i + 1];
			          // blue
			          data[i + 2] = 255 - data[i + 2];
			        """),format.raw("""}"""),format.raw/*598.13*/("""
				idata.data = data;
				return idata;
			break;
			
			case "noise": 
				var er = 0; // extra red
				var eg = 0; // extra green
				var eb = 0; // extra blue
				var p1 = 0.99;
				var p2 = 0.99;
				var p3 = 0.99;
				for (var i = 0, n = data.length; i < n; i += 4) """),format.raw("""{"""),format.raw/*610.54*/("""
					// generating random color coefficients
					var randColor1 = 0.6 + Math.random() * 0.4;
					var randColor2 = 0.6 + Math.random() * 0.4;
					var randColor3 = 0.6 + Math.random() * 0.4;
					// assigning random colors to our data
					data[i] = data[i]*p2*randColor1+er; // green
					data[i+1] = data[i+1]*p2*randColor2+eg; // green
					data[i+2] = data[i+2]*p3*randColor3+eb; // blue
					"""),format.raw("""}"""),format.raw/*619.7*/("""
					// put image date back to context
					idata.data = data;
					return idata;
			break;
			
			case "strips":
				var weights = [1/9, 3/9, 3/9,
							   1/9, 1/9, 1/9,
							   1/9, 2/9, 1/9];
				var side = Math.round(Math.sqrt(weights.length));
				var halfSide = Math.floor(side / 2);
				var dst = data;
				// Iterate through the destination image pixels
				var opaque=1;
				var alphaFac = opaque ? 1 : 0;
				for (var y = 0; y < ch; y++) """),format.raw("""{"""),format.raw/*635.35*/("""
					for (var x = 0; x < cw; x++) """),format.raw("""{"""),format.raw/*636.36*/("""
						var sy = y;
						var sx = x;
						var dstOff = (y * cw + x) * 4;
						// Calculate the weighed sum of the source image pixels that fall under the convolution matrix
						var r = 0, g = 0, b = 0, a = 0;
						for (var cy = 0; cy < side; cy++) """),format.raw("""{"""),format.raw/*642.42*/("""
							for (var cx = 0; cx < side; cx++) """),format.raw("""{"""),format.raw/*643.43*/("""
								var scy = sy + cy - halfSide;
								var scx = sx + cx - halfSide;
								if (scy >= 0 && scy < ch && scx >= 0 && scx < cw) """),format.raw("""{"""),format.raw/*646.60*/("""
									var srcOff = (scy * cw + scx) * 4;
									var wt = weights[cy * side + cx];
									r += data[srcOff] * wt;
									g += data[srcOff+1] * wt;
									b += data[srcOff+2] * wt;
									a += data[srcOff+3] * wt;
								"""),format.raw("""}"""),format.raw/*653.10*/("""
							"""),format.raw("""}"""),format.raw/*654.9*/("""
						"""),format.raw("""}"""),format.raw/*655.8*/("""
						dst[dstOff] = r;
						dst[dstOff+1] = g;
						dst[dstOff+2] = b;
						dst[dstOff+3] = a + alphaFac * (255 - a);
					"""),format.raw("""}"""),format.raw/*660.7*/("""
				"""),format.raw("""}"""),format.raw/*661.6*/("""
				idata.data = data;
				return idata;

			break;
			case "tint":
				
				for(var i = 0; i < data.length; i+=4) """),format.raw("""{"""),format.raw/*668.44*/("""
					var average = (data[i] + data[i+1] + data[i+2]) /3;
					data[i] = average;
					data[i+1] = average + 30;
					data[i+2] = average;
				"""),format.raw("""}"""),format.raw/*673.6*/("""
				idata.data = data;
				return idata;
			  break;			  
			default:
			  return idata;
		"""),format.raw("""}"""),format.raw/*679.4*/("""
	"""),format.raw("""}"""),format.raw/*680.3*/("""
	var filterTimeout;
	function draw(v,c,w,h,filter) """),format.raw("""{"""),format.raw/*682.33*/("""
		//alert('W= '+w+', H= '+h);
		if(v.paused || v.ended)	return false;
		//localVideo.pause;
		ctx.drawImage(localVideo,0,0,w,h);

		if (typeof filter === 'undefined') """),format.raw("""{"""),format.raw/*688.39*/("""
		    // variable is undefined
		"""),format.raw("""}"""),format.raw/*690.4*/(""" else """),format.raw("""{"""),format.raw/*690.11*/("""
			var idata = ctx.getImageData(0,0,w,h);
			newdata = filterdata(idata,filter);
			//filterdata(idata,filter);
			ctx.putImageData(newdata,0,0);
		"""),format.raw("""}"""),format.raw/*695.4*/("""
		//console.log(filter);
		//localVideo.play;
		filterTimeout = setTimeout(draw,20,localVideo,ctx,w,h,filter);
		
	"""),format.raw("""}"""),format.raw/*700.3*/("""
		
	//TODO add some javaScript/JQuery logic here - controll it through webSocket messages from the server
		
</script>

""")))})),format.raw/*706.2*/("""
"""))}
    }
    
    def render(displayId:String,wsAddress:String,size:String) = apply(displayId,wsAddress,size)
    
    def f:((String,String,String) => play.api.templates.Html) = (displayId,wsAddress,size) => apply(displayId,wsAddress,size)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Feb 22 15:01:33 CET 2013
                    SOURCE: /srv/pdnet/MomentMachine/app/views/momentMachine.scala.html
                    HASH: 35142d31a794e979504aa24d6e65e4b5aa09af85
                    MATRIX: 777->2|901->54|933->57|963->79|997->81|1031->86|1058->105|1091->106|1170->155|1184->161|1244->200|1280->206|1313->210|1338->227|1371->228|1451->277|1466->283|1525->320|1562->326|1596->330|1629->354|1663->355|1743->404|1758->410|1824->454|1861->460|1895->464|1926->486|1960->487|2040->536|2055->542|2119->584|2156->590|2190->594|2217->612|2252->614|2319->634|2373->657|2388->663|2447->700|2502->709|2548->724|2619->764|2634->770|2701->815|2783->866|2798->872|2863->915|2945->966|2960->972|3018->1008|3610->1568|3626->1574|3687->1612|3756->1650|3771->1656|3830->1693|3960->1792|3975->1798|4034->1835|4253->2023|4268->2029|4326->2065|4565->2273|4580->2279|4633->2310|4844->2490|4859->2496|4912->2527|5225->2809|5240->2815|5301->2854|5478->3000|5493->3006|5551->3042|5732->3192|5747->3198|5805->3234|6257->3655|6288->3664|6537->3882|6568->3891|6613->3905|6639->3909|6727->3950|6835->4011|6907->4051|6939->4060|6986->4075|7013->4079|7065->4084|7139->4111|7245->4169|7356->4233|7428->4273|7460->4282|7507->4297|7534->4301|7586->4306|7661->4334|7770->4395|7900->4477|8024->4554|8164->4646|8301->4735|8464->4850|8709->5047|10059->6350|10110->6354|10248->6444|10750->6898|10963->7063|11411->7464|11512->7518|11621->7579|11698->7609|13083->8946|13143->8958|13211->8978|13298->9017|13646->9318|13793->9417|13874->9451|13929->9458|14038->9520|14118->9553|14426->9813|14535->9875|14621->9913|14739->9984|14822->10019|15111->10261|15191->10293|15706->10761|15779->10786|15853->10812|17489->12401|17565->12445|17597->12454|17649->12459|17937->12700|17987->12703|18068->12736|18243->12863|18324->12897|18374->12900|18454->12932|18728->13159|18804->13203|18836->13212|18887->13216|18971->13253|19055->13289|19254->13440|19317->13455|19928->14018|20020->14063|20097->14108|20129->14117|20345->14286|20399->14293|20471->14317|20563->14362|20643->14410|20675->14419|20891->14588|20945->14595|21107->14710|21185->14740|22182->15689|22271->15731|22351->15779|22383->15788|22436->15794|22521->15832|22572->15836|22654->15870|22842->16011|22922->16059|22954->16068|23006->16073|23089->16109|23164->16137|23254->16180|23504->16383|23559->16390|23671->16455|23777->16514|23922->16611|24130->16771|24245->16838|24325->16870|24427->16925|24507->16973|24539->16982|24593->16989|24683->17032|24779->17080|24893->17146|24973->17178|25074->17232|25152->17278|25184->17287|25238->17294|25325->17334|25376->17338|25494->17408|25583->17449|25715->17533|25972->17743|26363->18086|26434->18110|26539->18167|26716->18297|26947->18480|27071->18557|30903->22341|31148->22538|31305->22647|31474->22768|31535->22781|31591->22790|31758->22909|32012->23115|32334->23389|32781->23789|33283->24243|33367->24279|33669->24533|33760->24576|33944->24712|34227->24947|34283->24956|34338->24964|34513->25092|34566->25098|34731->25215|34922->25359|35062->25452|35112->25455|35213->25508|35430->25677|35512->25712|35567->25719|35764->25869|35928->25986|36082->26108
                    LINES: 27->2|30->2|32->4|32->4|32->4|34->6|34->6|34->6|35->7|35->7|35->7|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|43->15|43->15|43->15|44->16|44->16|44->16|45->17|46->18|46->18|46->18|48->20|49->21|49->21|49->21|50->22|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|68->40|68->40|68->40|70->42|70->42|70->42|72->44|72->44|72->44|76->48|76->48|76->48|81->53|81->53|81->53|85->57|85->57|85->57|92->64|92->64|92->64|96->68|96->68|96->68|100->72|100->72|100->72|116->88|116->88|125->97|125->97|125->97|125->97|127->99|130->102|132->104|132->104|133->105|133->105|134->106|136->108|138->110|141->113|143->115|143->115|144->116|144->116|145->117|147->119|149->121|152->124|154->126|157->129|159->131|163->135|168->140|185->157|186->158|189->161|200->172|205->177|211->183|215->187|217->189|219->191|253->225|253->225|253->225|255->227|262->234|264->236|266->238|266->238|268->240|270->242|282->254|285->257|287->259|290->262|292->264|298->270|300->272|313->285|315->287|316->288|353->325|355->327|355->327|356->328|361->333|362->334|364->336|368->340|370->342|371->343|373->345|380->352|382->354|382->354|383->355|386->358|388->360|394->366|394->366|412->384|414->386|416->388|416->388|424->396|425->397|427->399|429->401|431->403|431->403|439->411|440->412|446->418|448->420|465->437|467->439|469->441|469->441|470->442|472->444|473->445|475->447|481->453|483->455|483->455|484->456|486->458|489->461|492->464|498->470|498->470|501->473|505->477|509->481|512->484|514->486|514->486|516->488|518->490|518->490|519->491|521->493|521->493|523->495|523->495|525->497|527->499|527->499|528->500|530->502|531->503|535->507|537->509|540->512|548->520|563->535|565->537|566->538|570->542|579->551|583->555|598->570|606->578|608->580|611->583|612->584|613->585|619->591|626->598|638->610|647->619|663->635|664->636|670->642|671->643|674->646|681->653|682->654|683->655|688->660|689->661|696->668|701->673|707->679|708->680|710->682|716->688|718->690|718->690|723->695|728->700|734->706
                    -- GENERATED --
                */
            