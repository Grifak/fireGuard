module fire.guard.analog.fireguard.fireguard {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires poi.tl;

    opens fire.guard.analog.fireguard to javafx.fxml;
    exports fire.guard.analog.fireguard;
}