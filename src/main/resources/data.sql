-- =============================
-- 🌱 Seed Data for Smart Expense Analyzer
-- =============================

-- Insert default categories
INSERT INTO category (id, name) VALUES (1, 'Food')
    ON DUPLICATE KEY UPDATE name = VALUES(name);
INSERT INTO category (id, name) VALUES (2, 'Transport')
    ON DUPLICATE KEY UPDATE name = VALUES(name);
INSERT INTO category (id, name) VALUES (3, 'Entertainment')
    ON DUPLICATE KEY UPDATE name = VALUES(name);
INSERT INTO category (id, name) VALUES (4, 'Bills')
    ON DUPLICATE KEY UPDATE name = VALUES(name);
INSERT INTO category (id, name) VALUES (5, 'Shopping')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

-- Insert a test user (⚠️ password is plain text for demo, later we hash it)
INSERT INTO user (id, username, email, password, created_at) 
VALUES (1, 'yagnesh', 'yagnesh@example.com', 'password123', NOW())
    ON DUPLICATE KEY UPDATE email = VALUES(email);

-- Insert sample expenses for user 1
INSERT INTO expense (id, amount, description, category_id, user_id, expense_date)
VALUES (1, 250.00, 'Dinner at KFC', 1, 1, '2025-08-20')
    ON DUPLICATE KEY UPDATE amount = VALUES(amount);

INSERT INTO expense (id, amount, description, category_id, user_id, expense_date)
VALUES (2, 50.00, 'Bus ticket', 2, 1, '2025-08-21')
    ON DUPLICATE KEY UPDATE amount = VALUES(amount);

INSERT INTO expense (id, amount, description, category_id, user_id, expense_date)
VALUES (3, 999.00, 'Netflix yearly plan', 3, 1, '2025-08-22')
    ON DUPLICATE KEY UPDATE amount = VALUES(amount);

INSERT INTO expense (id, amount, description, category_id, user_id, expense_date)
VALUES (4, 1200.00, 'Electricity Bill', 4, 1, '2025-08-23')
    ON DUPLICATE KEY UPDATE amount = VALUES(amount);

INSERT INTO expense (id, amount, description, category_id, user_id, expense_date)
VALUES (5, 2000.00, 'Amazon Shopping', 5, 1, '2025-08-25')
    ON DUPLICATE KEY UPDATE amount = VALUES(amount);
