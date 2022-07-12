package module;

public class Subject {
    private String subject_id;
    private String student_name;
    private Double credit;
    private String teacher_id;

    public Subject() {
    }

    public Subject(String subject_id, String student_name, Double credit, String teacher_id) {
        this.subject_id = subject_id;
        this.student_name = student_name;
        this.credit = credit;
        this.teacher_id = teacher_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id='" + subject_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", credit=" + credit +
                ", teacher_id='" + teacher_id + '\'' +
                '}';
    }
}
