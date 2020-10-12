package seedu.address.ui;

import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.item.Item;
import seedu.address.ui.display.InformationDisplay;
import seedu.address.ui.panel.ListPanel;

public class GuardClauseUi {

    public static Predicate<String> isEmptyListString = string -> string.equals("[]");
    public static Predicate<ObservableList<? extends Item>> isEmptyDataList = list -> list.size() <= 0;
    public static Predicate<Optional<InformationDisplay<? extends Item>>> isEmptyDisplay = Optional::isEmpty;
    public static Predicate<Optional<ListPanel<? extends Item>>> isEmptyListPanel = Optional::isEmpty;
    public static Predicate<String> isEmptyString = string -> string.length() <= 0;
    public static BiPredicate<String, String> isSameString = String::equals;
}
