package TTPOrPAMMiCT.su.service.view.studentView;

import TTPOrPAMMiCT.su.entity.view.StudentView;
import TTPOrPAMMiCT.su.service.DaoService;

public interface StudentViewService extends DaoService<StudentView> {
    void updateStudent(StudentView studentView);
}
