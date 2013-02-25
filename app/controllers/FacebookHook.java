package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.map.ObjectMapper;

public class FacebookHook {
    // get these from your FB Dev App
    private String appSecret;
    private String appId;

    // set this to your servlet URL for the authentication servlet/filter
    private String appRedirectUrl;
    /// set this to the list of extended permissions you want
    private String[] appPerms;// = new String[] {"publish_stream", "email"};
    private String appToken;
    private String pageId;
    private String pageAccessToken;
    
    //TODO init form db
    
    public void init(String[] perms, String secret, String appID, String redirectURL) {
    	this.setPermissions(perms);
    	this.setSecret(secret);
    	this.setAppID(appID);
    	this.setRedirectURL(redirectURL);
    }
    
    public void init(String perms, String secret, String appID, String redirectURL) {
    	this.setPermissions(perms);
    	this.setSecret(secret);
    	this.setAppID(appID);
    	this.setRedirectURL(redirectURL);
    }
    
    public void init(String perms, String secret, String appID, String redirectURL, String appToken, String pageId, String pAT) {
    	this.setPermissions(perms);
    	this.setSecret(secret);
    	this.setAppID(appID);
    	this.setRedirectURL(redirectURL);
    	this.setAppToken(appToken);
    	this.setPageId(pageId);
    	this.setPageAccessToken(pAT);
    }
    
    public String parseForCodeOrToken(URL url, String codeOrToken) {
    	String returnValue="";
    	
    	return returnValue;
    }
    
    private String parsePermissions() {
    	String permissions="";
    	permissions = this.appPerms[0];
    	if (this.appPerms.length>1) {
    		for(int i=1; i< this.appPerms.length; i++) {
    			permissions = permissions + "," + this.appPerms[i];
    		}
    	}
    	return permissions;
    }
    
    public void setPermissions(String[] permissions) {
    	this.appPerms = new String[permissions.length];
    	System.arraycopy(permissions, 0, this.appPerms, 0, permissions.length);
    }
    
    public void setPermissions(String permissions) {
    	String[] parts = permissions.split(",");
    	this.appPerms = new String[parts.length];
    	System.arraycopy(parts, 0, this.appPerms, 0, parts.length);
    }
    
    public String getRedirectURL() {
    	return this.appRedirectUrl;
    }
    
    public void setRedirectURL(String url) {
    	this.appRedirectUrl = url;
    }
    
    public String getAppToken() {
        return appToken;
    }
    
    public void setAppToken(String new_token) {
         this.appToken = new_token;
    }
    
    public String getAppID() {
        return appId;
    }
    
    public void setAppID(String appID) {
        this.appId = appID;
    }

    public String getSecret() {
        return appSecret;
    }
    
    public void setSecret(String secret) {
        this.appSecret = secret;
    }
    
    public String getPageId() {
        return pageId;
    }
    
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    
    public String getPageAccessToken() {
        return pageAccessToken;
    }
    
    public void setPageAccessToken(String pageAccessToken) {
        this.pageAccessToken = pageAccessToken;
    }
    
    public String getOAuthURL() {
        return "https://www.facebook.com/dialog/oauth?client_id=" +//"https://graph.facebook.com/oauth/access_token?client_id=" +
            getAppID() + "&redirect_uri=" +
            getRedirectURL()+"&scope="+parsePermissions();
    }

    public String getTokenURL(String authCode) {
    	
    		String rValue="";

			try {
				System.out.println("\n\n*****getTokenURL****\n");
	    		URL tUrl;
				tUrl = new URL("https://graph.facebook.com/oauth/access_token?client_id=" +
				        getAppID()+"&redirect_uri=" +
				        getRedirectURL()+"&client_secret="+getSecret()+"&code="+authCode);
				BufferedReader in;
    		
				in = new BufferedReader(
    				new InputStreamReader(tUrl.openStream()));
				String iLine="";
				while ((iLine = in.readLine()) != null) {
					//System.out.println(iLine);
					rValue = iLine;
				}
				in.close();
				//System.out.println("\n\nrValue before delim "+rValue);
				String delims = "access_token=";
				String[] tokens = rValue.split(delims);	
				//for (String item: tokens) System.out.println("\n\t Tokens"+item);
				rValue = tokens[1];
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rValue;
    }
    
 public String postToFacebook(String accessToken, String userId, String action, String params) {
	 	
	 String rValue="";
	 
		try {
			String urlParameters = "access_token="+accessToken+params;
			String request = "https://graph.facebook.com/"+userId+"/"+action;
			URL url = new URL(request); 
			System.out.println("Url: "+url.toString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();           
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false); 
			connection.setRequestMethod("POST"); 
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
			connection.setUseCaches (false);

			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
			DataInputStream input = new DataInputStream(connection.getInputStream()); 
			for( int c = input.read(); c != -1; c = input.read() ) rValue = rValue + (char)c;
			
			connection.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rValue;
    }
    
    public String getAlbums(String aToken, String userId) {
    	
		String rValue="";

		try {
			System.out.println("\n\n*****getTokenURL****\n");
    		URL tUrl;
			tUrl = new URL("https://graph.facebook.com/"+userId+"/albums?access_token=" + aToken);
			BufferedReader in;
		
			in = new BufferedReader(
				new InputStreamReader(tUrl.openStream()));
			String iLine="";
			while ((iLine = in.readLine()) != null) {
				//System.out.println(iLine);
				rValue = iLine;
			}
			in.close();
			//System.out.println("\nReturn value is "+rValue+"\n");
			//URL tokenUrl = new URL(iLine);
			//System.out.println("\n\n*****access token URL****\n"+iLine);
			//String token[] = (tokenUrl.getQuery()).split("=");	
			//rValue = token[1];
			//System.out.println("\n\n*****access token ****\n"+rValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		rValue = "{ error: { type: \"OAuthException\", message: " +
//				"\"Session has expired at unix time SOME_TIME. " +
//				"The current unix time is SOME_TIME.\" }, } ";
		
		this.checkTokenExpiration(rValue);
		return rValue;
    }

public String getPhotoLikesCmmentsTags(String aToken, String photoId) {
    	
		String rValue="";

		try {
			System.out.println("\n\n*****getTokenURL****\n");
    		URL tUrl;
			tUrl = new URL("https://graph.facebook.com/"+photoId+"?likes&comments&tags&access_token=" + aToken);
			BufferedReader in;
		
			in = new BufferedReader(
				new InputStreamReader(tUrl.openStream()));
			String iLine="";
			while ((iLine = in.readLine()) != null) {
				//System.out.println(iLine);
				rValue = iLine;
			}
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.checkTokenExpiration(rValue);
		return rValue;
    }

public ObjectNode getPhotoLikesCmmentsTags(String aToken, String photoId) {
	
	String rValue="";
	
	try {
		System.out.println("\n\n*****getTokenURL****\n");
		URL tUrl;
		tUrl = new URL("https://graph.facebook.com/"+photoId+"?likes&comments&tags&access_token=" + aToken);
		BufferedReader in;
	
		in = new BufferedReader(
			new InputStreamReader(tUrl.openStream()));
		String iLine="";
		while ((iLine = in.readLine()) != null) {
			//System.out.println(iLine);
			rValue = iLine;
		}
		in.close();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	this.checkTokenExpiration(rValue);
	
	ObjectMapper mapper = new ObjectMapper();
	ObjectNode response = mapper.readValue(rValue, ObjectNode.class);
	
	return response;
}
    
public String getPages(String aToken) {
    	
		String rValue="";

		try {
			System.out.println("\n\n*****getPagesURL****\n");
    		URL tUrl;
			tUrl = new URL("https://graph.facebook.com/me/accounts?access_token=" + aToken);
			BufferedReader in;
		
			in = new BufferedReader(
				new InputStreamReader(tUrl.openStream()));
			String iLine="";
			while ((iLine = in.readLine()) != null) {
				//System.out.println(iLine);
				rValue = iLine;
			}
			in.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.checkTokenExpiration(rValue);
		return rValue;
    }
    
	public String getPhotosForAlbum(String aToken, String aid) {
	    	
		String rValue="";
	
		try {
			System.out.println("\n\n*****getTokenURL****\n");
    		URL tUrl;
			tUrl = new URL("https://graph.facebook.com/"+aid+"/photos?access_token=" + aToken);
			BufferedReader in;
		
			in = new BufferedReader(
				new InputStreamReader(tUrl.openStream()));
			String iLine="";
			while ((iLine = in.readLine()) != null) {
				//System.out.println(iLine);
				rValue = iLine;
			}
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.checkTokenExpiration(rValue);
		return rValue;
	}
    
	private void checkTokenExpiration(String token) {
		if (token.toUpperCase().indexOf("error".toUpperCase()) != -1) {
			if (token.toUpperCase().indexOf("OAuthException".toUpperCase()) != -1) {
				System.out.println("OAuthException");
				// Retrieving a valid access token.
				token = "<script> top.location.href='https://graph.facebook.com/oauth/access_token?client_id=" +
				        getAppID()+"&redirect_uri=" +
				        getRedirectURL()+"'</script>";
			} else {
				System.out.println("Other error");
				token = "Other error has happened";
			} 
		} 	
	}
	
}
