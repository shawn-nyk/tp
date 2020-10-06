package seedu.address.model.company;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.internship.InternshipItem;
import seedu.address.model.item.Item;

/**
 * Represents a Person in the address book. TODO: Javadocs (Shawn)
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class CompanyItem extends Item {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Industry> industries = new HashSet<>();
    private final List<InternshipItem> internships = new ArrayList<>();

    /**
     * Every field must be present and not null.
     */
    public CompanyItem(Name name, Phone phone, Email email, Address address, Set<Industry> industries,
                       List<InternshipItem> internships) {
        requireAllNonNull(name, phone, email, address, industries, internships);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.industries.addAll(industries);
        this.internships.addAll(internships);
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Industry> getIndustries() {
        return Collections.unmodifiableSet(industries);
    }

    /**
     * TODO: Javadocs (Shawn)
     */
    public List<InternshipItem> getInternships() {
        return Collections.unmodifiableList(internships);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameItem(Item otherItem) {
        if (this == otherItem) {
            return true;
        }

        if (!(otherItem instanceof CompanyItem)) {
            return false;
        }

        CompanyItem otherCompanyItem = (CompanyItem) otherItem;

        return otherCompanyItem != null
                && otherCompanyItem.getName().equals(getName())
                && (otherCompanyItem.getPhone().equals(getPhone()) || otherCompanyItem.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof CompanyItem)) {
            return false;
        }

        CompanyItem otherCompanyItem = (CompanyItem) other;
        return otherCompanyItem.getName().equals(getName())
                && otherCompanyItem.getPhone().equals(getPhone())
                && otherCompanyItem.getEmail().equals(getEmail())
                && otherCompanyItem.getAddress().equals(getAddress())
                && otherCompanyItem.getIndustries().equals(getIndustries())
                && otherCompanyItem.getInternships().equals(getInternships());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, industries, internships);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Phone: ")
                .append(getPhone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Industries: ");
        getIndustries().forEach(builder::append);
        builder.append(getInternships())
                .append(" Internships: ");
        getInternships().forEach(builder::append);
        return builder.toString();
    }

    @Override
    public String getItemName() {
        return "company";
    }

    @Override
    public LinkedHashMap<String, Object> getMapping() {
        LinkedHashMap<String, Object> mapping = new LinkedHashMap<>();
        mapping.put("Name", name);
        mapping.put("Phone", phone);
        mapping.put("Email", email);
        mapping.put("Address", address);
        mapping.put("Industries", industries);
        mapping.put("Internships", internships);
        return mapping;
    }

}
