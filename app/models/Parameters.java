/**
 * 
 * Developed by Nemanja Memarovic 
 * v1.0 
 * 23.11.2012
 * 
 */

package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Parameters extends Model{

	private static final long serialVersionUID = 1L;
	
	@Id
	public Long id;
	
	public String appId;
	public String appSecret;
	public String appAccessToken;
	public String url;
	public String permissions;
	public String pageId;
	public String pageAccessToken;
	
	public static Finder<Long, Parameters> find = new Finder<Long, Parameters>(Long.class, Parameters.class);

	
	public static List<Parameters> all() {
		return find.all();
	}
	
	public static Parameters addNew(Parameters dl) {
		dl.save();
		return dl;
	}
	
	public static Parameters get(Long id){
		return find.ref(id);
	}
	
	public static void updateAppAccessToken(Long id, String appAccessToken){
		Parameters tmp = find.ref(id);
		tmp.appAccessToken = appAccessToken;
		tmp.update();
	}
	
	public static void updatePageAccessToken(Long id, String pageAccessToken){
		Parameters tmp = find.ref(id);
		tmp.pageAccessToken = pageAccessToken;
		tmp.update();
	}
	
	public Parameters(String appId, String appSecret, String accessToken, String permissions, String url) {
		this.appId = appId;
		this.appSecret = appSecret;
		this.appAccessToken = accessToken;
		this.permissions = permissions;
		this.url = url;
	}
	
	
}
