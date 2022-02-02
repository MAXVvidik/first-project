import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Subtask> listOfSubtasks = new ArrayList<>();

    public Epic(String name, String description) {

        super(name, description);
    }

    public ArrayList<Subtask> getListOfSubtasks() {
        return listOfSubtasks;
    }

    public void setListOfSubtasks(ArrayList<Subtask> listOfSubtasks) {
        this.listOfSubtasks = listOfSubtasks;
    }

    @Override
    public String toString() {
        return super.toString() +
                "listOfSubtasks=" + listOfSubtasks +
                '}';
    }
}
