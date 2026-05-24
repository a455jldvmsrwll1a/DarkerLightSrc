package ph.jldvmsrwll1a.darkerlightsrc.exception;

import java.util.List;

public class RuleConfigParseException extends RuntimeException {
    private RuleConfigParseException(String message) {
        super(message);
    }

    public static RuleConfigParseException fromErrors(List<String> errors) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rule config failed with ");

        sb.append(errors.size());
        if (errors.size() == 1) {
            sb.append(" error:\n");
        } else {
            sb.append(" errors:\n");
        }

        errors.forEach(err -> {
            sb.append(" -> ");
            sb.append(err);
            sb.append('\n');
        });

        return new RuleConfigParseException(sb.toString());
    }
}
