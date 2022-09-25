/**
 * CPSC 319 Assignment 4
 * Created by: Aarushi Roy Choudhury
 * Date: 2022-04-01
 * Version: 6.3
 */

public class LList<T> {
	T data;
	LList<T> next;

	LList(T data) {
		this.data = data;
		next = null;
	}

	LList() {
		this(null);
	}

	public void add(T data) {
		if (this.data == null)
			this.data = data;
	}
}
