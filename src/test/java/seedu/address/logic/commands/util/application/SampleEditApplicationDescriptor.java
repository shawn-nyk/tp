package seedu.address.logic.commands.util.application;

import static seedu.address.testutil.application.SampleApplicationItems.GOLDMAN_OFFERED;
import static seedu.address.testutil.application.SampleApplicationItems.SHOPEE_OFFERED;

import seedu.address.logic.commands.edit.EditApplicationCommand.EditApplicationDescriptor;

/**
 * Contains the sample edit application descriptors for the {@code EditApplicationCommand} tests.
 */
public class SampleEditApplicationDescriptor {

    public static final EditApplicationDescriptor DESC_GOLDMAN =
            new EditApplicationDescriptorBuilder(GOLDMAN_OFFERED).build();

    public static final EditApplicationDescriptor DESC_SHOPEE =
            new EditApplicationDescriptorBuilder(SHOPEE_OFFERED).build();

}
