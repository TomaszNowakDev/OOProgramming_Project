package storage;

import java.io.Serializable;

public interface Storage extends Serializable{
	public Object read();

	public void save(Object o);

}
