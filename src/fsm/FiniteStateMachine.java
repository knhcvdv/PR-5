package fsm;

public class FiniteStateMachine {
    public enum State {
        S,
        ONE,
        TWO,
        THREE,
        F
    }

    private State currentState;

    public FiniteStateMachine() {
        this.currentState = State.S;
    }

    public void process(String input) {
        for (char c : input.toCharArray()) {
            switch (currentState) {
                case S:
                    if (c == 'T') {
                        currentState = State.ONE;
                    }
                    break;
                case ONE:
                    if (c == 'E') {
                        currentState = State.TWO;
                    } else if (c == 'T') {
                        currentState = State.ONE;
                    } else {
                        currentState = State.S;
                    }
                    break;
                case TWO:
                    if (c == 'S') {
                        currentState = State.THREE;
                    } else if (c == 'T') {
                        currentState = State.ONE;
                    } else {
                        currentState = State.S;
                    }
                    break;
                case THREE:
                    if (c == 'T') {
                        currentState = State.F;
                    } else if (c == 'T') {
                        currentState = State.ONE;
                    } else {
                        currentState = State.S;
                    }
                    break;
                case F:
                    break;
            }
        }
    }

    public boolean isFinalState() {
        return currentState == State.F;
    }

    public State getCurrentState() {
        return currentState;
    }
}
