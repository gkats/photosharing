package app.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

public class CollectionUtils {

	public static <T extends Object> List<T> asList(ListModel listModel, 
															Class<T> type) {
		
		List<T> res = new ArrayList<T>();
		for (int i = 0; i < listModel.getSize(); i++) {
			res.add(type.cast(listModel.getElementAt(i)));
		}
		return res;
	}
	
	public static <T extends Object> T[] extendModel(ListModel selected, T[] extras, 
															Class<T> type) {
		
		int selectedSize = selected.getSize();
		int extraSize = extras.length;
		@SuppressWarnings("unchecked")
		T[] augmented = (T[]) Array.newInstance(type, selectedSize + extraSize);
		
		// copy current
		for (int i = 0; i < selectedSize; i++) {
			augmented[i] = type.cast(selected.getElementAt(i));
		}
		// augment
		for (int i = 0; i < extraSize; i++) {
			augmented[selectedSize + i] = extras[i];
		}
		return augmented;
	}
}
