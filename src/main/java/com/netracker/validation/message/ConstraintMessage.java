package com.netracker.validation.message;

public final class ConstraintMessage {
    private ConstraintMessage() {
    }

    public static class Field {
        public static final String PASSWORD = "PASSWORD";
        public static final String TITLE = "TITLE";
        public static final String VPN_ID = "VPNID";
        public static final String EXPIRATION_DATE = "EXPIRATIONDATE";
        private Field() {
        }
    }

    public static class Constraint {
        public static final String IS_NULL = "_NULL";
        public static final String IS_EMPTY = "_EMPTY";
        public static final String TOO_LONG = "_TOO_LONG";
        public static final String TOO_SHORT = "_TOO_SHORT";
        public static final String NOT_UNIQUE = "_NOT_UNIQUE";
        public static final String NOT_EXISTS = "_NOT_EXISTS";
        private Constraint() {
        }
    }
}
