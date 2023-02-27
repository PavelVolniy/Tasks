package linkedlist;

import java.util.*;

public class Installer implements Subsystem {
    private List<Subsystem> objects;
    private List<Integer> distances;
    private int distance = 0;
    private String name;
    private int version;
    private Subsystem[] prerequisites;
    private Queue<Subsystem> queue = new PriorityQueue<>(new Comparator<Subsystem>() {
        @Override
        public int compare(Subsystem o1, Subsystem o2) {
            if (o1.getName().equals(o2.getName())) return o1.getVersion() - o2.getVersion();
            else return o2.getName().compareTo(o1.getName());
//            return o1.getPrerequisites().length - o2.getPrerequisites().length;
        }
    });

    public Installer(String name, int version, Subsystem[] prerequisites) {
        this.name = name;
        this.version = version;
        this.prerequisites = prerequisites;
        objects = new ArrayList<>();
        distances = new ArrayList<>();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getVersion() {
        return version;
    }

    public Installer setName(String name) {
        this.name = name;
        return this;
    }

    public Installer setVersion(int version) {
        this.version = version;
        return this;
    }

    public Installer setPrerequisites(Subsystem[] prerequisites) {
        this.prerequisites = prerequisites;
        return this;
    }

    @Override
    public void install() {
        System.out.printf("%s version %d installed successfully\n", name, version);
    }

    @Override
    public Subsystem[] getPrerequisites() {
        return prerequisites;
    }

    public Queue<Subsystem> setUpPlan() {
        if (prerequisites != null && prerequisites.length != 0) {
            checkPrerequisites(this);
        } else if (prerequisites.length == 0) queue.add(this);

        queue.stream().sorted(new Comparator<Subsystem>() {
            @Override
            public int compare(Subsystem o1, Subsystem o2) {
                if (o1.getName().equals(o2.getName())) return o1.getVersion() - o2.getVersion();
                else return o2.getName().compareTo(o1.getName());
            }
        });
        return queue;
    }

    private void checkPrerequisites(Subsystem object) {
        if (object.getPrerequisites() != null && object.getPrerequisites().length != 0 && objects != null) {
            for (int i = 0; i < object.getPrerequisites().length && objects != null; i++) {
                objects.add(object);
                distances.add(null);
                distance++;
                checkPrerequisites(object.getPrerequisites()[i]);
            }
        } else if (object.getPrerequisites() != null && object.getPrerequisites().length == 0) {
            objects.add(object);
            distances.add(distance);
            distance = 0;
            if (checkListDuplicate((ArrayList<Subsystem>) objects)) {
                objects = null;
                distances.clear();
                distance = 0;
                queue.clear();
            } else {
                if (queue.isEmpty()){
                    for (Subsystem item : objects) queue.add(item);
                } else {
                    ArrayList<Subsystem> arr = new ArrayList<>(queue);
                    for (int i = 0; i < arr.size(); i++) {
                        for (int j = 0; j < objects.size(); j++) {
                            if (objects.get(j).getName() == arr.get(i).getName()){
                                if (objects.get(j).getVersion() == arr.get(i).getVersion()) objects.remove(j);
                            }
                        }
                    }
                    arr.clear();
                    queue.addAll(objects);
                }
                objects.clear();
            }

        } else if (object == null || object.getPrerequisites() == null) printErrorMessage(object.getName());
    }

    private boolean checkListDuplicate(ArrayList<Subsystem> list) {
        for (int i = 0; i < list.size(); i++) {
            Subsystem item = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (item == list.get(j)) return true;
            }
        }
        return false;
    }

    private ArrayList<Subsystem> removeDuplicate(ArrayList<Subsystem> list) {
        for (int i = 0; i < list.size(); i++) {
            Subsystem item = list.get(i);
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).equals(item)) list.remove(i);
            }
        }
        return list;
    }


    private void printErrorMessage(String name) {
        System.out.printf("SetUp plan calculation failed. Wrong prerequisite description at %s version %d. ",
                name, this.version);
    }


    public static void setUp(Queue<Subsystem> list) {
        if (list != null && !list.isEmpty()) while (!list.isEmpty()) list.poll().install();
    }

    @Override
    public String toString() {
        return "Installer{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }

}
