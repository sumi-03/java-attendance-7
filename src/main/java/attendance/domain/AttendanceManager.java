package attendance.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AttendanceManager {
    private List<List<String>> crewAttendance;

    public AttendanceManager(List<List<String>> crewAttendance) {
        this.crewAttendance = crewAttendance;
    }

    public boolean containsNickname(String name) {
        Set<String> nickname = new HashSet<>();
        for (List<String> crewRecord : crewAttendance) {
            nickname.add(crewRecord.get(0));
        }

        return nickname.contains(name);
    }

    public void addAttendance(String name, String time) {
        List<String> crew = new ArrayList<>();
        crew.add(name);
        crew.add(time);
        crewAttendance.add(crew);
    }
}
