public class Subtask extends Task {
    private final Long epicId;

    public Subtask(Long epicId, String name, String description, Status status) {
        super(name, description, status);
        this.epicId = epicId;
    }

    public Long getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "epicId=" + epicId +
                '}';
    }

}
