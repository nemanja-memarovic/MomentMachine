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
public class Location extends Model{

	private static final long serialVersionUID = 1L;
	
	@Id
	public Long id;
	
	public String locationName;
	public String fbAlbum;
	
	public static Finder<Long, Location> find = new Finder<Long, Location>(Long.class, Location.class);

	
	public static List<Location> all() {
		return find.all();
	}
	
	public static Location addNew(Location dl) {
		dl.save();
		return dl;
	}
	
	public static Location get(Long id){
		return find.ref(id);
	}
	
	public static void update(Long id, String name){
		Location tmp = find.ref(id);
		tmp.locationName = name;
		tmp.update();
	}
	
	public Location(String locationName) {
		this.locationName = locationName;
	}
	
	
}
