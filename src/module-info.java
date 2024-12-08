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

    exports training.exampleclass;
    opens training.exampleclass;
}