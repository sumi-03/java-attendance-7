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

    public String modifyAttendance(String name, String day, String time) {
        List<String> modified = new ArrayList<>();
        String oldTime = "";
        modified.add(name);
        modified.add("2024-12-" + day + " " + time);
        for (int i = 0; i < crewAttendance.size(); i++) {
            List<String> crewRecord = crewAttendance.get(i);
            String include = "2024-12-" + day;
            if (crewRecord.get(0).equals(name) && crewRecord.get(1).contains(include)) {
                oldTime = crewRecord.get(1).substring(11);
                crewAttendance.set(i, modified);
                break;
            }
        }
        return oldTime;
    }
}
