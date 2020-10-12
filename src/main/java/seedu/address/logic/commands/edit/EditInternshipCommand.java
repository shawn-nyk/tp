package seedu.address.logic.commands.edit;

//import static java.util.Objects.requireNonNull;
//import static seedu.address.commons.core.Messages.MESSAGE_EDIT_SUCCESS;
//import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_JOB_TITLE;
//import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_PERIOD;
//import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_REQUIREMENT;
//import static seedu.address.logic.parser.clisyntax.InternshipCliSyntax.PREFIX_WAGE;
//import static seedu.address.logic.parser.clisyntax.ItemCliSyntax.PREFIX_INDEX;
//import static seedu.address.model.FilterableItemList.PREDICATE_SHOW_ALL_ITEMS;
//import static seedu.address.model.util.ItemUtil.COMPANY_NAME;
//import static seedu.address.model.util.ItemUtil.INTERNSHIP_ALIAS;
//import static seedu.address.model.util.ItemUtil.INTERNSHIP_NAME;
//
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import seedu.address.commons.core.Messages;
//import seedu.address.commons.core.index.Index;
//import seedu.address.commons.util.CollectionUtil;
//import seedu.address.logic.commands.CommandResult;
//import seedu.address.logic.commands.exceptions.CommandException;
//import seedu.address.model.Model;
//import seedu.address.model.internship.InternshipItem;

/** todo javadocs (shawn) */
//public class EditInternshipCommand extends EditCommandAbstract {
public class EditInternshipCommand {
//
//    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + INTERNSHIP_ALIAS
//            + ": Edits the " + INTERNSHIP_NAME + " identified by the index number used in the displayed "
//            + INTERNSHIP_NAME + " list in a " + COMPANY_NAME + ".\n"
//            + "Existing values will be overwritten by the input values.\n"
//            + "Parameters: INDEX " + PREFIX_INDEX + "INDEX "
//            + "[" + PREFIX_JOB_TITLE + "JOB_TITLE] "
//            + "[" + PREFIX_WAGE + "WAGE] "
//            + "[" + PREFIX_PERIOD + "PERIOD] "
//            + "[" + PREFIX_REQUIREMENT + "REQUIREMENT]...\n"
//            + "Note: Select a " + COMPANY_NAME + " with the first INDEX and an " + INTERNSHIP_NAME + " within that "
//            + COMPANY_NAME + " with the second INDEX. "
//            + "At least one of the optional fields must be provided.\n"
//            + "Example: " + COMMAND_WORD + " " + INTERNSHIP_ALIAS + " 5 " + PREFIX_INDEX + "2 "
//            + PREFIX_JOB_TITLE + "Web Developer "
//            + PREFIX_REQUIREMENT + "HTML "
//            + PREFIX_REQUIREMENT + "CSS "
//            + PREFIX_REQUIREMENT + "JS ";
//
//    private final Index companyIndex;
//    private final Index internshipIndex;
//    private final EditCompanyDescriptor editCompanyDescriptor;
//
//    /** todo javadocs (shawn)
//     * @param index of the person in the filtered person list to edit
//     * @param editCompanyDescriptor details to edit the person with
//     */
//    public EditCompanyCommand(Index index, EditCompanyDescriptor editCompanyDescriptor) {
//        requireNonNull(index);
//        requireNonNull(editCompanyDescriptor);
//
//        this.index = index;
//        this.editCompanyDescriptor = new EditCompanyDescriptor(editCompanyDescriptor);
//    }
//
//    @Override
//    public CommandResult execute(Model model) throws CommandException {
//        requireNonNull(model);
//        CompanyItem companyToEdit = getCompany(model, index);
//        CompanyItem editedCompany = createEditedCompany(companyToEdit, editCompanyDescriptor);
//
//        if (!companyToEdit.isSameItem(editedCompany) && model.getCompanyList().hasItem(editedCompany)) {
//            throw new CommandException(String.format(Messages.MESSAGE_DUPLICATE_ITEM, COMPANY_NAME));
//        }
//
//        model.getCompanyList().setItem(companyToEdit, editedCompany);
//        model.getCompanyList().updateFilteredItemList(PREDICATE_SHOW_ALL_ITEMS);
//        return new CommandResult(String.format(MESSAGE_EDIT_SUCCESS, COMPANY_NAME, editedCompany));
//    }
//
//    /**
//     * Creates and returns a {@code Person} with the details of {@code personToEdit}
//     * edited with {@code editPersonDescriptor}.
//     */
//    private static CompanyItem createEditedCompany(CompanyItem companyToEdit,
//                                                   EditCompanyDescriptor editCompanyDescriptor) {
//        assert companyToEdit != null;
//
//        CompanyName updatedName = editCompanyDescriptor.getName().orElse(companyToEdit.getCompanyName());
//        Phone updatedPhone = editCompanyDescriptor.getPhone().orElse(companyToEdit.getPhone());
//        Email updatedEmail = editCompanyDescriptor.getEmail().orElse(companyToEdit.getEmail());
//        Address updatedAddress = editCompanyDescriptor.getAddress().orElse(companyToEdit.getAddress());
//        Set<Industry> updatedIndustries = editCompanyDescriptor.getIndustries().orElse(companyToEdit.getIndustries());
//        List<InternshipItem> internships = companyToEdit.getInternships();
//
//        CompanyItem updatedCompany = new CompanyItem(updatedName, updatedPhone, updatedEmail, updatedAddress,
//                updatedIndustries, internships);
//        updatedCompany.updateAllInternshipsCompanyName();
//        return updatedCompany;
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        // short circuit if same object
//        if (other == this) {
//            return true;
//        }
//
//        // instanceof handles nulls
//        if (!(other instanceof EditCompanyCommand)) {
//            return false;
//        }
//
//        // state check
//        EditCompanyCommand e = (EditCompanyCommand) other;
//        return index.equals(e.index)
//                && editCompanyDescriptor.equals(e.editCompanyDescriptor);
//    }
//
//    /**
//     * Stores the details to edit the person with. Each non-empty field value will replace the
//     * corresponding field value of the person.
//     */
//    public static class EditCompanyDescriptor {
//        private CompanyName name;
//        private Phone phone;
//        private Email email;
//        private Address address;
//        private Set<Industry> industries;
//
//        public EditCompanyDescriptor() {}
//
//        /**
//         * Copy constructor.
//         * A defensive copy of {@code tags} is used internally.
//         */
//        public EditCompanyDescriptor(EditCompanyDescriptor toCopy) {
//            setName(toCopy.name);
//            setPhone(toCopy.phone);
//            setEmail(toCopy.email);
//            setAddress(toCopy.address);
//            setIndustries(toCopy.industries);
//        }
//
//        /**
//         * Returns true if at least one field is edited.
//         */
//        public boolean isAnyFieldEdited() {
//            return CollectionUtil.isAnyNonNull(name, phone, email, address, industries);
//        }
//
//        public void setName(CompanyName name) {
//            this.name = name;
//        }
//
//        public Optional<CompanyName> getName() {
//            return Optional.ofNullable(name);
//        }
//
//        public void setPhone(Phone phone) {
//            this.phone = phone;
//        }
//
//        public Optional<Phone> getPhone() {
//            return Optional.ofNullable(phone);
//        }
//
//        public void setEmail(Email email) {
//            this.email = email;
//        }
//
//        public Optional<Email> getEmail() {
//            return Optional.ofNullable(email);
//        }
//
//        public void setAddress(Address address) {
//            this.address = address;
//        }
//
//        public Optional<Address> getAddress() {
//            return Optional.ofNullable(address);
//        }
//
//        /**
//         * Sets {@code tags} to this object's {@code tags}.
//         * A defensive copy of {@code tags} is used internally.
//         */
//        public void setIndustries(Set<Industry> industries) {
//            this.industries = (industries != null) ? new HashSet<>(industries) : null;
//        }
//
//        /**
//         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
//         * if modification is attempted.
//         * Returns {@code Optional#empty()} if {@code tags} is null.
//         */
//        public Optional<Set<Industry>> getIndustries() {
//            return (industries != null) ? Optional.of(Collections.unmodifiableSet(industries)) : Optional.empty();
//        }
//
//        @Override
//        public boolean equals(Object other) {
//            // short circuit if same object
//            if (other == this) {
//                return true;
//            }
//
//            // instanceof handles nulls
//            if (!(other instanceof EditCompanyDescriptor)) {
//                return false;
//            }
//
//            // state check
//            EditCompanyDescriptor e = (EditCompanyDescriptor) other;
//
//            return getName().equals(e.getName())
//                    && getPhone().equals(e.getPhone())
//                    && getEmail().equals(e.getEmail())
//                    && getAddress().equals(e.getAddress())
//                    && getIndustries().equals(e.getIndustries());
//        }
//    }
}
