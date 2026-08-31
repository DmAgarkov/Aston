package hometask.task_3.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private final String id;
    private final BigDecimal amount;
    private final String currency;
    private final String category;
    private final String description;
    private final LocalDate date;

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.category = builder.category;
        this.description = builder.description;
        this.date = builder.date;
    }

    public String getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }
    public String getDateString() { return date.toString(); }

    @Override
    public String toString() {
        return String.format("%s | %s %s | %s | %s",
                date.toString(),
                amount.toString(),
                currency,
                category,
                description);
    }

    public static class Builder {
        private String id;
        private BigDecimal amount = BigDecimal.ZERO;
        private String currency = "RUB";
        private String category = "Uncategorized";
        private String description = "";
        private LocalDate date = LocalDate.now();

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setDate(String date) {
            this.date = LocalDate.parse(date);
            return this;
        }

        public Transaction build() {
            if (id == null || id.isEmpty()) {
                throw new IllegalStateException("Необходим ID транзакции");
            }
            if (amount == null) {
                throw new IllegalStateException("Необходима сумма");
            }
            return new Transaction(this);
        }

    }
}