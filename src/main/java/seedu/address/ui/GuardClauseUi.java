package seedu.address.ui;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.item.Item;
import seedu.address.ui.display.InformationDisplay;
import seedu.address.ui.panel.ListPanel;

public class GuardClauseUi {

    /** Checks if the given string is an empty representation of a list */
    public static final Predicate<String> IS_EMPTY_LIST_STRING = string -> string.equals("[]");

    /** Checks if the given data list is empty */
    public static final Predicate<ObservableList<? extends Item>> IS_EMPTY_DATA_LIST = list -> list.size() <= 0;

    /** Checks if the given display is empty */
    public static final Predicate<Optional<InformationDisplay<? extends Item>>> IS_EMPTY_DISPLAY = Optional::isEmpty;

    /** Checks if the given list panel is empty */
    public static final Predicate<Optional<ListPanel<? extends Item>>> IS_EMPTY_LIST_PANEL = Optional::isEmpty;

    /** Checks if the given string is empty */
    public static final Predicate<String> IS_EMPTY_STRING = string -> string.length() <= 0;

    /** Checks if both strings are equal */
    public static final BiPredicate<String, String> IS_SAME_STRING = String::equals;
}