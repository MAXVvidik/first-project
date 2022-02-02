import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Task task0 = new Task("АААААААААААА", "БББББББББББ", Status.NEW);
        Task task1 = new Task("ВВВВВВВВВВ", "ГГГГГГГГГГГ", Status.DONE);
        Epic epic2 = new Epic("ДДДДДДДДДДД", "ЕЕЕЕЕЕЕЕЕЕЕЕЕЕ");
        Epic epic3 = new Epic("УУУУУУУУУУУУ", "МММММММММММ");
        Subtask subtask4 = new Subtask(2L, "КККККККККККККК", "ХХХХХХХХХХХ", Status.DONE);
        Subtask subtask5 = new Subtask(2L, "ФФФФФФФФФФФФ", "ИИИИИИИИИИ", Status.DONE);
        Subtask subtask6 = new Subtask(3L, "ЯЯЯЯЯЯЯЯЯЯЯЯ", "ФФФФФФФФФФФФ", Status.NEW);


        //создаем 2 задачи 1 эпик с 2 подзадачами 1 эпик с 1 подзадачей
        Manager.createTask(task0);
        Manager.createTask(task1);
        Manager.createEpic(epic2);
        Manager.createEpic(epic3);
        Manager.createSubtask(subtask4);
        Manager.createSubtask(subtask5);
        Manager.createSubtask(subtask6);
        //////////////////////////////////////////
        //печатаем список эпиков поздазач задач
        System.out.println("Создайте 2 задачи, один эпик с 2 подзадачами, а другой эпик с 1 подзадачей.");
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все задачи:");
        printTask(Manager.getListOfAllTasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все эпики:");
        printEpic(Manager.getListOfAllEpics());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все подзадачи:");
        printSubtask(Manager.getListOfAllSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-2 поздадача");
        printSubtask(epic2.getListOfSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-3 подзадача");
        printSubtask(epic3.getListOfSubtasks());



        //статусы эпика и подзадач
        task0.setStatus(Status.DONE);
        task1.setStatus(Status.IN_PROGRESS);
        subtask4.setStatus(Status.DONE);
        subtask5.setStatus(Status.NEW);
        subtask6.setStatus(Status.IN_PROGRESS);
        ///////////////////////////////////////////////
        //проверка на изменение статуа задачи подадачи
        Manager.updateTask(task0);
        Manager.updateTask(task1);
        Manager.updateSubtask(subtask4);
        Manager.updateSubtask(subtask5);
        Manager.updateSubtask(subtask6);
        /////////////////////////////////////////////////////
        //изменяем статусы обьектов котоыре создали и печатем
        System.out.println("Измените статусы созданных объектов, распечатайте.");
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все задачи:");
        printTask(Manager.getListOfAllTasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все эпики:");
        printEpic(Manager.getListOfAllEpics());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все подзадачи:");
        printSubtask(Manager.getListOfAllSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-2 поздадача");
        printSubtask(epic2.getListOfSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-3 подзадача");
        printSubtask(epic3.getListOfSubtasks());
        /////////////////////////////////////////
        //удалить одну из задач и один из эпиков
        Manager.deleteSubtaskById(5L);
        Manager.deleteEpicById(2L);
        System.out.println("Удалите одну из задач и один из эпиков.");
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все задачи:");
        printTask(Manager.getListOfAllTasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все эпики:");
        printEpic(Manager.getListOfAllEpics());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все подзадачи:");
        printSubtask(Manager.getListOfAllSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-2 поздадача");
        printSubtask(epic2.getListOfSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-3 подзадача");
        printSubtask(epic3.getListOfSubtasks());
        //////////////////////////////////////////
        //удаляем все задачи эпики подзадачи
        Manager.deleteAllTasks();
        Manager.deleteAllEpics();
        Manager.deleteAllSubtasks();
        System.out.println("Удаление всех задач");
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все задачи:");
        printTask(Manager.getListOfAllTasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все эпики:");
        printEpic(Manager.getListOfAllEpics());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Все подзадачи:");
        printSubtask(Manager.getListOfAllSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-2 поздадача");
        printSubtask(epic2.getListOfSubtasks());
        System.out.println("/*/*/*/*/*/**/**/");
        System.out.println("Эпик-3 подзадача");
        printSubtask(epic3.getListOfSubtasks());

    }

    public static void printTask (ArrayList <Task> list){
        for (Task task:list){
            System.out.println(task.toString());
        }
    }

    public static void printEpic (ArrayList <Epic> list){
        for (Epic epic:list){
            System.out.println(epic.toString());
        }
    }

    public static void printSubtask (ArrayList <Subtask> list){
        for (Subtask subtask:list){
            System.out.println(subtask.toString());
        }
    }
}
