package seedu.internhunter.logic.commands.util.company;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.internhunter.logic.commands.edit.EditCompanyCommand.EditCompanyDescriptor;
import seedu.internhunter.model.company.Address;
import seedu.internhunter.model.company.CompanyItem;
import seedu.internhunter.model.company.CompanyName;
import seedu.internhunter.model.company.Email;
import seedu.internhunter.model.company.Industry;
import seedu.internhunter.model.company.Phone;

// todo javadocs (shawn)
public class EditCompanyDescriptorBuilder {
    private EditCompanyDescriptor descriptor;

    public EditCompanyDescriptorBuilder() {
        descriptor = new EditCompanyDescriptor();
    }

    public EditCompanyDescriptorBuilder(EditCompanyDescriptor descriptor) {
        this.descriptor = new EditCompanyDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditProfileItemDescriptor} with fields containing {@code profileItem}'s details
     */
    public EditCompanyDescriptorBuilder(CompanyItem companyItem) {
        descriptor = new EditCompanyDescriptor();
        descriptor.setAddress(companyItem.getAddress());
        descriptor.setEmail(companyItem.getEmail());
        descriptor.setName(companyItem.getCompanyName());
        descriptor.setPhone(companyItem.getPhone());
        descriptor.setIndustries(companyItem.getIndustries());
    }

    /**
     * Sets the {@code ProfileItemCategory} of the {@code EditProfileItemDescriptor} that we are building.
     */
    public EditCompanyDescriptorBuilder withAddress(String address) {
        requireNonNull(address);
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Sets the {@code Title} of the {@code EditProfileItemDescriptor} that we are building.
     */
    public EditCompanyDescriptorBuilder withCompanyName(String companyName) {
        requireNonNull(companyName);
        descriptor.setName(new CompanyName(companyName));
        return this;
    }

    /**
     * Sets the {@code Title} of the {@code EditProfileItemDescriptor} that we are building.
     */
    public EditCompanyDescriptorBuilder withEmail(String email) {
        requireNonNull(email);
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Title} of the {@code EditProfileItemDescriptor} that we are building.
     */
    public EditCompanyDescriptorBuilder withPhone(String phone) {
        requireNonNull(phone);
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Title} of the {@code EditProfileItemDescriptor} that we are building.
     */
    public EditCompanyDescriptorBuilder withIndustries(String... industries) {
        requireNonNull(industries);
        descriptor.setIndustries(getIndustrySet(industries));
        return this;
    }

    public EditCompanyDescriptor build() {
        return descriptor;
    }

    /**
     * Returns a set of requirements containing the list of strings given.
     */
    private Set<Industry> getIndustrySet(String... strings) {
        return Arrays.stream(strings)
                .map(Industry::new)
                .collect(Collectors.toSet());
    }
}
