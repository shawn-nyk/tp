package seedu.internhunter.logic.commands.add;

import static seedu.internhunter.testutil.company.SampleCompanyItems.getSampleCompanyList;

import org.junit.jupiter.api.BeforeEach;

import seedu.internhunter.model.Model;
import seedu.internhunter.model.ModelManager;
import seedu.internhunter.model.UserPrefs;
import seedu.internhunter.model.item.ItemList;

public class AddInternshipCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getSampleCompanyList(), new ItemList<>(), new ItemList<>(),
                new UserPrefs());
        expectedModel = new ModelManager(model.getUnfilteredCompanyList(), new ItemList<>(),
                new ItemList<>(), new UserPrefs());
    }


}
