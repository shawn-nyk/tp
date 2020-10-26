package seedu.address.testutil.application;

import static seedu.address.logic.commands.edit.EditApplicationCommand.EditApplicationDescriptor;
import static seedu.address.testutil.application.SampleApplicationItems.GOLDMAN_OFFERED;
import static seedu.address.testutil.application.SampleApplicationItems.SHOPEE_OFFERED;

public class SampleEditApplicationDescriptor {

    public static final EditApplicationDescriptor DESC_GOLDMAN =
            new EditApplicationDescriptorBuilder(GOLDMAN_OFFERED).build();

    public static final EditApplicationDescriptor DESC_SHOPEE =
            new EditApplicationDescriptorBuilder(SHOPEE_OFFERED).build();

}
