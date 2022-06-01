package comparator;

import model.Student;
import java.util.Comparator;

public class SortByDown implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAverageSubject() - o2.getAverageSubject() > 0) {
            return 1;
        } else if (o1.getAverageSubject() - o2.getAverageSubject() == 0) {
            return 0;

        } else
            return -1;
    }
}
