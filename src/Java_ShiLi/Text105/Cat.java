/**  
* <p>Title: Cat.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Apr 2, 2019  
* @version 1.0  
*/ 
package Java_ShiLi.Text105;

import java.awt.Color;

/**  
* <p>Title: Cat</p>  
* <p>Description: </p>  
* @author ÂíÀ¤  
* @date Apr 2, 2019  
*/
public class Cat {
	private String name;
	private int age;
	private double weight;
	private Color color;
	/**  
	* <p>Title: </p>  
	* <p>Description: </p>    
	*/
	public Cat(String name, int age, double weight, Color color) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cat cat = (Cat)obj;
		return name.equals(cat.name) && (age == cat.age) && (weight == cat.weight) && (color.equals(cat.color));
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 7*name.hashCode() + 11*new Integer(age).hashCode() + 13*new Double(weight).hashCode() + 17*color.hashCode();
	}

}
