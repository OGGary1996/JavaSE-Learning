/**
 * 
 */
/**
 * 
 */
module JavaExercise {
    requires java.sql;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires org.junit.jupiter.engine;
    requires org.junit.platform.launcher;
    requires java.desktop;
    exports training.tutorial.exampleClass;
    opens training.tutorial.exampleClass to org.junit.platform.commons;

}