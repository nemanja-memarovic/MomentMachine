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
public class PhotoItem extends Model{

	private static final long serialVersionUID = 1L;
	
	@Id
	public Long id;
	
	public String fileName;
	public long likes;
	public long comments;
	public String fbId;
	public String displayID;
	
	public static Finder<Long, PhotoItem> find = new Finder<Long, PhotoItem>(Long.class, PhotoItem.class);

	
	public static List<PhotoItem> all() {
		return find.all();
	}
	
	public static PhotoItem addNew(PhotoItem dl) {
		dl.save();
		return dl;
	}
	
	public static PhotoItem get(Long id){
		return find.ref(id);
	}
	
	public static void updateLikes(Long id, long likes){
		PhotoItem tmp = find.ref(id);
		tmp.likes = likes;
		tmp.update();
	}
	
	public static void updateComments(Long id, long comments){
		PhotoItem tmp = find.ref(id);
		tmp.comments = comments;
		tmp.update();
	}
	
	public static void updateFbId(Long id, String fbId){
		PhotoItem tmp = find.ref(id);
		tmp.fbId = fbId;
		tmp.update();
	}
	
	public PhotoItem(String fileName, long likes, long comments, String displayID) {
		this.fileName = fileName;
		this.likes = likes;
		this.comments = comments;
		this.displayID = displayID;
	}
	
	
}
