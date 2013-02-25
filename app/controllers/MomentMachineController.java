/*
 * Based on public display template developed by Ivan Elhart and Marcello Romanelli
 * 
 * Developed by Nemanja Memarovic 
 * v1.0 
 * 23.11.2012
 * 
 * Changed by Ivan Elhart
 * v1.1
 * 04.02.2013
 */

package controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.lang.Long;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import javax.xml.bind.DatatypeConverter;

import models.AppLogger;
import models.PhotoItem;
import models.Location;
import models.Parameters;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.map.ObjectMapper;

import play.*;
import play.libs.Json;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.mvc.*;
import play.mvc.WebSocket.Out;

import views.html.*;

public class MomentMachineController extends Controller {
	
	public static String appName = "MomentMachine";
	public static String wsAddress = "ws://pdnet.inf.unisi.ch:9002/MomentMachine/socket";
	private static FacebookHook mmHook;
	private static List<Location> locationItems;
	//display size: small(600x1080), big(1320x1080), fullscreen(1920x1080)
	
	public static Result index(String displayID, String size) {
		Logger.info(appName+".displayConnecting, displayId: "+displayID+" ,size: "+size);
		
		File directory = new File (".");
		try {
			Logger.info("Current directory is"+directory.getCanonicalPath());
		} catch(Exception e) {
			Logger.info("Exceptione is ="+e.getMessage());
		  }
		AppLogger.addNew(new AppLogger(appName, "displayConnecting", new Date().toString(), " ", displayID));
		if(displayID == null) displayID = "99";
		if(size == null) size = "portrait";
		return ok(views.html.momentMachine.render(displayID, wsAddress, size));
	}//index()
	
  	//---- WS
	
	public static HashMap<String, Sockets> displaySockets = new HashMap<String, Sockets>();
	public static HashMap<WebSocket.Out<JsonNode>, String> displaySocketReverter = new HashMap<WebSocket.Out<JsonNode>, String>();
	
	public static WebSocket<JsonNode> webSocket() { 
		return new WebSocket<JsonNode>() {
	
			// Called when the Websocket Handshake is done.
			public void onReady(WebSocket.In<JsonNode> in, final WebSocket.Out<JsonNode> out){
	
				// For each event received on the socket 
				in.onMessage(new Callback<JsonNode>() { 
					public void invoke(JsonNode event) {
						//Logger.info("Hello Nemanja, nice to see you");
						String messageKind = event.get("kind").asText();						
						Logger.info(messageKind);
						//ws message - when client is ready
						if(messageKind.equals("appReady")){
							//save the connection for later use
							if(!displaySockets.containsKey(event.get("displayID"))){
								Logger.info(appName+".Socket(): new displayID= "+event.get("displayID")+" size="+event.get("size"));
								//Logger.info("Hello Nemanja, nice to see you");
								//TODO
								//do something with the app on display (displayID)
								//create a new instance of a scheduler for each display client and send content messages to the display client
								
								//Send helloWorld message to connected client
								ObjectNode msg = Json.newObject();
								msg.put("kind", "imageList");
								//msg.put("text", "Hello World!!!");
								List<PhotoItem> photoItems = PhotoItem.all();
								//Logger.info("In2");
								Logger.info("!photoItems.isEmpty(): "+!photoItems.isEmpty());
								if (!photoItems.isEmpty()) {
									Iterator<PhotoItem> iterator = photoItems.iterator();
									ArrayNode photos = msg.putArray("urls");

									//List<Location> locationItems = Location.all();
									//Logger.info("Locations "+photoItems.isEmpty());
									//Logger.info("In3");
									PhotoItem pItem;
									while (iterator.hasNext()) {
										Iterator<Location> lIterator = locationItems.iterator();
										pItem = iterator.next();
										ObjectNode row = Json.newObject();
										row.put("image_id", pItem.id);
										row.put("fileName", pItem.fileName);
										Logger.info(appName+"\nfile name: "+pItem.fileName);
										int index = Integer.parseInt(pItem.displayID);
										//Logger.info("index: "+index);
										while (lIterator.hasNext()) {
											Location loc = lIterator.next();
											//Logger.info("locaiton name: "+loc.locationName);
											if (loc.id == index) {
												//Logger.info("locaiton name: "+loc.locationName);
									            row.put("location", loc.locationName);
									            break;
											}
										}
										row.put("likes", pItem.likes);
										//row.put("shares", pItem.shares);
										photos.add(row);
									}
								/*String[] fileList;
								String path = "./public/images/"; 
								//String fileList=""; 
								String files;
								File folder = new File(path);
								File[] listOfFiles = folder.listFiles(); 
								Arrays.sort(listOfFiles);
								if (listOfFiles.length>0) {
									ArrayNode photos = msg.putArray("urls");
									for (int i = 0; i < listOfFiles.length; i++) 
									{
										if (listOfFiles[i].isFile()) 
										{
											files = listOfFiles[i].getName();
											if ((files.endsWith(".jpg") || files.endsWith(".JPG") || files.endsWith(".JPEG") || files.endsWith(".jpeg"))
													&&(files.startsWith("photobooth")))
											{
												Logger.info(appName+"\nfile name: "+files);
												//fileList = files + "**";
												photos.add(files);
											}
									    
										}
									}*/
									//msg.put("urls", fileList);
								} else {
									msg.put("urls", "empty");
								}
								Logger.info("Message: "+msg);
								out.write(msg);
								
								String displayid = event.get("displayID").asText();
								if(displayid != "null"){
									//register display
									displaySockets.put(event.get("displayID").asText(), new Sockets(out));
									displaySocketReverter.put(out, event.get("displayID").asText());
									
								}//if
								AppLogger.addNew(new AppLogger(appName, "displayNew", "data", "", event.get("displayID").toString()));
								
							}//if
	
						}//appReady
						Logger.info(appName+" message kind, displayId: "+event.get("displayID")+" ,message kind: "+ messageKind);
						//ws message - image received from the client
						if(messageKind.equals("saveimage") || messageKind.equals("savefacebook")){
							//save the connection for later use
							if(!displaySockets.containsKey(event.get("displayID"))){
								//Logger.info(appName+".Socket(): displayID= "+event.get("displayID")+" image="+event.get("image"));
									String string = event.get("image").toString();
									String[] parts = string.split("base64,");
									String base64Image = parts[1]; // 034556
									//Logger.info(appName+".Socket(): displayID= "+event.get("displayID")+" image= \n"+base64Image);
									byte[] decodedBytes = DatatypeConverter.parseBase64Binary(base64Image);
									BufferedImage image;
									//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
									   //get current date time with Date()
									Date date = new Date();
									try {
										image = ImageIO.read( new ByteArrayInputStream( decodedBytes ) );
										String fileName = "momentmachine-"+event.get("year").toString()+"-"+event.get("month").toString().substring(1,3)+"-"+event.get("day").toString().substring(1,3)+"-"+event.get("hour").toString().substring(1,3)+"-"+event.get("minute").toString().substring(1,3)+"-"+event.get("seconds").toString().substring(1,3)+"-"+event.get("displayID").toString()+".jpg";//dateFormat.format(date)+".jpg";
										ImageIO.write(image, "JPG", new File("public/images/"+ fileName));
										PhotoItem pi = PhotoItem.addNew(new PhotoItem(fileName,0,0,event.get("displayID").toString()));
										PhotoItem.updateFbId(pi.id,"none");
										//List<Location> locationItems = Location.all();
										Iterator<Location> lIterator = locationItems.iterator();
										int index = Integer.parseInt(event.get("displayID").toString());
										String location="";
										while (lIterator.hasNext()) {
											Location loc = lIterator.next();
											//Logger.info("locaiton name: "+loc.locationName);
											if (loc.id == index) {
												//Logger.info("locaiton name: "+loc.locationName);
										        location = loc.locationName;
										        break;
											}
										}
										AppLogger.addNew(new AppLogger(appName, "image saved", new Date().toString(), fileName, event.get("displayID").toString()));
										ObjectNode msg = Json.newObject();
										msg.put("kind", "newImage");
										msg.put("image_id", pi.id);
										msg.put("fileName", fileName);
										msg.put("location", location);
										msg.put("likes", 0);
										//msg.put("shares", 0);
										//out.write(msg);
										//Logger.info("Filename: "+fileName);
										if (messageKind.equals("savefacebook")) {
											Iterator<Location> lIterator1 = locationItems.iterator();
											
											Long index1 = Long.parseLong(event.get("displayID").toString());
											//Logger.info("index: "+index);
											while (lIterator1.hasNext()) {
												Location loc = lIterator1.next();
												//Logger.info("locaiton name: "+loc.locationName);
												if (loc.id == index1) {
													ObjectMapper mapper = new ObjectMapper();
													ObjectNode response = mapper.readValue(mmHook.postToFacebook(mmHook.getPageAccessToken(), loc.fbAlbum, "photos", "&url=http://pdnet.inf.unisi.ch/momentmachine/images/"+fileName), ObjectNode.class);
													Logger.info(response.get("id").toString());
													String resp = response.get("id").toString();
													resp = resp.substring(1, resp.length()-1);
													PhotoItem.updateFbId(pi.id,resp);
													//Logger.info(mmHook.postToFacebook(mmHook.getPageAccessToken(), loc.fbAlbum, "photos", "&url=http://pdnet.inf.unisi.ch/momentmachine/images/"+fileName));
										            
										            break;
												}
											}
										}
										//send looping tweets to all connected clients
										Set<?> set = displaySockets.entrySet();
										// Get an iterator
										Iterator<?> i = (Iterator<?>) set.iterator();
										// Display elements
										while(i.hasNext()) {
											Map.Entry ds = (Map.Entry)i.next();
											Logger.info("PhotoBoothController: broadcasting new image to displayID="+ds.getKey()+" socket="+ds.getValue().toString());
											displaySockets.get(ds.getKey()).wOut.write(msg);
										}//while 
										
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
							}//if
	
						}//saveimage
						
						if(messageKind.equals("imagetaken")){
							AppLogger.addNew(new AppLogger(appName, "image taken", new Date().toString(), " ", event.get("displayID").toString()));
						}//imagetaken
						
						if(messageKind.equals("imagediscarded")){
							AppLogger.addNew(new AppLogger(appName, "image discarded", new Date().toString(), " ", event.get("displayID").toString()));
						}//imagediscarded
						
						if(messageKind.equals("runoutoftime")){
							AppLogger.addNew(new AppLogger(appName, "run out of time", new Date().toString(), " ", event.get("displayID").toString()));
						}//runoutoftime
						
						if(messageKind.equals("changefilter")){
							AppLogger.addNew(new AppLogger(appName, "filter changed", new Date().toString(), " ", event.get("displayID").toString()));
						}//changefilter
						
						if(messageKind.equals("scrolldown")){
							AppLogger.addNew(new AppLogger(appName, "scroll down", new Date().toString(), " ", event.get("displayID").toString()));
						}//scrolldown
						
						if(messageKind.equals("scrollup")){
							AppLogger.addNew(new AppLogger(appName, "scroll up", new Date().toString(), " ", event.get("displayID").toString()));
						}//scrollup
						
						//ws message - when client is ending connection
						if(messageKind.equals("appClose")){
							Logger.info(appName+".webSocket(): appClose - displayID="+event.get("displayID")+" size="+event.get("size"));
						}
						
						//TODO
						//TODO add more messages from clients such as appReady or appClose as needed
						//TODO
	
					}//invoke
				});//in.onMessage
	
				// When the socket connection is closed. 
				in.onClose(new Callback0() {
					public void invoke() { 
						String displayID =displaySocketReverter.get(out);
						displaySocketReverter.remove(out);
						displaySockets.remove(displayID);
						AppLogger.addNew(new AppLogger(appName, "displayDisconect", new Date().toString(),"", displayID));
						Logger.info(appName+".Socket(): display "+displayID+" is disconnected; number of connected displays: "+displaySockets.size());
					}//invoke
				});//in.onClose
	
			}//onReady
		};//WebSocket<String>()
	}//webSocket() { 
	
	public static class Sockets {
		public WebSocket.Out<JsonNode> wOut;
	
		public Sockets(Out<JsonNode> out) {
			this.wOut = out;
		}
	}//class
  
  //WS ----
  //-------------------Facebook init -------------------
	public static void initFacebook(){
		String tmp = "\"12344567\"";
		System.out.println(tmp);
		System.out.println(tmp.substring(1, tmp.length()-1));
		Logger.info("initFacebook:");
		Parameters params = Parameters.get(new Long(1));
		
		mmHook = new FacebookHook();
		mmHook.init(params.permissions, params.appSecret, params.appId, params.url, params.appAccessToken, params.pageId, params.pageAccessToken);
		locationItems = Location.all();
		
		Logger.info("mmHook.getPageAccessToken(): "+mmHook.getPageAccessToken()+", mmHook.getPageId(): "+mmHook.getPageId());
		//mmHook.init(new String[] {"publish_stream", "user_photos"}, "069ca85e8e61a4d7926af41d6932b2f6", "137934469664440", "https://pdnet.inf.unisi.ch/MomentMachine/");
	}//initFacebook()
  
}