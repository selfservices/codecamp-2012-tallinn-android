package selfservice.codecamp;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TableLayout;

public class ImageButtonOnClickEvent implements OnClickListener {

	private final ImageTable result; 
	private final Bitmap image;
	private final TableLayout table;
	private final Context context;
	private final ImageButton button;
	
	private static Bitmap selectedImageOne;
	private static Bitmap selectedImageTwo;
	
	public ImageButtonOnClickEvent(ImageTable result, Bitmap image, TableLayout table, Context context,ImageButton button) {
		this.result = result;
		this.image = image;
		this.table = table;
		this.context = context;
		this.button = button;
	}

	@Override
	public void onClick(View v) {
		button.setSelected(true);
//		button.set
		if(selectedImageOne == null) {
			selectedImageOne = image;

			Log.e("2","ONE NULL");
		} else if(selectedImageTwo == null) {
			selectedImageTwo = image;
			Log.e("2","TWO NULL");

		}
		if(selectedImageTwo != null) {
			Log.e("2","REDRAW");
			//Swap images
			//redraw
			table.removeAllViews();
			PuzzleImageLoader.drawImageTable(result, context, table);
			//Clear
			selectedImageOne = null;
			selectedImageOne = null;
		}
		
		
	}

}
