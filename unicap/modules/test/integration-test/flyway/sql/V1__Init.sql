CREATE SCHEMA IF NOT EXISTS bank;

CREATE TABLE bank.BALANCE (
  user_id TEXT PRIMARY KEY,
  balance REAL NOT NULL
);
