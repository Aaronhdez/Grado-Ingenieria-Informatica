package es.ulpgc.hpds.rules;

import es.ulpgc.hpds.conditions.OnUseCondition;
import es.ulpgc.hpds.environment.Sensor;
import es.ulpgc.hpds.persistence.Condition;
import es.ulpgc.hpds.persistence.Rule;
import java.util.ArrayList;

public class GreenToRedRule implements Rule {

    private ArrayList<Condition> conditionsToEvaluate;

    public GreenToRedRule(ArrayList<Sensor> sensors) {
        this.conditionsToEvaluate = new ArrayList<>();
        this.conditionsToEvaluate.add(new OnUseCondition(sensors));
    }

    @Override
    public boolean check() {
        return conditionsToEvaluate.get(0).evaluate();
    }

}
