package DesignPatterns.creational;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DpBuilder {

    public static void main(String[] args){

        String statement = "Allow";
        PolicyDocument policyDocument = PolicyDocument.builder().statements(Collections.singletonList(statement)).build();
        System.out.println("Builder: "+policyDocument);
    }
}


class PolicyDocument {

    public final String versionString = "2012-10-17";
    public List<String> statements;

    private PolicyDocument(Builder builder) {
        this.statements = builder.statements;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<String> statements;

        private Builder() {
            statements = new ArrayList<String>();
        }

        public Builder statements(List<String> statements) {
            this.statements = statements;
            return this;
        }

        public PolicyDocument build() {
            return new PolicyDocument(this);
        }
    }

    @Override
    public String toString() {
        return "PolicyDocument [versionString=" + versionString + ", statements=" + statements + "]";
    }
}