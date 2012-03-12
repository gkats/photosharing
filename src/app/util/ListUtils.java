package app.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

public class ListUtils {

	public static <T extends Object> List<T> asList(ListModel listModel, 
															Class<T> type) {
		
		List<T> res = new ArrayList<T>();
		for (int i = 0; i < listModel.getSize(); i++) {
			res.add(type.cast(listModel.getElementAt(i)));
		}
		return res;
	}
}