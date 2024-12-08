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
    exports training.tutorial.exampleclass;
    opens training.tutorial.exampleclass;
}