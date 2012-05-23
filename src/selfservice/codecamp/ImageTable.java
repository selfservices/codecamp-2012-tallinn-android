package selfservice.codecamp;


import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
public class ImageTable {

	
	private List<List<Bitmap>> tableContents = new ArrayList<List<Bitmap>>();
	
	public void addRow(List<Bitmap> newRow) {
		tableContents.add(newRow);
	}
	
	public List<List<Bitmap>> getContents() {
		return tableContents;
	}
	
}
