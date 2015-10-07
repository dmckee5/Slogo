package slogo.element;

import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public abstract class AbstractList extends AbstractElement implements Observer {
	protected String title;
	protected Text text;
	protected boolean open;
	private int i = 1;
	ListView<String> list;
	ObservableList<String> data;

	public AbstractList(GridPane pane) {
		super(pane);
	}

	@Override
	protected void makePane() {
		title = slogoResources.getString(this.getClass().getName());
		open = true;
		text = new Text(title);
		text.setFont(font);
		text.setOnMouseClicked(e -> toggle());
		pane.add(text, 0, 0);
		data = FXCollections.observableArrayList();
		list = new ListView<String>(data);
		pane.add(list, 0, 1);
		toggle();
	}

	@Override
	public void update(Observable o, Object arg) {
		data.add((String) arg);
	}

	private void toggle() {
		if (open) {
			text.setText(">" + title);
			list.setItems(null);
			list.setMaxHeight(0);
		} else {
			text.setText("*" + title);
			list.setItems(data);
			list.setMaxHeight(Double.MAX_VALUE);
		}
		open = !open;
	}

	public void add(String s) {
		data.add(s);
		if (!open) {
			toggle();
		}
	}
}
