import java.util.HashMap;
import java.util.ArrayList;

public class Manager {

    private static final HashMap<Long, Epic> epics = new HashMap<>();
    private static final HashMap<Long, Task> tasks = new HashMap<>();
    private static final HashMap<Long, Subtask> subtasks = new HashMap<>();
    private static Long counter = 0L;


    //получаем список всех задач
    public static ArrayList<Task> getListOfAllTasks() {
        ArrayList<Task> allTasksList = new ArrayList<>();
        for (Long id : tasks.keySet()) {
            Task task = tasks.get(id);
            allTasksList.add(task);
        }
        return allTasksList;
    }

    public static ArrayList<Epic> getListOfAllEpics() {
        ArrayList<Epic> allEpicsList = new ArrayList<>();
        for (Long id : epics.keySet()) {
            Epic epic = epics.get(id);
            allEpicsList.add(epic);
        }
        return allEpicsList;
    }

    public static ArrayList<Subtask> getListOfAllSubtasks() {
        ArrayList<Subtask> allSubtasksList = new ArrayList<>();
        for (Long id : subtasks.keySet()) {
            Subtask subtask = subtasks.get(id);
            allSubtasksList.add(subtask);
        }
        return allSubtasksList;
    }

    //удаление всех задач
    public static void deleteAllTasks() {
        tasks.clear();
    }

    public static void deleteAllEpics() {
        for (Epic epic:getListOfAllEpics()){
            ArrayList<Subtask> listOfSubtasks = epic.getListOfSubtasks();
            listOfSubtasks.clear();
        }
        epics.clear();
    }

    public static void deleteAllSubtasks() {
        for (Epic epic:getListOfAllEpics()){
            ArrayList<Subtask> listOfSubtasks = epic.getListOfSubtasks();
            listOfSubtasks.clear();
        }
        subtasks.clear();
    }

    public static Epic getEpicById(Long id) {
        if (!epics.containsKey(id)) {
            System.out.println("Такого идентификатора нет");
            System.exit(0);
        }
        return epics.get(id);
    }

    public static Subtask getSubtaskById(Long id) {
        if (!subtasks.containsKey(id)) {
            System.out.println("Такого идентификатора нет");
            System.exit(0);
        }
        return subtasks.get(id);
    }

    //cоздание объект должен передаваться в качестве параметра
    public static void createTask(Task task) {
        task.setId(counter++);
        tasks.put(task.getId(), task);
    }

    public static void createEpic(Epic epic) {
        epic.setId(counter++);
        epics.put(epic.getId(), epic);
    }

    public static void createSubtask(Subtask subtask) {
        subtask.setId(counter++);
        subtasks.put(subtask.getId(), subtask);
        addToEpicSubs(subtask);
        updateEpicStatus(subtask);
    }

    //новая версия объекта с верным идентификатором предаютсья параметром
    public static void updateTask(Task task) {
        Long id = task.getId();

        if (!tasks.containsKey(id)) {
            System.out.println("Такого идентификатора нет");
            System.exit(0);
        }
        tasks.put(id, task);
    }

    public static void updateSubtask(Subtask subtask) {
        Long id = subtask.getId();

        if (!subtasks.containsKey(id)) {
            System.out.println("Такого идентификатора нет");
            System.exit(0);
        }
        changeInEpicSubs(subtask);
        subtasks.put(id, subtask);
        updateEpicStatus(subtask);
    }

    public static void deleteEpicById(Long id) {
        Epic epic = getEpicById(id);
        ArrayList<Subtask> listOfSubtasks = epic.getListOfSubtasks();
        listOfSubtasks.clear();
        epics.remove(id);
    }

    public static void deleteSubtaskById(Long id) {
        Subtask subtask = subtasks.get(id);
        removeFromEpicSubs(subtask);
        subtasks.remove(id);
        updateEpicStatus(subtask);
    }

    //добавление подзадачи в список к эпику
    public static void addToEpicSubs(Subtask subtask) {
        Long epicId = subtask.getEpicId();
        Epic epic = getEpicById(epicId);
        ArrayList<Subtask> listOfSubtasks = epic.getListOfSubtasks();
        listOfSubtasks.add(subtask);
    }

    //изменение епика
    public static void changeInEpicSubs(Subtask subtask) {
        Long epicId = subtask.getEpicId();
        Long id = subtask.getId();
        Epic epic = getEpicById(epicId);
        Subtask oldSubtask = getSubtaskById(id);
        ArrayList<Subtask> listOfSubtasks = epic.getListOfSubtasks();
        int index = listOfSubtasks.indexOf(oldSubtask);
        listOfSubtasks.set(index, subtask);
        epic.setListOfSubtasks(listOfSubtasks);
    }

    //удаление эпика
    public static void removeFromEpicSubs(Subtask subtask) {
        Long epicId = subtask.getEpicId();
        Epic epic = getEpicById(epicId);
        ArrayList<Subtask> listOfSubtasks = epic.getListOfSubtasks();
        listOfSubtasks.remove(subtask);
    }

    //проверка статусов подзадачи равны эпику
    public static boolean allEqual(ArrayList<Subtask> listOfSubtasks) {

        Subtask subtask0 = listOfSubtasks.get(0);
        Status subtask0Status = subtask0.getStatus();

        for (Subtask sub : listOfSubtasks) {
            Status subStatus = sub.getStatus();
            if (!subStatus.equals(subtask0Status)) {
                return false;
            }
        }
        return true;
    }

    //обновление статуса эпика
    public static void updateEpicStatus(Subtask subtask) {
        Long epicId = subtask.getEpicId();
        Epic epic = getEpicById(epicId);
        ArrayList<Subtask> listOfSubtasks = epic.getListOfSubtasks();

        if (listOfSubtasks.isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }
        Subtask subtask0 = listOfSubtasks.get(0);
        Status subtask0Status = subtask0.getStatus();

        boolean allEqual = allEqual(listOfSubtasks);
        if (allEqual) {
            epic.setStatus(subtask0Status);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }
}