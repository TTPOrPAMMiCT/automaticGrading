package TTPOrPAMMiCT.su.service.view.studentView;

import TTPOrPAMMiCT.su.entity.model.Squad;
import TTPOrPAMMiCT.su.entity.view.StudentView;
import TTPOrPAMMiCT.su.service.DaoService;

import java.util.List;

public interface StudentViewService extends DaoService<StudentView> {
    void updateStudent(StudentView studentView);
    List<StudentView> getEntityListBySquad(Squad squad);
}
