package selfservice.codecamp;


import java.util.ArrayList;
import java.util.List;
public class ImageTable {

	
	private List<List<String>> tableContents = new ArrayList<List<String>>();
	
	public void addRow(List<String> newRow) {
		tableContents.add(newRow);
	}
	
	public List<List<String>> getContents() {
		return tableContents;
	}
	
}
