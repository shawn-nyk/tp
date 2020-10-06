package seedu.address.ui.cards;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.company.CompanyItem;
import seedu.address.model.internship.InternshipItem;

/**
 * todo Javadocs
 */
public class CompanyCard extends Card<CompanyItem> {

    /**
     * todo Javadocs
     */
    public CompanyCard(CompanyItem companyItem, int displayedIndex) {
        super(companyItem, displayedIndex);
        initializeCompanyCardGui();
    }

    /**
     * todo Javadocs
     */
    private void initializeCompanyCardGui() {
        // to be edited in the future!
        initializeBody();
    }
    
    @Override
    protected void setName() {
        
    }

    @Override
    protected void setTags() {
//        person.getTags().stream()
//            .sorted(Comparator.comparing(Tag::getName))
//            .forEach(tag -> tags.getChildren().add(new Label(tag.getName())));
    }
}
