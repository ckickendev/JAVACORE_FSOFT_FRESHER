/**
 * 
 */
package fa.training.models;

import java.util.Comparator;

/**
 * 
 *
 */
public class CourseTitleCompare implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		return o1.getId().compareToIgnoreCase(o2.getId());
	}

}
