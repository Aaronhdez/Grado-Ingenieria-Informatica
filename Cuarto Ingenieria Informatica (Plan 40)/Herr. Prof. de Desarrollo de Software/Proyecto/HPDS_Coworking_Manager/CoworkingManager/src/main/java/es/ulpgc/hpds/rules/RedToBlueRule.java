package es.ulpgc.hpds.rules;

import es.ulpgc.hpds.conditions.CleanCondition;
import es.ulpgc.hpds.conditions.TemporarilyAwayCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.persistence.Condition;
import es.ulpgc.hpds.persistence.Rule;

import java.util.ArrayList;

public class RedToBlueRule implements Rule {

    private ArrayList<Condition> conditionsToEvaluate;

    public RedToBlueRule(ArrayList<Sensor> sensors) {
        this.conditionsToEvaluate = new ArrayList<>();
        conditionsToEvaluate.add(new TemporarilyAwayCondition(sensors));
        conditionsToEvaluate.add(new CleanCondition(sensors));
    }

    @Override
    public boolean check() {
        return (this.conditionsToEvaluate.get(0).evaluate() && !this.conditionsToEvaluate.get(1).evaluate());
    }
}
