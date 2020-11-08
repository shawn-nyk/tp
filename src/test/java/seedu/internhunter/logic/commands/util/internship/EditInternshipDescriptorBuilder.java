package seedu.internhunter.logic.commands.util.internship;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.internhunter.logic.commands.edit.EditInternshipCommand.EditInternshipDescriptor;
import seedu.internhunter.model.internship.InternshipItem;
import seedu.internhunter.model.internship.JobTitle;
import seedu.internhunter.model.internship.Period;
import seedu.internhunter.model.internship.Requirement;
import seedu.internhunter.model.internship.Wage;

// todo javadocs (shawn)
public class EditInternshipDescriptorBuilder {
    private EditInternshipDescriptor descriptor;

    public EditInternshipDescriptorBuilder() {
        descriptor = new EditInternshipDescriptor();
    }

    public EditInternshipDescriptorBuilder(EditInternshipDescriptor descriptor) {
        this.descriptor = new EditInternshipDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditInternshipDescriptor} with fields containing {@code internshipItem}'s details
     */
    public EditInternshipDescriptorBuilder(InternshipItem internshipItem) {
        descriptor = new EditInternshipDescriptor();
        descriptor.setJobTitle(internshipItem.getJobTitle());
        descriptor.setPeriod(internshipItem.getPeriod());
        descriptor.setWage(internshipItem.getWage());
        descriptor.setRequirements(internshipItem.getRequirements());
    }

    /**
     * Sets the {@code JobTitle} of the {@code EditInternshipDescriptor} that we are building.
     */
    public EditInternshipDescriptorBuilder withJobTitle(String jobTitle) {
        requireNonNull(jobTitle);
        descriptor.setJobTitle(new JobTitle(jobTitle));
        return this;
    }

    /**
     * Sets the {@code Period} of the {@code EditInternshipDescriptor} that we are building.
     */
    public EditInternshipDescriptorBuilder withPeriod(String period) {
        requireNonNull(period);
        descriptor.setPeriod(new Period(period));
        return this;
    }

    /**
     * Sets the {@code Wage} of the {@code EditInternshipDescriptor} that we are building.
     */
    public EditInternshipDescriptorBuilder withWage(String wage) {
        requireNonNull(wage);
        descriptor.setWage(new Wage(wage));
        return this;
    }

    /**
     * Sets the {@code Requirements} of the {@code EditInternshipDescriptor} that we are building.
     */
    public EditInternshipDescriptorBuilder withRequirements(String... requirements) {
        requireNonNull(requirements);
        descriptor.setRequirements(getRequirementSet(requirements));
        return this;
    }

    public EditInternshipDescriptor build() {
        return descriptor;
    }

    /**
     * Returns a set of requirements containing the list of strings given.
     */
    private Set<Requirement> getRequirementSet(String... strings) {
        return Arrays.stream(strings)
                .map(Requirement::new)
                .collect(Collectors.toSet());
    }
}
