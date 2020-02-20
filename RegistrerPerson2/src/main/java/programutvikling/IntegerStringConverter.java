package programutvikling;

import javafx.scene.control.Alert;

public class IntegerStringConverter extends javafx.util.converter.IntegerStringConverter {
    private boolean conversionSuccessful;

    @Override
    public Integer fromString(String s) {
        try {
            Integer result = super.fromString(s);
            conversionSuccessful = true;
            return result;
        } catch (NumberFormatException e) {
            programutvikling.gui.Dialogs.showErrorDialog("Du må taste inn et gyldig tall!");

            conversionSuccessful = false;
            return 0;
        }
    }

    public boolean wasSuccessful() {
        return conversionSuccessful;
    }
}