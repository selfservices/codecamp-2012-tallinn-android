package selfservice.codecamp.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtils {

	public static Bitmap[][] toBitmapArray(Object[][] objects) {
		Bitmap[][] result = new Bitmap[objects.length][0];
		for (int i = 0; i < result.length; i++) {
			result[i] = new Bitmap[objects[i].length];
			for (int j = 0; j < result[i].length; j++) {
				byte[] bytes = (byte[]) objects[i][j];
				result[i][j] = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);				
			}
		}
		return result;
	}
	
}
